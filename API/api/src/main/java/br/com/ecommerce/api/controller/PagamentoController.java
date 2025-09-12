package br.com.ecommerce.api.controller;

import br.com.ecommerce.api.model.Pagamento;
import br.com.ecommerce.api.service.PagamentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pagamento")
public class PagamentoController {

    private final PagamentoService pagamentoService;

    // Construtor para injeção de dependência
    public PagamentoController(PagamentoService service) {
        this.pagamentoService = service;
    }

    // Listar todos os pagamentos
    @GetMapping
    public ResponseEntity<List<Pagamento>> findAll() {
        // Obter a lista de pagamento
        List<Pagamento> pagamento = pagamentoService.listarTodos();
        return ResponseEntity.ok(pagamento);
    }

    // Cadastrar um novo pagamento
    @PostMapping
    public ResponseEntity<Pagamento> cadastrarPagamento(@RequestBody Pagamento pagamento) {
        // Tentar cadastrar o pagamento
        pagamentoService.cadastrarPagamento(pagamento);
        // Retornar com o status 200 OK
        return ResponseEntity.ok(pagamento);
    }
    // Buscar pagamento por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPagamentoPorID(@PathVariable Integer id) {
        Pagamento pagamento = pagamentoService.buscarPorId(id);
        // Se o pagamnto não for encontrado, retorna

        if (pagamento == null){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Pagamento " + id + "não encontrado.");
        }
        // Se for encontrado

        return ResponseEntity.ok(pagamento);
    }
    // Deletar Pagamento por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarPagamentoPorID(@PathVariable Integer id) {
        // Verifica se o pagamento existe
        Pagamento pagamento = pagamentoService.buscarPorId(id);

        // Se o pagamento não for encontrado, retorna
        if (pagamento == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pagamento " + id + "não encontrado.");
        }
        // Caso seja encontrado, retorna 200
        return ResponseEntity.ok(pagamento);
    }
    @PutMapping("/pagamento/{id}")
    public ResponseEntity<?> atualizarPagamentoPorId(@PathVariable Integer id, @RequestBody Pagamento pagamentoNovo) {
        // Tento atualizar o pagamento
        Pagamento pagamento = pagamentoService.atualizarPagamento(id, pagamentoNovo);

        // Se não achar...
        if (pagamento == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pagamento " + id + " não encontrado");
        }

        // Se achar, retorno ok
        return ResponseEntity.ok(pagamento);
    }

}
