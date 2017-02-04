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
				
		
		System.out.println(contrato.getTipoContrato());
		contrato.restaura(historico.getEstado(0));
		System.out.println(contrato.getTipoContrato());
		
	}

}
