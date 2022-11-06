package com.company.urban.airconditioner.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.urban.airconditioner.entity.ServiceAirCondition;
import com.company.urban.airconditioner.service.ServiceAirConditionService;

@RestController
public class ServiceAirConditionRestController {

	@Autowired
	private ServiceAirConditionService service;
	
	
	//get all services present in air-condition table
	@GetMapping("/admin/air-condition/services")
	public List<ServiceAirCondition> showServices(){
		return this.service.getAllServiceAirCondition();
	}
	
	//adds a new service by taking fields
	@PostMapping("/admin/air-condition/addService")
	public ServiceAirCondition addService(@RequestBody ServiceAirCondition serviceAirCondition) {
		return service.saveServiceAirCondition(serviceAirCondition);
	}
	
	//delete entry by id
	@DeleteMapping("/admin/air-condition/deleteServiceById")
	public HashMap<String,String> deleteService(@RequestParam("id") int id) {
		ServiceAirCondition s=new ServiceAirCondition();
		s.setId(id);
		service.deleteServiceAirCondition(s);
		String messageString="Service deleted with id :"+id;
		HashMap<String,String> hashMap=new HashMap<String,String>();
		hashMap.put("message",messageString);
		return hashMap;
	}
	
	//get the service details by id
	@GetMapping("/admin/air-condition/getServiceById")
	public ServiceAirCondition getServiceByid(@RequestParam("id")int id) {
		return service.getServiceAirConditionById(id);
	}
	
	//get all services present in air-condition table
	@GetMapping("/user/air-condition/services")
	public List<ServiceAirCondition> showServicesDetails(){
		return this.service.getAllServiceAirCondition();
	}
	
	//get the service details by name like clause(need pass whole name)
	@GetMapping("/user/air-condition/getServiceByName")
	public ServiceAirCondition getAirConditionByName(@RequestParam("name")String name) {
		return service.getServiceAirConditionByName(name);
	}
	
	//get the service details by name contains (%name%)
	@GetMapping("/user/air-condition/getServiceByNameContains")
	public List<ServiceAirCondition> getServiceByNameContains(@RequestParam("name")String name){
		return service.getServiceAirConditionByNameContaining(name);
	}
	
	//get the service details by price
	@GetMapping("/user/air-condition/getServiceByPriceBetween")
	public List<ServiceAirCondition> getServiceByPriceBetween(@RequestParam int startPrice, @RequestParam int endPrice ){
		return this.service.getServiceAirConditionByPriceBetween(startPrice, endPrice);
	}
	
	//get the service details by group by clause
	@GetMapping("/user/air-condition/getServiceBySection")
	public List<ServiceAirCondition> getServiceBySection(@RequestParam String section){
		return this.service.getServiceBySection(section);
	}
}
