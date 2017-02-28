package com.atsistemas.curso;

public class Dios {

	private static Dios instance = new Dios();
	
	private Dios(){
		
	}
	
	//Factoria Estatica
	public static Dios getInstance(){
		return instance;
	}
	
	//Factoria instanciada
	public Hombre frabicarAsiatico(){
		return new Asiatico();
	}
	
	public Hombre frabicarEuropeo(){
		return new Europeo();
	}
	
	private class Asiatico implements Hombre{
		
	}
	
	private class Europeo implements Hombre{
		
	}
}
