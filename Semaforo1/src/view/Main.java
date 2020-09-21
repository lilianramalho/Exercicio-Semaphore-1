package view;

import java.util.concurrent.Semaphore;

import controller.Corrida;

public class Main {

	public static void main(String[] args) {
		int permissao = 1;
		Semaphore semaforo = new Semaphore(permissao);
		for (int i = 0; i < 4; i++) {
			Thread corrida = new Corrida(semaforo, i);
			corrida.start();
		}

	}

}
