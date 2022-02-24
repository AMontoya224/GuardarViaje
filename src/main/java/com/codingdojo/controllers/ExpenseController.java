package com.codingdojo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.models.Expense;
import com.codingdojo.services.ExpenseService;


@Controller
@RequestMapping( "/expenses/" )
public class ExpenseController {
private final ExpenseService expenseService;
	
	public ExpenseController( ExpenseService expenseService ) {
		this.expenseService = expenseService;
	}
	
	@RequestMapping( value="", method=RequestMethod.GET )
	public String index( Model model, @ModelAttribute("expense") Expense expense ) {
		List<Expense> expensesList = expenseService.selectAllFromExpenses();
		model.addAttribute( "expensesList", expensesList );
		
		return "index.jsp";
	}
	
	@RequestMapping( value="/register", method=RequestMethod.POST )
	public String register( @Valid @ModelAttribute("expense") Expense expense, BindingResult result, Model model ) {
		if( result.hasErrors() ) {
			List<Expense> expensesList = expenseService.selectAllFromExpenses();
			model.addAttribute( "expensesList", expensesList );
			return "index.jsp";
		}
		expenseService.insertIntoExpenses(expense);
		return "redirect:/expenses/";
	}
	
	@RequestMapping( value="/edit/{id}", method=RequestMethod.GET )
	public String edit( @PathVariable("id") int id, Model model, @ModelAttribute("expense") Expense expense ) {
		Expense expenseEncontrado = expenseService.selectFromExpensesWhereId(id);
		model.addAttribute( "expense", expenseEncontrado );
		
		return "edit.jsp";
	}
	
	@RequestMapping( value="/{id}", method=RequestMethod.GET )
	public String show(@PathVariable("id") int id, Model model ) {
		Expense expenseEncontrado = expenseService.selectFromExpensesWhereId(id);
		model.addAttribute( "expense", expenseEncontrado );
		
		return "show.jsp";
    }
	
	@RequestMapping( value="/update", method=RequestMethod.PUT )
	public String update(@Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
        if (result.hasErrors()) {
            return "edit.jsp";
        } 
        else {
        	expenseService.updateExpense(expense);
            return "redirect:/expenses/";
        }
    }
	
	@RequestMapping( value = "/delete/{id}", method = RequestMethod.DELETE )
	public String delete( @PathVariable("id") int id ) {
		expenseService.deleteFromExpense(id);
		return "redirect:/expenses/";
	}
}
