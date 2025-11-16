package com.telusko.ecom_proj.service;

import com.telusko.ecom_proj.model.Product;
import com.telusko.ecom_proj.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepo repo;
    public List<Product> getProducts() {
    return repo.findAll();
    }
    public Product getProduct(int prodId){
        return repo.findById(prodId).orElse(null);
    }
}
