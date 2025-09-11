package br.com.ecommerce.api.service;

import br.com.ecommerce.api.model.Cliente;
import br.com.ecommerce.api.model.Itemdopedido;
import br.com.ecommerce.api.repository.ItemdopedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemdopedidoService {

    private final ItemdopedidoRepository itemdopedidoRepository;

    // Construtor para injeção de dependência
    public ItemdopedidoService(ItemdopedidoRepository itemdopedidoRepository) {
        this.itemdopedidoRepository = itemdopedidoRepository;
    }

    // Listar todos os itens do pedido
    public List<Itemdopedido> listarTodos() {
        return itemdopedidoRepository.findAll();
    }

    // Cadastrar um novo item no pedido
    public Itemdopedido cadastrarItemdopedido(Itemdopedido itemdopedido) {
        return itemdopedidoRepository.save(itemdopedido);
    }

    // Buscar por ID do item do pedido
    public Itemdopedido buscarPorID(int id) {
        return itemdopedidoRepository.findById(id).orElse(null);
    }

    // Deletar
    public Itemdopedido deletarItemdopedido(int id) {
        // Verificar se o item do pedido existe
        Itemdopedido itemdopedido = buscarPorID(id);

        // Se o item do pedido não existir, retorna null
        if (itemdopedido == null) {
            return null;
        }

        // Se existir, excluir o itemdopedido
        itemdopedidoRepository.delete(itemdopedido);
        return itemdopedido;
    }
    // Atualizar/Editar cliente
    public Itemdopedido atualizarItemdopedido(Integer id, Itemdopedido novoItemdopedido) {
        // Procurar quem eu quero atualizar
        Itemdopedido itemAntigo = buscarPorID(id);

        // Se eu não achar, retorno nulo
        if (itemAntigo == null) {
            return null;
        }
        // Se existir
        itemAntigo.setQuantidade(novoItemdopedido.getQuantidade());
        itemAntigo.setProduto(novoItemdopedido.getProduto());
        itemAntigo.setPedido(novoItemdopedido.getPedido());
        return itemdopedidoRepository.save(itemAntigo);
    }
}
