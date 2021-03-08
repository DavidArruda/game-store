package com.david.gamestore.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

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
	 * @param Sale, SaleItem
	 * @throws Exception
	 */
	void addItem(Sale sale, SaleItem saleItem) throws Exception;

	/**
	 * Remove um produto do carrinho de compra
	 * 
	 * @param Sale, SaleItem
	 * @throws Exception
	 */
	void removeItem(Sale sale, SaleItem saleItem) throws Exception;

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

}
