package com.example.concorrencia.controller;

import com.example.concorrencia.entity.ContaBancaria;
import com.example.concorrencia.service.ContaBancariaService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/contas")
public class ContaBancariaController {

    private final ContaBancariaService service;

    public ContaBancariaController(ContaBancariaService service) {
        this.service = service;
    }

    @PostMapping
    public ContaBancaria criarConta(
            @RequestParam String titular,
            @RequestParam BigDecimal saldo
    ) {

        return service.criarConta(titular, saldo);
    }

    @PostMapping("/{id}/deposito")
    public ContaBancaria deposito(
            @PathVariable Long id,
            @RequestParam BigDecimal valor
    ) {

        return service.deposito(id, valor);
    }

    @PostMapping("/{id}/saque")
    public ContaBancaria saque(
            @PathVariable Long id,
            @RequestParam BigDecimal valor
    ) {

        return service.saque(id, valor);
    }
}