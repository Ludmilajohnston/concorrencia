package com.example.concorrencia.repository;

import com.example.concorrencia.entity.ContaBancariaVersionada;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaBancariaVersionadaRepository
        extends JpaRepository<ContaBancariaVersionada, Long> {
}