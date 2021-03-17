package com.david.gamestore.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.david.gamestore.model.Product;
import com.david.gamestore.model.Sale;
import com.david.gamestore.model.SaleItem;

/**
 * Serviço responsável por realizar as rotinas relacionadas com as vendas
 * 
 * @author david
 *
 */
@Service
public interface SalesService {

	/**
	 * Adiciona um novo produto no carrinho de compras
	 * 
	 * @param Sale, idItem
	 * @throws Exception
	 */
	Sale addItem(Sale sale, Long idItem) throws Exception;

	/**
	 * Remove um produto do carrinho de compra
	 * 
	 * @param Sale, indexSalemItem
	 * @throws Exception
	 */
	void removeItem(Sale sale, int indexSalemItem) throws Exception;

	/**
	 * Obtem o checkout(frete, subtotal e total) de uma venda.
	 * 
	 * @param sale
	 * @return List<BigDecimal>
	 * @throws Exception
	 */
	List<BigDecimal> getCheckOut(Sale sale) throws Exception;

	/**
	 * Calcula o frete relacionado a venda.
	 * 
	 * @param saleItems
	 * @return BigDecimal
	 * @throws Exception
	 */
	BigDecimal calculateFreight(List<SaleItem> saleItems) throws Exception;

	/**
	 * Retorna uma lista com todos os dados cadastrados na entidade products.
	 * @return List<Product>
	 * @throws Exception
	 */
	List<Product> findAllProducts() throws Exception;

}
