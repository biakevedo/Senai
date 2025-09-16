package br.com.senai.entregas.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "endereco_id", nullable = false)
    private Integer enderecoid;

    @Column(name = "logradouro", nullable = false, columnDefinition = "TEXT")
    private String logradouro;

    @Column(name = "numero", nullable = false, length = 10)
    private String numero;

    @Column(name = "cidade", nullable = false, columnDefinition = "TEXT")
    private String cidade;

    @Column(name = "cep", nullable = false, length = 15)
    private String cep;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

}










