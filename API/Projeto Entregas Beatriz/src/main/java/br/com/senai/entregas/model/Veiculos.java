package br.com.senai.entregas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table

public class Veiculos {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "veiculo_id", nullable = false)
    private Integer veiculoid;

    @Column(name = "placa", nullable = false, columnDefinition = "text", unique = true)
    private String placa;

    @Column(name = "modelo", nullable = false)
    private String modelo;

    @Column(name = "tipo", nullable = false)
    private String tipo;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

}





















