package pl.coderslab.expenses.model.dto;

import lombok.Data;
import pl.coderslab.expenses.model.Role;
import pl.coderslab.expenses.model.User;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.List;

@Data
public class RegisterDto { //obiekt DTO czyli Data Transfer Object, wykorzystywany do mapowania formularzy html na obiekt javy
    //  some DTO from browser
    //
    //            v
    //
    //Spring @Controller method
    //
    //            v
    //
    //  Spring @Service method
    // mozliwa walidacja w DTO

    @NotNull
    private String name;
    @NotNull
    private String username;
    @Size(min = 6)
    private String password;
    @Size(min = 6)
    private String confirm_password;

    private Double amountPaid;

    public User map(Role role) {
        if(!this.password.equals(this.confirm_password)) {
            return null;
        }
        User user = new User();
        user.setName(this.name);
        user.setUsername(this.username);
        user.setPassword(this.password);
        user.setEnabled(1);
        user.setRoles(new HashSet<>(List.of(role)));
        user.setAmountPaid(0.0);


        return user;
    }
}
