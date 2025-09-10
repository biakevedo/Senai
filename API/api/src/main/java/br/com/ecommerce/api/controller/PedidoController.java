package br.com.ecommerce.api.controller;

import br.com.ecommerce.api.model.Cliente;
import br.com.ecommerce.api.model.Pedido;
import br.com.ecommerce.api.service.PedidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping
    public ResponseEntity<Pedido> cadastrarPedido(
            @RequestBody Pedido pedido
    ) {


        // tentar cadastrar
        PedidoService.cadastrarPedido(pedido);
        // codigo 200 - ok
        return ResponseEntity.ok(pedido);
        // codigo 201 - created
        // return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }


}
