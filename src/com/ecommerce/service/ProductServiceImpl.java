package com.ecommerce.service;

import com.ecommerce.exception.ProductExistsException;
import com.ecommerce.model.Product;
import com.ecommerce.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    //dependency
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product save(Product product) throws ProductExistsException{
        //check whether product already exists or not based on id
        /*Optional<Product> byId = productRepository.getById(product.getId());
        if(byId.isPresent())
            throw new ProductExistsException("Product already exists with id: " + product.getId());
        else
            return productRepository.save(product);

            p -> sout(p)    -> void accept(T t)
            @Overrid
            public void accept(Product p) {
            try{
            throw new ProductExistsException("...");
            } catch(ProductExists
            */
        productRepository.getById(product.getId()).ifPresent(
                (p) -> {
                        throw new ProductExistsException("Product already exists with id : " + product.getId());
                });

        return productRepository.save(product);
    }



    @Override
    public List<Product> getProductsByAvailability(boolean isAvailble) {
        return productRepository.getAll().stream()
                .filter(p -> p.isAvailable() == isAvailble)
                .toList();
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        return productRepository.getAll().stream()
                .filter(product -> product.getCategory().equals(category))
                .toList();
    }
}
