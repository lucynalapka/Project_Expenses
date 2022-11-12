package pl.coderslab.expenses.service;

import pl.coderslab.expenses.model.Trip;
import pl.coderslab.expenses.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

public interface TripService {

    Trip findByName(String name);

    void saveTrip(Trip trip);

    List<Trip> getTrips();

    List<Trip> findAll();

    Optional<Trip> get(Long id);

    String deleteTrip(Long id);
}
