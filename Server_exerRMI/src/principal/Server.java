package principal;

import java.io.File;
import java.net.SocketPermission;
import java.rmi.AlreadyBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Properties;
import java.util.Scanner;

import interfaces.InterfaceServ;

public class Server {
	private InterfaceServImpl interf;

	public Server() {
		super();
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}

		Registry servicoNomes = null;
		try {
			interf = new InterfaceServImpl();

			servicoNomes = LocateRegistry.createRegistry(10000);
			servicoNomes.bind("Server", interf);

		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			System.out.println("Fukeq");
		}
	}

	public static void main(String[] args) {
		System.setProperty("java.security.policy", "file:java.policy");

		Server server = new Server();
		Scanner scan = new Scanner(System.in);
		boolean flag = true;
		while (flag) {
			String entrada = scan.nextLine();
			if (entrada.equals("teste")) {

			}
			if (entrada.equalsIgnoreCase("sair"))
				break;
		}

	}

}
