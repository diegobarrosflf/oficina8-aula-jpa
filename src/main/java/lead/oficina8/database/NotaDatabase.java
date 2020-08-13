package lead.oficina8.database;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import lead.oficina8.domain.Nota;

public class NotaDatabase {

	EntityManager entityManager;

	public NotaDatabase(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	// Implementando o m�todo listar():
	public List<Nota> listar() {

		entityManager.getTransaction().begin();

		Query query = entityManager.createQuery("SELECT e FROM Nota e");
		List<Nota> notas = query.getResultList();

		entityManager.getTransaction().commit();

		return notas;
	}

	// Implementando o m�todo buscar():
	public Nota buscar(int id) {

		entityManager.getTransaction().begin();

		Nota nota = entityManager.find(Nota.class, id);

		entityManager.getTransaction().commit();

		return nota;
	}

	// Implementando o m�todo salvar():
	public void salvar(Nota nota) {

		entityManager.getTransaction().begin();

		entityManager.persist(nota);

		entityManager.getTransaction().commit();

	}

//	Implementando o m�todo alterar():
	public void alterar(Nota nota) {

		entityManager.getTransaction().begin();

		entityManager.merge(nota);

		entityManager.getTransaction().commit();

	}

//	Implementando o m�todo remover():
	public void remover(int id) {

		entityManager.getTransaction().begin();

		Nota nota = entityManager.find(Nota.class, id);
		entityManager.remove(nota);

		entityManager.getTransaction().commit();

	}

}
