package com.mustafin.learningtask.adminmicroservice.feignclient;

import com.mustafin.learningtask.adminmicroservice.enums.Role;
import com.mustafin.learningtask.adminmicroservice.models.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "${goods.service.name}", url = "${goods.service.url}")
public interface GoodsServiceFeignClient {

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable Long id, @RequestHeader(value = "USER_ID", defaultValue = "3") Long userId, @RequestHeader(value = "ROLE_NAME", defaultValue = "anonim") Role role);

    @PostMapping
    Product saveProduct(@RequestBody Product product, @RequestHeader(value = "USER_ID", defaultValue = "3") Long userId, @RequestHeader(value = "ROLE_NAME", defaultValue = "anonim") Role role);
}
