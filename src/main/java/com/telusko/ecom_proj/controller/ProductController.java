package com.telusko.ecom_proj.controller;

import com.telusko.ecom_proj.model.Product;
import com.telusko.ecom_proj.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5174")
@RestController
@RequestMapping(value="/api")
public class ProductController {
    @Autowired
   private  ProductService service;
    @GetMapping(value="/products")
   public ResponseEntity<List<Product>> getProducts(){
       return new ResponseEntity<>(service.getProducts(),HttpStatus.OK);
   }

   @GetMapping(value="/products/{id}")
   public ResponseEntity<Product> getProduct(@PathVariable int id){
        Product product = service.getProduct(id);
        if(product!=null) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
   }
}
