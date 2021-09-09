package com.piuwave.piuvendas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.piuwave.piuvendas.dto.SaleDTO;
import com.piuwave.piuvendas.dto.SaleSuccessDTO;
import com.piuwave.piuvendas.dto.SaleSumDTO;
import com.piuwave.piuvendas.entities.Sale;
import com.piuwave.piuvendas.repositories.SaleRepository;
import com.piuwave.piuvendas.repositories.SellerRepository;

//a annotation abaixo registra o SellerService como um
//component do sistema assim ele podera ser injetado
//em outro sistema

@Service
public class SaleService {

	//aqui declaramos que o SellerService tem uma dependencia com o SellerRepository
	//com a annotation Autowired injeta a instancia abaixo automaticamente pelo JPA 
	@Autowired
	private SaleRepository repository;
	
	//para evitarmos que o JPA fique buscando os vendedores ao montar a listagem de vendas
	//fazemos a dependencia abaixo do SellerRepositor
	@Autowired
	private SellerRepository sellerRepository;
	
	@Transactional(readOnly = true)//aqui o JPA nao fara logs no BD
	public Page<SaleDTO> findAll(Pageable pageable){
		sellerRepository.findAll();
		Page<Sale> result = repository.findAll(pageable);
		return result.map(x -> new SaleDTO(x));
	}	
	
	@Transactional(readOnly = true)//aqui o JPA nao fara logs no BD
	public List<SaleSumDTO> amountGroupedBySeller(){
			return repository.amountGroupedBySeller();
	}
	
	@Transactional(readOnly = true)//aqui o JPA nao fara logs no BD
	public List<SaleSuccessDTO> successGroupedBySeller(){
			return repository.successGroupedBySeller();
	}
}
