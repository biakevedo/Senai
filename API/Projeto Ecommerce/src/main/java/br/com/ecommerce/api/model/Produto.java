package br.com.ecommerce.api.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "produto", schema = "ecommerce")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "produto_id", nullable = false)
    private java.lang.Integer id;

    @Column(name = "nome_produto", nullable = false, length = Integer.MAX_VALUE)
    private java.lang.String nomeProduto;

    @Column(name = "descricao", length = Integer.MAX_VALUE)
    private java.lang.String descricao;

    @Column(name = "preco", precision = 10, scale = 4)
    private java.math.BigDecimal preco;

    @Column(name = "estoque_disponivel", nullable = false)
    private java.lang.Integer estoqueDisponivel;

    @Column(name = "imagem_url", length = Integer.MAX_VALUE)
    private java.lang.String imagemUrl;

}