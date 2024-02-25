/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estanco2;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Usuario
 */
public class Estanco implements Runnable {
    private Semaphore[] ingredientes;
    private Semaphore mutex;

    public Estanco() {
        ingredientes = new Semaphore[3];
        for (int i = 0; i < 3; i++) {
            ingredientes[i] = new Semaphore(0);
        }
        mutex = new Semaphore(1);
    }

    public void ponerIngrediente(int ingrediente) {
        try {
            mutex.acquire();
            ingredientes[ingrediente].release();
            System.out.println("Estanquero puso ingrediente " + ingrediente + " en la mesa.");
            mutex.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean hayIngredientes() {
        return ingredientes[0].availablePermits() > 0 &&
               ingredientes[1].availablePermits() > 0 &&
               ingredientes[2].availablePermits() > 0;
    }

    public void esperarFumar() throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            ingredientes[i].acquire();
        }
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
