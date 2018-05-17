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
		// escrevi
		super();
		Registry servicoNomes = null;
		try {
			interf = new InterfaceServImpl();

			// System.setProperty("java.rmi.server.hostname", "hostname");
			servicoNomes = LocateRegistry.createRegistry(10000);
			servicoNomes.bind("Server", interf);

			// System.setProperty("java.security.policy", );
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			System.out.println("Fukeq");
		}
	}

	public static void main(String[] args) {
		// System.setProperty("java.security.policy", "file:./bin/settings.policy");
		Properties propriedades = new Properties();
		propriedades.put("java.security.policy", "/home/giovani/politica.policy");
		SocketPermission p2 = new SocketPermission("localhost:1024-", "accept,connect,listen");

		Server server = new Server();
		Scanner scan = new Scanner(System.in);
		boolean flag = true;
		while (flag) {
			String entrada = scan.nextLine();
			if (entrada.equals("teste")) {
				server.teste();

			}
			if (entrada.equalsIgnoreCase("sair"))
				break;
		}

	}

	private void teste() {
		// TODO Auto-generated method stub

	}

}
