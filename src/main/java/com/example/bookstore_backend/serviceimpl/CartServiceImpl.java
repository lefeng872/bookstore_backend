package com.example.bookstore_backend.serviceimpl;

import com.example.bookstore_backend.dao.CartDao;
import com.example.bookstore_backend.dao.UserDao;
import com.example.bookstore_backend.entity.Cart;
import com.example.bookstore_backend.entity.CartItem;
import com.example.bookstore_backend.entity.User;
import com.example.bookstore_backend.service.CartService;
import com.example.bookstore_backend.utility.Result;
import com.example.bookstore_backend.utility.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private CartDao cartDao;
    private Result<Cart> cartResult = new Result<>();
    private Result<List<CartItem>> cartItemListResult = new Result<>();
    @Override
    public Result<Cart> createCart(Integer userID) {
        User user = userDao.findUserByUserID(userID);
        if (user == null) {
            cartResult.setCode(Constants.FAIL);
            cartResult.setMsg("This user don't exist");
            cartResult.setDetail(null);
        } else {
            Cart cart = cartDao.getCart(userID);
            if (cart == null) {
                cartResult.setCode(Constants.SUCCESS);
                cartResult.setMsg("Success to Create a Cart");
                cartResult.setDetail(cartDao.createCart(userID));
            } else {
                cartResult.setCode(Constants.FAIL);
                cartResult.setMsg("This user already have a cart");
                cartResult.setDetail(null);
            }
        }
        return cartResult;
    }
    @Override
    public Result<List<CartItem>> getCartItems(Integer userID) {
        if (userID == null) {
            cartItemListResult.setCode(Constants.FAIL);
            cartItemListResult.setMsg("please login!");
            cartItemListResult.setDetail(null);
            return cartItemListResult;
        }
        List<CartItem> res = cartDao.getCartItems(userID);
        if (res == null) {
            cartItemListResult.setCode(Constants.FAIL);
            cartItemListResult.setMsg("Empty cart!");
            cartItemListResult.setDetail(null);
        } else {
            cartItemListResult.setCode(Constants.SUCCESS);
            cartItemListResult.setMsg("Success to get Carts");
            cartItemListResult.setDetail(res);
        }
        return cartItemListResult;
    }
    @Override
    public Result<List<CartItem>> addCartItem(String isbn, Integer userID, Integer bookAmount) {
        cartItemListResult.setCode(cartDao.addCartItem(isbn, userID, bookAmount));
        if (cartItemListResult.getCode() == Constants.SUCCESS) {
            cartItemListResult.setMsg("Success to Add to Cart");
        } else {
            cartItemListResult.setMsg("Fail to Add to Cart");
        }
        cartItemListResult.setDetail(null);
        return cartItemListResult;
    }
    @Override
    public Result<List<CartItem>> cancelCartItem(String isbn, Integer userID) {
        cartItemListResult.setCode(cartDao.cancelCartItem(isbn, userID));
        if (cartItemListResult.getCode() == Constants.SUCCESS) {
            cartItemListResult.setMsg("Success to Cancel");
        } else cartItemListResult.setMsg("Fail to Cancel");
        cartItemListResult.setDetail(cartDao.getCartItems(userID));
        return cartItemListResult;
    }
}
