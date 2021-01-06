package aspectj;

import beans.Client;
import beans.Compte;

public class Test {
	public static void main(String[] args) {
		Client client =new Client();
		Compte cp = new Compte();
		cp.setSolde(1000);
		client.setCp(cp);
		client.setNom("Ali");
		client.retirer(20);
		client.verser(2000);
		}
}
