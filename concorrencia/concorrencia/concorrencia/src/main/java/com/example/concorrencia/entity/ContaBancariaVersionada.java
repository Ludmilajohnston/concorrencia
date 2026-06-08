package com.example.concorrencia.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class ContaBancariaVersionada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titular;

    private BigDecimal saldo;

    @Version
    private Integer version;

    public Long getId() {
        return id;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public Integer getVersion() {
        return version;
    }
}