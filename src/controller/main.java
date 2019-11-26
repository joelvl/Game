/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author Administrator
 */
public class main {

    public static void main(String[] args) {
        Log_Creator lc = new Log_Creator();
        lc.addAction("Vegeta vino a pelear");
        lc.addAction("Salió una zanahoria del vívero");
        lc.saveDay("27/11/19", "src\\Binnacle\\prueba1.txt", true);
    }
    
}
