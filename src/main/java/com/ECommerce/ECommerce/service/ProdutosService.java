package com.ECommerce.ECommerce.service;

import com.ECommerce.ECommerce.domain.Produtos;
import com.ECommerce.ECommerce.repository.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutosService {

    @Autowired
    private ProdutosRepository repository;

    public Produtos buscarPorId(Long id) {
        Optional<Produtos> produtosOptional = this.repository.findById(id);
        if (produtosOptional.isPresent()) {
            return produtosOptional.get();
        } else {
            throw new RuntimeException("Produto não encontrado");
        }
    }

    public List<Produtos> listarTodos() {
        return repository.findAll();
    }

    public Produtos salvar(Produtos produtos) {
        return repository.save(produtos);
    }

    public Produtos atualizar(Long id, Produtos produtos) {
        Optional<Produtos> produtosOptional = this.repository.findById(id);
        if (produtosOptional.isPresent()) {
            return this.repository.save(produtos);
        } else {
            throw new RuntimeException("Produto não encontrado");
        }
    }

    public void deletar(Long id) {
        Optional<Produtos> produtosOptional = this.repository.findById(id);
        if (produtosOptional.isPresent()) {
            this.repository.delete(produtosOptional.get());
        } else {
            throw new RuntimeException("Produto não encontrado");
        }
    }
}
