package pl.coderslab.expenses.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 3)
    private String name;
    private String place;
    @DateTimeFormat
    private String date;
    @ManyToMany(fetch = FetchType.EAGER)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<User> users;


    public List<User> getUsers() {
        return users;
    }





}
