package beans;

import org.apache.log4j.Logger;

import aspectj.RetirerAspect;

public class Client {
	private static Logger logger = Logger.getLogger(RetirerAspect.class);
	private String nom;
	private Compte cp;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Compte getCp() {
		return cp;
	}

	public void setCp(Compte cp) {
		this.cp = cp;
	}

	public void retirer(double mt) {
		cp.debiter(mt);
	}

	public void verser(double mt) {
		cp.approvisionner(mt);
		logger.info("le client "+ this.getNom()+" a verser" + mt + "sur son compte" );
	}

}
