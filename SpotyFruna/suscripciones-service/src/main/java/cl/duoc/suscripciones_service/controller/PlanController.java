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
    public Optional<Plan> findById(@PathVariable Long id) {
        return planService.findById(id);
    }

    @PostMapping
    public Plan save(@RequestBody Plan p) {
        return planService.save(p);
    }

    @PutMapping("/{id}")
    public Plan update(@PathVariable Long id, @RequestBody Plan p) {
        return planService.update(id, p);
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable  Long id) {
        return planService.deleteById(id);
    }

}
