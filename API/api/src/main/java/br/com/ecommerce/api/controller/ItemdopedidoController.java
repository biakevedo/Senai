package br.com.ecommerce.api.controller;

import br.com.ecommerce.api.model.Itemdopedido;
import br.com.ecommerce.api.model.Produto;
import br.com.ecommerce.api.service.ItemdopedidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/itemdopedido")
public class ItemdopedidoController {
    // controller > service

    private ItemdopedidoService itemdopedidoService;

    public ItemdopedidoController(ItemdopedidoService service) {
        ItemdopedidoService pedidoService = service;
    }

    // Listar todos
    @GetMapping
    public ResponseEntity<List<Itemdopedido>> findAll() {
        // pegar a lista
        List<Itemdopedido> itemdopedido = ItemdopedidoService.listarTodos();

        return ResponseEntity.ok(itemdopedido);
    }

    @PostMapping
    public ResponseEntity<Itemdopedido> cadastrarItemdopedido(
            @RequestBody Itemdopedido itemdopedido
    ) {


        // tentar cadastrar o item do pedido
        itemdopedidoService.cadastrarItemdopedido(itemdopedido);
        // codigo 200 - ok
        return ResponseEntity.ok(itemdopedido);
    }
}

