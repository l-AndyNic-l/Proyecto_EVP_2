package cl.duoc.suscripciones_service.controller;

import cl.duoc.suscripciones_service.model.Plan;
import cl.duoc.suscripciones_service.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/planes")
public class PlanController {

    @Autowired
    private PlanService planService;



    @GetMapping
    public List<Plan> findAll() {
        return planService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Plan> findById(@PathVariable Long idPlan) {
        return planService.findById(idPlan);
    }

    @PostMapping
    public Plan save(@RequestBody Plan plan) {
        return planService.save(plan);
    }

    @PutMapping("/{id}")
    public Plan update(@PathVariable Long idPlan, @RequestBody Plan plan) {
        return planService.update(idPlan, plan);
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Long idPlan) {
        return planService.deleteById(idPlan);
    }

}
