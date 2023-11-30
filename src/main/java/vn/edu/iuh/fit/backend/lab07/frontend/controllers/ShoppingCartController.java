package vn.edu.iuh.fit.backend.lab07.frontend.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.backend.lab07.backend.entities.Product;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class ShoppingCartController {
    @GetMapping("/view-cart")
    public String view_cart(Model model, HttpSession session) {
        return "client/checkout";
    }



    @GetMapping("/checkout")
    public String checkout(HttpSession session, Model model) {
        Object obj = session.getAttribute("items");
        List<Product> lst = (List<Product>) obj;
        return "";
    }
}
