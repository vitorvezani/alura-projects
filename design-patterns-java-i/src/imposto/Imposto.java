package imposto;

public abstract class Imposto {

	private final Imposto outroImposto;

	public Imposto(Imposto outroImposto) {
		this.outroImposto = outroImposto;
	}

	// construtor default
	public Imposto() {
		this.outroImposto = null;
	}

	protected double calculoDoOutroImposto(Orcamento orcamento) {
		// tratando o caso do proximo imposto nao existir!
		return outroImposto == null ? 0 : outroImposto.calcula(orcamento);
	}

	public abstract double calcula(Orcamento orcamento);

}
