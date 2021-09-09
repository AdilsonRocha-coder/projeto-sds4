package com.piuwave.piuvendas.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.piuwave.piuvendas.dto.SellerDTO;
import com.piuwave.piuvendas.entities.Seller;
import com.piuwave.piuvendas.repositories.SellerRepository;

//a annotation abaixo registra o SellerService como um
//component do sistema assim ele podera ser injetado
//em outro sistema

@Service
public class SellerService {

	//aqui declaramos que o SellerService tem uma dependencia com o SellerRepository
	//com a annotation Autowired injeta a instancia abaixo automaticamente pelo JPA 
	@Autowired
	private SellerRepository repository;
	
	public List<SellerDTO> findAll(){
		List<Seller> result = repository.findAll();
		return result.stream().map(x -> new SellerDTO(x)).collect(Collectors.toList());
	}	
}
