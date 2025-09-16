package br.com.senai.entregas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Anotações do Lombok
@Getter
@Setter
// Obrigatório ter para o JPA funcionar
@NoArgsConstructor
// Ele cria o construtor que recebe tudo mas não é obrigatório
@AllArgsConstructor

// Anotações do JPA
// Entity informa que essa classe é uma tabela
@Entity
// Table permite que você consigure a tabela
@Table(name = "tipo_usuario")

// Classe
public class TipoUsuario {

    // JPA - Id define que é chave primária
    @Id
    // Define que a chave é gerenciada pelo banco de dados
    // Esse é pra seguir o padrão de criação 1, 2, 3, 4, 5
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Column configura a coluna
    // name é o nome da coluna
    // nullable se é nulo ou não, no caso false, obrigatório
    @Column(name = "tipo_usuario_id", nullable = false)

    private Integer tipoUsuarioId;

    @Column(name = "descricao", nullable = false, columnDefinition = "text")
    private String descricao;
}
