package requisicao;

public class Requisicao {
	enum Formato {
		XML, CSV, PORCENTO, OTHER
	}

	private Formato formato;

	public Requisicao(Formato formato) {
		this.formato = formato;
	}

	public Formato getFormato() {
		return formato;
	}

}
