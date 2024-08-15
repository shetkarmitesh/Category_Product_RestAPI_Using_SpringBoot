package com.nimapmachinetest.Category_Product_RestAPI_Using_SpringBoot.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nimapmachinetest.Category_Product_RestAPI_Using_SpringBoot.Entities.ProductEntity;
import com.nimapmachinetest.Category_Product_RestAPI_Using_SpringBoot.repositories.ProductRepository;
@Service
public class ProductServices {
    @Autowired
    private ProductRepository pRepository;
    public ProductEntity saveProduct(ProductEntity productEntity){
        return pRepository.save(productEntity);
    }
    public List<ProductEntity> saveProducts(List<ProductEntity> productsEntity){
        return pRepository.saveAll(productsEntity);
    }
    public Optional<ProductEntity> findProductById(int id){
        return  pRepository.findById(id);
    }
    public Optional<ProductEntity> findProductByName(String name){
        return  pRepository.findByName(name);
    }

	public List<ProductEntity> getAllProduct() {
			return pRepository.findAll();
		}

    public ProductEntity updateProductById(int id, ProductEntity product){
        return pRepository.updateProductById(id,product);
    }

    public String deleteById(int id){
        pRepository.deleteById(id);
        return "product removed ...!";
    }
}
