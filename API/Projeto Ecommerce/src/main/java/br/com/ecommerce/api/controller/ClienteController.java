package br.com.ecommerce.api.controller;

import br.com.ecommerce.api.model.Cliente;
import br.com.ecommerce.api.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteService clienteService;


    // Construtor para injeção de dependência
    public ClienteController(ClienteService service) {
        this.clienteService = service;

    }

    // Listar todos os clientes
    @GetMapping
    public ResponseEntity<List<Cliente>> findAll() {
        List<Cliente> clientes = clienteService.listarTodos();
        return ResponseEntity.ok(clientes);
    }

    // Cadastrar um novo cliente
    @PostMapping
    public ResponseEntity<Cliente> cadastrarCliente(@RequestBody Cliente cliente) {
        clienteService.cadastrarCliente(cliente);
        // Código 201 - Created
        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }

    // Buscar cliente por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarClientePorId(@PathVariable Integer id) {
        Cliente cliente = clienteService.buscarPorId(id);

        // Se o cliente não for encontrado, retorna erro 404
        if (cliente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Cliente " + id + " não encontrado");
        }

        // Se o cliente for encontrado, retorna o cliente com status 200
        return ResponseEntity.ok(cliente);
    }

    // Deletar cliente por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarClientePorId(@PathVariable Integer id) {
        // Verifica se o cliente existe
        Cliente cliente = clienteService.buscarPorId(id);

        // Se o cliente não for encontrado, retorna erro 404
        if (cliente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Cliente " + id + " não encontrado");
        }

        // Caso o cliente exista, retorna um status 200 OK
        return ResponseEntity.ok(cliente);
    }
    @PutMapping("/id")
    public ResponseEntity<?> atualizarClientePorId(@PathVariable Integer id,@RequestBody Cliente clienteNovo) {
        // Tento atualizar o cliente
        Cliente cl = clienteService.atualizarCliente(id, clienteNovo);
        // Se não achar...
        if (cl == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente " + id + "não encontrado");
        }
        // Se achar, retorno ok
        return ResponseEntity.ok(cl);
    }
}
