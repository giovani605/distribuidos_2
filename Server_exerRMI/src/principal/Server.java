package principal;

import java.rmi.AlreadyBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

import interfaces.InterfaceServ;

public class Server {
	private InterfaceServImpl servidor;

	public Server() {
		// escrevi
		Registry servicoNomes = null;
		try {
			servidor = new InterfaceServImpl();
			servicoNomes = LocateRegistry.createRegistry(8080);
			servicoNomes.bind("Server", servidor);
			
			
			//System.setProperty("java.security.policy", );
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			System.out.println("Fukeq");
		}
	}

	public static void main(String[] args) {
		
		System.setSecurityManager(new RMISecurityManager());
		
		Server server = new Server();
		Scanner scan = new Scanner(System.in);
		scan.nextLine();
	}

}
