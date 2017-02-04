package memento;

import java.util.Calendar;

public class Contrato {

	private Calendar date;
	private String descricao;
	private TipoContrato tipoContrato;

	public Contrato(Calendar date, String descricao, TipoContrato tipoContrato) {
		this.date = date;
		this.descricao = descricao;
		this.tipoContrato = tipoContrato;
	}

	public Estado salvaEstado() {
		return new Estado(new Contrato(date, descricao, tipoContrato));
	}

	public void avanca() throws Exception {
		switch (tipoContrato) {
		case NOVO:
			tipoContrato = TipoContrato.EM_ANDAMENTO;
			break;
		case EM_ANDAMENTO:
			tipoContrato = TipoContrato.ABERTO;
			break;
		case ABERTO:
			tipoContrato = TipoContrato.FECHADO;
			break;
		case FECHADO:
			throw new Exception("Não deveria ser possivel avançar o estado fechado");
		}
	}

	public Calendar getDate() {
		return date;
	}

	public String getDescricao() {
		return descricao;
	}

	public TipoContrato getTipoContrato() {
		return tipoContrato;
	}

	public void restaura(Estado estado) {
		this.date = estado.getContrato().getDate();
		this.descricao = estado.getContrato().getDescricao();
		this.tipoContrato = estado.getContrato().getTipoContrato();
	}

}
