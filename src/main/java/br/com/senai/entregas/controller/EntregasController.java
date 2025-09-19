package br.com.senai.entregas.controller;

import br.com.senai.entregas.model.Entregas;
import br.com.senai.entregas.service.EntregasService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entregas")
public class EntregasController {


    private final EntregasService entregasService;


    public EntregasController(EntregasService service, EntregasService entregasService) {
        this.entregasService = entregasService;
    }

    @GetMapping
    public ResponseEntity<List<Entregas>> findAll() {
        List<Entregas> Endereco = entregasService.listarTodos();
        return ResponseEntity.ok(Endereco);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        Entregas entregas = entregasService.buscarPorId(id);

        if (entregas == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Entrega " + id + " não encontrada");
        }

        entregasService.deletar(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarEntregasPorID(@PathVariable Integer id, @RequestBody Entregas entregasNovo) {

        Entregas entregas = entregasService.atualizar(id, entregasNovo);


        if (entregas == null) {
            return new ResponseEntity<>("Entrega " + id + " não encontrada", HttpStatus.NOT_FOUND);
        }


        return ResponseEntity.ok(entregas);
    }
}



