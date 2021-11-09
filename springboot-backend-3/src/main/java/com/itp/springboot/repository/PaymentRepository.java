package com.itp.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itp.springboot.model.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long>{

}