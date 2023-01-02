package pl.coderslab.expenses.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import pl.coderslab.expenses.model.Trip;
import pl.coderslab.expenses.repository.TripRepository;
import pl.coderslab.expenses.service.TripService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TripServiceImpl implements TripService {

    private TripRepository tripRepository;
    private static Long nextId = 2L;
    List<Trip> trips;

    @Override
    public Optional<Trip> get(Long id) {
        return trips.stream().filter(item -> item.getId().equals(id)).findFirst();
    }


    @Override
    public Trip findByName(String name) {
        return tripRepository.findByName(name);
    }

    @Override
    public void saveTrip(Trip trip) {
        trip.setId(nextId++);
        tripRepository.save(trip);
    }

    @Override
    public List<Trip> getTrips() {
        return trips;
    }

    @Override
    public List<Trip> findAll() {
        return tripRepository.findAll();
    }


    @Override
    public String deleteTrip(Long id) {
        tripRepository.deleteById(id);
        return "trip deleted";
    }
}
