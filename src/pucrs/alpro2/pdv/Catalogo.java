package pucrs.alpro2.pdv;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Catalogo {
	public void leArquivo() {
		Path path1 = Paths.get("catalogo.txt");
		try (BufferedReader br = Files.newBufferedReader(path1,
				Charset.forName("UTF-8"))) {
			String linha = null;
			while ((linha = br.readLine()) != null) {
				Scanner sc = new Scanner(linha).useDelimiter(",");
				String ian, descricao, unidade, valorEmCentavos;

				ian = sc.next();
				descricao = sc.next();
				unidade = sc.next();
				valorEmCentavos = sc.next();
				System.out.format("%s | %s | %s | %s\n", ian, descricao,
						unidade, valorEmCentavos);
			}
		} catch (IOException x) {
			System.err.format("Erro de E/S: %s%n", x);
		}
	}
}
