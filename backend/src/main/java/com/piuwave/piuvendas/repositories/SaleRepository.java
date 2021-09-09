package com.piuwave.piuvendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.piuwave.piuvendas.entities.Sale;


//o JPA Repository já tem implementado as operacoes de inserir,
//buscar, alterar
//obs:: aqui como o JPA já é um componente, nao precisamos registra-la
//atraves de uma annotation
public interface SaleRepository extends JpaRepository<Sale, Long> {
}
