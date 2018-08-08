package com.teamdev.app.services.dto;

import com.teamdev.app.domain.Produits;

import java.util.List;

import com.teamdev.app.domain.Images;

public class ProduitDTO {
	
	private Produits produit;
	
	private List<Images> images;

	public Produits getProduit() {
		return produit;
	}

	public void setProduit(Produits produit) {
		this.produit = produit;
	}

	public List<Images> getImages() {
		return images;
	}

	public void setImages(List<Images> images) {
		this.images = images;
	}
	
}
