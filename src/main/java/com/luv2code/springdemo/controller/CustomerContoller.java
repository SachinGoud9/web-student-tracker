package com.luv2code.springdemo.controller;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerContoller {

    //need to inject the customer DAO

    //It is replaced by Customer Service
    @Autowired
    private CustomerService customerService;


    @GetMapping("/list")
    public String listCustomers(Model theModel){
        //get the Customers from the dao
        List<Customer> theCustomers = customerService.getCustomers();

        //add the Customers to the model
        theModel.addAttribute("customers",theCustomers);

        return "list-customers";
    }


    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel){
        //create model attribute to bind the data
        Customer theCustomer = new Customer();

        //add the Customers to the model
        theModel.addAttribute("customer",theCustomer);

        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer){

        customerService.saveCustomer(theCustomer);

        return "redirect:/customer/list";
    }


    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int theId,
                                    Model theModel){
        //get the customer from the database
        Customer theCustomer = customerService.getCustomer(theId);

        //set customer as a model attribute tp pre-populate the form
        theModel.addAttribute("customer",theCustomer);

        //send out the form

        return "customer-form";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("customerId") int theId){

        //get the customer from the database
        customerService.deleteCustomer(theId);

        return "redirect:/customer/list";


    }

}
