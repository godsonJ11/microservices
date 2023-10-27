package com.user.service.user.Service;

import com.user.service.user.Dto.ProductDto;
import com.user.service.user.Model.UserData;
import com.user.service.user.Repository.UserRepository;
import com.user.service.user.Response.Response;
import com.user.service.user.customException.NullValueOrEmptyDataException;
import com.user.service.user.feign.ProductFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class Service {
    @Autowired
    private Response response;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductFeign productFeign;
    public Response saveTheUserDetails(UserData userData) throws NullValueOrEmptyDataException {
        if(userData.getName()==null || userData.getName().isEmpty()){
            throw  new NullValueOrEmptyDataException("NULL VALUE OR EMPTY DATA ");
        }else{
            userRepository.save(userData);
            response.setStatus(HttpStatus.CREATED);
            response.setError(null);
            response.setData(userData);
        }
        return response;
    }

    public Response getListOfUser(Integer id) {
       Optional<UserData> userData=userRepository.findById(id);
       response.setError(null);
       response.setStatus(HttpStatus.FOUND);
       response.setData(userData);
        return response;
    }

    public List<UserData> getAllUser() {
        return userRepository.findAll();
    }

    public Response getAllProduct() {
        List<ProductDto> productDtos=productFeign.getAllTheProduct();
        if(productDtos.isEmpty()){
            response.setData(null);
            response.setStatus(HttpStatus.BAD_REQUEST);
            response.setError("EMPTY DATA");
            return response;
        }else{
            response.setStatus(HttpStatus.OK);
            response.setError(null);
            response.setData(productDtos);
            return response;
        }
    }
}
