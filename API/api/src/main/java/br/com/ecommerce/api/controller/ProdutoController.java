package br.com.ecommerce.api.controller;

import br.com.ecommerce.api.model.Produto;
import br.com.ecommerce.api.service.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produto")


public class ProdutoController {
    // controller > service

    private ProdutoService produtoService;

    public ProdutoController(ProdutoService service) {
        produtoService = service;
    }

    // Listar todos
    @GetMapping
    public ResponseEntity<List<Produto>> findAll() {
        // pegar a lista
        List<Produto> produto = produtoService.listarTodos();

        return ResponseEntity.ok(produto);
    }

    @PostMapping
    public ResponseEntity<Produto> cadastrarProduto(
            @RequestBody Produto produto
    ) {


        // tentar cadastrar o produto
        produtoService.cadastrarProduto(produto);
        // codigo 200 - ok
        return ResponseEntity.ok(produto);
        // codigo 201 - created
        // return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }


}

