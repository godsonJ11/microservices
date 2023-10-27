package com.productModule.product.controller;

import com.productModule.product.Response.Response;
import com.productModule.product.model.Product;
import com.productModule.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;
    @PostMapping("/product")
    public ResponseEntity<Response> saveProductDetails(@RequestBody Product product){
        Response response=productService.saveTheProduct(product);
        return ResponseEntity.
                status(HttpStatus.OK).body(response);
    }

    //feign client will get the data from the user
    @GetMapping("list/user")
    public ResponseEntity<Response>getTheUserDetails(){
       Response response=productService.getUserDetails();
       return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("list/product")
    public List<Product>  getAllTheProduct(){
        System.out.println("called");
        return  productService.getAllTheProducts();
    }

}
