package com.example.demo;


public class Prodotto {
	private String nome;
	private String marca;
	private double prezzo;
	private String luogo;
	private String immagine;

	public Prodotto(String nome, String marca, double prezzo, String luogo, String immagine) {
		super();
		this.nome = nome;
		this.marca = marca;
		this.prezzo = prezzo;
		this.luogo = luogo;
		this.immagine = immagine;
	}
	
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	public String getLuogo() {
		return luogo;
	}
	public void setLuogo(String luogo) {
		this.luogo = luogo;
	}

	public String getImmagine() {
		return immagine;
	}

	public void setUrl(String immagine) {
		this.immagine = immagine;
	}

	@Override
	public String toString() {
		return "Prodotto [nome=" + nome + ", marca=" + marca + ", prezzo=" + prezzo + ", luogo=" +luogo + ", immagine=" + immagine + "]";
	}
}