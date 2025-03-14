package cat.institutmarianao.services.impl;

import java.util.List;

import cat.institutmarianao.model.Cycle;
import cat.institutmarianao.services.CycleService;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class CycleServiceImpl implements CycleService {
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Cycle> findAll() {
		return em.createQuery("SELECT c FROM Cycle c", Cycle.class).getResultList();
	}

}
