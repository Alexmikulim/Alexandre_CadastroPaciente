package web;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import entidade.CadastroPaciente;
import servico.ServicoCadastroPaciente;

@Named
@RequestScoped
public class ServicoPacienteBean {

	@EJB
	private ServicoCadastroPaciente servicoPaciente;

	private CadastroPaciente paciente;

	private ServicoPacienteBean() {
		this.paciente = new CadastroPaciente();
	}

	public List<CadastroPaciente> listarPacientes() {
		return this.servicoPaciente.listaPacientes();
	}

	public void cadastrarPaciente() {
		try {
			this.servicoPaciente.cadastrarPaciente(paciente);
			JSFUtils.enviarMensagemDeInformacao("Paciente cadastrado com sucesso");
			this.paciente = new CadastroPaciente();
		} catch (Exception e) {
			JSFUtils.enviarMensagemDeAtencao(e.getMessage());
		}
	}

	public void excluirPaciente(CadastroPaciente paciente) {
		this.servicoPaciente.excluirPaciente(paciente);
		JSFUtils.enviarMensagemDeInformacao("Cadastro do Paciente Excluido");
	}

	public ServicoCadastroPaciente getServicoCadastroPaciente() {
		return servicoPaciente;
	}

	public void setServicoCadastroPaciente(ServicoCadastroPaciente servicoCadastroPaciente) {
		this.servicoPaciente = servicoCadastroPaciente;
	}

	public CadastroPaciente getCadastroPaciente() {
		return paciente;
	}

	public void setCadastroPaciente(CadastroPaciente cadastroPaciente) {
		this.paciente = cadastroPaciente;
	}

}
