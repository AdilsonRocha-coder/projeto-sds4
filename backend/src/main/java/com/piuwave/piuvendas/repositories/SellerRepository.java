package com.piuwave.piuvendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.piuwave.piuvendas.entities.Seller;


//o JPA Repository já tem implementado as operacoes de inserir,
//buscar, alterar
//obs:: aqui como o JPA já é um componente, nao precisamos registra-la
//atraves de uma annotation
public interface SellerRepository extends JpaRepository<Seller, Long> {

}
