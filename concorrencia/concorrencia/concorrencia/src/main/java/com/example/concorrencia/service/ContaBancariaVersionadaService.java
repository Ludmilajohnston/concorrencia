package com.example.concorrencia.service;

import com.example.concorrencia.entity.ContaBancariaVersionada;
import com.example.concorrencia.repository.ContaBancariaVersionadaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class ContaBancariaVersionadaService {

    private final ContaBancariaVersionadaRepository repository;

    public ContaBancariaVersionadaService(
            ContaBancariaVersionadaRepository repository
    ) {
        this.repository = repository;
    }

    @Transactional
    public ContaBancariaVersionada criarConta(
            String titular,
            BigDecimal saldo
    ) {

        ContaBancariaVersionada conta =
                new ContaBancariaVersionada();

        conta.setTitular(titular);
        conta.setSaldo(saldo);

        return repository.save(conta);
    }

    @Transactional
    public ContaBancariaVersionada deposito(
            Long id,
            BigDecimal valor
    ) {

        ContaBancariaVersionada conta =
                repository.findById(id).orElseThrow();

        conta.setSaldo(conta.getSaldo().add(valor));

        return repository.save(conta);
    }

    @Transactional
    public ContaBancariaVersionada saque(
            Long id,
            BigDecimal valor
    ) {

        ContaBancariaVersionada conta =
                repository.findById(id).orElseThrow();

        if (conta.getSaldo().compareTo(valor) < 0) {
            throw new RuntimeException("Saldo insuficiente");
        }

        conta.setSaldo(conta.getSaldo().subtract(valor));

        return repository.save(conta);
    }
}
