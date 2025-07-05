package controller;

import dao.ProductDAO;
import model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProductController {

    private final ProductDAO productDAO = new ProductDAO();

    @GetMapping("/products")
    public ModelAndView showAllProducts() {
        List<Product> products = productDAO.findAll();
        ModelAndView mav = new ModelAndView("product-list");
        mav.addObject("products", products);
        return mav;
    }

    @GetMapping("/products/add")
    public ModelAndView showAddForm() {

        return new ModelAndView("add-product", "product", new Product());
    }

    @PostMapping("/products/add")
    public String addProduct(@ModelAttribute Product product) {
        productDAO.insert(product);
        return "redirect:/products";
    }

    @GetMapping("/products/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
         Product product = productDAO.findById(id);
         model.addAttribute("product", product);
         return "editProduct";
    }

    @PostMapping("/products/update")
    public String updateProduct(@ModelAttribute("product") Product product) {
        productDAO.updateProduct(product);
        return "redirect:/products";
    }

    @GetMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        productDAO.delete(id);
        return "redirect:/products";
    }
}

