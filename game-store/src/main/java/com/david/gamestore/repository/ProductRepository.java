package com.david.gamestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.david.gamestore.model.Product;

/**
 * Repository para classe Product. Contem os métodos necessários para realizar as operações com a base de dados
 * @author david
 *
 */
@Repository
@Transactional
public interface ProductRepository extends JpaRepository<Product, Integer> {
	
}
