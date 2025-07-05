package controller;

import dao.CustomerDAO;
import dao.ProductDAO;
import dao.SaleDAO;
import model.Customer;
import model.Sale;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/sales")
public class SaleController {

    private SaleDAO saleDAO = new SaleDAO();
    private CustomerDAO customerDAO = new CustomerDAO();
    private ProductDAO productDAO = new ProductDAO();

    @GetMapping
    public String listSales(Model model) {
        model.addAttribute("sales", saleDAO.getAllSales());
        return "sales"; // View: WEB-INF/views/sales.jsp
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("sale", new Sale());
        model.addAttribute("customers", customerDAO.getAllCustomers());
        model.addAttribute("products", productDAO.findAll());
        return "addSale"; // View: WEB-INF/views/addSale.jsp
    }

    @PostMapping("/save")
    public String saveSale(@ModelAttribute Sale sale, Model model) {
        sale.setSaleDate(LocalDateTime.now());
        boolean success = saleDAO.processSale(sale);
        if (success) {
            return "redirect:/sales";
        } else {
            model.addAttribute("error", "Stoc insuficient pentru produsul selectat.");
            model.addAttribute("sale", sale); // păstrează selecția
            model.addAttribute("customers", customerDAO.getAllCustomers());
            model.addAttribute("products", productDAO.findAll());
            return "addSale";
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteSale(@PathVariable("id") int id) {
        saleDAO.deleteSale(id);
        return "redirect:/sales";
    }
}
