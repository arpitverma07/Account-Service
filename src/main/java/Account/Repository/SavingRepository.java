package Account.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import Account.domain.Saving;

public interface SavingRepository extends JpaRepository<Saving, Integer>{
	
	public Optional<Saving> findByaccount_username(String username);

}
