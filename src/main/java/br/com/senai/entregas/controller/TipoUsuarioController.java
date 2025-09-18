package br.com.senai.entregas.controller;

import br.com.senai.entregas.model.TipoUsuario;
import br.com.senai.entregas.model.Usuario;
import br.com.senai.entregas.service.TipoUsuarioService;
import br.com.senai.entregas.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/TipoUsuario")


public class TipoUsuarioController {

    private final TipoUsuarioService tipoUsuarioService;


    private final UsuarioService usuarioService;

    public TipoUsuarioController(TipoUsuarioService service, UsuarioService usuarioService) {
        this.tipoUsuarioService = service;
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> findAll() {
        List<Usuario> tipoUsuarios = usuarioService.listarTodos();
        return ResponseEntity.ok(tipoUsuarios);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        TipoUsuario tipoUsuario = tipoUsuarioService.buscarPorId(id);

        if (tipoUsuario != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Tipo usuário " + id + " não encontrado");
        }

        tipoUsuarioService.deletar(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarTipoUsuarioPorID(@PathVariable Integer id, @RequestBody TipoUsuario tipoUsuarioNovo) {
        // Chama o serviço para atualizar o tipo de usuário
        TipoUsuario tipoUsuario = tipoUsuarioService.atualizar(id, tipoUsuarioNovo);

        // Verifica se o tipo de usuário foi encontrado após a atualização
        if (tipoUsuario == null) {
            return new ResponseEntity<>("Tipo usuário " + id + " não encontrado", HttpStatus.NOT_FOUND);
        }

        // Retorna a resposta com o tipo de usuário atualizado
        return ResponseEntity.ok(tipoUsuario);
    }
}
