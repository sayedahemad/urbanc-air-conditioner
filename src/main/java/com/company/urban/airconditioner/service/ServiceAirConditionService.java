package com.company.urban.airconditioner.service;

import java.util.List;

import com.company.urban.airconditioner.entity.ServiceAirCondition;

public interface ServiceAirConditionService {
	
	ServiceAirCondition saveServiceAirCondition(ServiceAirCondition serviceAirCondition);
	
	ServiceAirCondition updateServiceAirCondition(ServiceAirCondition serviceAirCondition);
	
	void deleteServiceAirCondition(ServiceAirCondition serviceAirCondition);
	
	ServiceAirCondition getServiceAirConditionById(int id);
	
	List<ServiceAirCondition> getAllServiceAirCondition();
	
	ServiceAirCondition getServiceAirConditionByName(String name);
	
	List<ServiceAirCondition> getServiceAirConditionByNameContaining(String name);
	
	List<ServiceAirCondition> getServiceAirConditionByPriceBetween(int startPrice, int endPrice);
	
	List<ServiceAirCondition> getServiceBySection(String section);
}
