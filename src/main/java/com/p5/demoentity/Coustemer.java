package com.p5.demoentity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="coustmer")
public class Coustemer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="first_name")
	private String firstname;
	@Column(name="last_name")
	private String lastname;
	@Column(name="sim")
	private String sim;
	@ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinTable(
			name="coustemer_service",
			joinColumns = @JoinColumn(name="coustemer_id"),
			inverseJoinColumns =@JoinColumn(name="service_id") 
			)
	
	private List<Service>services;
	
	public Coustemer()
	{
		
	}

	public Coustemer(String firstname, String lastname, String sim) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.sim = sim;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getSim() {
		return sim;
	}

	public void setSim(String sim) {
		this.sim = sim;
	}

	public List<Service> getServices() {
		return services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}

	@Override
	public String toString() {
		return "Coustemer [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", sim=" + sim + "]";
	}
	public void addService(Service s)
	{
		if(services==null)
		{
			services=new ArrayList<Service>();
		}
		services.add(s);
	}
	
	
	

}
