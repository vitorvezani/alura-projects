package br.com.caelum.leilao.servico;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.caelum.leilao.builder.CriadorDeLeilao;
import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;

public class AvaliadorTest {

    private Avaliador leiloeiro;
    private Usuario joao;
    private Usuario jose;
    private Usuario maria;

    @Before
    public void criaAvaliador() {
        this.leiloeiro = new Avaliador();
        this.joao = new Usuario("João");
        this.jose = new Usuario("José");
        this.maria = new Usuario("Maria");
    }

    @After
    public void finaliza() {
    	// finaliza recursos
    }

    @BeforeClass
    public static void testandoBeforeClass() {
      // inicializa recursos uma unica vez (antes do primeiro teste)
    }

    @AfterClass
    public static void testandoAfterClass() {
    	// finaliza recursos uma unica vez (depois do ultimo teste)
    }

    @Test(expected=RuntimeException.class)
    public void naoDeveAvaliarLeiloesSemNenhumLanceDado() {
        Leilao leilao = new CriadorDeLeilao()
            .para("Playstation 3 Novo")
            .constroi();

        leiloeiro.avalia(leilao);
    }

	@Test
	public void avaliaMedia() {
        Leilao leilao = new CriadorDeLeilao().para("Carro 0km")
                .lance(joao, 10.0)
                .lance(jose, 10.0)
                .constroi();

        leiloeiro.avaliaMediaLances(leilao);

		Assert.assertEquals(10d, leiloeiro.getMedia(), 0.00001);
	}

	@Test
	public void deveEntenderLancesEmOrdemCrescente() {
        Leilao leilao = new CriadorDeLeilao().para("Carro 0km")
                .lance(joao, 250.0)
                .lance(jose, 300.0)
                .lance(maria, 400.0)
                .constroi();

		// executando a acao
		leiloeiro.avalia(leilao);

		// comparando a saida com o esperado
		assertThat(leiloeiro.getMenorLance(), equalTo(250.0));
        assertThat(leiloeiro.getMaiorLance(), equalTo(400.0));
	}

	@Test
	public void deveEntenderLancesEmOrdemCrescenteComOutrosValores() {
        Leilao leilao = new CriadorDeLeilao().para("Carro 0km")
                .lance(joao, 1000.0)
                .lance(jose, 2000.0)
                .lance(maria, 3000.0)
                .constroi();

		leiloeiro.avalia(leilao);

		assertEquals(3000, leiloeiro.getMaiorLance(), 0.0001);
		assertEquals(1000, leiloeiro.getMenorLance(), 0.0001);
	}

	@Test
	public void deveEntenderLeilaoComApenasUmLance() {
        Leilao leilao = new CriadorDeLeilao().para("Carro 0km")
                .lance(joao, 1000.0)
                .constroi();

		leiloeiro.avalia(leilao);

		assertEquals(1000, leiloeiro.getMaiorLance(), 0.0001);
		assertEquals(1000, leiloeiro.getMenorLance(), 0.0001);
	}

	/**
	 * Para isso, crie um Leilao e proponha Lance com valores randômicos, como
	 * por exemplo, 200, 450, 120, 700, 630, 230. Ao final, verifique que o
	 * menor é 120 e o maior é 700.
	 */
	@Test
	public void deveEntenderLeilaoComOrderAleatoria() {
       Leilao leilao = new CriadorDeLeilao().para("Carro 0km")
                .lance(joao, 200.0)
                .lance(jose, 450.0)
                .lance(joao, 120.0)
                .lance(jose, 700.0)
                .lance(joao, 630.0)
                .lance(jose, 230.0)
                .constroi();

		leiloeiro.avalia(leilao);

		assertEquals(700, leiloeiro.getMaiorLance(), 0.0001);
		assertEquals(120, leiloeiro.getMenorLance(), 0.0001);
	}

	/**
	 * Crie Lances com valores de 400, 300, 200, 100, por exemplo, e garanta que
	 * a saída bata com os valores da entrada.
	 */
	@Test
	public void deveEntenderLeilaoComOrderDecrescente() {
		Leilao leilao = new CriadorDeLeilao().para("Carro 0km")
                .lance(joao, 400.0)
                .lance(jose, 300.0)
                .lance(maria, 200.0)
                .lance(joao, 100.0)
                .constroi();

		leiloeiro.avalia(leilao);

		assertEquals(400, leiloeiro.getMaiorLance(), 0.0001);
		assertEquals(100, leiloeiro.getMenorLance(), 0.0001);
	}

	@Test
	public void deveEncontrarOsTresMaioresLances() {
        Leilao leilao = new CriadorDeLeilao().para("Playstation 3 Novo")
                .lance(joao, 100.0)
                .lance(maria, 200.0)
                .lance(joao, 300.0)
                .lance(maria, 400.0)
                .constroi();

		leiloeiro.avalia(leilao);

		List<Lance> maiores = leiloeiro.getTresMaiores();

		assertEquals(3, maiores.size());
        assertThat(maiores, hasItems(
                new Lance(maria, 400),
                new Lance(joao, 300),
                new Lance(maria, 200)
        ));
	}

	/**
	 * Um leilão com 5 lances, deve encontrar os três maiores
	 */
	@Test
	public void deveEncontrarOsTresMaioresLancesEm5Lances() {
		Leilao leilao = new Leilao("Playstation 3 Novo");

		leilao.propoe(new Lance(joao, 100.0));
		leilao.propoe(new Lance(maria, 200.0));
		leilao.propoe(new Lance(joao, 300.0));
		leilao.propoe(new Lance(maria, 400.0));
		leilao.propoe(new Lance(joao, 800.0));

		leiloeiro.avalia(leilao);

		List<Lance> maiores = leiloeiro.getTresMaiores();

		assertEquals(3, maiores.size());
		assertEquals(800, maiores.get(0).getValor(), 0.00001);
		assertEquals(400, maiores.get(1).getValor(), 0.00001);
		assertEquals(300, maiores.get(2).getValor(), 0.00001);
	}

	/**
	 * Um leilão com 2 lances, deve devolver apenas os dois lances que encontrou
	 */
	@Test
	public void deveEncontrarOsTresMaioresLancesEm2Lances() {
		Leilao leilao = new Leilao("Playstation 3 Novo");

		leilao.propoe(new Lance(joao, 100.0));
		leilao.propoe(new Lance(maria, 200.0));

		leiloeiro.avalia(leilao);

		List<Lance> maiores = leiloeiro.getTresMaiores();

		assertEquals(2, maiores.size());
		assertEquals(200, maiores.get(0).getValor(), 0.00001);
		assertEquals(100, maiores.get(1).getValor(), 0.00001);
	}

	/**
	 * Um leilão sem nenhum lance, devolve lista vazia
	 */
	@Test
	public void deveEncontrarOsTresMaioresLancesSemNenhumLance() {

		Leilao leilao = new Leilao("Playstation 3 Novo");
		leilao.propoe(new Lance(joao, 100.0));

		leiloeiro.avalia(leilao);

		List<Lance> maiores = leiloeiro.getTresMaiores();

		assertEquals(1, maiores.size());
	}

}
