package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the samuser database table.
 * 
 */
@Entity
@NamedQuery(name="Samuser.findAll", query="SELECT s FROM Samuser s")
public class Samuser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int samid;

	private String address;

	@Temporal(TemporalType.DATE)
	private Date joindate;

	private String useremail;

	private String username;

	private String userpassword;

	private String userrole;

	//bi-directional many-to-one association to Samitem
	@OneToMany(mappedBy="samuser")
	private List<Samitem> samitems;

	public Samuser() {
	}

	public int getSamid() {
		return this.samid;
	}

	public void setSamid(int samid) {
		this.samid = samid;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getJoindate() {
		return this.joindate;
	}

	public void setJoindate(Date joindate) {
		this.joindate = joindate;
	}

	public String getUseremail() {
		return this.useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpassword() {
		return this.userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}

	public String getUserrole() {
		return this.userrole;
	}

	public void setUserrole(String userrole) {
		this.userrole = userrole;
	}

	public List<Samitem> getSamitems() {
		return this.samitems;
	}

	public void setSamitems(List<Samitem> samitems) {
		this.samitems = samitems;
	}

	public Samitem addSamitem(Samitem samitem) {
		getSamitems().add(samitem);
		samitem.setSamuser(this);

		return samitem;
	}

	public Samitem removeSamitem(Samitem samitem) {
		getSamitems().remove(samitem);
		samitem.setSamuser(null);

		return samitem;
	}

}