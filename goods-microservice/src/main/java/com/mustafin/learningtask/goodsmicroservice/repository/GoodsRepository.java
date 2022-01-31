package com.mustafin.learningtask.goodsmicroservice.repository;

import com.mustafin.learningtask.goodsmicroservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GoodsRepository extends JpaRepository <Product, Long> {
    @Override
    Optional<Product> findById(Long id);
}
