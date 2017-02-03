package memento;

import java.util.Calendar;

public class Programa {
	
	public static void main(String[] args) throws Exception {
		Historico historico = new Historico();

		Contrato contrato = new Contrato(Calendar.getInstance(), "Mauricio", TipoContrato.NOVO);
		historico.adiciona(contrato.salvaEstado());

		contrato.avanca();
		historico.adiciona(contrato.salvaEstado());

		contrato.avanca();
		historico.adiciona(contrato.salvaEstado());

		contrato.avanca();
		historico.adiciona(contrato.salvaEstado());
		
		System.out.println(historico.getEstado(2).getContrato().getTipoContrato());

		System.out.println(historico.getEstado(1).getContrato().getTipoContrato());

		System.out.println(historico.getEstado(0).getContrato().getTipoContrato());
	}

}
