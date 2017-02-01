package builder;

import java.util.Calendar;

import imposto.Item;

public class TestaNotaFiscalBuilder {
  public static void main(String[] args) {
    NotaFiscal nf = new NotaFiscalBuilder().paraEmpresa("Caelum")
                      .comCnpj("123.456.789/0001-10")
                      .comItem(new Item("item 1", 100.0))
                      .comItem(new Item("item 2", 200.0))
                      .comItem(new Item("item 3", 300.0))
                      .comObservacoes("entregar nf pessoalmente")
                      .naData(Calendar.getInstance())
                      .build();
    
    Item item = new ItemDaNotaBuilder()
    		.comNome("Item x")
    		.comValor(100)
    		.build();
    
  }
}
