package id.ac.ui.cs.advprog.eshop.controller;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping("/create")
    public String createProductPage(Model model){
        Product product = new Product();
        model.addAttribute("product", product);
        return "createProduct";
    }

    @PostMapping("/create")
    public String createProductPost(@ModelAttribute Product product, Model model){
        service.create(product);
        return "redirect:list";
    }

    @GetMapping("/edit")
    public String editProductPage(Model model){
        Product product = new Product();
        model.addAttribute("product", product);
        return "EditProduct";
    }

    @PostMapping("/edit")
    public String EditProductPost(@ModelAttribute Product product, Model model){
        service.edit(product);
        return "redirect:list";
    }

    @GetMapping("/list")
    public String productListPage(Model model){
        List<Product> allProducts = service.findAll();
        for(Product p : allProducts){
            System.out.println(p.getProductId()+" "+p.getProductName()+" ");
        }
        model.addAttribute("products", allProducts);
        return "productList";
    }
}
