package br.com.senai.entregas.service;

import br.com.senai.entregas.model.Endereco;
import br.com.senai.entregas.repository.EnderecoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;

    public EnderecoService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    // Listar todos os endereços
    public List<Endereco> listarTodos() {
        return enderecoRepository.findAll();
    }

    // Buscar endereço por ID
    public Endereco buscarPorId(Integer id) {
        return enderecoRepository.findById(id).orElse(null);
    }

    // Cadastrar um novo endereço
    public Endereco cadastrar(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    // Atualizar um endereço existente
    public Endereco atualizar(Integer id, Endereco enderecoNovo) {
        Endereco enderecoExistente = buscarPorId(id);

        if (enderecoExistente == null) {
            return null;
        }

        // Atualizando os campos do endereço
        enderecoExistente.setLogradouro(enderecoNovo.getLogradouro());
        enderecoExistente.setNumero(enderecoNovo.getNumero());
        enderecoExistente.setCidade(enderecoNovo.getCidade());
        enderecoExistente.setCep(enderecoNovo.getCep());

        // Atualizando o relacionamento com o usuário
        enderecoExistente.setUsuario(enderecoNovo.getUsuario());

        return enderecoRepository.save(enderecoExistente);
    }

    // Deletar um endereço
    public Endereco deletar(Integer id) {
        Endereco enderecoExistente = buscarPorId(id);

        if (enderecoExistente == null) {
            return null;
        }

        enderecoRepository.delete(enderecoExistente);
        return enderecoExistente;
    }
}
