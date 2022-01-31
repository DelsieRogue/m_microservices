package com.mustafin.learningtask.adminmicroservice.rest;

import com.mustafin.learningtask.adminmicroservice.enums.Role;
import com.mustafin.learningtask.adminmicroservice.models.Product;
import com.mustafin.learningtask.adminmicroservice.services.GoodsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@Slf4j
@RequiredArgsConstructor
public class AdminController {

    private final GoodsService goodsService;

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id, @RequestHeader("USER_ID") Long userId, @RequestHeader("ROLE_NAME") Role role){
        log.info("USER_ID : " + userId);
        log.info("ROLE_NAME : " + role.name());
        goodsService.deleteProductById(id, userId, role);
        return "Product with id: " + id + " deleted";
    }

    @PostMapping
    public Long addNewProduct(@RequestBody Product product, @RequestHeader("USER_ID") Long userId, @RequestHeader("ROLE_NAME") Role role){
        log.info("USER_ID : " + userId);
        log.info("ROLE_NAME : " + role.name());
        Product productRet = goodsService.saveProduct(product, userId, role);
        return productRet.getId();
    }

    @GetMapping
    public String getInfoForAdmin(@RequestHeader("USER_ID") Long userId, @RequestHeader("ROLE_NAME") Role role){
        log.info("USER_ID : " + userId);
        log.info("ROLE_NAME : " + role.name());
        return "(: Hello Admin :)";
    }
}
