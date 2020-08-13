package lead.oficina8;

import java.sql.SQLException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.h2.tools.Server;

import lead.oficina8.database.NotaDatabase;
import lead.oficina8.database.AlunoDatabase;
import lead.oficina8.domain.Aluno;
import lead.oficina8.domain.Nota;

public class Application {

	public static void main(String[] args) throws SQLException {
		//iniciando servidor do banco de testes H2
		//para acessar abra o navegador http://localhost:8082/
		//não esquecer de fechar o prcesso no console
		startDatabase();

		//iniciando as dependencias 
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("nota_aluno");
		EntityManager em = emf.createEntityManager();

		Aluno a = new Aluno();

		// Declaração do objeto da classe database
		AlunoDatabase alunoDB = new AlunoDatabase(em);
		NotaDatabase notaDB = new NotaDatabase(em);

		// Declaraão de 3 alunos e respectivas notas
		Aluno aluno1 = new Aluno("Pedro", "1");
		alunoDB.salvar(aluno1);
		a = alunoDB.buscarPorMatricula("1");
		Nota nota1 = new Nota(a, 9.5, 10.);
		notaDB.salvar(nota1);

		Aluno aluno2 = new Aluno("João", "2");
		alunoDB.salvar(aluno2);
		a = alunoDB.buscarPorMatricula("2");
		Nota nota2 = new Nota(a, 9.5, 10.);
		notaDB.salvar(nota2);

		Aluno aluno3 = new Aluno("Maria", "3");
		alunoDB.salvar(aluno3);
		a = alunoDB.buscarPorMatricula("3");
		Nota nota3 = new Nota(a, 9.5, 10.);
		notaDB.salvar(nota3);

		//lista alunos e suas notas a partir de objetos notas, pois estes possuem uma referencia para o aluno
		System.out.println("***Listando Alunos e Notas***");
		for (Nota notas : notaDB.listar()) {
			System.out.println(notas);
		}

		// buscar
		System.out.println("\n***Pesquisando um aluno***");
		Aluno buscaAluno = alunoDB.buscar(3);
		System.out.println(buscaAluno);

		// Alterar notas
		notaDB.buscar(1).setNota1(6.0);
		notaDB.buscar(2).setNota1(7.0);
		notaDB.buscar(3).setNota1(8.0);

		System.out.println("\n***Listando Alunos após alteração de notas***");
		for (Nota notas : notaDB.listar()) {
			System.out.println(notas);
		}
		
		em.close();

	}

	private static void startDatabase() throws SQLException {
		new Server().runTool("-tcp", "-web", "-ifNotExists");
	}
}
