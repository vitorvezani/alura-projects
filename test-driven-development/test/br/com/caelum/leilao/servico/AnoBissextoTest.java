package br.com.caelum.leilao.servico;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AnoBissextoTest {

	@Test
	public void deveSaberAnoBissexto4Anos() {
		AnoBissexto anoBissexto = new AnoBissexto();

		assertTrue(anoBissexto.ehBissexto(4));
		assertTrue(anoBissexto.ehBissexto(8));
		assertTrue(anoBissexto.ehBissexto(12));
		assertTrue(anoBissexto.ehBissexto(16));
	}

	@Test
	public void deveSaberAnoBissexto100Anos() {
		AnoBissexto anoBissexto = new AnoBissexto();

		assertFalse(anoBissexto.ehBissexto(100));
		assertFalse(anoBissexto.ehBissexto(200));
		assertFalse(anoBissexto.ehBissexto(300));
	}

	@Test
	public void deveSaberAnoBissexto400Anos() {
		AnoBissexto anoBissexto = new AnoBissexto();

		assertTrue(anoBissexto.ehBissexto(400));
		assertTrue(anoBissexto.ehBissexto(800));
		assertTrue(anoBissexto.ehBissexto(1200));
		assertTrue(anoBissexto.ehBissexto(1600));
	}

	@Test
	public void deveRetornarAnoBissexto() {
	    AnoBissexto anoBissexto = new AnoBissexto();

	    assertTrue(anoBissexto.ehBissexto(2016));
	    assertTrue(anoBissexto.ehBissexto(2012));
	}

	@Test
	public void naoDeveRetornarAnoBissexto() {
	    AnoBissexto anoBissexto = new AnoBissexto();

	    assertFalse(anoBissexto.ehBissexto(2015));
	    assertFalse(anoBissexto.ehBissexto(2011));
	}
}
