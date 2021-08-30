package io.github.s19151.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name = "ordercomplaint")
public class OrderComplaint extends Complaint {
	//connections
	private Order order = null;
	private List<Decision> decisions = new ArrayList<>();
	
	//functional methods
	
	//connections
	
	@ManyToOne
	public Order getOrder() {
		return order;
	}
	
	public void setOrder(Order order) {
		if(this.order != null && !this.order.equals(order)) {
			this.order.removeOrderComplaint(this);
		}
		
		this.order = order;
		order.addOrderComplaint(this);
	}
	
	public void removeOrder(Order supply) {
		if(this.order != null && this.order.equals(order)) {
			this.order = null;
			supply.removeOrderComplaint(this);
		}
	}
	
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
			decision.setOrderComplaint(this);
		}
	}

	public void removeDecision(Decision decision) {
		if(decisions.contains(decision)) {
			decisions.remove(decision);
			decision.removeOrderComplaint(this);
		}
	}
	
	//getters and setters
		
}
