package com.ECommerce.ECommerce.service;

import com.ECommerce.ECommerce.domain.Pedidos;
import com.ECommerce.ECommerce.repository.PedidosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidosService {

    @Autowired
    private PedidosRepository repository;

    public Pedidos buscarPorId(Long id) {
        Optional<Pedidos> pedidosOptional = this.repository.findById(id);
        if (pedidosOptional.isPresent()) {
            return pedidosOptional.get();
        } else {
            throw new RuntimeException("Pedido não encontrado");
        }
    }

    public List<Pedidos> listarTodos() {
        return repository.findAll();
    }

    public Pedidos salvar(Pedidos pedidos) {
        return repository.save(pedidos);
    }

    public Pedidos atualizar(Long id, Pedidos pedidos) {
        Optional<Pedidos> pedidosOptional = this.repository.findById(id);
        if (pedidosOptional.isPresent()) {
            return this.repository.save(pedidos);
        } else {
            throw new RuntimeException("Pedido não encontrado");
        }
    }

    public void deletar(Long id) {
        Optional<Pedidos> pedidosOptional = this.repository.findById(id);
        if (pedidosOptional.isPresent()) {
            this.repository.delete(pedidosOptional.get());
        } else {
            throw new RuntimeException("Pedido não encontrado");
        }
    }
}
