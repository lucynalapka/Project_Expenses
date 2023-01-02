package pl.coderslab.expenses.service;

import pl.coderslab.expenses.model.Role;

public interface RoleService {
    Role findByName(String name);

    Role save(Role role);
}
