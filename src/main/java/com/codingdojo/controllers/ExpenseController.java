package com.codingdojo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.models.Expense;
import com.codingdojo.services.ExpenseService;


@Controller
public class ExpenseController {
private final ExpenseService expenseService;
	
	public ExpenseController( ExpenseService expenseService ) {
		this.expenseService = expenseService;
	}
	
	@RequestMapping( value="/expenses", method=RequestMethod.GET )
	public String index( Model model, @ModelAttribute("expense") Expense expense ) {
		List<Expense> expensesList = expenseService.selectAllFromExpenses();
		model.addAttribute( "expensesList", expensesList );
		
		return "index.jsp";
	}
	
	@RequestMapping( value="/expenses/register", method=RequestMethod.POST )
	public String register( @Valid @ModelAttribute("expense") Expense  expense, BindingResult result, Model model ) {
		if( result.hasErrors() ) {
			List<Expense> expensesList = expenseService.selectAllFromExpenses();
			model.addAttribute( "expensesList", expensesList );
			return "index.jsp";
		}
		expenseService.insertIntoExpenses(expense);
		return "redirect:/expenses";
	}
}
