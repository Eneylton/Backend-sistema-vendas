package com.venda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.venda.model.Venda;

public interface Vendas extends JpaRepository<Venda, Long> {

}
