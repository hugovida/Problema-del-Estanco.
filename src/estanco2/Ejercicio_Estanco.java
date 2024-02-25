/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package estanco2;

/**
 *
 * @author Usuario
 */
public class Ejercicio_Estanco {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Estanco estanco = new Estanco();
        Thread estanquero = new Thread(new Estanquero(estanco));
        estanquero.start();
        for(int i=0;i<3;i++){
        Thread fumador= new Thread(new Fumador(i, estanco));
        fumador.start();
        }
       

        
    }

}
    

