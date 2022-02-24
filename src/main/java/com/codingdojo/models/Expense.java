package com.codingdojo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table( name= "expense" )
public class Expense {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private int id;
	
	@NotNull
	@Size(min = 1, max = 40, message="El nombre no puede estar vacio.")
	private String name;
	
	@NotNull
	@Size(min = 1, max = 40, message="El vendedor no puede estar vacio.")
	private String vendor;
	
	@NotNull
	@Min(value=0, message="El monto debe ser mayor que 0.")
	private String amount;
	
	@NotNull
	@Size(min = 3, max = 254, message="La descripcion debe tener al menos 3 caracteres.")
	private String description;
	
	public Expense() {
	}

	public Expense(String name, String vendor, String amount, String description) {
		this.name = name;
		this.vendor = vendor;
		this.amount = amount;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
