import java.util.Scanner;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class MainTeste {

    public static void main(String[] args) throws IOException, UnknownHostException, IOException{

        boolean teste;
        Scanner scan = new Scanner(System.in);
        int porta;
        String ipAdd;
        String username;
        Gerenciador manager = new Gerenciador();

        teste = scan.nextBoolean();

        if(teste == true){

            System.out.print("Digite a porta do servidor: ");
            porta = scan.nextInt();
            manager.server(porta);

        }
        else if (teste == false){

            scan.nextLine();

            System.out.print("Digite o ip do servidor: ");
            ipAdd = scan.nextLine();

            System.out.print("Digite a porta do servidor: ");
            porta = scan.nextInt();

            scan.nextLine();

            System.out.print("Digite seu nome de usuário: ");
            username = scan.nextLine();

            manager.client(ipAdd, porta, username);

        }

        scan.close();

    }

}