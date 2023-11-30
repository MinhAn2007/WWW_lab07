package vn.edu.iuh.fit.backend.lab07.frontend.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.backend.lab07.backend.entities.Product;
import vn.edu.iuh.fit.backend.lab07.backend.repositories.ProductRepository;
import vn.edu.iuh.fit.backend.lab07.backend.service.ProductService;
import vn.edu.iuh.fit.backend.lab07.frontend.dto.CartItem;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/shopping")
public class ShoppingController {
    @Autowired
    private ProductService productServices;
    @Autowired
    private ProductRepository productRepository;

    @GetMapping()
    public String showProductListPaging(
            HttpSession session,
            Model model,
            @RequestParam("page") Optional<Integer> page,
            @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(12);

        Page<Product> candidatePage = productServices.findPaginated(currentPage - 1,
                pageSize, "name", "asc");

        model.addAttribute("productPage", candidatePage);

        int totalPages = candidatePage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        //them so phan tu co trong cart
//        model.addAttribute("itemsOnCart", 0);
        return "client/index";
    }

    @PostMapping("/add2cart/{id}")
    public String add2Cart(HttpSession session, Model model, @PathVariable("id") long id) {
        Object obj = session.getAttribute("items");

        Product product = productRepository.findById(id).get();

        HashMap<Long, CartItem> cart = null;

        if (obj == null)
            cart = new HashMap<>();
        else
            cart = (HashMap<Long, CartItem>) obj;

        CartItem item = new CartItem(product, 1);
        if (cart.get(product.getProduct_id()) != null)
            item.setAmount(item.getAmount() + 1);
        cart.put(product.getProduct_id(),item);

        session.setAttribute("items", cart);
        System.out.println(cart.values());
        session.setAttribute("itemsOnCart", cart.size());

        return "redirect:/shopping";
    }

    @GetMapping("/cart")
    public String viewCart(Model model, HttpSession session) {
        @SuppressWarnings("unchecked")
        HashMap<Long, CartItem> cartMap = (HashMap<Long, CartItem>) session.getAttribute("items");
        List<CartItem> cartItemList = CartItem.mapToCartItemList(cartMap);
        List<Long> amountsList = CartItem.mapToAmountList(cartMap);
        System.out.println("Cart Items: " + cartItemList);
        System.out.println("Amounts: " + amountsList);
        model.addAttribute("items",cartItemList);
        model.addAttribute("itemsOnCart",session.getAttribute("itemsOnCart"));
        return "client/checkout";
    }
}
