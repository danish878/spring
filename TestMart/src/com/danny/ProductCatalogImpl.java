package com.danny;

import java.util.List;

import javax.jws.WebService;

import com.danny.model.Product;
import com.danny.service.ProductService;
import com.danny.service.ProductServiceImpl;

@WebService(endpointInterface = "com.danny.ProductCatalog",
        portName = "TestMartCatalogPort",
        serviceName = "TestMartCatalogService")
public class ProductCatalogImpl implements ProductCatalog {

    ProductService productService = new ProductServiceImpl();

    @Override
    public List<String> getProductCategories() {
        return productService.getProductCategories();
    }

    @Override
    public List<String> getProducts(String category) {
        return productService.getProducts(category);
    }

    @Override
    public List<Product> getProductsV2(String category) {
        return productService.getProductsV2(category);
    }

    @Override
    public boolean addProduct(String category, String product) {
        return productService.addProduct(category, product);
    }
}
