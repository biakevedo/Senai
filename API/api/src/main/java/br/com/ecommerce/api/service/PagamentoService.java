package br.com.ecommerce.api.service;

import br.com.ecommerce.api.model.Itemdopedido;
import br.com.ecommerce.api.model.Pagamento;
import br.com.ecommerce.api.repository.PagamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.antlr.v4.runtime.tree.xpath.XPath.findAll;

@Service

public class PagamentoService {
    private static PagamentoRepository pagamentoRepository = null;

    public PagamentoService(PagamentoRepository repo) {
        pagamentoRepository = repo;
    }


    public static List<Pagamento> listarTodos(){

        return pagamentoRepository.findAll();
    }


    // insert into bla bla bla
    public Pagamento cadastrarPagamento(Pagamento pagamento){
        return pagamentoRepository.save(pagamento);
    }



}