package com.david.gamestore.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Classe modelo para relacionar os produtos com uma venda
 * @author david
 *
 */
@Entity
@Table(name = "sales_items")
public class SaleItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@ManyToOne(fetch = FetchType.EAGER)
	private Product product;

	@JsonIgnore
	@NotBlank
	@ManyToOne(fetch = FetchType.EAGER)
	private Sale sale;
	
	@Deprecated
	public SaleItem() {
		//CONSTRUTOR VAZIO
	}
	
	public SaleItem(@NotBlank Product product, @NotBlank Sale sale) {
		super();
		this.product = product;
		this.sale = sale;
	}
	
	public Long getId() {
		return id;
	}
	
	public Product getProduct() {
		return product;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public Sale getSale() {
		return sale;
	}
	
	public void setSale(Sale sale) {
		this.sale = sale;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SaleItem other = (SaleItem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
