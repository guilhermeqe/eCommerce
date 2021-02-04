package com.ECommerce.ECommerce.service;

import com.ECommerce.ECommerce.domain.Endereco;
import com.ECommerce.ECommerce.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository repository;

    public Endereco buscarPorId(Long id) {
        Optional<Endereco> enderecoOptional = this.repository.findById(id);
        if (enderecoOptional.isPresent()) {
            return enderecoOptional.get();
        } else {
            throw new RuntimeException("Endereço não encontrado");
        }
    }

    public List<Endereco> listarTodos() {
        return repository.findAll();
    }

    public Endereco salvar(Endereco endereco) {
        return repository.save(endereco);
    }

    public Endereco atualizar(Long id, Endereco endereco) {
        Optional<Endereco> enderecoOptional = this.repository.findById(id);
        if (enderecoOptional.isPresent()) {
            return this.repository.save(endereco);
        } else {
            throw new RuntimeException("Endereço não encontrado");
        }
    }

    public void deletar(Long id) {
        Optional<Endereco> enderecoOptional = this.repository.findById(id);
        if (enderecoOptional.isPresent()) {
            this.repository.delete(enderecoOptional.get());
        } else {
            throw new RuntimeException("Endereço não encontrado");
        }
    }
}
