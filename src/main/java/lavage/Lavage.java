package lavage;

import java.io.*;

public class Lavage {

	public static void main(String[] args) {
		// La ressource partagée
		PileDAssiettes pileAssiettes = new PileDAssiettes();
		// Les threads qui se partagent la ressource
		Laveur l = new Laveur(pileAssiettes); l.start();
		Laveur l2 = new Laveur(pileAssiettes); l2.start();
		Laveur l3 = new Laveur(pileAssiettes); l3.start();
		Essuyeur e = new Essuyeur(pileAssiettes); e.start();
		//Essuyeur e2 = new Essuyeur(pileAssiettes); e2.start();
		//Essuyeur e3 = new Essuyeur(pileAssiettes); e3.start();

		// Arrête le programme lors de la frappe d’une touche dans la console
		try {
			System.in.read();
		} catch (IOException ex) {}
		l.interrupt();
		l2.interrupt();
		l3.interrupt();
		e.interrupt();
		//e2.interrupt();
		//e3.interrupt();
	}
}
