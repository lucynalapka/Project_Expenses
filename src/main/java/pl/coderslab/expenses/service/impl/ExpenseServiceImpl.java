package pl.coderslab.expenses.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.expenses.model.Expense;
import pl.coderslab.expenses.repository.ExpenseRepository;
import pl.coderslab.expenses.service.ExpenseService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ExpenseServiceImpl implements ExpenseService {

    private ExpenseRepository expenseRepository;
    private static Long nextId = 2L;
    private List<Expense> expenses;


    public Expense findByName(String name) {
        return expenseRepository.findByName(name);
    }
    @Override
    public void saveExpense(Expense expense) {
        expense.setId(nextId++);
        expenseRepository.save(expense);

    }
    @Override
    public List<Expense>findAll() {
        return expenseRepository.findAll();
//
    }
    @Override
    public List<Expense> getAll(Long id) {
        return null;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    @Override
    public Optional<Expense> get(Long id) {
        return expenses.stream().filter(item -> item.getId().equals(id)).findFirst();
    }

    @Override
    public String deleteExpense(Long id) {
        expenseRepository.deleteById(id);
        return "expense deleted";
    }


}
