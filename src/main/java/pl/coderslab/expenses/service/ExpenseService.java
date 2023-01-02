package pl.coderslab.expenses.service;

import pl.coderslab.expenses.model.Expense;

import java.util.List;
import java.util.Optional;

public interface ExpenseService {

    void saveExpense(Expense expense);

    List<Expense> findAll();

    List<Expense> getAll(Long id);

    String deleteExpense(Long id);

    public List<Expense> getExpenses();

    Expense findByName(String name);

    Optional<Expense> get(Long id);
}



