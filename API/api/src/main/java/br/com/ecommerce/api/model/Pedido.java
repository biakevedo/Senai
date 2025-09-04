package br.com.ecommerce.api.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "pedido", schema = "ecommerce")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pedido_id", nullable = false)
    private java.lang.Integer id;

    @Column(name = "data_pedido", nullable = false)
    private java.time.Instant dataPedido;

    @Column(name = "status", nullable = false, length = Integer.MAX_VALUE)
    private java.lang.String status;

    @Column(name = "valor_total", nullable = false, precision = 10, scale = 4)
    private java.math.BigDecimal valorTotal;

    @Column(name = "cliente_id", nullable = false)
    private java.lang.Integer clienteId;

}