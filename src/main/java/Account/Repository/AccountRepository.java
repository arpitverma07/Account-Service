package Account.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Account.domain.AccountDetails;

public interface AccountRepository extends JpaRepository<AccountDetails,String>{

}
