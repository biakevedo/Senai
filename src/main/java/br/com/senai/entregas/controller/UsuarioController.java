package br.com.senai.entregas.controller;

import br.com.senai.entregas.model.Usuario;
import br.com.senai.entregas.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")




public class UsuarioController {

    private final UsuarioService UsuarioService;


    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService service, UsuarioService usuarioService) {
        this.UsuarioService = service;
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> findAll() {
        List<Usuario> Usuarios = usuarioService.listarTodos();
        return ResponseEntity.ok(Usuarios);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        Usuario Usuario = UsuarioService.buscarPorId(id);

        if (Usuario == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário " + id + " não encontrado");
        }

        UsuarioService.deletar(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizaUsuarioPorID(@PathVariable Integer id, @RequestBody Usuario UsuarioNovo) {

        Usuario Usuario = UsuarioService.atualizar(id, UsuarioNovo);


        if (Usuario == null) {
            return new ResponseEntity<>("Usuário " + id + " não encontrado", HttpStatus.NOT_FOUND);
        }


        return ResponseEntity.ok(Usuario);
    }
}