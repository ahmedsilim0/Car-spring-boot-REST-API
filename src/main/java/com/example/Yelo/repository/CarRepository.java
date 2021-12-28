package com.example.Yelo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.Yelo.Car;

@Repository
public interface CarRepository extends MongoRepository<Car, String> {
	Car findByOwner(String owner);
}
