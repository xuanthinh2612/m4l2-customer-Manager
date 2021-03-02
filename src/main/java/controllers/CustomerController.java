package controllers;


import model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.customer.ICustomerService;

import java.util.List;

@Controller
@RequestMapping("home")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @GetMapping("/list")

    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("list");
        List<Customer> customerList = customerService.findAll();
        modelAndView.addObject("customerList", customerList);
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEdit(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("edit");
        Customer customer = customerService.findById(id);
        modelAndView.addObject("customer",customer);
        return modelAndView;
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, @RequestParam String name, String email, String address){
        Customer customer =  new Customer(id,name,email,address);
        customerService.edit(customer);
         return "redirect:/home/list";
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDelete(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("delete");
        Customer customer = customerService.findById(id);
        modelAndView.addObject("customer",customer);
        return modelAndView;
    }
    @PostMapping("/delete/{id}")
    public String delete(@RequestParam Integer id ){
        customerService.delete(id);
         return "redirect:/home/list";
    }

}


