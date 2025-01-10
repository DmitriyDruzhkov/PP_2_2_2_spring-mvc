package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.Car;
import web.service.CarService;
import web.service.CarServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class CarController {
    @GetMapping(value = "/cars")
    public String car(@RequestParam(value = "count", defaultValue = "5") int count,
                      Model model) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("BMW", "X5", 2010));
        cars.add(new Car("Audi", "Q3", 2015));
        cars.add(new Car("Mercedes", "GL", 2012));
        cars.add(new Car("Honda", "CR-V", 2008));
        cars.add(new Car("Ford", "Kuga", 2016));
        if (count > 5) {
            count = 5;
        }
        CarService carService = new CarServiceImpl();
        model.addAttribute("cars", carService.getCarByCount(cars, count));
        return "cars";
    }
}
