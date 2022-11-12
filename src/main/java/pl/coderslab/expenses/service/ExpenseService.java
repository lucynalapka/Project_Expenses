package pl.coderslab.expenses.service;

import pl.coderslab.expenses.model.Expense;
import pl.coderslab.expenses.model.Trip;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

public interface ExpenseService {

   void saveExpense(Expense expense);

    List<Expense>findAll();

    List<Expense> getAll(Long id);

//    String editExpense(Expense expense);

    String deleteExpense(Long id);

    public List<Expense> getExpenses();

    Expense findByName(String name);
    Optional<Expense> get(Long id);


}



