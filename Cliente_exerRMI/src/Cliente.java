import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.net.SocketPermission;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.security.AllPermission;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

import interfaces.InterfaceServ;

public class Cliente {
	private InterfaceServ server;
	private InterfaceClienteImpl interfaceCliente;
	private SistemaArquivos arquivos;

	public Cliente(String path) {
		arquivos = new SistemaArquivos(path);

		System.setProperty("java.security.policy", "file:java.policy");

		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}
		try {
			interfaceCliente = new InterfaceClienteImpl();
			Registry locate = LocateRegistry.getRegistry("localhost", 10000);
			server = (InterfaceServ) locate.lookup("Server");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void loop() {
		if (this.server == null) {
			return;
		}
		boolean flag = true;
		Scanner scan = new Scanner(System.in);
		while (flag) {
			System.out.println("Digite um comando: ");
			String comando = scan.nextLine();
			if (comando.equalsIgnoreCase("SAIR")) {
				break;
			}
			if (comando.equalsIgnoreCase("CONSULTAR")) {
				consultar();
			}
			if (comando.equalsIgnoreCase("REGISTRAR")) {
				registrar();
			}
			if (comando.equalsIgnoreCase("DOWNLOAD")) {
				download();
			}
			if (comando.equalsIgnoreCase("UPLOAD")) {
				upload();
			}
			if (comando.equalsIgnoreCase("CANCELAR")) {
				cancelar();
			}
		}
		System.out.println("fim: ");

	}

	//
	public void cancelar() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Digite o arquivo desejado: ");
		String arq = scan.nextLine();
		try {
			server.cancelarRegistro(arq, this.interfaceCliente);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// funcao q baixa um arquivo
	public void download() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Digite o arquivo desejado: ");
		String arq = scan.nextLine();
		try {
			byte[] arquivo = server.download(arq);
			// TODO fazer ele receber o arquivo
			if (arquivo == null) {
				System.out.println("Arquivo não encontrado");
				return;
			}
			arquivos.gravarArq(arquivo, arq);

		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void upload() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Digite o arquivo desejado: ");
		String arq = scan.nextLine();
		try {
			File f = new File(arq);
			if (f == null)
				return;

			int cod = server.upload(arquivos.converterArqByte(f), arq);

		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// funcao que resgistra o interrese em um arquivo
	public void registrar() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Digite o arquivo desejado: ");
		String arq = scan.nextLine();
		try {
			server.registrarInteresse(arq, this.interfaceCliente);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// aqui consulto o Server para ver os arquivos disponiveis
	public void consultar() {
		ArrayList<String> lista = null;
		try {
			lista = server.consultar();
		} catch (RemoteException e) {
			System.out.println("problemas ao se conectar ao Server: " + e.getMessage());
		}
		if (lista == null || lista.isEmpty()) {
			System.out.println("Nenhum arquivo disponivel");
			return;
		}
		System.out.println("Arquivos disponiveis: ");
		for (String s : lista) {
			System.out.println(s);
		}

	}

	public static void main(String[] args) {
		// isso vai servir depois
		// System.setProperty("java.security.policy", "file:./bin/settings.policy");
		Cliente cliente = new Cliente("arquivos/teste");
		cliente.loop();
	}

}
