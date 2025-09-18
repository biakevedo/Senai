package br.com.senai.entregas.service;


import br.com.senai.entregas.model.Veiculos;
import br.com.senai.entregas.repository.VeiculosRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class VeiculosService {

    // Declaração do repositório que será usado

    private final VeiculosRepository veiculosRepository;

    // Construtor com injecão de dependência

    public VeiculosService(VeiculosRepository veiculosRepository) {
        this.veiculosRepository = veiculosRepository;
    }


    // Listar todos os veiculos

    public List<Veiculos> listar() {
        return veiculosRepository.findAll();
    }

    // Cadastrar um novo veiculo

    public Veiculos cadastrarVeiculo(Veiculos veiculos) {
        return veiculosRepository.save(veiculos);
    }

    // Buscar veiculo por ID

    public Veiculos buscarPorId(int id) {
        return veiculosRepository.findById(id).get();
    }

    // Deletar veiculo por ID

    public boolean deletarPorId(int id) {
        Veiculos veiculo = buscarPorId(id);

        // Se o veiculo não existir, retorna falso

        if (veiculo == null) {
            return false;
        }

        // Se o veiculo existir, exclui ele

        veiculosRepository.delete(veiculo);
        return true;
    }

    // Atualizar veiculo por ID

    public Veiculos atualizarVeiculo(Integer id, Veiculos veiculoNovo) {

        // Busca o veiculo existente


        Veiculos veiculoAntigo = buscarPorId(id);

        // Se não achar, retorna null

        if (veiculoAntigo == null) {
            return null;
        }

        // Se achar, atualiza os dados do veiculo

        veiculoAntigo.setModelo(veiculoNovo.getModelo());
        veiculoAntigo.setTipo(veiculoNovo.getTipo());
        veiculoAntigo.setPlaca(veiculoNovo.getPlaca());
        return veiculoAntigo;
    }
}



