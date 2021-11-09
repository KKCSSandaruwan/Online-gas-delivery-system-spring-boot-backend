package com.itp.springboot.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.itp.springboot.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
