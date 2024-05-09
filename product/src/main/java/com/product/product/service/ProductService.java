package com.product.product.service;

import java.util.List;

import com.product.product.entity.ProductEntity;

public interface ProductService {
     List<ProductEntity> getAllProducts();
     List<ProductEntity> getAllProductsByIds(List<Long> id);
     ProductEntity getProductById(Long id);
     ProductEntity createProduct(ProductEntity entity);
     ProductEntity updateProduct(Long id,ProductEntity entity);
     void deleteProduct(Long id);
}



