package br.com.ecommerce.api.controller;

import br.com.ecommerce.api.model.Pedido;
import br.com.ecommerce.api.service.PedidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {
    // controller > service

    private PedidoService pedidoService;
    public PedidoController(PedidoService service){
        PedidoService pedidoService = service;
    }
    // Listar todos
    @GetMapping
    public ResponseEntity<List<Pedido>> findAll(){
        // pegar a lista
        List<Pedido> pedidos = PedidoService.listarTodos();

        return ResponseEntity.ok(pedidos);
    }

}