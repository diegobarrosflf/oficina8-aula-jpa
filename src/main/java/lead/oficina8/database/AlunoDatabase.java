package lead.oficina8.database;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import lead.oficina8.domain.Aluno;

public class AlunoDatabase {

	private EntityManager em;
	
	public AlunoDatabase(EntityManager em) {		
		this.em = em;
	}

	// Implementando o m�todo listar():
	public List<Aluno> listar() {

		em.getTransaction().begin();
		Query query = em.createQuery("SELECT e FROM Aluno e");
		List<Aluno> alunos = query.getResultList();
		em.getTransaction().commit();
		return alunos;
	}

	// Implementando o m�todo buscar():
	public Aluno buscar(int id) {
		em.getTransaction().begin();
		Aluno aluno = em.find(Aluno.class, id);
		em.getTransaction().commit();
		return aluno;
	}

	// Implementando o m�todo salvar():
	public void salvar(Aluno aluno) {
		em.getTransaction().begin();
		em.persist(aluno);
		em.getTransaction().commit();
	}

	// Implementando o m�todo alterar():
	public void alterar(Aluno aluno) {
		em.getTransaction().begin();
		em.merge(aluno);
		em.getTransaction().commit();
	}

	// Implementando o m�todo remover():
	public void remover(int id) {
		em.getTransaction().begin();
		Aluno aluno = em.find(Aluno.class, id);
		em.remove(aluno);
		em.getTransaction().commit();
	}

	public Aluno buscarPorMatricula(String matricula) {
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT e FROM Aluno e WHERE e.matricula = " + matricula);
		Aluno aluno = (Aluno) query.getSingleResult();
		em.getTransaction().commit();
		return aluno;
	}

	public void close() {
		em.close();
	}

}
