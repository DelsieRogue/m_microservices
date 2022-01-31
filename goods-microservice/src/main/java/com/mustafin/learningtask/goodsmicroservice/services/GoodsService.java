package com.mustafin.learningtask.goodsmicroservice.services;

import com.mustafin.learningtask.goodsmicroservice.exceptions.classes.ProductNotFoundException;
import com.mustafin.learningtask.goodsmicroservice.exceptions.classes.SaveProductException;
import com.mustafin.learningtask.goodsmicroservice.models.Product;
import com.mustafin.learningtask.goodsmicroservice.repository.GoodsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class GoodsService implements InitializingBean {

    private List<Product> productList;
    private final GoodsRepository goodsRepository;

    public Product getProductById(Long id) throws ProductNotFoundException {
        return goodsRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product with id: " + id + " not found"));
    }

    public List<Product> getAllGoods(){
        return productList;
    }


    public void deleteById(Long id) {
        goodsRepository.deleteById(id);
    }

    public Product save(Product product) throws SaveProductException {
        Product productSave;
        try {
            productSave = goodsRepository.save(product);
        }
        catch (Exception e){
            throw new SaveProductException("Failed to save product: " + product.toString());
        }
        return productSave;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        updateGoods();
    }

    @Scheduled(cron = "${cron.expression}")
    private void updateGoods(){
        productList = goodsRepository.findAll();
        log.info("update cache ProductList");
    }
}
