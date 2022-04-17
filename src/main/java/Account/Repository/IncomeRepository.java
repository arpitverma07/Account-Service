package Account.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Account.domain.Income;

public interface IncomeRepository extends JpaRepository<Income, Integer> {

}
