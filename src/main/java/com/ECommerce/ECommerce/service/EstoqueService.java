package com.ECommerce.ECommerce.service;

import com.ECommerce.ECommerce.domain.Estoque;
import com.ECommerce.ECommerce.repository.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstoqueService {

    @Autowired
    private EstoqueRepository repository;

    public Estoque buscarPorId(Long id) {
        Optional<Estoque> estoqueOptional = this.repository.findById(id);
        if (estoqueOptional.isPresent()) {
            return estoqueOptional.get();
        } else {
            throw new RuntimeException("Estoque não encontrado");
        }
    }

    public List<Estoque> listarTodos() {
        return repository.findAll();
    }

    public Estoque salvar(Estoque estoque) {
        return repository.save(estoque);
    }

    public Estoque atualizar(Long id, Estoque estoque) {
        Optional<Estoque> estoqueOptional = this.repository.findById(id);
        if (estoqueOptional.isPresent()) {
            return this.repository.save(estoque);
        } else {
            throw new RuntimeException("Estoque não encontrado");
        }
    }

    public void deletar(Long id) {
        Optional<Estoque> estoqueOptional = this.repository.findById(id);
        if (estoqueOptional.isPresent()) {
            this.repository.delete(estoqueOptional.get());
        } else {
            throw new RuntimeException("Estoque não encontrado");
        }
    }
}
