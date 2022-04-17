package Account.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Account.domain.Expenditure;

public interface ExpenditureRepository extends JpaRepository<Expenditure, Integer>{

}
