package tn.g3.spring.service;

import java.util.List;

import tn.g3.spring.entity.Transaction;

public interface ITransactionService {
	Transaction addTransaction(Transaction t);

	void deleteTransaction(int id);

	List<Transaction> retrieveAllTransactions();

	Transaction retrieveTransactions(int id);

	List<Transaction> listAll();
 int addOrUpdateTransaction(Transaction t);
 public List<Transaction> getAllTransById();
}
