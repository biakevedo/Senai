package br.com.senai.entregas.controller;

import br.com.senai.entregas.model.Endereco;
import br.com.senai.entregas.service.EnderecoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
class EnderecoController {

        private final EnderecoService enderecoService;


        public EnderecoController(EnderecoService service, EnderecoService enderecoService) {
            this.enderecoService = enderecoService;
        }

        @GetMapping
        public ResponseEntity<List<Endereco>> findAll() {
            List<Endereco> Endereco = enderecoService.listarTodos();
            return ResponseEntity.ok(Endereco);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<String> delete(@PathVariable Integer id) {
            Endereco endereco = enderecoService.buscarPorId(id);

            if (endereco == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Endereço " + id + " não encontrado");
            }

           enderecoService.deletar(id);

            return ResponseEntity.noContent().build();
        }

        @PutMapping("/{id}")
        public ResponseEntity<?> atualizarEnderecoPorID(@PathVariable Integer id, @RequestBody Endereco tipoUsuarioNovo) {

            Endereco endereco = enderecoService.atualizar(id, tipoUsuarioNovo);


            if (endereco == null) {
                return new ResponseEntity<>("Endereço " + id + " não encontrado", HttpStatus.NOT_FOUND);
            }


            return ResponseEntity.ok(endereco);
        }
    }


