package br.com.ecommerce.product.service.util;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import br.com.ecommerce.product.service.model.Manufacturer;

@Component
public class RestConnector {
	//@Autowired
	//private DiscoveryClient discoveryclient;
	@Autowired
	private LoadBalancerClient loadBalancerClient;
	
    public Manufacturer getManufacturer(int id) {
        //String baseUrl = "http://localhost:8084";
    	//List<ServiceInstance> serviceInstance = discoveryclient.getInstances("results-service");
    	//String baseUrl = serviceInstance.get(0).getUri().toString();
    	ServiceInstance instance = loadBalancerClient.choose("ecommerce-manufacturer-service");
    	String baseUrl = instance.getUri().toString();
    	System.out.println(" base url of manufacturer-service : "+ baseUrl);
    	String resultsUrl = baseUrl + "/manufacturers/" + id;
        RestTemplate restTemplate = new RestTemplate();
        Map<String, Integer> manufacturer = (Map) restTemplate.getForObject(resultsUrl, Object.class);
        return new Manufacturer(manufacturer.get("id"), manufacturer.get("name").toString());
    }
}
