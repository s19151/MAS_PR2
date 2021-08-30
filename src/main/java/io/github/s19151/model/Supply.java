package io.github.s19151.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity(name = "supply")
public class Supply {
	private long id;
	private LocalDate supplyDate;
	
	//connections
	private List<SupplyProduct> supplyProducts = new ArrayList<>();
	private List<SupplyComplaint> supplyComplaints = new ArrayList<>();
	private Supplier supplier = null;
	
	public Supply() {}
	
	public Supply(LocalDate supplyDate) {
		this.supplyDate = supplyDate;
	}
	
	//functional methods
	
	//connections
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	public List<SupplyProduct> getSupplyProducts() {
		return supplyProducts;
	}
	
	public void setSupplyProducts(List<SupplyProduct> supplyProducts) {
		this.supplyProducts = supplyProducts;
	}
	
	public void addSupplyProduct(SupplyProduct supplyProduct) {
		if(!supplyProducts.contains(supplyProduct)) {
			supplyProducts.add(supplyProduct);
			supplyProduct.setSupply(this);
		}
	}

	public void removeSupplyProduct(SupplyProduct supplyProduct) {
		if(supplyProducts.contains(supplyProduct)) {
			supplyProducts.remove(supplyProduct);
			supplyProduct.removeSupply(this);
		}
	}
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	public List<SupplyComplaint> getSupplyComplaints() {
		return supplyComplaints;
	}
	
	public void setSupplyComplaints(List<SupplyComplaint> supplyComplaints) {
		this.supplyComplaints = supplyComplaints;
	}
	
	public void addSupplyComplaint(SupplyComplaint supplyComplaint) {
		if(!supplyComplaints.contains(supplyComplaint)) {
			supplyComplaints.add(supplyComplaint);
			supplyComplaint.setSupply(this);
		}
	}

	public void removeSupplyComplaint(SupplyComplaint supplyComplaint) {
		if(supplyComplaints.contains(supplyComplaint)) {
			supplyComplaints.remove(supplyComplaint);
			supplyComplaint.removeSupply(this);
		}
	}
	
	@ManyToOne
	public Supplier getSupplier() {
		return supplier;
	}
	
	public void setSupplier(Supplier supplier) {
		if(this.supplier != null && !this.supplier.equals(supplier)) {
			this.supplier.removeSupply(this);
		}
		
		this.supplier = supplier;
		supplier.addSupply(this);
	}
	
	public void removeSupplier(Supplier supplier) {
		if(this.supplier != null && this.supplier.equals(supplier)) {
			this.supplier = null;
			supplier.removeSupply(this);
		}
	}
	
	//getters and setters
	
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	public long getId() {
		return id;
	}
	
	private void setId(long id) {
		this.id = id;
	}
	
	@Basic
	public LocalDate getSupplyDate() {
		return supplyDate;
	}
	
	public void setSupplyDate(LocalDate supplyDate) {
		this.supplyDate = supplyDate;
	}
	
	@Override
	public String toString() {
		return String.format(
				"%s: %d %s",
				getClass().getName(),
				getId(),
				getSupplyDate().toString()
			);
	}
}
