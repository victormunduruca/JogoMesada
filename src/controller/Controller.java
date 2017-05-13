package controller;

public class Controller {
	private int saldoTeste;
	public Controller() {
		this.setSaldoTeste(0);
	}
	public void mudaSaldo() {
		setSaldoTeste(getSaldoTeste() + 1);
		System.out.println("Saldo: " +saldoTeste);
	}
	public int getSaldoTeste() {
		return saldoTeste;
	}
	public void setSaldoTeste(int saldoTeste) {
		this.saldoTeste = saldoTeste;
	}
}
