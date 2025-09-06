package br.com.ecommerce.api.controller;

import br.com.ecommerce.api.model.Itemdopedido;
import br.com.ecommerce.api.service.ItemdopedidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/itemdopedido")
public class ItemdopedidoController {
    // controller > service

    private ItemdopedidoService pedidoService;
    public ItemdopedidoController(ItemdopedidoService service){
        ItemdopedidoService pedidoService = service;
    }
    // Listar todos
    @GetMapping
    public ResponseEntity<List<Itemdopedido>> findAll(){
        // pegar a lista
        List<Itemdopedido> itemdopedido = ItemdopedidoService.listarTodos();

        return ResponseEntity.ok(itemdopedido);
    }

}