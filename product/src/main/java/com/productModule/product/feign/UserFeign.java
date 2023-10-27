package com.productModule.product.feign;

import com.productModule.product.Dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("USER-SERVICE")
public interface UserFeign {
    @GetMapping("/getAll/user")
   List<UserDto> getListOfUser();


}
