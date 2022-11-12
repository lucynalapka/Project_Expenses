//package pl.coderslab.expenses.modelDao;
//
//import org.hibernate.Hibernate;
//import org.springframework.stereotype.Repository;
//import pl.coderslab.expenses.model.Trip;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.transaction.Transactional;
//import java.awt.print.Book;
//import java.util.List;
//
//@Repository
//@Transactional
//public class TripDao {
//    @PersistenceContext
//    EntityManager entityManager;
//
//    public Trip findByName(String name) {
//        return entityManager.find(Trip.class, name);
//    }
//
//
//    public void saveTrip(Trip trip) {
//        entityManager.persist(trip);
//
//    }
//
//
//    public List<Trip> findAll() {
//        return entityManager.createQuery("SELECT t FROM Trip t").getResultList();
//    }
//
//
//    public void editTrip(Trip trip) {
//        entityManager.merge(trip);
//    }
//
//    public Trip findById(long id) {
//        Trip trip = entityManager.find(Trip.class, id);
//        return trip;
//    }
//
//    public void deleteTrip(Trip trip) {
//        entityManager.remove(entityManager.contains(trip) ?
//                trip : entityManager.merge(trip));
//    }
//}
