package br.com.ecommerce.api.controller;

import br.com.ecommerce.api.model.Pagamento;
import br.com.ecommerce.api.service.PagamentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/pagamento")
public class PagamentoController {
    // controller > service

    private PagamentoService pagamentoService;
    public PagamentoController(PagamentoService service){
        PagamentoService pedidoService = service;
    }
    // Listar todos
    @GetMapping
    public ResponseEntity<List<Pagamento>> findAll(){
        // pegar a lista
        List<Pagamento> pagamento = PagamentoService.listarTodos();

        return ResponseEntity.ok(pagamento);
    }

}