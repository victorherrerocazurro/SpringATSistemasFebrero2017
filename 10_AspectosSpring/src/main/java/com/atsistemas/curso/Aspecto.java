package com.atsistemas.curso;

import org.aspectj.lang.ProceedingJoinPoint;

//La logica que yo quiero ejecutar cuando se intercepte la 
//ejecucion de los beans
public class Aspecto {

	public void antesDelTarget(String numero){
		System.out.println("Antes del Target con dato: " + numero);
	}
	
	public void despuesDelTarget(String numero){
		System.out.println("Despues del Target con dato: " + numero);
	}
	
	public void despuesDelTargetFiltrandoElResultado(String retorno){
		System.out.println("Despues del Target con retorno: " + retorno);
	}
	
	public Object duranteElTarget(ProceedingJoinPoint pjp) throws Throwable{
		Object[] parametros = pjp.getArgs();
		
		System.out.println("El numero recibido es: " + parametros[0]);
		
		//Object resultado = pjp.proceed(parametros);
		
		String resultado = "GANDALF: No puedes pasar!!!!";
		
		System.out.println("El resultado es: " + resultado);
		
		return resultado;
	}
	
}
