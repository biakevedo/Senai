package br.com.ecommerce.api.controller;

import br.com.ecommerce.api.model.Cliente;
import br.com.ecommerce.api.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
// link do controller
@RequestMapping("/api/clientes")
public class ClienteController {
    // controller > service

    private ClienteService clienteService;

    public ClienteController(ClienteService service) {
        clienteService = service;
    }

    // Listar todos
    @GetMapping
    public ResponseEntity<List<Cliente>> findAll() {
        // pegar a lista de clientes
        List<Cliente> clientes = clienteService.listarTodos();

        return ResponseEntity.ok(clientes);
    }

    @PostMapping
    public ResponseEntity<Cliente> cadastrarCliente(
            // recebe dados pelo corpo
            @RequestBody Cliente cliente
    ) {


        // tentar cadastrar o cliente
        clienteService.cadastrarCliente(cliente);
        // codigo 200 - ok
        return ResponseEntity.ok(cliente);
        // codigo 201 - created
       // return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }

    // buscar cliente por id
    // get
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarClientePorId(@PathVariable Integer id) {
        // Tentar encontrar o cliente pelo id
        Cliente cliente = clienteService.buscarPorId(id);

        // Se o cliente não for encontrado, retorna erro 404
        if (cliente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente " + id + " não encontrado");
        }

        // Se o cliente for encontrado, retorna com o cliente
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarClientePorId(@PathVariable Integer id) {
    // 1 verifico se o cliente existe
        Cliente cliente = clienteService.buscarPorId(id);

        // 2 se não existir retorno erro
        if (cliente == null) {return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente " + id + " não encontrado");
        }

        // 3 se existir, retorno ok
        return ResponseEntity.ok(cliente);
    }
}