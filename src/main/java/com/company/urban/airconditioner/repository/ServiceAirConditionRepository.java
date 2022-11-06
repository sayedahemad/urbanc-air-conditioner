package com.company.urban.airconditioner.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.company.urban.airconditioner.entity.ServiceAirCondition;

public interface ServiceAirConditionRepository extends JpaRepository<ServiceAirCondition, Integer> {

	public ServiceAirCondition findByNameLike(String name);
	
	public List<ServiceAirCondition> findByNameContaining(String name);
	
	public List<ServiceAirCondition> findByPriceBetween(int startPrice,int endPrice);
	
	public List<ServiceAirCondition> findBySection(String section);
}
