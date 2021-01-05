package AspetjPack;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import beans.Client;

@Aspect
public class RetirerAspect {
	
	private static Logger logger = Logger.getLogger(RetirerAspect.class);
	@Pointcut("execution(* *..Client.retirer(..))")
	public void retirer(){};
	
	@After("retirer()")
	public void afterRetirer(){
		logger.info("after la methode retirer");
	}
	@Before("retirer()")
	public void beforeRetirer(){
		logger.info("before la methode retirer");
	}
	@Around("retirer()")
	public void aroundRetirer(ProceedingJoinPoint joinPoint){
		Client c = (Client)joinPoint.getTarget();
		double mt = (double)(joinPoint.getArgs()[0]);
		if (c.getCp().getSolde() > mt) {
			logger.info("le client "+ c.getNom()+" a retirer " + mt + " de son compte" );}
		else {
			logger.error("erreur");
		}
	}

	}