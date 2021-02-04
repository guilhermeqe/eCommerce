package com.ECommerce.ECommerce.controller;

import com.ECommerce.ECommerce.domain.Pedidos;
import com.ECommerce.ECommerce.service.PedidosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidosController {

    @Autowired
    private PedidosService service;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Pedidos buscarPorId(@PathVariable("id") Long id) {
        return this.service.buscarPorId(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Pedidos> listarTodos() {
        return this.service.listarTodos();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pedidos salvar(@RequestBody Pedidos pedidos) {
        return this.service.salvar(pedidos);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Pedidos atualizar(@PathVariable("id") Long id, @RequestBody Pedidos pedidos) {
        return this.service.atualizar(id, pedidos);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable("id") Long id) {
        this.service.deletar(id);
    }
}
