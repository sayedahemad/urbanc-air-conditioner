package com.company.urban.airconditioner.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.urban.airconditioner.entity.ServiceAirCondition;
import com.company.urban.airconditioner.repository.ServiceAirConditionRepository;

@Service
public class ServiceAirConditionServiceImpl implements ServiceAirConditionService {

	@Autowired
	private ServiceAirConditionRepository repository;

	@Override
	public ServiceAirCondition saveServiceAirCondition(ServiceAirCondition serviceAirCondition) {
		return repository.save(serviceAirCondition);
	}

	@Override
	public ServiceAirCondition updateServiceAirCondition(ServiceAirCondition serviceAirCondition) {
		return repository.save(serviceAirCondition);
	}

	@Override
	public void deleteServiceAirCondition(ServiceAirCondition serviceAirCondition) {
		repository.delete(serviceAirCondition);
	}

	@Override
	public ServiceAirCondition getServiceAirConditionById(int id) {
		if (repository.existsById(id))
			return repository.findById(id).get();
		else {
			return null;
		}
	}

	@Override
	public List<ServiceAirCondition> getAllServiceAirCondition() {
		return repository.findAll();
	}

	@Override
	public ServiceAirCondition getServiceAirConditionByName(String name) {
		return repository.findByNameLike(name);
	}

	@Override
	public List<ServiceAirCondition> getServiceAirConditionByNameContaining(String name) {
		return repository.findByNameContaining(name);
	}

	@Override
	public List<ServiceAirCondition> getServiceAirConditionByPriceBetween(int startPrice, int endPrice) {
		return repository.findByPriceBetween(startPrice, endPrice);
	}

	@Override
	public List<ServiceAirCondition> getServiceBySection(String section) {
		// TODO Auto-generated method stub
		return repository.findBySection(section);
	}


//	@Override
//	public List<ServiceAirCondition> getServiceBySection(String type, String section) {
//		return repository.findBySection(type, section);
//	}

}
