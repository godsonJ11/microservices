package com.productModule.product.service;

import com.netflix.discovery.converters.Auto;
import com.productModule.product.Dto.UserDto;
import com.productModule.product.Repository.ProductRepository;
import com.productModule.product.Response.Response;
import com.productModule.product.feign.UserFeign;
import com.productModule.product.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private Response response;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserFeign userFeign;
    public Response saveTheProduct(Product product) {
        productRepository.save(product);
        response.setData(product);
        response.setStatus(HttpStatus.OK);
        response.setError(null);
        return response;
    }

    public Response getUserDetails() {
        List<UserDto> userDtoList=userFeign.getListOfUser();
        if(userDtoList.isEmpty()){
            response.setError("ERROR OCCURS");
            response.setData(null);
            response.setStatus(HttpStatus.BAD_REQUEST);
            return response;
        }
        else{
            response.setError(null);
            response.setStatus(HttpStatus.OK);
            response.setData(userDtoList);
            return response;
        }
    }

    public List<Product> getAllTheProducts() {
        List<Product> products=productRepository.findAll();
        if(products.isEmpty()){
            return new ArrayList<>();
        }
        else{
            return  products;
        }
    }
}
