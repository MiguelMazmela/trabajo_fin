/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package trabajo;

import javax.swing.JFrame;
import variables.Var;
import ventanas.prueba;

/**
 *
 * @author miguel
 */
public class Trabajo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
           
        Var v= new Var();
        v.conectar();
        System.out.println("Sistem Operativo : "+v.getsSistemaOperativo());
        System.out.println("Path : "+v.getCaminoCompletoBD());
        System.out.println("conectado : "+v.isConectado());
        prueba p=new prueba(v);
        p.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        p.setTitle("Principal");
        p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        p.setLocationRelativeTo(null);
        p.setVisible(true);
        
    
    }
    
}
