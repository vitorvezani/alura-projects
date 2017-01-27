package investimento;

import java.util.Random;

public class Moderado implements TipoInvestidor {

  private Random random;

  public Moderado() {
    this.random = new Random();
  }

	@Override
	public double calculaRendimento(Investimento investimento) {
    if(random.nextInt(2) == 0) return investimento.getValor() * 0.025;
    else return investimento.getValor() * 0.007;
	}

}
