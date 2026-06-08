package com.example.concorrencia.repository;

import com.example.concorrencia.entity.ContaBancaria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaBancariaRepository extends JpaRepository<ContaBancaria, Long> {
}