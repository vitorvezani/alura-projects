package br.com.caelum.leilao.dominio;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LeilaoTest {

	@Test
	public void deveReceberUmLance() {
		Leilao leilao = new Leilao("Macbook Pro 15");
		assertEquals(0, leilao.getLances().size());

		leilao.propoe(new Lance(new Usuario("Steve Jobs"), 2000));

		assertEquals(1, leilao.getLances().size());
		assertEquals(2000, leilao.getLances().get(0).getValor(), 0.00001);
	}

	@Test
	public void deveReceberVariosLances() {
		Leilao leilao = new Leilao("Macbook Pro 15");
		leilao.propoe(new Lance(new Usuario("Steve Jobs"), 2000));
		leilao.propoe(new Lance(new Usuario("Steve Wozniak"), 3000));

		assertEquals(2, leilao.getLances().size());
		assertEquals(2000, leilao.getLances().get(0).getValor(), 0.00001);
		assertEquals(3000, leilao.getLances().get(1).getValor(), 0.00001);
	}

	@Test
	public void naoDeveAceitarDoisLancesSeguidosDoMesmoUsuario() {
		Leilao leilao = new Leilao("Macbook Pro 15");
		Usuario steveJobs = new Usuario("Steve Jobs");

		leilao.propoe(new Lance(steveJobs, 2000));
		leilao.propoe(new Lance(steveJobs, 3000));

		assertEquals(1, leilao.getLances().size());
		assertEquals(2000, leilao.getLances().get(0).getValor(), 0.00001);
	}

	@Test
	public void naoDeveAceitarMaisDoQue5LancesDeUmMesmoUsuario() {
		Leilao leilao = new Leilao("Macbook Pro 15");
		Usuario steveJobs = new Usuario("Steve Jobs");
		Usuario billGates = new Usuario("Bill Gates");

		leilao.propoe(new Lance(steveJobs, 2000));
		leilao.propoe(new Lance(billGates, 3000));

		leilao.propoe(new Lance(steveJobs, 4000));
		leilao.propoe(new Lance(billGates, 5000));

		leilao.propoe(new Lance(steveJobs, 6000));
		leilao.propoe(new Lance(billGates, 7000));

		leilao.propoe(new Lance(steveJobs, 8000));
		leilao.propoe(new Lance(billGates, 9000));

		leilao.propoe(new Lance(steveJobs, 10000));
		leilao.propoe(new Lance(billGates, 11000));

		// deve ser ignorado
		leilao.propoe(new Lance(steveJobs, 12000));

		assertEquals(10, leilao.getLances().size());
		int ultimo = leilao.getLances().size() - 1;
		Lance ultimoLance = leilao.getLances().get(ultimo);
		assertEquals(11000.0, ultimoLance.getValor(), 0.00001);
	}

	/**
	 * Implemente o método dobraLance(Usuario usuario) na classe Leilao. Este
	 * método deve encontrar o último lance dado por este usuário e criar um
	 * novo lance com o dobro do lance anterior. Caso ele não tenha dado nenhum
	 * lance anteriormente, não é criado um novo lance.
	 */
	@Test
	public void deveDobrarOUltimoLanceDoUsuario() {
		Leilao leilao = new Leilao("Macbook Pro 15");
		Usuario steveJobs = new Usuario("Steve Jobs");
		Usuario billGates = new Usuario("Bill Gates");

		leilao.propoe(new Lance(steveJobs, 2000));
		leilao.propoe(new Lance(billGates, 1000));

		leilao.dobrarLance(steveJobs);

		assertEquals(3, leilao.getLances().size());
		assertEquals(4000, leilao.getLances().get(leilao.getLances().size() - 1).getValor(), 0.00001);
	}

}
