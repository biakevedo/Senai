package br.com.ecommerce.api.controller;

import br.com.ecommerce.api.model.Produto;
import br.com.ecommerce.api.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

    private final ProdutoService produtoService;

    // Construtor para injeção de dependência
    public ProdutoController(ProdutoService service) {
        this.produtoService = service;
    }

    // Listar todos os produtos
    @GetMapping
    public ResponseEntity<List<Produto>> findAll() {
        // Obter a lista de produtos
        List<Produto> produtos = produtoService.listarTodos();
        return ResponseEntity.ok(produtos);
    }

    // Cadastrar um novo produto
    @PostMapping
    public ResponseEntity<Produto> cadastrarProduto(@RequestBody Produto produto) {
        // Tentar cadastrar o produto
        produtoService.cadastrarProduto(produto);
        // Retornar com o status 201 (Created)
        return ResponseEntity.status(201).body(produto);
    }
    // Buscar produto por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarProduto(@PathVariable Integer id) {
        Produto produto = produtoService.buscarPorId(id);

        // Se o produto não for encontrado
        if (produto == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto " + id + " não encontrado");
        }
        // Se for encontrado
        return ResponseEntity.ok(produto);
    }

    // Deletar produto
    @DeleteMapping("/id")
    public ResponseEntity<?> deletarProduto(@RequestParam Integer id) {
        // Verifica se o produto existe
        Produto produto = produtoService.buscarPorId(id);

        // Se não for encontrado
        if (produto == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto " + id + " não foi encontrado");
        }
        // Caso exista, retorna
        return ResponseEntity.ok(produto);
    }
    @PutMapping("/produto/{id}")
    public ResponseEntity<?> atualizarProdutoPorId(@PathVariable Integer id, @RequestBody Produto produtoNovo) {
        // Tento atualizar o produto
        Produto produto = produtoService.atualizarProduto(id, produtoNovo);

        // Se não achar...
        if (produto == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto " + id + " não encontrado");
        }

        // Se achar, retorno ok
        return ResponseEntity.ok(produto);
    }

}


