//package pl.coderslab.expenses.modelDao;
//
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//import pl.coderslab.expenses.model.Expense;
//import pl.coderslab.expenses.model.Trip;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.transaction.Transactional;
//import java.util.List;
//import java.util.Map;
//
//@Repository
//@Transactional
//public class ExpenseDao {
//    @PersistenceContext
//    EntityManager entityManager;
//
//
//    public void saveExpense(Expense expense) {
//        entityManager.persist(expense);
//
//    }
//
//    public List<Trip> findAll() {
//        return entityManager.createQuery("SELECT e FROM Expense e").getResultList();
//    }
//
//
//    public void editExpense(Expense expense) {
//        entityManager.merge(expense);
//    }
//
//    public Expense findById(long id) {
//        Expense expense = entityManager.find(Expense.class, id);
//        return expense;
//    }
//
//    public void deleteExpense(Expense expense) {
//        entityManager.remove(entityManager.contains(expense) ?
//                expense : entityManager.merge(expense));
//    }

//    @Query("SELECT SUM(e.amount) as total FROM Expense e")
//    public abstract List<Expense> getSum();

//}
