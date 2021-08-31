package io.github.s19151.model.projection;

import java.time.LocalDate;
import java.time.Period;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import io.github.s19151.model.Client;
import io.github.s19151.model.ClientCompany;
import io.github.s19151.model.ClientPerson;

public class ReadClientModel {
	//Client
	private long id;
	private List<String> phoneNumbers;
	private List<String> emails;
	private String address;
	
	//ClientPerson
	private String firstname;
	private String lastname;
	private LocalDate birthdate;
	
	//ClientCompany
	private String companyName;
	private String NIP;
	private String REGON;
	
	private ClientType type;
	
	private Set<ReadOrderModel> orders;

	public ReadClientModel(Client source) {
		this.id = source.getId();
		this.address = source.getAddress();
		
		this.phoneNumbers = source.getPhoneNumbers();
		this.emails = source.getEmails();
		
		this.orders = source.getOrders().stream()
				.map(ReadOrderModel::new)
				.collect(Collectors.toSet());
		
		if(source instanceof ClientPerson) {
			this.firstname = ((ClientPerson) source).getFirstname();
			this.lastname = ((ClientPerson) source).getLastname();
			this.birthdate = ((ClientPerson) source).getBirthdate();
			
			type = ClientType.ClientPerson;
		}
		else {
			this.companyName = ((ClientCompany) source).getCompanyName();
			this.companyName = ((ClientCompany) source).getNIP();
			this.companyName = ((ClientCompany) source).getREGON();
			
			type = ClientType.ClientCompany;
		}
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long newId) {
		id = newId;
	}
	
	public List<String> getPhoneNumbers() {
		return phoneNumbers;
	}
	
	public void setPhoneNumbers(List<String> newPhoneNumbers) {
		phoneNumbers = newPhoneNumbers;
	}
	
	public List<String> getEmails() {
		return emails;
	}
	
	public void setEmails(List<String> newEmails) {
		emails = newEmails;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String newAddress) {
		address = newAddress;
	}
	
	public Set<ReadOrderModel> getOrders() {
		return orders;
	}
	
	public void setOrders(Set<ReadOrderModel> newOrders) {
		orders = newOrders;
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
	
	public LocalDate getBirthdate() {
		return birthdate;
	}
	
	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}
	
	public int getAge() {
		return Period.between(getBirthdate(), LocalDate.now()).getYears();
	}
	
	public String getCompanyName() {
		return companyName;
	}
	
	public void setCompanyName(String newCompanyName) {
		companyName = newCompanyName;
	}
	
	public String getNIP() {
		return NIP;
	}
	
	public void setNIP(String newNIP) {
		NIP = newNIP;
	}
	
	public String getREGON() {
		return REGON;
	}
	
	public void setREGON(String newREGON) {
		REGON = newREGON;
	}
	
	public ClientType getClientType() {
		return type;
	}
	
	public void setClientType(ClientType newType) {
		type = newType;
	}
}
