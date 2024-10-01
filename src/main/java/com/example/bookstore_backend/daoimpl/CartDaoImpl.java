package com.example.bookstore_backend.daoimpl;
import com.example.bookstore_backend.dao.CartDao;
import com.example.bookstore_backend.entity.Book;
import com.example.bookstore_backend.entity.Cart;
import com.example.bookstore_backend.entity.CartItem;
import com.example.bookstore_backend.entity.User;
import com.example.bookstore_backend.repository.BookRepository;
import com.example.bookstore_backend.repository.CartItemRepository;
import com.example.bookstore_backend.repository.CartRepository;
import com.example.bookstore_backend.repository.UserRepository;
import com.example.bookstore_backend.utility.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Repository
public class CartDaoImpl implements CartDao {
    @Autowired
    UserRepository userRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    CartRepository  cartRepository;
    @Autowired
    CartItemRepository cartItemRepository;
    @Override
    public Integer getCartID(Integer userID) {
        User user = userRepository.findUserByUserID(userID);
        if (user == null) return -1;
        else return user.getCart().getCartID();
    }
    @Override
    public Cart getCart(Integer userID) {
        Integer cartID = getCartID(userID);
        if (cartID == -1) return null;
        else return cartRepository.findCartByCartID(cartID);
    }
    @Override
    public Cart createCart(Integer userID) {
        Cart cart = new Cart();
        cart.setUser(userRepository.findUserByUserID(userID));
        return cartRepository.save(cart);
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED, rollbackFor=Exception.class, isolation = Isolation.READ_COMMITTED)
    public List<CartItem> getCartItems(Integer userID) {
        Cart cart = getCart(userID);
        return cartItemRepository.findCartItemByCart(cart);
    }
    @Override
    public Integer addCartItem(String isbn, Integer userID, Integer bookAmount) {
        User user = userRepository.findUserByUserID(userID);
        CartItem cartItem = findCartItemByISBNInUser(isbn, userID);
        if (cartItem == null) {
            // new item
            cartItem = new CartItem();
            cartItem.setBookAmount(bookAmount);
            cartItem.setIsbn(isbn);
            cartItem.setCart(user.getCart());
        } else {
            // modify item
            cartItem.setBookAmount(bookAmount + cartItem.getBookAmount());
        }
        cartItemRepository.save(cartItem);
        return Constants.SUCCESS;
    }
    @Override
    @Transactional(propagation = Propagation.SUPPORTS, rollbackFor=Exception.class, isolation = Isolation.READ_COMMITTED)
    public Integer cancelCartItem(String isbn, Integer userID) {
        CartItem cartItem = findCartItemByISBNInUser(isbn, userID);
        if (cartItem == null) {
            return Constants.FAIL;
        } else {
            User user = userRepository.findUserByUserID(userID);
            user.getCart().getCartItems().remove(cartItem);
            cartItemRepository.delete(cartItem);
            return Constants.SUCCESS;
        }
    }
    @Override
    public CartItem findCartItemByISBNInUser(String isbn, Integer userID) {
        User user = userRepository.findUserByUserID(userID);
        Cart cart = user.getCart();
        Set<CartItem> items = cart.getCartItems();
        for (CartItem item: items) {
            if (item.getIsbn().equals(isbn)) return item;
        }
        return null;
    }
}
