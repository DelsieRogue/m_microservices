package com.mustafin.learningtask.adminmicroservice.services;

import com.mustafin.learningtask.adminmicroservice.enums.Role;
import com.mustafin.learningtask.adminmicroservice.feignclient.GoodsServiceFeignClient;
import com.mustafin.learningtask.adminmicroservice.models.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GoodsService {

    private final GoodsServiceFeignClient goodsServiceFeignClient;

    public void deleteProductById(Long id, Long userId, Role role) {
        goodsServiceFeignClient.deleteById(id, userId, role);
    }

    public Product saveProduct(Product product, Long userId, Role role) {
        return goodsServiceFeignClient.saveProduct(product, userId, role);
    }
}
