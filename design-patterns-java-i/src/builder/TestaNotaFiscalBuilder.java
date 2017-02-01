package builder;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import imposto.Item;
import observer.AcaoAposGerarNota;
import observer.EnviadorDeEmail;
import observer.EnviadorDeSms;
import observer.Impressora;
import observer.Multiplicador;
import observer.NotaFiscalDao;

public class TestaNotaFiscalBuilder {
	public static void main(String[] args) {
		List<AcaoAposGerarNota> acoes = new ArrayList<>();
		acoes.add(new EnviadorDeEmail());
		acoes.add(new NotaFiscalDao());
		acoes.add(new EnviadorDeSms());
		acoes.add(new Impressora());
		acoes.add(new Multiplicador(2));
		
		NotaFiscalBuilder builder = new NotaFiscalBuilder(acoes);

		NotaFiscal nf = builder.paraEmpresa("Caelum")
				.comCnpj("123.456.789/0001-10")
				.comItem(new Item("item 1", 100.0))
				.comItem(new Item("item 2", 200.0))
		    .comItem(new Item("item 3", 300.0))
		    .comObservacoes("entregar nf pessoalmente")
		    .naData(Calendar.getInstance())
		    .build();

		Item item = new ItemDaNotaBuilder().comNome("Item x").comValor(100).build();

	}
}
