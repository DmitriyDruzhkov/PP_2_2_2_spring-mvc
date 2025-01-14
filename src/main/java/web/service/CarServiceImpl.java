package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    private List<Car> cars = new ArrayList<>();

    {
        cars.add(new Car("BMW", "X5", 2010));
        cars.add(new Car("Audi", "A6", 2014));
        cars.add(new Car("Honda", "CR-V", 2012));
        cars.add(new Car("Mercedes", "V6", 2016));
        cars.add(new Car("Honda", "Accord", 2015));
    }

    @Override
    public List<Car> getCarByCount(int count) {
        if (count > 5) return cars;
        else {
            return cars.stream().limit(count).toList();
        }
    }
}

