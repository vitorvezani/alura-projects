package com.solid.java.srp;

public class Funcionario {

	private Cargo cargo = Cargo.DBA;
	private String nome;
	private double salario;

	public Funcionario(String nome, Cargo cargo, double salario) {
		this.nome = nome;
		this.cargo = cargo;
		this.salario = salario;
	}
	
	public double getSalarioBase() {
		return salario;
	}
	
	public Cargo getCargo() {
		return cargo;
	}

	public String getNome() {
		return nome;
	}

	public double getSalario() {
		return salario;
	}

	public double calculaSalario() {
		 return cargo.getRegra().calcula(this);
	}

}
