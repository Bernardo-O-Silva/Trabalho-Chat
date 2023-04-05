/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.InputStream;
import java.util.Scanner;


/**
 *
 * @author Virginia
 */
public class Recebedor implements Runnable {
 
   private InputStream servidor;
   private Cliente clienteAUX;

   public Recebedor(InputStream servidor, Cliente client) {
     this.servidor = servidor;
     this.clienteAUX = client;
   }
 
   @Override
   public void run() {
    // recebe msgs do servidor e imprime na tela
     Scanner s = new Scanner(this.servidor);
     while (s.hasNextLine()) {
       this.clienteAUX.setMessageInterface(" "+s.nextLine());
     }
     s.close();
   }
 }
