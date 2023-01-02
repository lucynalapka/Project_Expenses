package pl.coderslab.expenses.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.coderslab.expenses.model.Expense;

import java.util.List;


@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    @Query("select e from Expense e where e.name=:name")
    Expense findByName(@Param("name") String name);


    @Query("SELECT SUM(amount) FROM Expense")
    Expense findAmountSum(@Param("amount") Double amount);

}

