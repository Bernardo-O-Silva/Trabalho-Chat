import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Gerenciador {

    public void server(int hostPort) throws IOException{
    
        // inicia o servidor
        Servidor server = new Servidor(hostPort);
        
        server.executa();

    }    

    public void client(String ipServer, int hostPort, String username) throws UnknownHostException, IOException{
 
        // dispara cliente
        Cliente client = new Cliente(ipServer, hostPort, username);
        
        client.executa();
    
    }


}