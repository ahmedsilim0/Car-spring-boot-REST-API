package com.example.Yelo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.apache.tomcat.websocket.server.UriTemplate;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder.*;

import com.example.Yelo.services.CarService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CarControllerTest {

	@Autowired
	private MockMvc mockMVC;

	@MockBean
	private CarService carService;

	@Test
	public void whenGetAllCars_theReturnJsonArray() {
		Car car1 = new Car("1", "kia", "red", "2013", "ahmed", true);
		Car car2 = new Car("2", "lancer", "blue", "2015", "samir", true);
		List<Car> data = Arrays.asList(car1, car2);

	}
}
