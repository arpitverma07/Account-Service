package Account.Controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Account.Service.Service;
import Account.domain.AccountDetails;
import Account.domain.Expenditure;
import Account.domain.Income;
import Account.domain.Saving;

@RestController
public class Controller {
	
	@Autowired
	Service service;
	
	@GetMapping("/current/{username}")
	public AccountDetails getAccount(@PathVariable String username) throws Exception {
			Optional<AccountDetails> account = service.findByName(username);
			if(!account.isPresent())
				throw new Exception("The User is not present in Database with Username : " + username);
			else 
				return account.get();
	}
	
	@GetMapping("/current/{username}/saving")
	public Saving getByaccount(@PathVariable String username) throws Exception {
		
		Optional<Saving> saving  = service.getAccountSaving(username);
		
		if(!saving.isPresent())
			throw new Exception("The User is not present in Database with Username : " + username);
		else
			return saving.get();	
	}
	
	@GetMapping("/current/{username}/expenses")
	public List<Expenditure> getExpenses(@PathVariable String username) throws Exception{
		Optional<AccountDetails> account = service.findByName(username);
		if(!account.isPresent())
			throw new Exception("The User is not present in Database with Username : " + username);
		else
			return account.get().getExpenses();
	}
	
	@GetMapping("/current/{username}/incomes")
	public List<Income> getIncomes(@PathVariable String username) throws Exception{
		Optional<AccountDetails> account = service.findByName(username);
		if(!account.isPresent())
			throw new Exception("The User is not present in Database with Username : " + username);
		else
			return account.get().getIncomes();
	}
	
	@PostMapping("/current/{username}/expenses")
	public Expenditure addexpense(@PathVariable String username , @Valid @RequestBody Expenditure expense) throws Exception{
		
		Optional<AccountDetails> account = service.findByName(username);
		if(!account.isPresent())
			throw new Exception("The User is not present in Database with Username : " + username);
		else
			return service.addNewExpense(username,expense);
		
	}
	
	@PostMapping("/current/{username}/incomes")
	public Income addIncome(@PathVariable String username , @Valid @RequestBody Income income) throws Exception{
		Optional<AccountDetails> account = service.findByName(username);
		if(!account.isPresent())
			throw new Exception("The User is not present in Database with Username : " + username);
		else
			return service.addNewIncome(username , income);
	}
	
	@PostMapping("/current")
	public AccountDetails CreateAccount(@Valid @RequestBody AccountDetails account) {
		return service.create(account);
	}
	
	@DeleteMapping("/current/{username}")
	public AccountDetails DeleteAccount(@PathVariable String username) throws Exception {
		
		Optional<AccountDetails> account = service.findByName(username);
		if(!account.isPresent())
			throw new Exception("The User is not present in Database with Username : " + username);
		else 
			return service.DeleteAccountwithEIS(username);
		
	}
}
