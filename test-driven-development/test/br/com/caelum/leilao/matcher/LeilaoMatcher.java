package br.com.caelum.leilao.matcher;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;

public class LeilaoMatcher extends TypeSafeMatcher<Leilao> {

	private Lance lance;

	public LeilaoMatcher(Lance lance) {
		this.lance = lance;
	}

	@Override
	public void describeTo(Description description) {
		description.appendText("leilao com lance " + lance.getValor());
	}

	@Override
	protected boolean matchesSafely(Leilao leilao) {
		return leilao.getLances().contains(lance);
	}

	@Factory
	public static Matcher<Leilao> temLance(Lance lance) {
	    return new LeilaoMatcher(lance);
	}

}
