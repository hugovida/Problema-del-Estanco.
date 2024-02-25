/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estanco2;

/**
 *
 * @author Usuario
 */
public class Fumador implements Runnable {
   private int id;
   private Estanco estanco;

    public Fumador(int id, Estanco estanco) {
        this.id =id+1;;
        this.estanco = estanco;
    }

    @Override
    public void run() {
        try {
            while (true) {
             
                estanco.esperarFumar();
                System.out.println("Fumador " + id + " está fumando.");
                Thread.sleep(1000); // Simula el tiempo que tarda en fumar
                System.out.println("Fumador " + id + " ha terminado de fumar.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


