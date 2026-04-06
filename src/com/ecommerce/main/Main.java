package com.ecommerce.main;

import com.ecommerce.model.Product;
import com.ecommerce.repository.ProductRepository;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProductRepository productRepository = new ProductRepository();
        List<Product> products = productRepository.getAllProducts();
        for(Product product : products){
            System.out.println(product);
        }

    }
}
