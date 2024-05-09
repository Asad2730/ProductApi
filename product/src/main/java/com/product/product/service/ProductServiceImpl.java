package com.product.product.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.product.product.entity.ProductEntity;
import com.product.product.repository.ProductRepository;


@Service
public class ProductServiceImpl implements ProductService {
      
    @Autowired
    ProductRepository repository;

    @Override
    public List<ProductEntity> getAllProducts() {
        return repository.findAll();
    }

    @Override
    public List<ProductEntity> getAllProductsByIds(List<Long> ids) {
        return repository.findAllById(ids);
    }

    @Override
    public ProductEntity getProductById(Long id) {
       return repository.getOne(id);
    }

    @Override
    public ProductEntity createProduct(ProductEntity entity) {
       return repository.saveAndFlush(entity);
    }

    @Override
    public ProductEntity updateProduct(Long id, ProductEntity entity) {
        var product = getProductById(id);
         product.setName(entity.getName());
         product.setPrice(entity.getPrice());
         return repository.saveAndFlush(entity);
    }

   
    @Override
    public Void deleteProduct(Long id) {
         List<Long>ids = new ArrayList<>();
         ids.add(id);
         var product = getAllProductsByIds(ids);
         repository.deleteInBatch(product);
    }

  
    
}
