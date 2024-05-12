package in.wipro.ajeet.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.wipro.ajeet.entity.PlanCateogry;

public interface PlanCategoryRepo extends JpaRepository<PlanCateogry, Integer> {

}
