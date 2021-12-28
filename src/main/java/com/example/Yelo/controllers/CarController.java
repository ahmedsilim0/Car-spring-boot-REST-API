package com.example.Yelo.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Yelo.Car;
import com.example.Yelo.services.CarService;

@RequestMapping(value = "/api/v1/cars")
@RestController
public class CarController {

	Logger logger = LoggerFactory.getLogger(CarController.class);

	@Autowired
	private CarService carService;

	@GetMapping({ "", "/" })
	public ResponseEntity<List<Car>> getAllCars() {
		List<Car> result = carService.findAll();
		logger.error("getAllCars is called");
		logger.trace("getAllCars is called");
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Car> getCarById(@PathVariable String id) {
		Car result = carService.getById(id);
		logger.error("getCarById is called");
		logger.trace("getCarById is called");
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@GetMapping("/searchn/{name}")
	public ResponseEntity<List<Car>> getCarByName(@PathVariable("name") String name) {
		List<Car> result = carService.getByName(name);
		logger.error("getCarByName is called");
		logger.trace("getCarByName is called");
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@GetMapping("/searcho/{owner}")
	public ResponseEntity<List<Car>> getCarByOwner(@PathVariable("owner") String owner) {
		List<Car> result = carService.getByOwner(owner);
		logger.error("getCarByOwner is called");
		logger.trace("getCarByOwner is called");
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@GetMapping("/ordern/")
	public ResponseEntity<List<Car>> OrderCarByName() {
		List<Car> result = carService.orderByName();
		logger.error("OrderCarByName is called");
		logger.trace("OrderCarByName is called");
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@GetMapping("/orderm/")
	public ResponseEntity<List<Car>> OrderCarByModel() {
		List<Car> result = carService.orderByModel();
		logger.error("OrderCarByModel is called");
		logger.trace("OrderCarByModel is called");
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@PostMapping({ "", "/" })
	public ResponseEntity<Car> createNewCar(@Validated @RequestBody Car car) {
		Car result = carService.save(car);
		logger.error("createNewCar is called");
		logger.trace("createNewCar is called");
		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCar(@PathVariable String id) {
		carService.delete(id);
		logger.error("deleteCar is called");
		logger.trace("deleteCar is called");
		return new ResponseEntity<>("data has been successfully deleted", HttpStatus.NO_CONTENT);
	}

	@PutMapping("/edit")
	public ResponseEntity<String> editCar(@RequestBody Car car) {
		carService.edit(car);
		logger.error("editCar is called");
		logger.trace("editCar is called");
		return new ResponseEntity<>("data has been updated", HttpStatus.ACCEPTED);
	}

}
