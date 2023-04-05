import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, UnknownHostException, IOException{

        boolean teste;
        Scanner scan = new Scanner(System.in);
        int porta;
        String ipAdd;
        String username;
        Gerenciador manager = new Gerenciador();
        Login telinha = new Login();
        String msg;

        teste = telinha.getAdmin();

        porta = telinha.getPorta();

        if(teste == true){

            manager.server(porta);
            

        }
        else if (teste == false){

            ipAdd = telinha.getIP();
            username = telinha.getNome();

            manager.client(ipAdd, porta, username);

        }

    }

}
