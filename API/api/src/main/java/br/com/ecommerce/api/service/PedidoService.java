package br.com.ecommerce.api.service;

import br.com.ecommerce.api.model.Pedido;
import br.com.ecommerce.api.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    // Construtor para injeção de dependência
    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    // Listar todos os pedidos
    public List<Pedido> listarTodos() {
        return pedidoRepository.findAll();
    }

    // Cadastrar um novo pedido
    public Pedido cadastrarPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    // Buscar pedido por ID
    public Pedido buscarPorId(Integer id) {
        return pedidoRepository.findById(id).orElse(null);
    }

    // Deletar pedido
    public Pedido deletarPedido(int id) {

        // Verificar se o pedido existe
        Pedido pedido = buscarPorId(id);

        // Se o pedido existir, retorna
        if (pedido != null) {
            return null;
        }
        // Se existir, excluir pedido
        pedidoRepository.delete(pedido);
        return pedido;
    }
    // Atualizar/Editar pedido
    public Pedido atualizarPedido(Integer id, Pedido pedidoNovo){
        // Procurar quem eu quero atualizar
        Pedido pedidoAntigo = buscarPorId(id);

        // Se eu não achar, retorno nulo
        if (pedidoAntigo == null) {
            return null;
        }

        // Se existir...
        pedidoAntigo.setDataPedido(pedidoNovo.getDataPedido());
        pedidoAntigo.setDataPedido(pedidoNovo.getDataPedido());
        pedidoAntigo.setValorTotal(pedidoNovo.getValorTotal());
        return pedidoRepository.save(pedidoAntigo);
    }


}
