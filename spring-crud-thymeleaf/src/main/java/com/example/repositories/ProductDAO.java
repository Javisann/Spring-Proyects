package com.example.repositories;

import com.example.models.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDAO extends CrudRepository<Product, Long> {
}
