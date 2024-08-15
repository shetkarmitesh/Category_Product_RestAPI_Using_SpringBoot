package com.nimapmachinetest.Category_Product_RestAPI_Using_SpringBoot.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nimapmachinetest.Category_Product_RestAPI_Using_SpringBoot.Entities.ProductEntity;
import com.nimapmachinetest.Category_Product_RestAPI_Using_SpringBoot.Services.ProductServices;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductServices pService;

    @PostMapping("/addProduct")
        public ProductEntity addProduct(@RequestBody ProductEntity product){
            return  pService.saveProduct(product);
        }
        @PostMapping("/addProducts")
        public List<ProductEntity> addProducts(@RequestBody List<ProductEntity> products){
            return  pService.saveProducts(products);
        }

        @GetMapping("/findById/{id}")
        public Optional<ProductEntity> findProductById(@PathVariable int id){
            return pService.findProductById(id);
        }
        @GetMapping("/findByName/{name}")
        public Optional<ProductEntity> findProductByName(@PathVariable String name){
            return pService.findProductByName(name);
        }

        @GetMapping("/findAll/page=3")
        public List<ProductEntity> findAllProduct(){
            return pService.getAllProduct();
        }

        @PutMapping("/findById/{id}")
        public ProductEntity updateProductById(@PathVariable int id,@RequestBody ProductEntity product){
            return pService.updateProductById(id,product);
        }

        @DeleteMapping("/delete/{id}")
        public void deleteProductById(@PathVariable int id){
            pService.deleteById(id);
        }
        
}
