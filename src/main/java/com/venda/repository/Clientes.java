package com.venda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.venda.model.Cliente;

public interface Clientes extends JpaRepository<Cliente, Long> {

}
