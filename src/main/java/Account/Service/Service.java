package Account.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import Account.Repository.AccountRepository;
import Account.Repository.ExpenditureRepository;
import Account.Repository.IncomeRepository;
import Account.Repository.SavingRepository;
import Account.domain.AccountDetails;
import Account.domain.Currency;
import Account.domain.Expenditure;
import Account.domain.Income;
import Account.domain.Saving;

@Component
public class Service {
	
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private AccountRepository accountrepo;
	
	@Autowired
	private ExpenditureRepository expenserepo;
	
	@Autowired
	private IncomeRepository incomerepo;
	
	@Autowired
	private SavingRepository savingrepo;
	
	public Optional<AccountDetails> findByName(String username) throws Exception {
		
		Optional<AccountDetails> account = accountrepo.findById(username);
		
		return account;
	}
	
	public AccountDetails create(AccountDetails user) {

		Optional<AccountDetails> existing = accountrepo.findById(user.getUsername());
		if(existing.isPresent())
			Assert.isNull(existing, "account already exists: " + user.getUsername());


		Saving saving = new Saving();
		saving.setAmount(new BigDecimal(0));
		saving.setCurrency(Currency.getDefault());
		saving.setInterest(new BigDecimal(0));
		saving.setDeposit(false);
		saving.setCapitalization(false);
		saving.setAccount(user);
		
		user.setLastseen(new Date());
		
		accountrepo.save(user);
		savingrepo.save(saving);

		log.info("new account has been created: " + user.getName());

		return user;
	}

	public Optional<Saving> getAccountSaving(String  username) {
		return savingrepo.findByaccount_username(username);
	}

	public Expenditure addNewExpense(String username, Expenditure expense) {
		
		if(expense.getCurrency() == null)
			expense.setCurrency(Currency.getDefault());
		AccountDetails account = accountrepo.findById(username).get();
		account.setLastseen(new Date());
		
		Saving saving = account.getSaving();
		saving.setAmount(saving.getAmount().subtract(expense.getAmount()));
		savingrepo.deleteById(saving.getId());
		savingrepo.save(saving);
		
		expense.setAccount(account);
		expenserepo.save(expense);
		
		log.info("new expense has been added to : " + account.getName());
		
		return expense;
	}

	public Income addNewIncome(String username, Income income) {
		
		if(income.getCurrency() == null)
			income.setCurrency(Currency.getDefault());
		
		AccountDetails account = accountrepo.findById(username).get();
		account.setLastseen(new Date());
		
		Saving saving = account.getSaving();
		saving.setAmount(saving.getAmount().add(income.getAmount()));
		savingrepo.deleteById(saving.getId());
		savingrepo.save(saving);
		
		income.setAccount(account);
		incomerepo.save(income);
		
		log.info("new income has been added to : " + account.getName());
		
		return income;
	}

	public AccountDetails DeleteAccountwithEIS(String username) {
		
		AccountDetails account = accountrepo.findById(username).get();
		
		savingrepo.delete(account.getSaving());
		incomerepo.deleteAll(account.getIncomes());
		expenserepo.deleteAll(account.getExpenses());
		accountrepo.delete(account);

		log.info("The account has been Deleted: " + account.getName());
		
		return null;
	}

	

}
