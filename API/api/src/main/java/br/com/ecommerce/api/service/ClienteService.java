package br.com.ecommerce.api.service;

import br.com.ecommerce.api.model.Cliente;
import br.com.ecommerce.api.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    // Construtor para injeção de dependência
    public ClienteService(ClienteRepository repo) {
        this.clienteRepository = repo;
    }

    // Listar todos os clientes
    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    // Cadastrar um novo cliente
    public Cliente cadastrarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // Buscar cliente por ID
    public Cliente buscarPorId(Integer id) {
        return clienteRepository.findById(id).orElse(null);
    }

    // Deletar cliente
    public Cliente deletarCliente(Integer id) {
        // Verificar se o cliente existe
        Cliente cliente = buscarPorId(id);

        // Se o cliente não existir, retorna null
        if (cliente == null) {
            return null;
        }

        // Se existir, excluir o cliente
        clienteRepository.delete(cliente);
        return cliente;
    }

    // Atualizar/Editar cliente
    public Cliente atualizarCliente(Integer id, Cliente clienteNovo){
        // Procurar quem eu quero atualizar
        Cliente clienteAntigo = buscarPorId(id);

        // Se eu não achar, retorno nulo
        if (clienteAntigo == null) {
            return null;
        }
        // Se existir...
        clienteAntigo.setSenha(clienteNovo.getSenha());
        clienteAntigo.setNomeCompleto(clienteNovo.getNomeCompleto());
        clienteAntigo.setDataCadastro(clienteNovo.getDataCadastro());
        clienteAntigo.setEmail(clienteNovo.getEmail());
        clienteAntigo.setTelefone(clienteNovo.getTelefone());
        return clienteRepository.save(clienteAntigo);
    }
}
