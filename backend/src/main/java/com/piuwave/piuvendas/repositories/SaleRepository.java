package com.piuwave.piuvendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.piuwave.piuvendas.dto.SaleSuccessDTO;
import com.piuwave.piuvendas.dto.SaleSumDTO;
import com.piuwave.piuvendas.entities.Sale;


//o JPA Repository já tem implementado as operacoes de inserir,
//buscar, alterar
//obs:: aqui como o JPA já é um componente, nao precisamos registra-la
//atraves de uma annotation
public interface SaleRepository extends JpaRepository<Sale, Long> {

	@Query("SELECT new com.piuwave.piuvendas.dto.SaleSumDTO(obj.seller, SUM(obj.amount)) " 
			+ "FROM Sale AS obj GROUP BY obj.seller")
	List<SaleSumDTO> amountGroupedBySeller();
	
	@Query("SELECT new com.piuwave.piuvendas.dto.SaleSuccessDTO(obj.seller, SUM(obj.visited), SUM(obj.deals)) " 
			+ "FROM Sale AS obj GROUP BY obj.seller")
	List<SaleSuccessDTO> successGroupedBySeller();
}
