package br.com.ecommerce.api.controller;

import br.com.ecommerce.api.model.Cliente;
import br.com.ecommerce.api.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    // controller > service

    private ClienteService clienteService;
            public ClienteController(ClienteService service){
                clienteService = service;
            }
        // Listar todos
    @GetMapping
        public ResponseEntity<List<Cliente>> findAll(){
                // pegar a lista de clientes
        List<Cliente> clientes = clienteService.listarTodos();

       return ResponseEntity.ok(clientes);
    }

}
