package com.example.concorrencia.controller;

import com.example.concorrencia.entity.ContaBancariaVersionada;
import com.example.concorrencia.service.ContaBancariaVersionadaService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/contas-versionadas")
public class ContaBancariaVersionadaController {

    private final ContaBancariaVersionadaService service;

    public ContaBancariaVersionadaController(
            ContaBancariaVersionadaService service
    ) {
        this.service = service;
    }

    @PostMapping
    public ContaBancariaVersionada criarConta(
            @RequestParam String titular,
            @RequestParam BigDecimal saldo
    ) {

        return service.criarConta(titular, saldo);
    }

    @PostMapping("/{id}/deposito")
    public ContaBancariaVersionada deposito(
            @PathVariable Long id,
            @RequestParam BigDecimal valor
    ) {

        return service.deposito(id, valor);
    }

    @PostMapping("/{id}/saque")
    public ContaBancariaVersionada saque(
            @PathVariable Long id,
            @RequestParam BigDecimal valor
    ) {

        return service.saque(id, valor);
    }
}