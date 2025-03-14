package cat.institutmarianao.services.impl;

import java.util.List;

import cat.institutmarianao.model.Module;
import cat.institutmarianao.services.ModuleService;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class ModuleServiceImpl implements ModuleService {
	@PersistenceContext
	EntityManager em;

	@Override
	public Module findByPk(String moduleCode, String cycleCode) {
		return em.createQuery("SELECT m FROM Module m WHERE m.code = :code AND m.cycleCode = :cycleCode", Module.class)
				.setParameter("code", moduleCode).setParameter("cycleCode", cycleCode).getSingleResult();
	}

	@Override
	public List<Module> findAllByCycleCode(String cycleCode) {
		return em.createQuery("SELECT m FROM Module m WHERE m.cycleCode = :cycleCode", Module.class)
				.setParameter("cycleCode", cycleCode).getResultList();
	}

}
