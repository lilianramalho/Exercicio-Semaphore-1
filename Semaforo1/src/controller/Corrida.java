package controller;

import java.util.concurrent.Semaphore;

public class Corrida extends Thread {
	Semaphore semaforo;
	int corredor, chegada, saida;
	
	public Corrida(Semaphore semaforo , int corredor) {
		this.semaforo = semaforo;
		this.corredor = corredor;
		
	}
	
	@Override
	public void run() {
		andando();
		
		try {
			semaforo.acquire();
			passandoPorta();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			passou();
		}
		
	}
	
	public void andando() {
		int distanciaTotal = 200;
		int distanciaPercorrida = 0;
		int deslocamento = (int) ((Math.random() * 2) + 4);
		int tempo = 1000;
		while (distanciaPercorrida < distanciaTotal) {
			distanciaPercorrida += deslocamento;
			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (distanciaPercorrida > 200) {
				distanciaPercorrida = 200;
			}
			System.out.println("pessoa " + corredor + " ja andou " + distanciaPercorrida + "m. ");
		}
		chegada++;
		System.out.println( corredor + " foi o " + chegada + " a chegar");
		
	}
	
	public void passandoPorta() {
		System.out.println( corredor + " esta passando a porta");
		int tempo = (int) ((Math.random() * 1001) + 1000);
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	
	public void passou() {
		saida++;
		System.out.println(corredor + "foi o " + saida + " a passar a porta");
	}
}
