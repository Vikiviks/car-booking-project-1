package com.example.car.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.car.model.CarModel;
import com.example.car.repository.CarRepository;
import com.example.car.service.CarService;
@CrossOrigin("*")
@RestController
public class CarController {
      @Autowired
      CarRepository cr;
      @Autowired
      CarService cs;
      @GetMapping("/car")
      public List<CarModel> getAllDetails(){
    	  return cr.findAll();
      }
      @GetMapping("/car/{id}")
  	public CarModel getDetailsById(@PathVariable int id)
  	{
  		return cr.findById(id).orElse(null);
  	}
  	@PostMapping("/save")
  	public String saveall(@RequestBody CarModel id)
  	{
  		cr.save(id);
  		return "Id Details Saved";
  	}
  	@DeleteMapping("/crud/{id}")
	public String deleteById(@PathVariable int id)
	{
		cr.deleteById(id);
		return "Id details deleted";
	}
	@PutMapping("/put")
	public CarModel putDetailsById(@RequestBody CarModel s)
	{
		return cr.save(s);
	}
	@GetMapping("/sort/{field}")
	public List<CarModel> sortCars(@PathVariable String field)
	{
		return cs.sortCars(field);
	}
    @GetMapping("/dsort/{field}")
    public List<CarModel> sortCarsDesc(@PathVariable String field)
    {
    	return cs.sortCarsDesc(field);
    }
    @GetMapping("/dsort/{field1}/{field2}")
    public List<CarModel> sortCarsDesc(@PathVariable String field1,@PathVariable String field2)
    {
    	return cs.sortCarsDesc2(field1,field2);
    }
    @GetMapping("/page/{offset}/{pagesize}")
    public List<CarModel> paginationCar(@PathVariable int offset,@PathVariable int pagesize)
    {
    	return cs.pageCar(offset,pagesize);
    }
    @GetMapping("/page/{offset}/{pagesize}/{field}")
    public List<CarModel> pagingsort(@PathVariable int offset,@PathVariable int pagesize,@PathVariable String field)
    {
    	return cs.pageSort(offset,pagesize,field);
    }
    @GetMapping("/fetchModelnamePrefix")
    public List<CarModel> fetchModelnamePrefix(@RequestParam String prefix){
		return cs.fetchModelnamePrefix(prefix);
	}
    @GetMapping("/fetchModelnameSuffix")
    public List<CarModel> fetchModelnameSuffix(@RequestParam String suffix){
		return cs.fetchModelnameSuffix(suffix);
	}
    @GetMapping("/fetchModelname")
    public List<CarModel> fetchModelname(@RequestParam String name){
		return cs.fetchModelname(name);
	}
    @GetMapping("/query")
    public List<CarModel>fetchqueryCar(@RequestParam String modelname,@RequestParam String fuel )
    {
    	return cs.queryCars(modelname, fuel);
    }
   /* @GetMapping("/query")
    public List<CarModel>fetchqueryCarFuel(@RequestParam String fuel )
    {
    	return cs.queryCarsFuel( fuel);
    }*/
   
}
