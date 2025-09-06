package br.com.ecommerce.api.controller;

import br.com.ecommerce.api.model.Produto;
import br.com.ecommerce.api.service.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/produto")


public class ProdutoController {
    // controller > service

    private ProdutoService produtoService;
    public ProdutoController(ProdutoService service){
        produtoService = service;
    }
    // Listar todos
    @GetMapping
    public ResponseEntity<List<Produto>> findAll(){
        // pegar a lista
        List<Produto> produto = produtoService.listarTodos();

        return ResponseEntity.ok(produto);
    }

}