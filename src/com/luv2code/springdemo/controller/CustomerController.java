package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomer(Model theModel){
		
		List<Customer> allCust = customerService.getCustomers();
		
		theModel.addAttribute("customers",allCust);
		
		return "list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel){
		
		Customer customer = new Customer();
		theModel.addAttribute("customer",customer);
		System.out.println("SHow");
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer){
		System.out.println("save");
		customerService.saveCustomers(theCustomer);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel){
		
		Customer theCustomer = customerService.getCustomers(theId);
		
		theModel.addAttribute("customer",theCustomer );
		return "customer-form";
	}
	
	
	@GetMapping("/delete")
	public String delete(@RequestParam("customerId") int theId){
		
		customerService.deleteCustomers(theId);
		
		
		return "redirect:/customer/list";
	}
	
	
}
