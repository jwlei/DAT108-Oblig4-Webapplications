package no.hvl.dat108;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PersonEAO {

	@PersistenceContext(name = "personPU")
    private EntityManager em;
	
	public PersonEAO() {	
	}
	
	public void addPerson(Person p) {
		em.persist(p);
	}
	
	public Person getPerson(String mobil) {
		return em.find(Person.class, mobil);
	}


	public List<Person> getList(){
		List<Person> liste = em.createQuery("SELECT p FROM Person p", Person.class).getResultList();
		sortering(liste);
		return liste;
	}
	
	private static void sortering(List<Person> liste) {
		Collections.sort(liste, Comparator.comparing(Person::getFornavn).thenComparing(Person::getEtternavn));
	}
	
	
	public boolean erPaameldtFraFor(String mobil) {
		return em.find(Person.class, mobil) != null;
	}
	
}


