package web.service;

import org.springframework.stereotype.Service;
import web.Car;

import java.util.List;

@Service
public interface CarService {
    List<Car> getCarByCount(List<Car> cars, int count);
}
