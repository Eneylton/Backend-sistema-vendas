package com.venda.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.venda.model.Venda;
import com.venda.repository.Produtos;
import com.venda.repository.Vendas;

@Service
public class VendaService {
	
	@Autowired
	private Vendas vendas;
	
	@Autowired
	private Produtos produtos;
	
	public Venda adicionar(Venda venda) {
		venda.setCadastro(LocalDateTime.now());
		venda.getItens().forEach(i -> {
			i.setVenda(venda);
			i.setProduto(produtos.findById(i.getProduto().getId()).get());
		});
		
		BigDecimal totalItens = venda.getItens().stream()
				.map(i -> i.getProduto().getValor().multiply(new BigDecimal(i.getQuantidade())))
				.reduce(BigDecimal.ZERO, BigDecimal::add);
		
		venda.setTotal(totalItens.add(venda.getFrete()));
		
		return vendas.save(venda);
	}
}
