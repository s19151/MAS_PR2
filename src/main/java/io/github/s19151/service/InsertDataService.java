package io.github.s19151.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.s19151.model.ClientCompany;
import io.github.s19151.model.ClientPerson;
import io.github.s19151.model.Order;
import io.github.s19151.model.OrderProduct;
import io.github.s19151.model.OrderState;
import io.github.s19151.model.Person;
import io.github.s19151.model.Processor;
import io.github.s19151.model.ProductType;
import io.github.s19151.model.Warehouseman;
import io.github.s19151.repository.ClientRepository;
import io.github.s19151.repository.OrderProductRepository;
import io.github.s19151.repository.OrderRepository;
import io.github.s19151.repository.ProductRepository;
import io.github.s19151.repository.WorkerRepository;

@Service
@Transactional
public class InsertDataService {
	private ClientRepository clientRepository;
	private WorkerRepository workerRepository;
	private OrderRepository orderRepository;
	private OrderProductRepository orderProductRepository;
	private ProductRepository productRepository;
	
	public InsertDataService(
			ClientRepository clientRepository,
			WorkerRepository workerRepository,
			OrderRepository orderRepository,
			OrderProductRepository orderProductRepository,
			ProductRepository productRepository
		) {
		this.clientRepository = clientRepository;
		this.workerRepository = workerRepository;
		this.orderRepository = orderRepository;
		this.orderProductRepository = orderProductRepository;
		this.productRepository = productRepository;
	}
	
	public void insertData() {
		Warehouseman wh1 = new Warehouseman(new Person("Jan", "Kowalski", LocalDate.of(1950, 1, 1)), LocalDate.of(2010, 1, 1));
		Warehouseman wh2 = new Warehouseman(new Person("Adam", "Adamowski", LocalDate.of(1990, 1, 1)), LocalDate.of(2011, 1, 1));
		Warehouseman wh3 = new Warehouseman(new Person("Marcin", "Marcinowski", LocalDate.of(1956, 5, 6)), LocalDate.of(2011, 5, 1));
		Warehouseman wh4 = new Warehouseman(new Person("Bob", "Bobowski", LocalDate.of(1970, 1, 1)), LocalDate.of(2012, 2, 6));
		Warehouseman wh5 = new Warehouseman(new Person("Jan", "Bobowski", LocalDate.of(1980, 5, 5)), LocalDate.of(2015, 1, 6));
		
		List<String> emails = new ArrayList<>();
		emails.add("jan.kowalski@mail.com");
		List<String> numbers = new ArrayList<>();
		numbers.add("123456789");
		ClientPerson cp1 = new ClientPerson(numbers, emails, "miasto 01-123 ul. ulica 1/2", wh1.getPerson());
		emails = new ArrayList<>();
		emails.add("adam.kowalski@mail.com");
		numbers = new ArrayList<>();
		numbers.add("456789132");
		ClientPerson cp2 = new ClientPerson(numbers, emails, "wies 02-123 ul. krotka 1/2", new Person("Adam", "Kowalski", LocalDate.of(1997, 5, 10)));
		emails = new ArrayList<>();
		emails.add("bob.kowalski@mail.com");
		numbers = new ArrayList<>();
		numbers.add("78945613");
		ClientPerson cp3 = new ClientPerson(numbers, emails, "miasto 01-123 ul. wiejska 1/2", new Person("Bob", "Kowalski", LocalDate.of(1995, 8, 18)));
		
		emails = new ArrayList<>();
		emails.add("firma1@mail.com");
		numbers = new ArrayList<>();
		numbers.add("111222333");
		ClientCompany cc1 = new ClientCompany(numbers, emails, "miasto 01-123 ul. wiejska 3/2", "Firma1", "123-45-67-819", "123456789");
		emails = new ArrayList<>();
		emails.add("firma2@mail.com");
		numbers = new ArrayList<>();
		numbers.add("222333444");
		ClientCompany cc2 = new ClientCompany(numbers, emails, "wies 02-123 ul. krotka 4/4", "Firma2", "123-45-67-820", "123456720");
		emails = new ArrayList<>();
		emails.add("firma3@mail.com");
		numbers = new ArrayList<>();
		numbers.add("333444555");
		ClientCompany cc3 = new ClientCompany(numbers, emails, "miasto 01-123 ul. ulica 10/3", "Firma3", "123-45-67-830", "123456730");
		
		Processor p1 = new Processor("procesor1", 500., "", ProductType.Component, "", 2, 4, 1.8);
		Processor p2 = new Processor("procesor2", 1500., "", ProductType.Component, "", 8, 16, 4.);
		Processor p3 = new Processor("procesor3", 700., "", ProductType.Component, "", 4, 8, 3.5);
		Processor p4 = new Processor("procesor4", 900., "", ProductType.Component, "", 6, 12, 4.);
		
		Order o1 = new Order(LocalDate.of(2010, 5, 5), LocalDate.of(2010, 5, 10), OrderState.FULFILLED, 15000);
		Order o2 = new Order(LocalDate.of(2010, 5, 7), LocalDate.of(2010, 5, 13), OrderState.FULFILLED, 15000);
		Order o3 = new Order(LocalDate.of(2010, 6, 10), LocalDate.of(2010, 6, 17), OrderState.CANCELED, 15000);
		Order o4 = new Order(LocalDate.of(2012, 7, 5), LocalDate.of(2012, 7, 18), OrderState.FULFILLED, 15000);
		Order o5 = new Order(LocalDate.of(2012, 9, 5), LocalDate.of(2012, 9, 18), OrderState.CANCELED, 15000);
		
		OrderProduct op1 = new OrderProduct(1, "code1");
		OrderProduct op2 = new OrderProduct(5, "code2");
		OrderProduct op3 = new OrderProduct(2, "code3");
		OrderProduct op4 = new OrderProduct(1, "code4");
		OrderProduct op5 = new OrderProduct(4, "code5");
		OrderProduct op6 = new OrderProduct(7, "code6");
		OrderProduct op7 = new OrderProduct(7, "code6");
		
		//connections
		op1.setOrder(o1);
		op1.setProduct(p1);
		op2.setOrder(o1);
		op2.setProduct(p2);
		
		op3.setOrder(o2);
		op3.setProduct(p3);
		
		op4.setOrder(o3);
		op4.setProduct(p1);
		op5.setOrder(o3);
		op5.setProduct(p4);
		
		o1.setClient(cp1);
		o2.setClient(cp2);
		o3.setClient(cc1);
		
		o1.setWarehouseman(wh1);
		o2.setWarehouseman(wh2);
		o3.setWarehouseman(wh1);
		
		op6.setOrder(o4);
		op6.setProduct(p1);
		o4.setClient(cp1);
		o4.setWarehouseman(wh1);
		
		op7.setOrder(o5);
		op7.setProduct(p1);
		o5.setClient(cp1);
		o5.setWarehouseman(wh1);
		
		workerRepository.save(wh1);
		workerRepository.save(wh2);
		workerRepository.save(wh3);
		workerRepository.save(wh4);
		workerRepository.save(wh5);
		
		clientRepository.save(cp1);
		clientRepository.save(cp2);
		clientRepository.save(cp3);
		
		clientRepository.save(cc1);
		clientRepository.save(cc2);
		clientRepository.save(cc3);
		
		productRepository.save(p1);
		productRepository.save(p2);
		productRepository.save(p3);
		productRepository.save(p4);
		
		orderRepository.save(o1);
		orderRepository.save(o2);
		orderRepository.save(o3);
		orderRepository.save(o4);
		orderRepository.save(o5);
		
		orderProductRepository.save(op1);
		orderProductRepository.save(op2);
		orderProductRepository.save(op3);
		orderProductRepository.save(op4);
		orderProductRepository.save(op5);
		orderProductRepository.save(op6);
		orderProductRepository.save(op7);
	}
}
