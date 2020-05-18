package br.com.ecommerce.product.service.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.ecommerce.product.service.model.Product;
import br.com.ecommerce.product.service.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductServiceRest {
	
    @Autowired
    ProductService productService;

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public Product getProductDetails(@PathVariable("id") int id){
    	Product product = productService.getProductDetails(id);
    	System.out.println("getProductDetails method : "+ product.toString());
        return product;
    }

    @RequestMapping(method=RequestMethod.GET)
    public List<Product> getAllProductDetails(){
    	List<Product> products = productService.getAllProductDetails();
    	System.out.println("getAllProductDetails method : "+ products);
        return products;
    }

    @RequestMapping(value="/results/{id}", method=RequestMethod.GET)
    public Product getStudentDetailsWithMarks(@PathVariable("id") int id){
    	Product product = productService.getProductDetailsWithManufacturer(id);
    	System.out.println("getProductDetailsWithManufacturer method : "+ product);
        return product;
    }
}
