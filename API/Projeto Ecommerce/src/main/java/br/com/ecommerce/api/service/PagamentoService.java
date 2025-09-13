package br.com.ecommerce.api.service;

import br.com.ecommerce.api.model.Cliente;
import br.com.ecommerce.api.model.Pagamento;
import br.com.ecommerce.api.repository.PagamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class PagamentoService {

    private final PagamentoRepository pagamentoRepository;

    // Construtor para injeção de dependência
    public PagamentoService(PagamentoRepository pagamentoRepository) {
        this.pagamentoRepository = pagamentoRepository;
    }

    // Listar todos os pagamentos
    public List<Pagamento> listarTodos() {
        return pagamentoRepository.findAll();
    }

    // Cadastrar um novo pagamento
    public Pagamento cadastrarPagamento(Pagamento pagamento) {
        return pagamentoRepository.save(pagamento);
    }

    // Buscar pagamento por ID
    public Pagamento buscarPorId(Integer id) {
        return pagamentoRepository.findById(id).orElse(null);
    }

    // Deletar pagamento
    public Pagamento deletarPagamento(Integer id) {

        // Verificar se o pagamento existe
        Pagamento pagamento = buscarPorId(id);

        // Se o pagamento não existir, retorna
        if (pagamento == null) {
            return null;
        }

        // Se existir, excluir o pagamento
        pagamentoRepository.delete(pagamento);
        return pagamento;
    }
    // Atualizar/Editar
    public Pagamento atualizarPagamento(Integer id, Pagamento pagamentoNovo){
        // Procurar quem eu quero atualizar
        Pagamento pagamentoAntigo = buscarPorId(id);

        // Se eu não achar, retorno nulo
        if (pagamentoAntigo == null) {
            return null;
        }
        // Se existir...
        pagamentoAntigo.setFormaPagamento(pagamentoNovo.getFormaPagamento());
        pagamentoAntigo.setStatus(pagamentoNovo.getStatus());
        pagamentoAntigo.setPedidoId(pagamentoNovo.getPedidoId());
        pagamentoAntigo.setDataPedido(pagamentoNovo.getDataPedido());
        return pagamentoRepository.save(pagamentoAntigo);

    }
}

