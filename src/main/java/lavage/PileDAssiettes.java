package lavage;

import java.util.LinkedList;
import java.util.List;

class PileDAssiettes {

	private final static int MAX = 10;
	private final List<Assiette> myList = new LinkedList<>();

	private boolean isEmpty() {
		return myList.isEmpty();
	}

	private boolean isFull() {
		return (myList.size() >= MAX);
	}

	public void push(Assiette assiette) throws InterruptedException {
		myList.add(assiette);
		System.out.printf("la pile contient %d assiettes%n", myList.size());
	}

	synchronized public Assiette pop() throws InterruptedException {
		// Attendre que la pile ne soit pas vide
		while (isEmpty()) {
			wait();
		}
		//assert !isEmpty(); // On est sur que la pile n'est pas vide
		Assiette result = myList.remove(myList.size() - 1);
		System.out.printf("la pile contient %d assiettes%n", myList.size());
		notifyAll(); // Notifier que la pile n'est plus pleine
		return result;
	}
}
