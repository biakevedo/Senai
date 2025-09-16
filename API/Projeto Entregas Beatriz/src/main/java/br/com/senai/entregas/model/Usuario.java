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

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id", nullable = false)
    private Integer usuarioId;

    @Column(name = "nome_completo", nullable = false)
    private String nomeCompleto;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "senha", nullable = false)
    private String senha;

    // Muitos usuários para um tipo usuário
    // Fetch.Type.EAGER - Carrega os dados juntos
    // optional - Se é obrigatório ou não
    @ManyToOne(fetch = FetchType.EAGER, optional = false)

    // Avisar para o java, qual coluna do tipo usuário que vou relacionar
    @JoinColumn(name = "tipo_usuario_id")
    private TipoUsuario tipoUsuario;

}



