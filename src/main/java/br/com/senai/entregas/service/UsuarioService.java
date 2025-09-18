package br.com.senai.entregas.service;

import br.com.senai.entregas.model.Usuario;
import br.com.senai.entregas.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    // Construtor para injeção de dependência
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // Listar todos os usuários
    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    // Buscar usuário por ID
    public Usuario buscarPorId(Integer id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    // Cadastrar um novo usuário
    public Usuario cadastrar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // Atualizar um usuário existente
    public Usuario atualizar(Integer id, Usuario usuarioNovo) {
        Usuario usuarioExistente = buscarPorId(id);

        if (usuarioExistente == null) {
            return null;
        }

        // Atualiza o email do usuário, por exemplo
        usuarioExistente.setEmail(usuarioNovo.getEmail());

        return usuarioRepository.save(usuarioExistente);
    }

    // Deletar um usuário
    public Usuario deletar(Integer id) {
        Usuario usuarioExistente = buscarPorId(id);

        if (usuarioExistente == null) {
            return null;
        }

        usuarioRepository.delete(usuarioExistente);
        return usuarioExistente;
    }
}
