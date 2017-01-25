package br.com.caelum.leilao.servico;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MatematicaMalucaTest {

	@Test
	public void deveMultiplicarNumerosMaioresQue30() {
		MatematicaMaluca matMaluca = new MatematicaMaluca();
		assertEquals(31 * 4, matMaluca.contaMaluca(31), 0.0001);
	}

	@Test
	public void deveMultiplicarNumerosMaioresQue10EMenoresQue30() {
		MatematicaMaluca matMaluca = new MatematicaMaluca();
		assertEquals(11 * 3, matMaluca.contaMaluca(11), 0.0001);
	}

	@Test
	public void deveMultiplicarNumerosMenoresQue10() {
		MatematicaMaluca matMaluca = new MatematicaMaluca();
		assertEquals(1 * 2, matMaluca.contaMaluca(1), 0.0001);
	}

}
