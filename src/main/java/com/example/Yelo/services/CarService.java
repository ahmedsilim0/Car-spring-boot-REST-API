package com.example.Yelo.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.example.Yelo.Car;
import com.example.Yelo.error.ConflictException;
import com.example.Yelo.error.NotFoundException;
import com.example.Yelo.repository.CarRepository;

@Service
public class CarService {

	@Autowired
	private CarRepository carRepository;
	@Autowired
	MongoTemplate mongoTemplate;

	public Car save(Car car) {
		if (carRepository.findByOwner(car.getOwner()) != null) {
			throw new ConflictException("Another car with the same owner not valid hehe");
		}
		return carRepository.insert(car);
	}

	public void delete(String id) {
		carRepository.deleteById(id);
	}

	public List<Car> findAll() {

		return carRepository.findAll();
	}

	public void edit(Car car) {
//		Car car = carRepository.findById(id).get();
//		car.setName(car.getName());
//		car.setColor(car.getColor());
//		car.setModel(car.getModel());
//		car.setOwner(car.getOwner());
//		car.setHideMe(car.isHideMe());
		carRepository.save(car);
	}

//	public void edit(Car car) {
//
//		data.stream().filter(c -> c.getId() == car.getId()).forEach(c -> {
//			c.setName(car.getName());
//			c.setColor(car.getColor());
//			c.setModel(car.getModel());
//			c.setOwner(car.getOwner());
//			c.setHideMe(car.isHideMe());
//		});
//
//	}
	public Car getById(String id) {
		try {
			return carRepository.findById(id).get();
		} catch (NoSuchElementException ex) {
			throw new NotFoundException(String.format("No Recrod with the id [%s] was found on our database", id));
		}

	}

	public List<Car> getByName(String name) {
		Query query = new Query();
		query.addCriteria(Criteria.where("name").is(name));
		List<Car> carsNameList = mongoTemplate.find(query, Car.class);
		return carsNameList;
	}

	public List<Car> getByOwner(String owner) {
		Query query = new Query();
		query.addCriteria(Criteria.where("owner").is(owner));
		List<Car> carsOwnerList = mongoTemplate.find(query, Car.class);
		return carsOwnerList;
	}

	public List<Car> orderByName() {
		Query query = new Query();
		query.with(Sort.by(Sort.Direction.ASC, "name"));
		List<Car> carByName = mongoTemplate.find(query, Car.class);
		return carByName;
	}

	public List<Car> orderByModel() {
		Query query = new Query();
		query.with(Sort.by(Sort.Direction.ASC, "model"));
		List<Car> carByModel = mongoTemplate.find(query, Car.class);
		return carByModel;

	}

}
