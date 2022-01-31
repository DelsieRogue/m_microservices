package com.mustafin.learningtask.goodsmicroservice.rest;

import com.mustafin.learningtask.goodsmicroservice.enums.Role;
import com.mustafin.learningtask.goodsmicroservice.exceptions.classes.ProductNotFoundException;
import com.mustafin.learningtask.goodsmicroservice.exceptions.classes.SaveProductException;
import com.mustafin.learningtask.goodsmicroservice.models.Product;
import com.mustafin.learningtask.goodsmicroservice.services.GoodsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Slf4j
public class GoodsController {

    private final GoodsService goodsService;

    @GetMapping
    public List<Product> getAllGoods(@RequestHeader(value = "USER_ID", defaultValue = "3") Long userId, @RequestHeader(value = "ROLE_NAME", defaultValue = "anonim") Role role){
        log.info("USER_ID : " + userId);
        log.info("ROLE_NAME : " + role.name());
        return goodsService.getAllGoods();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id, @RequestHeader(value = "USER_ID", defaultValue = "3") Long userId, @RequestHeader(value = "ROLE_NAME", defaultValue = "anonim") Role role) throws ProductNotFoundException {
        log.info("USER_ID : " + userId);
        log.info("ROLE_NAME : " + role.name());
        return goodsService.getProductById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id, @RequestHeader(value = "USER_ID", defaultValue = "3") Long userId, @RequestHeader(value = "ROLE_NAME", defaultValue = "anonim") Role role)  {
        log.info("USER_ID: " + userId);
        log.info("ROLE_NAME: " + role.name());
        goodsService.deleteById(id);
    }

    @PostMapping
    public Product saveProduct(@RequestBody Product product, @RequestHeader(value = "USER_ID", defaultValue = "3") Long userId, @RequestHeader(value = "ROLE_NAME", defaultValue = "anonim") Role role) throws SaveProductException {
        log.info("USER_ID: " + userId);
        log.info("ROLE_NAME: " + role.name());
        return goodsService.save(product);
    }

}
