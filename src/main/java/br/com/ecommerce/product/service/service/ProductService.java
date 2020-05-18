package br.com.ecommerce.product.service.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ecommerce.product.service.model.Manufacturer;
import br.com.ecommerce.product.service.model.Product;
import br.com.ecommerce.product.service.util.RestConnector;

@Service
public class ProductService {
	
	@Autowired
	private RestConnector restConnector;

    private static final Map<Integer, Product> productMap = new HashMap<Integer, Product>();
    static {
        productMap.put(1, new Product(1, "P00D1", null));
        productMap.put(2, new Product(2,"P00D2", null));
        productMap.put(3, new Product(3,"P00D3", null));
        productMap.put(4, new Product(4,"P00D4", null));
        productMap.put(5, new Product(5,"P00D5", null));
        productMap.put(6, new Product(6,"P00D6", null));
        productMap.put(7, new Product(7,"P00D7", null));
        productMap.put(8, new Product(8,"P00D8", null));
        productMap.put(9, new Product(9,"P00D9", null));
        productMap.put(10, new Product(10,"P00D10", null));
    }

    public Product getProductDetails(int id) {
    	if (productMap.containsKey(id)) 
    		return productMap.get(id);
    	else
    		throw new RuntimeException("No Record found.");
    }

    public List<Product> getAllProductDetails() {
        List<Product> Products =  new ArrayList<Product>();
        Products.addAll(productMap.values());
        return Products;
    }

    public Product getProductDetailsWithManufacturer(int id) {
    	if (productMap.containsKey(id)) {
	        Product product = productMap.get(id);
	        Manufacturer manufacturer = restConnector.getManufacturer(id);
	        product.setManufacturer(manufacturer);
	        return product;
    	}
    	else
    		throw new RuntimeException("No Record found.");
    }
    
}
