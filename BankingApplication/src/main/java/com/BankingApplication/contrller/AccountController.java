package com.BankingApplication.contrller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BankingApplication.dto.AccountDto;
import com.BankingApplication.service.AccountService;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
	@Autowired
	private AccountService accountService;
	
	@PostMapping
 public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto){
	 return new ResponseEntity<AccountDto>(accountService.createAccount(accountDto),HttpStatus.CREATED);
 }
	@GetMapping("/{id}")
	public ResponseEntity<AccountDto> getAccountById(@PathVariable long id){
		AccountDto accountDto=accountService.getAccounyById(id);
		return ResponseEntity.ok(accountDto);
	}
	
	@PutMapping("/{id}/deposite")
	public ResponseEntity<AccountDto> deposite(@PathVariable long id,
			                                   @RequestBody Map<String, Double> request){
		
	AccountDto accountDto=	accountService.deposite(id, request.get("amount"));
	
	return ResponseEntity.ok(accountDto);
	}
	@PutMapping("/{id}/withdraw")
	 public ResponseEntity<AccountDto> withdraw(@PathVariable long id,
			                                     @RequestBody Map<String, Double> request){
		 AccountDto accountDto=accountService.withdraw(id, request.get("amount"));
		 return ResponseEntity.ok(accountDto);
	 }
	@GetMapping
	public ResponseEntity<List<AccountDto>> getAllAccount(){
		
	List<AccountDto> listAllAc=	accountService.getAllAcoount();
	 return ResponseEntity.ok(listAllAc);
		
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletAccountById(@PathVariable long id){
		accountService.deleteAccountById(id);
		return ResponseEntity.ok("Account Deleted SuccessFully");
	}
	
}
