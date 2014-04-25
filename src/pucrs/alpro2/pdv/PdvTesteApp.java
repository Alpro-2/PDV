package pucrs.alpro2.pdv;

public class PdvTesteApp {

	public static void main(String[] args) throws Exception {
		Cliente cliente = new Cliente("123.123.123-11", "a@b.c");
		System.out.println(cliente);
		Produto produto = new Produto("789123123123", "Ovo de Páscoa - Lacta", "g", 2999);
		System.out.println(produto);
	}

}
