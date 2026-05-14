package cl.duoc.suscripciones_service.service;

import cl.duoc.suscripciones_service.model.Plan;
import cl.duoc.suscripciones_service.repository.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PlanService {

    @Autowired
    private PlanRepository planRepository;



    public List<Plan> findAll() {
        return planRepository.findAll();
    }

    public Optional<Plan> findById(Long idPlan) { return planRepository.findById(idPlan); }

    public Plan save(Plan plan) {
        return planRepository.save(plan);
    }

    public Plan update(Long idPlan, Plan planNuevo) {
        if ( planRepository.existsById(idPlan) ) {
            Plan plan = planRepository.findById(idPlan).orElse(null);

            plan.setNombre(planNuevo.getNombre());
            plan.setPrecio(planNuevo.getPrecio());
            plan.setAnuncios(planNuevo.getAnuncios());
            plan.setTamanioDescargas(planNuevo.getTamanioDescargas());

            return planRepository.save(plan);
        } else {
            return null;
        }
    }

    public Boolean deleteById(Long idPlan) {
        if ( planRepository.existsById(idPlan) ) {
            planRepository.deleteById(idPlan);
            return true;
        } else {
            return false;
        }
    }

}
