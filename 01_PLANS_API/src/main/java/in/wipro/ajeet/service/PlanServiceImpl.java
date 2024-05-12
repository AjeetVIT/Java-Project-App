package in.wipro.ajeet.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.wipro.ajeet.entity.Plan;
import in.wipro.ajeet.entity.PlanCateogry;
import in.wipro.ajeet.repo.PlanCategoryRepo;
import in.wipro.ajeet.repo.PlanRepo;

@Service
public class PlanServiceImpl implements PlanService {
	@Autowired
	private PlanRepo planRepo;
	@Autowired
	private PlanCategoryRepo planCategoryRepo;

	@Override
	public Map<Integer, String> getPlanCategories() {
		// TODO Auto-generated method stub
		List<PlanCateogry> categories = planCategoryRepo.findAll();
		Map<Integer, String> categoryMap = new HashMap<>();
		categories.forEach(category -> {
			categoryMap.put(category.getCategoryId(), category.getCategoryName());
		});
		return categoryMap;
	}

	@Override
	public boolean savePlan(Plan plan) {
		// TODO Auto-generated method stub
		Plan saved = planRepo.save(plan);
		/*
		 * if(saved.getPlanId()!=null) { return true; }else { return false; }
		 */
		return saved.getPlanId() != null ? true : false;

	}

	@Override
	public List<Plan> getAllPlans() {
		// TODO Auto-generated method stub
		return planRepo.findAll();

	}

	@Override
	public Plan getPlanById(Integer planId) {
		// TODO Auto-generated method stub
		Optional<Plan> findById = planRepo.findById(planId);
		if (findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public boolean updatePlan(Plan plan) {
		// TODO Auto-generated method stub
		Plan save = planRepo.save(plan);

		return plan.getPlanId() != null;
	}

	@Override
	public boolean deletePlanById(Integer planId) {
		// TODO Auto-generated method stub
		boolean status = false;
		try {
			planRepo.deleteById(planId);
			status = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean planStatusChange(Integer planid, String status) {
		// TODO Auto-generated method stub
		/*
		 * Plan plan = new Plan(); plan.setPlanId(planid); plan.setActiveSW(status);
		 * planRepo.save(plan);
		 */
		Optional<Plan> findById = planRepo.findById(planid);
		if (findById.isPresent()) {
			Plan plan = findById.get();
			plan.setActiveSW(status);
			planRepo.save(plan);
			return true;
		}
		return false;
	}

}
