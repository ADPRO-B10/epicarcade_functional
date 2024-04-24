package adpro.b10.epicarcade_functional.cart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
class CartController {

    @Autowired
    private CartService cartService;
    @PreAuthorize("hasRole('BUYER')")
    @GetMapping("/addToCart/{productId}")
    public void addProductToCart(@PathVariable(name = "productId") Integer productId) {
        // Add product to cart
    }
}