package entidade;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

@Entity
public class CadastroPaciente {

	@Id
	@SequenceGenerator(name = "CONTADOR_PACIENTE", sequenceName = "NUM_SEQ_PACIENTE", allocationSize = 0)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CONTADOR_PACIENTE")
	private Integer id;

	@NotBlank
	private String nome;

	@NotNull
	private Integer idade;

	@CPF
	@NotBlank
	private String cpf;

	@NotBlank
	private String sexo;

	@NotNull
	private Date dataDeInternacao;

	public CadastroPaciente() {

	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public String getCpf() {
		return cpf;
	}

	public String getSexo() {
		return sexo;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Date getDataDeInternacao() {
		return dataDeInternacao;
	}

	public void setDataDeInternacao(Date dataDeInternacao) {
		this.dataDeInternacao = dataDeInternacao;
	}

}
