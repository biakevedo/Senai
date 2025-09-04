package br.com.ecommerce.api.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "cliente", schema = "ecommerce")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cliente_id", nullable = false)
    private java.lang.Integer id;

    @Column(name = "nome_completo", nullable = false, length = Integer.MAX_VALUE)
    private java.lang.String nomeCompleto;

    @Column(name = "email", length = Integer.MAX_VALUE)
    private java.lang.String email;

    @Column(name = "senha", nullable = false, length = Integer.MAX_VALUE)
    private java.lang.String senha;

    @Column(name = "telefone", length = 13)
    private java.lang.String telefone;

    @Column(name = "data_cadastro")
    private java.time.LocalDate dataCadastro;

}