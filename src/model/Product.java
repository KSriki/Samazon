package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the products database table.
 * 
 */
@Entity
@Table(name="products")
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int productid;

	private String image;

	private float price;

	private int productcount;

	private String productdesc;

	private String productname;

	private int stock;

	//bi-directional many-to-one association to Samitem
	@OneToMany(mappedBy="product")
	private List<Samitem> samitems;

	public Product() {
	}

	public int getProductid() {
		return this.productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getProductcount() {
		return this.productcount;
	}

	public void setProductcount(int productcount) {
		this.productcount = productcount;
	}

	public String getProductdesc() {
		return this.productdesc;
	}

	public void setProductdesc(String productdesc) {
		this.productdesc = productdesc;
	}

	public String getProductname() {
		return this.productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public int getStock() {
		return this.stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public List<Samitem> getSamitems() {
		return this.samitems;
	}

	public void setSamitems(List<Samitem> samitems) {
		this.samitems = samitems;
	}

	public Samitem addSamitem(Samitem samitem) {
		getSamitems().add(samitem);
		samitem.setProduct(this);

		return samitem;
	}

	public Samitem removeSamitem(Samitem samitem) {
		getSamitems().remove(samitem);
		samitem.setProduct(null);

		return samitem;
	}

}