package com.BankingApplication.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.BankingApplication.dto.AccountDto;
import com.BankingApplication.entity.Account;
import com.BankingApplication.mapper.AccountMapper;
import com.BankingApplication.repository.AccountRepository;
import com.BankingApplication.service.AccountService;
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
	private AccountRepository accountRepository;
	
	@Override
	public AccountDto createAccount( AccountDto accountDto) {
		  Account account=AccountMapper.mapToAccount(accountDto);
		  Account savedAccount=accountRepository.save(account);
		return AccountMapper.mapToAccountDto(savedAccount);
	}

	@Override
	public AccountDto getAccounyById(long id) {
	Account account=	accountRepository.findById(id).orElseThrow(()->new RuntimeException("Account DoesNot Exit"));
		return AccountMapper.mapToAccountDto(account) ;
	}

	@Override
	public AccountDto deposite(long id, double amount) {
		//first get user Account
		Account account=	accountRepository.findById(id).orElseThrow(()->new RuntimeException("Account DoesNot Exit"));
		
	double totalBalance=	account.getBalance()+amount;
		account.setBalance(totalBalance);
	Account savedAccount= accountRepository.save(account);
		return AccountMapper.mapToAccountDto(savedAccount);
	}

	@Override
	public AccountDto withdraw(long id, double amount) {
		Account account=accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account Not Fpound"));
		if(account.getBalance()<amount) {
			throw new RuntimeException("Insufficint Bank Balance");
		}
		double totalBalance=account.getBalance()-amount;
		account.setBalance(totalBalance);
		Account savedAccount=accountRepository.save(account);
			
		
		return AccountMapper.mapToAccountDto(savedAccount);
	}

	@Override
	public List<AccountDto> getAllAcoount() {
	List<AccountDto> allAccount=	accountRepository.findAll().stream().map((account)->AccountMapper.mapToAccountDto(account)).collect(Collectors.toList());
		return allAccount;
	}

	@Override
	public void deleteAccountById(long id) {
		Account account=	accountRepository.findById(id).orElseThrow(()->new RuntimeException("Account DoesNot Exit"));

		accountRepository.delete(account);
	}
 
	
}
