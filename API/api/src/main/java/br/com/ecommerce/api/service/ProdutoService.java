package br.com.ecommerce.api.service;


import br.com.ecommerce.api.model.Produto;
import br.com.ecommerce.api.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.antlr.v4.runtime.tree.xpath.XPath.findAll;

@Service

public class ProdutoService {
    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }


    public List<Produto> listarTodos(){

        return produtoRepository.findAll();
    }



}


