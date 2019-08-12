package com.danny.rabbitmqspringboot.services;

import com.danny.rabbitmqspringboot.commands.ProductForm;
import com.danny.rabbitmqspringboot.domain.Product;

import java.util.List;

public interface ProductService {

    List<Product> listAll();

    Product getById(Long id);

    Product saveOrUpdate(Product product);

    void delete(Long id);

    Product saveOrUpdateProductForm(ProductForm productForm);

    void sendProductMessage(String id);
}
