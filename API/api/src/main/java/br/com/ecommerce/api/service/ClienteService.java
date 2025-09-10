package br.com.ecommerce.api.service;

import br.com.ecommerce.api.model.Cliente;
import br.com.ecommerce.api.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.antlr.v4.runtime.tree.xpath.XPath.findAll;

@Service

public class ClienteService {
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository repo) {
        clienteRepository = repo;
    }

    // listar todos
    public List<Cliente> listarTodos(){

        return clienteRepository.findAll();
    }
    // insert into bla bla bla
    public Cliente cadastrarCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public Cliente buscarPorId(Integer id){
        return clienteRepository.findById(id).orElse(null);
    }
    // para excluir
    public Cliente deletarCliente(Integer id){
        // 1 verificar se o cliente existe
        Cliente cliente = buscarPorId(id);

        // 2 se nao existir, retorno nulo
        if (cliente == null){
            return null;
        }

        // 3 e se existir, excluo
        clienteRepository.delete(cliente);
        return cliente;
    }


}
