package br.com.ecommerce.api.controller;

import br.com.ecommerce.api.model.Pedido;
import br.com.ecommerce.api.service.PedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    // Construtor para injeção de dependência
    public PedidoController(PedidoService service) {
        this.pedidoService = service;
    }

    // Listar todos os pedidos
    @GetMapping
    public ResponseEntity<List<Pedido>> findAll() {
        // Obter a lista de pedidos
        List<Pedido> pedidos = pedidoService.listarTodos();
        return ResponseEntity.ok(pedidos);
    }

    // Cadastrar um novo pedido
    @PostMapping
    public ResponseEntity<Pedido> cadastrarPedido(@RequestBody Pedido pedido) {
        // Tentar cadastrar o pedido
        pedidoService.cadastrarPedido(pedido);
        // Retornar com o status 201 (Created)
        return ResponseEntity.status(201).body(pedido);
    }
    // Buscar item do pedido por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPedido(@PathVariable Integer id) {
        Pedido pedido = pedidoService.buscarPorId(id);

        // Se o pedido não for encontrado
        if (pedido == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedido " + id + " não encontrado");
        }
        // Se for encontrado
        return ResponseEntity.ok(pedido);
    }

    // Deletar pedido
    @DeleteMapping("/id")
    public ResponseEntity<?> deletarPedido(@RequestParam Integer id) {
        // Verifica se o pedido existe
        Pedido pedido = pedidoService.buscarPorId(id);

        // Se não for encontrado
        if (pedido == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedido " + id + " não foi encontrado");
        }
        // Caso exista, retorna
        return ResponseEntity.ok(pedido);
    }
    @PutMapping("/pedido/{id}")
    public ResponseEntity<?> atualizarPedidoPorId(@PathVariable Integer id, @RequestBody Pedido pedidoNovo) {
        // Tento atualizar o pedido
        Pedido pedido = pedidoService.atualizarPedido(id, pedidoNovo);

        // Se não achar...
        if (pedido == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedido " + id + " não encontrado");
        }

        // Se achar, retorno ok
        return ResponseEntity.ok(pedido);
    }



}

