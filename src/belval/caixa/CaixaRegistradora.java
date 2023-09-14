package belval.caixa;

public class CaixaRegistradora {
	private int saldo;
	private int lucro;

	public CaixaRegistradora(int saldoInicial) {
		if (saldoInicial < 0) {
			throw new IllegalArgumentException("Caixa não pode ter saldo negativo");
		}
		this.saldo = saldoInicial;
		this.lucro = 0;
		printEstado("*");
	}

	public int getSaldo() {
		return this.saldo;
	}

	public int getLucro() {
		return lucro;
	}

	public int efetuarPagamento(int valorMercadoria, int valorPago) {
		if (valorMercadoria > valorPago) {
			throw new IllegalArgumentException(
					"Valor pago insuficiente" + 
					"(valor mercadoria:" + valorMercadoria + "," + 
						"valor pago:" + valorPago + ")");
		}
		int troco = valorPago - valorMercadoria;
		this.saldo += valorMercadoria;
		this.lucro += valorMercadoria;
		System.out.println("efetuarPagamento(" + valorMercadoria + "," + valorPago + "), " + "Troco:" + troco);
		return troco;
	}

	public void efeturarRetirada(int valorRetirada) {
		if (valorRetirada < 0) {
			throw new IllegalArgumentException("valorRetirada não pode ser negativo");
		}
		if (this.saldo < valorRetirada) {
			throw new IllegalArgumentException("Saldo insuficiente");
		}
		System.out.println("efeturarRetirada(" + valorRetirada + ")");
		this.saldo -= valorRetirada;
	}

	public void transferir(int valor, CaixaRegistradora cxDestino) {
		System.out.println("transferir(" + valor + ")");
		efeturarRetirada(valor);
		cxDestino.saldo += valor;
	}

	public CaixaRegistradora abrirNovaCaixa(int valorTransferidoParaNovaCaixa) {
		CaixaRegistradora cxDestino = new CaixaRegistradora(0);
		transferir(valorTransferidoParaNovaCaixa, cxDestino);
		return cxDestino;
	}

	public void printEstado(String nome) {
		System.out.println("[" + nome + "]Saldo:" + saldo + ", Lucro:" + lucro);
	}
}
