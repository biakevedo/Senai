package br.com.ecommerce.api.service;

import br.com.ecommerce.api.model.Cliente;
import br.com.ecommerce.api.model.Pedido;
import br.com.ecommerce.api.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.antlr.v4.runtime.tree.xpath.XPath.findAll;

@Service

public class PedidoService {
    private static PedidoRepository pedidoRepository = null;

    public PedidoService(PedidoRepository repo) {
        pedidoRepository = repo;
    }


    public static List<Pedido> listarTodos(){

        return pedidoRepository.findAll();
    }
    // insert into bla bla bla
    public static Pedido cadastrarPedido(Pedido pedido){
        return pedidoRepository.save(pedido);
    }


}


