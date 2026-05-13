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

    public Optional<Plan> findById(Long id) { return planRepository.findById(id); }

    public Plan save(Plan plan) {
        return planRepository.save(plan);
    }

    public Plan update(Long id, Plan p) {
        if ( planRepository.existsById(id) ) {
            Plan plan = planRepository.findById(id).orElse(null);
            plan.setNombre(p.getNombre());
            plan.setPrecio(p.getPrecio());
            plan.setAnuncios(p.getAnuncios());
            plan.setTamanioDescargas(p.getTamanioDescargas());


            return planRepository.save(plan);

        } else {
            return null;
        }
    }

    public Boolean deleteById(Long id) {
        if ( planRepository.existsById(id) ) {

            planRepository.deleteById(id);
            return true;

        } else {
            return false;
        }
    }

}
