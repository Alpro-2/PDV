package pucrs.alpro2.pdv;

/**
 * A classe <code>Cliente</code> representa um cliente de supermercado.
 * 
 * <p>
 * Um objeto da classe cliente armazena o número de cadastro de pessoa física
 * para fins de nota fiscal.
 * 
 * <p>
 * O objeto armazena um endereço de correio eletrônico para envio de cópia de
 * nota fiscal e para relacionamento com o cliente.
 * 
 * <p>
 * O número de cadastro de pessoa física deve ser verificado para evitar erros
 * de digitação e cadastro duplicado.
 * 
 * <p>
 * Caso o cliente não informe ou não tenho um número de CPF, indicar a
 * constante CPF_INDEFINIDO.
 * 
 * @see http://www.receita.fazenda.gov.br/pessoafisica/cpf/cadastropf.htm
 * @see http://pt.wikipedia.org/wiki/Cpf
 * @see https://nfg.sefaz.rs.gov.br
 * 
 * @author marco.mangan@pucrs.br
 */
public class Cliente {
	public final static String CPF_INDEFINIDO = "CPF_INDEFINIDO";

	private String cpf;
	private String email;

	public Cliente(final String cpf, final String email) throws PdvException {

		if (email == null) {
			throw new PdvException("O email não pode ser nulo!");
		}

		checkCpf(cpf);

		this.cpf = cpf;
		this.email = email;
	}
	
	
	private static void checkCpf(String cpf) throws PdvException { 
		if (cpf == null) {
			throw new PdvException("O CPF não pode ser nulo!");
		}

		if (cpf.length() != 14) {
			throw new PdvException("O CPF deve ter 14 caracteres!");
		}

		// if (!Pattern.matches("[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}-[0-9]{2}", cpf))
		// {
		// throw new PdvException(
		// "O CPF deve ser composto de dígitos, pontos e traço!");
		// }

		if (cpf.charAt(11) != '-') {
			throw new PdvException(
					"O décimo-primeiro caracter deve ser um traço!");
		}
		if (cpf.charAt(3) != '.') {
			throw new PdvException("O caracter na posição 3 deve ser um ponto!");
		}
		if (cpf.charAt(7) != '.') {
			throw new PdvException("O caracter na posição 7 deve ser um ponto!");
		}
		
		for (int i = 0; i < cpf.length(); i++) {
			if (i != 3 && i != 7 && i != 11) {
				if (!Character.isDigit(cpf.charAt(i))) {
					throw new PdvException(
							String.format(
									"O caracter na posição %d deve ser um dígito entre 0 e 9!",
									i + 1));
				}
			}
		}
	}
	
	public String getCpf() {
		return cpf;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return String.format("Cliente [cpf=%s, email=%s]", cpf, email);
	}

}
