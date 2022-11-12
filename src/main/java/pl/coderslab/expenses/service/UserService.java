package pl.coderslab.expenses.service;

import pl.coderslab.expenses.model.Expense;
import pl.coderslab.expenses.model.User;
import pl.coderslab.expenses.model.dto.RegisterDto;

import java.util.List;

public interface UserService {

    User save(User u);
    User saveAdmin(User u);
    List<User> findAll();
    User findByUsername(String username);
    User registerUser(RegisterDto dto);

    List<Expense> getExpenses(Long id);

    List<User> getUsers(Long id);
}
