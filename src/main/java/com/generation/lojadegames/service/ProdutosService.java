package com.generation.lojadegames.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.lojadegames.model.Produtos;
import com.generation.lojadegames.repository.ProdutosRepository;

@Service
public class ProdutosService {
	
	@Autowired
	private ProdutosRepository produtosRepository;
	
	public Optional<Produtos> curtir(Long id){
		if(produtosRepository.existsById(id)) {
			Produtos produtos = produtosRepository.findById(id).get();
			
			produtos.setCurtir(produtos.getCurtir() + 1);
			
			return Optional.of(produtosRepository.save(produtos));
		}
		
		return Optional.empty();
	}

}
