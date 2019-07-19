package servico;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidade.CadastroPaciente;

@Stateless
public class ServicoCadastroPaciente {
	
	@PersistenceContext
	private EntityManager em;
	
	
	
	public void cadastrarPaciente(CadastroPaciente paciente) throws Exception {
		if (listaPacientesCpf(paciente).isEmpty()) {
			this.em.persist(paciente);
		}else {
			throw new Exception("CPF já cadastrado");
		}
		
	}
	
	
	public List<CadastroPaciente> listaPacientes(){
		Query query = this.em.createQuery("SELECT p FROM CadastroPaciente p", CadastroPaciente.class);
		return query.getResultList();
	}
	
	public void excluirPaciente(CadastroPaciente paciente) {
		this.em.remove(this.em.merge(paciente));
	}

	
	public List<CadastroPaciente> listaPacientesCpf(CadastroPaciente paciente){
		Query query = this.em.createQuery("SELECT p FROM CadastroPaciente p WHERE p.cpf=:p1", CadastroPaciente.class);
		query.setParameter("p1", paciente.getCpf());
		return query.getResultList();
	}
}
