package pl.coderslab.expenses.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;
@Entity
@Data
@NoArgsConstructor

public class Settlement {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double value;
   @OneToOne
    private User paidTo;
   @OneToOne
    private User paidBy;

    public Settlement(Double value, User paidTo) {
        this.value = value;
        this.paidTo = paidTo;
    }

    public Settlement(Long finalPayTo, Long finalPayBy, Float finalAmt) {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Settlement that = (Settlement) o;
        return value.equals(that.value) && paidTo.equals(that.paidTo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, paidTo);
    }
}
