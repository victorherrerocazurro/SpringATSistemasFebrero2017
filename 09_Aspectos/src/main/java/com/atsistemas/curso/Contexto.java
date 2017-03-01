package com.atsistemas.curso;

public class Contexto {
	public Object getBean(String tipo){
		if(tipo.equals("servicio")){
			//No hace esto, que seria lo que en principio podriamos esperar
			//return new MiServicio();
			
			//Lo que hace es
			return new ProxyServicio(new MiServicio(), new ExtensionImpl(), new Aspecto());
		} else {
			return null;
		}
	}	
}