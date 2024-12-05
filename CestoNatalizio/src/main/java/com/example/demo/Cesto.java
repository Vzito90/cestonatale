package com.example.demo;

 
	public class Cesto {
	private String nome;
	private double prezzo;
	 
	 
	 
	public Cesto (String nome, double prezzo) {
	 
		this.nome = nome;
		this.prezzo = prezzo;
	  }
	 
	 
	public String getNome() {
		return nome;
	}
	 
	public void setNome(String nome) {
		this.nome = nome;
	}
	 
	public double getPrezzo() {
		return prezzo;
	} 
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	
}
