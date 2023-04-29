package com.example.car.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.car.model.CarModel;
import com.example.car.repository.CarRepository;

@Service
public class CarService {
	@Autowired
	CarRepository cr;
	public List<CarModel> getAllDetails()
	{
		return cr.findAll();
	}
	public List<CarModel> sortCars(String field) {
		return cr.findAll(Sort.by(field));
	}
	public List<CarModel> sortCarsDesc(String field) {
		// TODO Auto-generated method stub
		return cr.findAll(Sort.by(Direction.DESC,field));
	}
	public List<CarModel> sortCarsDesc2(String field1, String field2) {
		return cr.findAll(Sort.by(Direction.DESC,field1).and (Sort.by(Direction.DESC,field2)));
	}
	public List<CarModel> pageCar(int offset, int pagesize) {
		Page<CarModel> paging=cr.findAll(PageRequest.of(offset,pagesize));
		return paging.getContent();
	}
	public List<CarModel> pageSort(int offset, int pagesize, String field) {
		Pageable paging=PageRequest.of(offset,pagesize).withSort(Sort.by(field));
		Page<CarModel>car=cr.findAll(paging);
		return car.getContent();
	}
	
	public List<CarModel> fetchModelnamePrefix(String prefix){
		return cr.findByModelnameStartingWith(prefix);
	}
	public List<CarModel> fetchModelnameSuffix(String suffix){
		return cr.findByModelnameEndingWith(suffix);
	}
	public List<CarModel> fetchModelname(String name){
		return cr.findByModelname(name);
	}
	public List<CarModel> queryCars(String modelname,String fuel)
	{
		return cr.getCarsByModelname(modelname,fuel);
	}
/*	public List<CarModel> queryCarsFuel(String fuel)
	{
		return cr.getCarsByFuel(fuel);
	}
	*/
	
}
	
	


