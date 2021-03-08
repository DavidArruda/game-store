package com.david.gamestore.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.david.gamestore.model.Sale;

/**
 * Repository para classe Sale. Contém os métodos necessários para realizar as operações com a base de dados.
 * @author david
 *
 */
@Repository
@Transactional
public interface SaleRepository extends JpaRepository<Sale, Long> {

}
