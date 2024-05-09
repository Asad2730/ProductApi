package com.product.product.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.product.product.entity.ProductEntity;
import com.product.product.service.ProductServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/product")
public class ProductControler {
    @Autowired
    ProductServiceImpl db;

    @PostMapping("/")
    public ResponseEntity<?> saveProduct(@RequestBody ProductEntity entity) {
        try {
            db.createProduct(entity);
            return new ResponseEntity<>("Prouct saved", HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity<>("Ex:" + ex.getMessage(), HttpStatus.EXPECTATION_FAILED);
        }

    }


    @GetMapping("/")
    public ResponseEntity<?> getProducts() {
        try{
           var products = db.getAllProducts();
           return new ResponseEntity<>(products,HttpStatus.OK);
        }catch(Exception ex){
            return new ResponseEntity<>("Ex:" + ex.getMessage(), HttpStatus.EXPECTATION_FAILED);
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getProduct(@PathVariable Long id) {
        try{
           var product = db.getProductById(id);
           return new ResponseEntity<>(product,HttpStatus.OK);
        }catch(Exception ex){
            return new ResponseEntity<>("Ex:" + ex.getMessage(), HttpStatus.EXPECTATION_FAILED);
        }
    }
    

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Long id, @RequestBody ProductEntity  entity) {
        try{
            var product = db.updateProduct(id, entity);
            return new ResponseEntity<>(product,HttpStatus.OK);
         }catch(Exception ex){
             return new ResponseEntity<>("Ex:" + ex.getMessage(), HttpStatus.EXPECTATION_FAILED);
         }
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@RequestParam Long id) {
        try{
            db.deleteProduct(id); 
            return new ResponseEntity<>("Deleted!",HttpStatus.OK);
         }catch(Exception ex){
             return new ResponseEntity<>("Ex:" + ex.getMessage(), HttpStatus.EXPECTATION_FAILED);
         }
    }
    

}
