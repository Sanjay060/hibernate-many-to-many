package com.p5.demoentity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="coustemer_service")
public class CoustemerService {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="coustemer_id")
	private int coustemer_id;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="service_id")
	private int service_id;
	
	
	

}
