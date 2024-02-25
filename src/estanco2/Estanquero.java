/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estanco2;

/**
 *
 * @author Usuario
 */
public class Estanquero implements Runnable {
    public Estanco estanco;

    public Estanquero(Estanco estanco) {
        this.estanco = estanco;
    }
      
    @Override
    public void run() {
        try {
            while (true) {
                int ingrediente = (int) (Math.random() * 3);
                estanco.ponerIngrediente(ingrediente);
                if (estanco.hayIngredientes()) {
                    System.out.println("Estanquero avisa que hay ingredientes en la mesa.");
                }
                Thread.sleep(1000); // Simula el tiempo que tarda en producir un ingrediente
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
 }

