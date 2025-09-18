package br.com.senai.entregas.service;

import br.com.senai.entregas.model.Entregas;
import br.com.senai.entregas.repository.EntregasRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntregasService {

    private final EntregasRepository entregasRepository;

    public EntregasService(EntregasRepository entregaRepository) {
        this.entregasRepository = entregaRepository;
    }

    // Listar todas as entregas
    public List<Entregas> listarTodos() {
        return entregasRepository.findAll();
    }

    // Buscar entrega por ID
    public Entregas buscarPorId(Integer id) {
        return entregasRepository.findById(id).orElse(null);
    }

    // Cadastrar uma nova entrega
    public Entregas cadastrar(Entregas entregas) {
        return entregasRepository.save(entregas);
    }

    // Atualizar uma entrega existente
    public Entregas atualizar(Integer id, Entregas entregaNova) {
        Entregas entregaExistente = buscarPorId(id);

        if (entregaExistente == null) {
            return null;
        }

        // Atualizando os campos da entrega
        entregaExistente.setDatapedido(entregaNova.getDatapedido());
        entregaExistente.setStatus(entregaNova.getStatus());
        entregaExistente.setDescricao(entregaNova.getDescricao());
        entregaExistente.setUsuario(entregaNova.getUsuario());
        entregaExistente.setEndereco(entregaNova.getEndereco());

        return entregasRepository.save(entregaExistente);
    }

    // Deletar uma entrega
    public Entregas deletar(Integer id) {
        Entregas entregasExistente = buscarPorId(id);

        if (entregasExistente == null) {
            return null;
        }

        entregasRepository.delete(entregasExistente);
        return entregasExistente;
    }
}