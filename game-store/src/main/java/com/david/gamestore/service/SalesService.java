package com.david.gamestore.service;

import com.david.gamestore.model.Product;

public interface SalesService {
	
	/**
	 * Adiciona um novo produto no carrinho de compras
	 * @param product
	 * @throws Exception
	 */
	void addItem(Product product) throws Exception;
	
	/**
	 * Remove um produto do carrinho de compra
	 * @param product
	 * @throws Exception
	 */
	void removeItem(Product product) throws Exception;
	
	/**
	 * Obtem o checkout(frete, subtotal e total) de uma venda.
	 * @param product
	 * @throws Exception
	 */
	void getCheckOut(Product product) throws Exception;
	
}
