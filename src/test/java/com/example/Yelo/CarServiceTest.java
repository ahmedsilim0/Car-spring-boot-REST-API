package com.example.Yelo;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.Yelo.error.NotFoundException;
import com.example.Yelo.repository.CarRepository;
import com.example.Yelo.services.CarService;

import static org.mockito.BDDMockito.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CarServiceTest {

	@MockBean
	private CarRepository carRepository;
	@Autowired
	private CarService carService;

	@TestConfiguration
	static class carServiceContextConfiguration {

		public CarService carService() {
			return new CarService();
		}
	}

	@Test
	public void whenFindAllReturnCarsList() {
		Car car1 = new Car("1", "kia", "red", "2013", "ahmed", true);
		Car car2 = new Car("2", "lancer", "blue", "2015", "samir", true);
		List<Car> data = Arrays.asList(car1, car2);

		given(carRepository.findAll()).willReturn(data);
		assertThat(carRepository.findAll()).hasSize(2).contains(car1, car2);
	}

	@Test
	public void whenGetById_CarShouldBeFound() {
		Car car = new Car("1", "kia", "red", "2013", "ahmed", true);
		given(carRepository.findById(anyString())).willReturn(Optional.ofNullable(car));

	}

	@Test
	public void whenInvalidId_TodoShouldNotBeFound() {
		given(carRepository.findById(anyString())).willReturn(Optional.empty());
		Exception exception = assertThrows(NotFoundException.class, () -> carService.getById("1"));
		assertEquals("Exception Message", exception.getMessage());
	}

}
