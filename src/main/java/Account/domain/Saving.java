package Account.domain;

import java.math.BigDecimal;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Saving {
	
	private @Id @GeneratedValue int id;
	
	@NotNull
	private BigDecimal amount;

	@NotNull
	private Currency currency;

	@NotNull
	private BigDecimal interest;

	@NotNull
	private Boolean deposit;

	@NotNull
	private Boolean capitalization;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private AccountDetails account;
	

	public Saving() {
		super();
	}
	
	public Saving(int id, BigDecimal amount, Currency currency, BigDecimal interest, Boolean deposit,
			Boolean capitalization, AccountDetails account) {
		super();
		this.id = id;
		this.amount = amount;
		this.currency = currency;
		this.interest = interest;
		this.deposit = deposit;
		this.capitalization = capitalization;
		this.account = account;
	}




	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public AccountDetails getAccount() {
		return account;
	}


	public void setAccount(AccountDetails account) {
		this.account = account;
	}


	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public BigDecimal getInterest() {
		return interest;
	}

	public void setInterest(BigDecimal interest) {
		this.interest = interest;
	}

	public Boolean getDeposit() {
		return deposit;
	}

	public void setDeposit(Boolean deposit) {
		this.deposit = deposit;
	}

	public Boolean getCapitalization() {
		return capitalization;
	}

	public void setCapitalization(Boolean capitalization) {
		this.capitalization = capitalization;
	}




	@Override
	public String toString() {
		return "Saving [id=" + id + ", amount=" + amount + ", currency=" + currency + ", interest=" + interest
				+ ", deposit=" + deposit + ", capitalization=" + capitalization + "]";
	}
	
	
	

}
