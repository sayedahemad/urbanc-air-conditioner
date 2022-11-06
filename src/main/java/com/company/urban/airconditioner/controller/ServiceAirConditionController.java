package com.company.urban.airconditioner.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.company.urban.airconditioner.entity.ServiceAirCondition;
import com.company.urban.airconditioner.service.ServiceAirConditionService;

@Controller
public class ServiceAirConditionController {

	@Autowired
	private ServiceAirConditionService service;
	
	@RequestMapping("/appliance")
	public String displayAddService() {
		return "addService";
	}
	
	@RequestMapping("/saveService")
	public String saveService(@ModelAttribute("serviceAirCondition")ServiceAirCondition serviceAirCondition,ModelMap modelMap) {
		ServiceAirCondition savedService = service.saveServiceAirCondition(serviceAirCondition);
		String message="Service added with Id no : "+savedService.getId();
		modelMap.addAttribute("message",message);
		return "addService";
	}
	
	@RequestMapping("/displayAllServices")
	public String displayAllService(ModelMap modelMap) {
		List<ServiceAirCondition> services = service.getAllServiceAirCondition();
		modelMap.addAttribute("services",services);
		return "displayAllServices";
	}
	
	@RequestMapping("/editService")
	public String editService(@RequestParam("id")int id,ModelMap modelMap) {
		ServiceAirCondition currentService = service.getServiceAirConditionById(id);
		modelMap.addAttribute("service",currentService);
		return "updateService";
	}
	
	@RequestMapping("/updateService")
	public String updateService(@ModelAttribute("serviceAirCondition") ServiceAirCondition serviceAirCondition,ModelMap modelMap) {
		service.saveServiceAirCondition(serviceAirCondition);
		List<ServiceAirCondition> services = service.getAllServiceAirCondition();
		modelMap.addAttribute("services",services);
		return "displayAllServices";
	}
	
	@RequestMapping("/deleteService")
	public String deleteService(@RequestParam("id") int id,ModelMap modelMap) {
		ServiceAirCondition service1=new ServiceAirCondition();
		service1.setId(id);
		service.deleteServiceAirCondition(service1);
		List<ServiceAirCondition> services = service.getAllServiceAirCondition();
		modelMap.addAttribute("services",services);
		return "displayAllServices";
	}
}
