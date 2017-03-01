package com.atsistemas.curso;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//La logica que yo quiero ejecutar cuando se intercepte la 
//ejecucion de los beans
@Aspect
//@Component
public class Aspecto {

	@Pointcut("execution(* com.atsistemas.curso.MiServicio.metodoInterceptado(java.lang.String)) && args(n)")
	public void concreto(String n){}
	
	@Before("concreto(numero)")
	public void antesDelTarget(String numero){
		System.out.println("Antes del Target con dato: " + numero);
	}
	
	@After("concreto(numero)")
	public void despuesDelTarget(String numero){
		System.out.println("Despues del Target con dato: " + numero);
	}
	
	@AfterReturning(pointcut="execution(* com.atsistemas.curso.MiServicio.metodoInterceptado(java.lang.String))", returning="retorno")
	public void despuesDelTargetFiltrandoElResultado(String retorno){
		System.out.println("Despues del Target con retorno: " + retorno);
	}
	
	@Around("execution(* com.atsistemas.curso.MiServicio.metodoInterceptado(java.lang.String))")
	public Object duranteElTarget(ProceedingJoinPoint pjp) throws Throwable{
		Object[] parametros = pjp.getArgs();
		
		System.out.println("El numero recibido es: " + parametros[0]);
		
		//Object resultado = pjp.proceed(parametros);
		
		String resultado = "GANDALF: No puedes pasar!!!!";
		
		System.out.println("El resultado es: " + resultado);
		
		return resultado;
	}
	
}
