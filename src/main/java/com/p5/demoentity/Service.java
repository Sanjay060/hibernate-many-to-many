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
@Table(name="service")
public class Service {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="number")
	private double number;
	@ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinTable(
			name="coustemer_service",
			joinColumns = @JoinColumn(name="service_id"),
			inverseJoinColumns = @JoinColumn(name="coustemer_id") //inverse:-other side of the service//
			)
		
	private List<Coustemer>coustemers;
	
	public Service()
	{
		
	}

	public Service(long number) {
	
		this.number = number;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public List<Coustemer> getCoustemers() {
		return coustemers;
	}

	public void setCoustemers(List<Coustemer> coustemers) {
		this.coustemers = coustemers;
	}

	public void addCoustemer(Coustemer c)
	{
		if(coustemers==null)
		{
			coustemers = new ArrayList<Coustemer>();
		}
		coustemers.add(c);
	}

	@Override
	public String toString() {
		return "Service [id=" + id + ", number=" + number + "]";
	}
	
	
	
	
	

}
