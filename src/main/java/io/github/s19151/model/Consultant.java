package io.github.s19151.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity(name = "consultant")
public class Consultant extends Worker {
	//connections
	private List<Decision> decisions = new ArrayList<>();
	
	public Consultant() {};
	
	public Consultant(Person person, LocalDate employmentDate, double ratePerHour) {
		super(person, employmentDate, ratePerHour);
	}
	
	public Consultant(Person person, LocalDate employmentDate) {
		super(person, employmentDate);
	}
	
	//functional methods
	
	//connections
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	public List<Decision> getDecisions() {
		return decisions;
	}
	
	public void setDecisions(List<Decision> orderComplaints) {
		this.decisions = orderComplaints;
	}
	
	public void addDecision(Decision decision) {
		if(!decisions.contains(decision)) {
			decisions.add(decision);
			decision.setConsultant(this);
		}
	}

	public void removeDecision(Decision decision) {
		if(decisions.contains(decision)) {
			decisions.remove(decision);
			decision.removeConsultant(this);
		}
	}
	
	//getters and setters
}
