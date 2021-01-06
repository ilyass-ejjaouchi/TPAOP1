package aspectj;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import beans.Client;

@Aspect
public class VerserAspect {
	
	private static Logger logger = Logger.getLogger(VerserAspect.class);
	@Pointcut("execution(* *..Client.verser(..))")
	public void verser(){};
	
	@After("verser()")
	public void afterVerser(){
		logger.info("after la methode retirer");
	}
	@Before("verser()")
	public void beforeVerser(){
		logger.info("before la methode retirer");
	}
	@Around("verser()")
	public void aroundRetirer(ProceedingJoinPoint joinPoint){
		Client c = (Client)joinPoint.getTarget();
		double mt = (double)(joinPoint.getArgs()[0]);
			logger.info("le client "+ c.getNom()+" a verser " + mt + " sur son compte" );
	}

	}