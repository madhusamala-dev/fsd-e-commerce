package com.ecommerce.service;

import com.ecommerce.exception.ProductExistsException;
import com.ecommerce.exception.ProductNotFoundException;
import com.ecommerce.model.Product;

import java.util.List;

public interface ProductService {

    /*
    CRUD
     */
     Product save(Product product) throws ProductExistsException;
     Product getById(int id) throws ProductNotFoundException;
     List<Product> getAll();
     Product update(int id, Product product) throws ProductNotFoundException;
     void delete(int id) throws ProductNotFoundException;



     List<Product> getProductsByAvailability(boolean isAvaialble);
     List<Product> getProductsByCategory(String category);
     List<Product> getProductsByPriceGreaterThan(int price);
     List<Product> getProductsByPriceLessThan(int price);



}
