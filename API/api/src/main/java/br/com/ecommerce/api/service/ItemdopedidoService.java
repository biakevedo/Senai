package br.com.ecommerce.api.service;

import br.com.ecommerce.api.model.Itemdopedido;
import br.com.ecommerce.api.repository.ItemdopedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ItemdopedidoService {
    private static ItemdopedidoRepository itemdopedidoRepository;

    public void itemdopedidoService(ItemdopedidoRepository repo) {
        itemdopedidoRepository = repo;
    }

    public ItemdopedidoService(ItemdopedidoRepository itemdopedidoRepository) {
        this.itemdopedidoRepository = itemdopedidoRepository;
    }

    // listar todos
    public static List<Itemdopedido> listarTodos(){

        return itemdopedidoRepository.findAll();
    }
    // insert into bla bla bla
    public Itemdopedido cadastrarItemdopedido(Itemdopedido itemdopedido){
        return itemdopedidoRepository.save(itemdopedido);
    }

}