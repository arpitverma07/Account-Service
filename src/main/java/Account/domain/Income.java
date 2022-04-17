package Account.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Income {
	
	private @Id @GeneratedValue int id;
	
	private String title;
	
	private BigDecimal amount;
	
	private Currency currency;
	
	private TimePeriod period;
	
	private String icon;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private AccountDetails account;
	

	public Income() {
		super();
	}

	public Income(int id, String title, BigDecimal amount, Currency currency, TimePeriod period, String icon,
			AccountDetails account) {
		super();
		this.id = id;
		this.title = title;
		this.amount = amount;
		this.currency = currency;
		this.period = period;
		this.icon = icon;
		this.account = account;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public TimePeriod getPeriod() {
		return period;
	}

	public void setPeriod(TimePeriod period) {
		this.period = period;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public AccountDetails getAccount() {
		return account;
	}

	public void setAccount(AccountDetails account) {
		this.account = account;
	}
	

}
