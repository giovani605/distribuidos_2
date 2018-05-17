package principal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import interfaces.InterfaceCliente;
import interfaces.InterfaceServ;

public class InterfaceServImpl extends UnicastRemoteObject implements InterfaceServ {

	private SistemaArquivos arquivos;

	protected InterfaceServImpl() throws RemoteException {
		super();
		arquivos = new SistemaArquivos();
	}

	@Override
	public ArrayList<String> consultar() {
		return arquivos.consultarTodosArquivos();
	}

	@Override
	public byte[] download(String nomeArq) {

		File f = arquivos.getArquivo(nomeArq);
		f = new File("texto.txt");

		if (f == null) {
			return null;
		}
		// retorna o arquivo
		try {
			PrintWriter print = new PrintWriter(f);
			print.print("EU QUERO CHURROS");
			print.flush();
			return null;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	// Pensar como fazer isso
	private ArrayList<ListaInterresados> listaInterrados = new ArrayList<>();

	private ListaInterresados getLista(String nomeArq) {
		for (ListaInterresados l : listaInterrados) {
			if (l.getNomeArq().equals(nomeArq)) {
				return l;
			}
		}
		return null;
	}

	@Override
	public void registrarInteresse(String nomeArq, InterfaceCliente cliente) throws RemoteException {
		if (arquivos.getArquivo(nomeArq) != null) {
			// ja chama a interface do cliente avisando a disponibilidade do arq
			return;
		}
		ListaInterresados lista = getLista(nomeArq);
		if (lista == null) {
			ListaInterresados l = new ListaInterresados(nomeArq);
			l.getClientes().add(cliente);
			this.listaInterrados.add(l);
		}

	}
	@Override
	public void cancelarRegistro(String nomeArq, InterfaceCliente cliente) throws RemoteException {
		// TODO Auto-generated method stub

	}

	// retorna os codigos de sucesso
	@Override
	public int upload(byte[] f, String nome) throws RemoteException {
		// grava no sitema de arquivos

		return 0;
	}

	

}
