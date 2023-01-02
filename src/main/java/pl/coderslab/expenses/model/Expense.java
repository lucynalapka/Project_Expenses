package pl.coderslab.expenses.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double amount;

    @ManyToMany
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<User> paidFor;

    public Expense(String name, Double amount, List<User> paidFor) {
        this.name = name;
        this.amount = amount;
        this.paidFor = paidFor;
    }

    public double getSettle() {
        double noOfUsers = paidFor.size();
        return noOfUsers;
    }

    public List<User> getUsers() {
        return paidFor;
    }
}
