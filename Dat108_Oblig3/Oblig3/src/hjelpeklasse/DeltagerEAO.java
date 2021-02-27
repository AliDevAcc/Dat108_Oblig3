package hjelpeklasse;
import java.util.List;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class DeltagerEAO {

	@PersistenceContext(name = "deltagerPU")
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public List<Deltager> hentAlleDeltagere() {
		return em.createQuery("SELECT d from Deltager d").getResultList();
	}

	public void addDeltager(Deltager d) {
		
		em.persist(d);
		 
	}

	public Deltager FinnesNr(String nokkel) {
		return em.find(Deltager.class,nokkel);

	}
	
	

}
