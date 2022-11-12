package pl.coderslab.expenses.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.coderslab.expenses.model.Expense;

import pl.coderslab.expenses.repository.ExpenseRepository;
import pl.coderslab.expenses.repository.UserRepository;
import pl.coderslab.expenses.service.ExpenseService;
import javax.validation.Valid;


@Controller
@AllArgsConstructor
@RequestMapping("/expenses")
public class ExpenseController {

    private final ExpenseService expenseService;
private final ExpenseRepository expenseRepository;
private final UserRepository userRepository;

//    @RequestMapping(value = "", method = RequestMethod.GET)
//    public String list(Model model) {
//        model.addAttribute("items", expenseService.getExpenses());
//        return "/expenses-list";
//    }
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("items", expenseService.findAll());
        model.addAttribute("noOfPerson", expenseService.findAll().size());
        return "/expenses-list";
    }

    @GetMapping("/{id}")
    public Expense getExpense(@PathVariable Long id) {
        return this.expenseService.get(id).orElseThrow(() -> {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        });
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String form(Model model) {
        model.addAttribute("expense", new Expense());
        model.addAttribute("paidFor", userRepository.findAll());
        return "/expense-form";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String submit(@Valid Expense expense, BindingResult result) {
//        if (result.hasErrors()) {
//            return "expense-form";
//        }
        expenseService.saveExpense(expense);
        return "redirect:/expenses";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String formUpdate(@PathVariable Long id, Model model) {
        model.addAttribute("expense", expenseService.get(id));
        model.addAttribute("paidFor", userRepository.findAll());
        return "/expense-form";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String formUpdate(@Valid Expense expense, BindingResult result) {
//        if (result.hasErrors()) {
//            return "expense/update";
//        }
        expenseService.saveExpense(expense);
        return "redirect:/expenses";
    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public String formDelete(@PathVariable Long id) {
        expenseService.deleteExpense(id);
        return "redirect:/expenses";
    }

//    @RequestMapping(value = "", method = RequestMethod.GET)
//    public String getAll(Model model) {
//        List<Expense> expenses = expenseService.getExpenses();
//        model.addAttribute("items", expenses);
//        return "/expenses-list";
//
//    }
//
//    @RequestMapping(value = "/create",method = RequestMethod.GET)
//    public String form(Model model){
//        model.addAttribute("expense",new Expense());
//        return "/expense-form";
//    }
//
//    @RequestMapping(value = "/create",method = RequestMethod.POST)
//    public String submit(@ModelAttribute Expense expense){
//        expenseService.saveExpense(expense);
//        return "redirect:/expenses";
//    }
//
//    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
//    public String formDelete(@PathVariable Long id) {
//        expenseService.deleteExpense(id);
//        return "redirect:/expenses";
//    }




//    @RequestMapping(value="/update/{id}", method = RequestMethod.GET)
//    public String formUpdate(@PathVariable Long id, Model model) {
//        model.addAttribute("expense", expenseDao.findById(id));
//        return "/expense-form";
//    }
//    @RequestMapping(value="/update/{id}", method = RequestMethod.POST)
//    public String formUpdate( @ModelAttribute Expense expense) {
//        expenseDao.editExpense(expense);
//        return "redirect:/expenses";
//    }





//    private final ExpenseDao expenseDao;
//
//    @RequestMapping(value = "", method = RequestMethod.GET)
//    public String list(Model model) {
//        model.addAttribute("items", expenseDao.findAll());
//        return "/expenses-list";
//
//    }
//
//    @RequestMapping(value = "/create",method = RequestMethod.GET)
//    public String form(Model model){
//        model.addAttribute("expense",new Expense());
//        return "/expense-form";
//    }
//
//    @RequestMapping(value = "/create",method = RequestMethod.POST)
//    public String submit(@ModelAttribute Expense expense){
//        expenseDao.saveExpense(expense);
//        return "redirect:/trips";
//    }
//
//    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
//    public String formDelete(@PathVariable Long id) {
//        expenseDao.deleteExpense(expenseDao.findById(id));
//        return "redirect:/expenses";
//    }
//
//    @RequestMapping(value="/update/{id}", method = RequestMethod.GET)
//    public String formUpdate(@PathVariable Long id, Model model) {
//        model.addAttribute("expense", expenseDao.findById(id));
//        return "/expense-form";
//    }
//    @RequestMapping(value="/update/{id}", method = RequestMethod.POST)
//    public String formUpdate( @ModelAttribute Expense expense) {
//        expenseDao.editExpense(expense);
//        return "redirect:/expenses";
//    }



}
