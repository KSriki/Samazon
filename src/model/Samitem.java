package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the samitems database table.
 * 
 */
@Entity
@Table(name="samitems")
@NamedQuery(name="Samitem.findAll", query="SELECT s FROM Samitem s")
public class Samitem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int itemid;

	private String list;

	private float price;

	@Temporal(TemporalType.DATE)
	private Date purchasedate;

	private int quantity;

	//bi-directional many-to-one association to Samuser
	@ManyToOne
	@JoinColumn(name="SAMID")
	private Samuser samuser;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="PRODUCTID")
	private Product product;

	public Samitem() {
	}

	public int getItemid() {
		return this.itemid;
	}

	public void setItemid(int itemid) {
		this.itemid = itemid;
	}

	public String getList() {
		return this.list;
	}

	public void setList(String list) {
		this.list = list;
	}

	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Date getPurchasedate() {
		return this.purchasedate;
	}

	public void setPurchasedate(Date purchasedate) {
		this.purchasedate = purchasedate;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Samuser getSamuser() {
		return this.samuser;
	}

	public void setSamuser(Samuser samuser) {
		this.samuser = samuser;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}