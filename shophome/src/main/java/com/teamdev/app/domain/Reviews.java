package com.teamdev.app.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="reviews")
public class Reviews implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nick_name")
	private String nickName;
	
	@Column(name = "summary")
	private String summary;
	
	@Column(name = "review")
	private String review;
	
	@Column(name = "price")
	private Integer price;
	
	@Column(name = "value")
	private Integer value;
	
	@Column(name = "quality")
	private Integer quality;
	
	@Column(name = "produit")
	private String produit;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public Integer getQuality() {
		return quality;
	}

	public void setQuality(Integer quality) {
		this.quality = quality;
	}

	public String getProduit() {
		return produit;
	}

	public void setProduit(String produit) {
		this.produit = produit;
	}

	@Override
	public String toString() {
		return "Reviews [id=" + id + ", nickName=" + nickName + ", summary=" + summary + ", review=" + review
				+ ", price=" + price + ", value=" + value + ", quality=" + quality + ", produit=" + produit + "]";
	}

	
	
	
}
