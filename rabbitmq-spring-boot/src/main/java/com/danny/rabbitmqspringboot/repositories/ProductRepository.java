package com.danny.rabbitmqspringboot.repositories;

import com.danny.rabbitmqspringboot.domain.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
