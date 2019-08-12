package com.danny.service;

import java.util.List;

import com.danny.model.Product;

public interface ProductService {

    /**
     * @return
     */
    List<String> getProductCategories();

    /**
     * @param category
     * @return
     */
    List<String> getProducts(String category);

    /**
     * @param category
     * @return
     */
    List<Product> getProductsV2(String category);

    /**
     * @param category
     * @param product
     * @return
     */
    boolean addProduct(String category, String product);
}
