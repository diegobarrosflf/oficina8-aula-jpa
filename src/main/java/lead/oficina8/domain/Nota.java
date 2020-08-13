package lead.oficina8.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Nota {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@OneToOne
	@JoinColumn(name = "id_aluno")
	private Aluno aluno;
	private Double nota1;
	private Double nota2;

	public Nota() {
		super();
	}

	public Nota(Aluno aluno, Double nota1, Double nota2) {
		super();
		this.aluno = aluno;
		this.nota1 = nota1;
		this.nota2 = nota2;
	}

	public int getId() {
		return id;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public Double getNota1() {
		return nota1;
	}

	public Double getNota2() {
		return nota2;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public void setNota1(Double nota1) {
		this.nota1 = nota1;
	}

	public void setNota2(Double nota2) {
		this.nota2 = nota2;
	}

	@Override
	public String toString() {
		return "Nota [id=" + id + ", aluno=" + aluno + ", nota1=" + nota1 + ", nota2=" + nota2 + "]";
	}

}
