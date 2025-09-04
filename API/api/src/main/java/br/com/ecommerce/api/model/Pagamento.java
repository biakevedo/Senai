package br.com.ecommerce.api.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "pagamento", schema = "ecommerce")
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pagamento_id", nullable = false)
    private java.lang.Integer id;

    @Column(name = "status", nullable = false, length = Integer.MAX_VALUE)
    private java.lang.String status;

    @Column(name = "data_pedido", nullable = false)
    private java.time.Instant dataPedido;

    @Column(name = "pedido_id", nullable = false)
    private java.lang.Integer pedidoId;

    @Column(name = "forma_pagamento", nullable = false, length = Integer.MAX_VALUE)
    private java.lang.String formaPagamento;

}