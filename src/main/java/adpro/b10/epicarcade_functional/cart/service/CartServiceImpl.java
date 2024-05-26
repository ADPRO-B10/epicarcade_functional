package adpro.b10.epicarcade_functional.cart.service;

import adpro.b10.epicarcade_functional.Review.Model.Game;
import adpro.b10.epicarcade_functional.cart.dao.CartDao;
import adpro.b10.epicarcade_functional.cart.dao.GameDao;
import adpro.b10.epicarcade_functional.cart.model.Cart;
import adpro.b10.epicarcade_functional.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService{
    @Autowired
    private CartDao cartDao;

    @Autowired
    private GameDao gameDao;

//    @Autowired
//    private UserDao userDao;

    public Cart addToCart(String email, String itemId, Integer quantity) {
        Cart cart = CartDao.findByEmail(email);

        String username = JwtRequestFilter.CURRENT_USER;

        UserEntity user = null;
        if(username != null){
            UserEntity user = userDao.findById(username).get();

            Cart cart = new Cart(game, user);

            return cartDao.save(cart);
        }

        return null;
    }

    public void removeFromCart(String username, CartItemDTO cartItemDTO) {
        Optional<Cart> cartOpt = cartRepository.findByUsername(username);
        cartOpt.ifPresent(cart -> {
            cart.removeItem(cartItemDTO.toEntity());
            cartRepository.save(cart);
        });
    }

    public Cart incrementProductQuantity(String username, Integer productId) {
        // Increment product quantity in the cart
    }

    public Cart decrementProductQuantity(String username, Integer productId) {
        // Decrement product quantity in the cart
    }

    public void checkout(String username) {
        // Perform checkout operation
    }

    public List<Cart> getCartDetails() {
        String username = JwtRequestFilter.CURRENT_USER;
        UserEntity user = userDao.findById(username).get();
        return cartDao.findByUser(user);
}
