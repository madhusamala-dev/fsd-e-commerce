package com.ecommerce.repository;


import com.ecommerce.model.Product;
import com.ecommerce.util.CsvParser;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class ProductRepository {
    /*
    CRUD operations on Products
     */
    private final List<Product> products;


    ProductRepository() throws IOException {
        CsvParser csvParser = new CsvParser();
        products = csvParser.getProductsFromCsv();
    }

    public Product save(Product product) {
        this.products.add(product);
        return product;
    }

    public Optional<Product> getById(int id) {
        return products.stream()
                .filter(product -> product.getId() == id)
                .findFirst();
    }

    public List<Product> getAll(){
        return this.products;
    }

    public Product update(int id, Product product) {
        products.replaceAll(p -> p.getId() == id ? product : p);
        return product;
    }

    public boolean delete(int id) {
        return products.removeIf(product -> product.getId() == id);
    }

    public boolean delete(Product product){
        return products.remove(product);
    }



}
