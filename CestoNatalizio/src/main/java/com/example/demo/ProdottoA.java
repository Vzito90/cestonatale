package com.example.demo;

public class ProdottoA extends Prodotto{
	
	int quantita;

	public ProdottoA(String nome, String marca, double prezzo, String luogo, String immagine, int quantita) {
		super(nome, marca, prezzo, luogo, immagine);
		// TODO Auto-generated constructor stub
		this.quantita=quantita;
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	@Override
	public String toString() {
		return "ProdottoA [quantita=" + quantita + ", getNome()=" + getNome() + ", getMarca()=" + getMarca()
				+ ", getPrezzo()=" + getPrezzo() + ", getLuogo()=" + getLuogo() + ", getImmagine()=" + getImmagine()
				+ ", toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ "]";
	}
	
	
	
}
