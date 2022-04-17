package Account.domain;

import java.util.Date;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;



@Entity
public class AccountDetails {
	
	@Id
	@Size(min = 1 , max = 15 , message = "The username size must be in between 1 to 15")
	private String username;
	
	@Size(min = 1 , max = 15 , message = "The Name size must be in between 1 to 15")
	private String Name;
	
	@PastOrPresent(message = "The Date should be past or present")
	private Date lastseen;
	
	@OneToMany(mappedBy = "account" , fetch = FetchType.LAZY)
	private List<Expenditure> expenses;
	
	@OneToMany(mappedBy = "account" , fetch  = FetchType.LAZY)
	private List<Income> incomes;
	
	@OneToOne(mappedBy = "account" , fetch  =  FetchType.LAZY)
	private Saving saving;
	
	
	private String note;
	

	public AccountDetails() {
		super();
	}

	public AccountDetails(String username, String name, Date lastseen, List<Expenditure> expenses, List<Income> incomes,
			Saving saving, String note) {
		super();
		this.username = username;
		Name = name;
		this.lastseen = lastseen;
		this.expenses = expenses;
		this.incomes = incomes;
		this.saving = saving;
		this.note = note;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public Date getLastseen() {
		return lastseen;
	}

	public void setLastseen(Date lastseen) {
		this.lastseen = lastseen;
	}

	public List<Expenditure> getExpenses() {
		return expenses;
	}

	public void setExpenses(List<Expenditure> expenses) {
		this.expenses = expenses;
	}

	public List<Income> getIncomes() {
		return incomes;
	}

	public void setIncomes(List<Income> incomes) {
		this.incomes = incomes;
	}

	public Saving getSaving() {
		return saving;
	}

	public void setSaving(Saving saving) {
		this.saving = saving;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
	

}
