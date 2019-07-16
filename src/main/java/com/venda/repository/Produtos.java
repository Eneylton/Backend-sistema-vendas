package com.venda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.venda.model.Produto;

public interface Produtos extends JpaRepository<Produto, Long> {

}
