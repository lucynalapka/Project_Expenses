package pl.coderslab.expenses.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.expenses.model.Expense;
import pl.coderslab.expenses.model.Role;
import pl.coderslab.expenses.model.User;
import pl.coderslab.expenses.model.dto.RegisterDto;
import pl.coderslab.expenses.repository.RoleRepository;
import pl.coderslab.expenses.repository.UserRepository;
import pl.coderslab.expenses.service.UserService;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    //implementujemy kontrakt dla serwisu usera
    // główne zalety to łatwiejsza możliwość testowania serwisów
    // późniejsze możliwości rozwoju dzięki przesłanianiu przez interfejs
    // (możemy stworzyć nowy serwis który działa inaczej - np laczy sie z innym kontenerem danych - a dla
    // reszty aplikacji jest to przezroczyste)
    // dodatkowo mamy zapewniona separacje miedzy warstwami aplikacji (clean architecture)

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;



    @Override
    public User save(User u) {
        u.setPassword(passwordEncoder.encode(u.getPassword()));
        u.setEnabled(1);
        Role userRole = roleRepository.findByName("ROLE_USER");
        u.setRoles(new HashSet<Role>(List.of(userRole)));
        return userRepository.save(u);
    }

    @Override
    public User saveAdmin(User u) {
        u.setPassword(passwordEncoder.encode(u.getPassword()));
        u.setEnabled(1);
        Role userRole = roleRepository.findByName("ROLE_USER");
        Role adminRole = roleRepository.findByName("ROLE_ADMIN");
        u.setRoles(new HashSet<Role>(Arrays.asList(userRole,adminRole)));
        return userRepository.save(u);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User registerUser(RegisterDto dto) {

        User user = dto.map(roleRepository.findByName("ROLE_USER"));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public List<Expense> getExpenses(Long id) {
        return null;
    }

    @Override
    public List<User> getUsers(Long id) {
        return null;
    }
}
