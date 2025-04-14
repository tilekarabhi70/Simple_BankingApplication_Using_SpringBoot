package com.BankingApplication.service;

import java.util.List;

import com.BankingApplication.dto.AccountDto;


public interface AccountService {

	
	AccountDto createAccount(AccountDto account);
	
	AccountDto getAccounyById(long id);
	
	AccountDto deposite(long id,double amount);
	
	AccountDto withdraw(long id,double amount);
	
	List<AccountDto> getAllAcoount();
	
	 void deleteAccountById(long id);
	
}
