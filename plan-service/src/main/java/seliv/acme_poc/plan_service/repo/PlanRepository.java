package seliv.acme_poc.plan_service.repo;

import seliv.acme_poc.plan_service.model.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanRepository extends JpaRepository<Plan, Long> {

    Plan findPlanByCode(String code);

}
