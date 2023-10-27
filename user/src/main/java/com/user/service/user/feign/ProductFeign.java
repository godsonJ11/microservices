package com.user.service.user.feign;

import com.user.service.user.Dto.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("PRODUCT-SERVICE")
public interface ProductFeign {

    @GetMapping("list/product")
    public List<ProductDto> getAllTheProduct();
}
