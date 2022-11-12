package pl.coderslab.expenses.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String username;
    private String password;
    private int enabled;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private Set<Role> roles;

    private Double amountToPay;
    private Double amountPaid;

    @ManyToMany(mappedBy = "paidFor")
    private List<Expense> expenses;

    @OneToMany(cascade = CascadeType.MERGE)
    private List<Settlement> settlementAmounts;

    public User(String name, Double amountToPay, Double amountPaid) {
        this.name = name;
        this.amountToPay = amountToPay;
        this.amountPaid = amountPaid;
        this.settlementAmounts = new LinkedList<>();
        this.expenses = new LinkedList<>();
    }
    void updateAmountToPay(Double amount) {
        this.amountToPay += amount;
    }

    void settlementAmountWith(User user, Double amount) {
        this.amountToPay = this.amountToPay - amount;
        this.addSettlementAmount(new Settlement(amount, user));
    }

    void receiveAmountFrom(User user, Double amount) {
        this.amountPaid = this.amountPaid - amount;
        user.addSettlementAmount(new Settlement(amount, this));
    }

    Double calculatePaidAndToPayDifference() {
        return this.amountPaid - this.amountToPay;
    }

    private void addSettlementAmount(Settlement settlement) {
        this.settlementAmounts.add(settlement);
    }

    int compare(User user) {
        Integer finalAmount = (int) Math.abs(user.amountPaid - user.amountToPay);
        Integer anotherFinalAmount = (int) Math.abs(this.amountPaid - this.amountToPay);

        return anotherFinalAmount - finalAmount;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) &&
                Objects.equals(amountToPay, user.amountToPay) &&
                Objects.equals(amountPaid, user.amountPaid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}