package br.com.ecommerce.api.controller;

import br.com.ecommerce.api.model.Cliente;
import br.com.ecommerce.api.model.Itemdopedido;
import br.com.ecommerce.api.model.Pagamento;
import br.com.ecommerce.api.service.ItemdopedidoService;
import br.com.ecommerce.api.service.PagamentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pagamento")
public class PagamentoController {
    // controller > service

    private PagamentoService pagamentoService;
    public PagamentoController(PagamentoService service){
        PagamentoService pagamentoService = service;
    }
    // Listar todos
    @GetMapping
    public ResponseEntity<List<Pagamento>> findAll() {
        // pegar a lista
        List<Pagamento> pagamento = pagamentoService.listarTodos();

        return ResponseEntity.ok(pagamento);
    }

    @PostMapping
    public ResponseEntity<Pagamento> cadastrarPagamento(
            @RequestBody Pagamento pagamento
    ) {


        // tentar cadastrar
        pagamentoService.cadastrarPagamento(pagamento);
        // codigo 200 - ok
        return ResponseEntity.ok(pagamento);

    }


}