package com.codingdojo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.models.Expense;
import com.codingdojo.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	private final ExpenseRepository expenseRepository;
	
	public ExpenseService( ExpenseRepository expenseRepository ) {
		this.expenseRepository = expenseRepository;
	}
	
	public List<Expense> selectAllFromExpenses(){
		List<Expense> expensesList = expenseRepository.findAll();
		if ( expensesList.isEmpty() ) {
			Expense expenseVacio = new Expense("N/A", "N/A", "N/A", "N/A");
			expensesList.add(expenseVacio);
		}
		return expensesList;
	}
	
	public Expense insertIntoExpenses( Expense expense ) {
		return expenseRepository.save(expense);
	}
	
}
