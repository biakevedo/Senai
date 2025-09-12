package br.com.ecommerce.api.controller;

import br.com.ecommerce.api.model.Itemdopedido;
import br.com.ecommerce.api.service.ItemdopedidoService;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springdoc.core.service.GenericResponseService;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/itemdopedido")
public class ItemdopedidoController {

    private final ItemdopedidoService itemdopedidoService;

    // Construtor para injeção de dependência
    public ItemdopedidoController(ItemdopedidoService service) {
        this.itemdopedidoService = service;

    }

    // Listar todos os itens do pedido
    @GetMapping
    public ResponseEntity<List<Itemdopedido>> findAll() {
        // Obter a lista de itens do pedido
        List<Itemdopedido> itemdopedidos = itemdopedidoService.listarTodos();
        return ResponseEntity.ok(itemdopedidos);
    }

    // Cadastrar um novo item do pedido
    @PostMapping
    public ResponseEntity<Itemdopedido> cadastrarItemdopedido(@RequestBody Itemdopedido itemdopedido) {
        // Tentar cadastrar o item do pedido
        itemdopedidoService.cadastrarItemdopedido(itemdopedido);
        // Retornar com o status 200 OK
        return ResponseEntity.ok(itemdopedido);
    }

    // Buscar item do pedido por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarItemdopedido(@PathVariable Integer id) {
        Itemdopedido itemdopedido = itemdopedidoService.buscarPorID(id);

        // Se o item não for encontrado
        if (itemdopedido == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item do pedido " + id + "não encontrado");
        }
            // Se for encontrado
            return ResponseEntity.ok(itemdopedido);
        }

        // Deletar item do pedido
    @DeleteMapping("/id")
    public ResponseEntity<?> deletarItemdopedido(@RequestParam Integer id) {
        // Verifica se o item existe
        Itemdopedido itemdopedido = itemdopedidoService.buscarPorID(id);

        // Se não for encontrado
        if (itemdopedido == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item do pedido " + id + "não foi encontrado");
        }
        // Caso exista, retorna
        return ResponseEntity.ok(itemdopedido);
    }
    @PutMapping("/itemdopedido/{id}")
    public ResponseEntity<?> atualizarItemdopedidoPorId(@PathVariable Integer id, @RequestBody Itemdopedido itemdoPedidoNovo) {
        // Tento atualizar o item do pedido
        Itemdopedido item = itemdopedidoService.atualizarItemdopedido(id, itemdoPedidoNovo);

        // Se não achar...
        if (item == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item de pedido " + id + " não encontrado");
        }

        // Se achar, retorno ok
        return ResponseEntity.ok(item);
    }

}


