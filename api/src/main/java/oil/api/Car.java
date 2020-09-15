package oil.api;

import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableAutoConfiguration
public class Car {
	private String Color;
	private String Type;
	private int Displacement;
	private boolean Sunroof;
	private int Speed;
	private static ArrayList cars = new ArrayList<Car>();


	@RequestMapping(value = "/car", method=RequestMethod.POST)
	public ResponseEntity<List<Car>> update(@RequestBody Car car) {
		String Color = car.getColor();
		String Type = car.getType();
		car.getDisplacement();
		boolean Sunroof = car.isSunroof();
		int Speed = car.getSpeed();
		cars.add(car);
		return new ResponseEntity<List<Car>>(cars, HttpStatus.OK);
	}
	@RequestMapping(value = "/car/{id}", method=RequestMethod.PATCH)
	public ResponseEntity<List<Car>> update(@PathVariable("id") int id, @RequestBody Car car) {
		String Color = car.getColor();
		String Type = car.getType();
		int Displacement = car.getDisplacement();
		boolean Sunroof = car.isSunroof();
		int Speed = car.getSpeed();
		cars.set(id-1, car);
		return new ResponseEntity<List<Car>>(cars, HttpStatus.OK);
	}
	@RequestMapping(value = "/car/{id}", method=RequestMethod.GET)
	public ResponseEntity<Car> get(@PathVariable("id") int id) {
		return new ResponseEntity<Car>((Car) cars.get(id-1), HttpStatus.OK);
	}
	@RequestMapping(value = "/car/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<List<Car>> update(@PathVariable("id") int id) {
		cars.remove(id-1);
		return new ResponseEntity<List<Car>>(cars, HttpStatus.OK);
	}

	public String getColor() {
		return Color;
	}
	public void setColor(String color) {
		Color = color;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public int getDisplacement() {
		return Displacement;
	}
	public void setDisplacement(int displacement) {
		Displacement = displacement;
	}
	public boolean isSunroof() {
		return Sunroof;
	}
	public void setSunroof(boolean sunroof) {
		Sunroof = sunroof;
	}
	public int getSpeed() {
		return Speed;
	}
	public void setSpeed(int speed) {
		Speed = speed;
	}
	
}