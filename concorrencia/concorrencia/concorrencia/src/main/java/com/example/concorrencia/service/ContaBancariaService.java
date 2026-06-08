package com.example.concorrencia.service;

import com.example.concorrencia.entity.ContaBancaria;
import com.example.concorrencia.repository.ContaBancariaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class ContaBancariaService {

    private final ContaBancariaRepository repository;

    public ContaBancariaService(ContaBancariaRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public ContaBancaria criarConta(String titular, BigDecimal saldo) {

        ContaBancaria conta = new ContaBancaria();

        conta.setTitular(titular);
        conta.setSaldo(saldo);

        return repository.save(conta);
    }

    @Transactional
    public ContaBancaria deposito(Long id, BigDecimal valor) {

        ContaBancaria conta = repository.findById(id)
                .orElseThrow();

        conta.setSaldo(conta.getSaldo().add(valor));

        return repository.save(conta);
    }

    @Transactional
    public ContaBancaria saque(Long id, BigDecimal valor) {

        ContaBancaria conta = repository.findById(id)
                .orElseThrow();

        if (conta.getSaldo().compareTo(valor) < 0) {
            throw new RuntimeException("Saldo insuficiente");
        }

        conta.setSaldo(conta.getSaldo().subtract(valor));

        return repository.save(conta);
    }
}