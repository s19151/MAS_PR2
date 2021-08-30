package io.github.s19151.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity(name = "manager")
public class Manager extends Worker {
	//connections
	private List<SupplyComplaint> supplyComplaints = new ArrayList<>();
	
	public Manager() {};
	
	public Manager(Person person, LocalDate employmentDate, double ratePerHour) {
		super(person, employmentDate, ratePerHour);
	}
	
	public Manager(Person person, LocalDate employmentDate) {
		super(person, employmentDate);
	}
	
	//functional methods
	
	//connections
	
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
			supplyComplaint.setManager(this);
		}
	}

	public void removeSupplyComplaint(SupplyComplaint supplyComplaint) {
		if(supplyComplaints.contains(supplyComplaint)) {
			supplyComplaints.remove(supplyComplaint);
			supplyComplaint.removeManager(this);
		}
	}
	
	//getters and setters
}
