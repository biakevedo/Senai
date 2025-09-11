package br.com.ecommerce.api.service;

import br.com.ecommerce.api.model.Produto;
import br.com.ecommerce.api.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    // Construtor para injeção de dependência
    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    // Listar todos os produtos
    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    // Cadastrar um novo produto
    public Produto cadastrarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }
    // Buscar produto pelo ID
    public Produto buscarPorId(Integer id) {
        return produtoRepository.findById(id).orElse(null);
    }
    // Deletar produto
    public Produto deletarProduto(Integer id) {
        // Verificar se o produto existe
        Produto produto = buscarPorId(id);
        // Se o produto não existir, retornar
        if (produto == null){
            return null;
        }

        // Se existir, excluir o produto
        produtoRepository.delete(produto);
        return produto;
    }
}



