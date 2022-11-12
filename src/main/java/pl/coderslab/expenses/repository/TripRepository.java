package pl.coderslab.expenses.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.coderslab.expenses.model.Trip;
import pl.coderslab.expenses.model.User;

import java.util.List;

@Repository
public interface TripRepository  extends JpaRepository<Trip, Long> {


    @Query("select t from Trip t where t.name=:name")
    Trip findByName(@Param("name") String name);

}
