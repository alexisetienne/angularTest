package co.simplon.catservice.service;

import co.simplon.catservice.dao.ProductRepository;
import co.simplon.catservice.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
public class ProductRestService {
    @Autowired
    ProductRepository productRepository;
    @GetMapping(value = "/listProducts")
    public List<Product> listProduct() {
      return productRepository.findAll();
    }
    @GetMapping(value = "/listProducts/{id}")
    public Product listProduct(@PathVariable(name = "id")Long id) {
        return productRepository.findById(id).get();
    }
    @PutMapping(value = "/listProducts/{id}")
    public Product update(@PathVariable(name = "id")Long id, @RequestBody Product p) {
        p.setId(id);
        return productRepository.save(p);
    }
    @PostMapping(value = "/listProducts")
    public Product save(@RequestBody Product p) {
        return productRepository.save(p);
    }
    @DeleteMapping(value = "/listProducts/{id}")
    public void delete(@PathVariable(name = "id")Long id) {
        productRepository.deleteById(id);
    }
}
