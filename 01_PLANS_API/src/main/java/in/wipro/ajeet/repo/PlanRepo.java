package in.wipro.ajeet.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.wipro.ajeet.entity.Plan;

public interface PlanRepo extends JpaRepository<Plan, Integer> {

}
