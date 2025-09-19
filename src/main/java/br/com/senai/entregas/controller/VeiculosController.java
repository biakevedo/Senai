package br.com.senai.entregas.controller;

import br.com.senai.entregas.model.Veiculos;
import br.com.senai.entregas.service.VeiculosService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/veiculos")
public class VeiculosController {

    private final VeiculosService veiculosService;


    public VeiculosController(VeiculosService service, VeiculosService veiculosService) {
        this.veiculosService = veiculosService;
    }

    @GetMapping
    public ResponseEntity<List<Veiculos>> findAll() {
        List<Veiculos> Veiculos = veiculosService.listar();
        return ResponseEntity.ok(Veiculos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        Veiculos veiculos = veiculosService.buscarPorId(id);

        if (veiculos == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Veiculo " + id + " não encontrado");
        }

        veiculosService.deletarPorId(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarVeiculosPorID(@PathVariable Integer id, @RequestBody Veiculos veiculoNovo) {

        Veiculos veiculos = veiculosService.atualizarVeiculo(id, veiculoNovo);


        if (veiculos == null) {
            return new ResponseEntity<>("Veiculos " + id + " não encontrado", HttpStatus.NOT_FOUND);
        }


        return ResponseEntity.ok(veiculos);
    }
}


