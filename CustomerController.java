package controller;

import dao.CustomerDAO;
import model.Customer;
import model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    private CustomerDAO customerDAO = new CustomerDAO();

    @GetMapping
    public String listCustomers(Model model) {
        model.addAttribute("customers", customerDAO.getAllCustomers());
        return "customers"; // View: WEB-INF/views/customers.jsp
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "addCustomer"; // View: WEB-INF/views/addCustomer.jsp
    }

    @PostMapping("/add")
    public String addCustomer(@ModelAttribute("customer") Customer customer) {
        customerDAO.insertCustomer(customer);
        return "redirect:/customers";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        Customer customer = customerDAO.findById(id);
        model.addAttribute("customer", customer);
        return "editCustomer";
    }

    @PostMapping("/update")
    public String updateCustomer(@ModelAttribute("customer") Customer customer) {
        customerDAO.updateCustomer(customer);
        return "redirect:/customers";
    }

    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable("id") int id) {
        customerDAO.deleteCustomer(id);
        return "redirect:/customers";
    }
}
