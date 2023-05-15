package com.example.bookstore_backend.serviceimpl;

import com.example.bookstore_backend.dao.CartDao;
import com.example.bookstore_backend.entity.Cart;
import com.example.bookstore_backend.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartDao cartDao;
    @Override
    public Cart findCartByUserId(Integer userId) {
        return cartDao.findCartByUserId(userId);
    }
}
