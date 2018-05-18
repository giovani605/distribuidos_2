package principal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import interfaces.InterfaceCliente;
import interfaces.InterfaceServ;

public class InterfaceServImpl extends UnicastRemoteObject implements InterfaceServ {

	private SistemaArquivos arquivos;

	protected InterfaceServImpl() throws RemoteException {
		super();
		arquivos = new SistemaArquivos("arquivos");
	}

	@Override
	public ArrayList<String> consultar() {
		System.out.println("consultando");
		return arquivos.consultarTodosArquivos();
	}

	@Override
	public byte[] download(String nomeArq) {

		File f = arquivos.getArquivo(nomeArq);
		// retorna o arquivo
		if (f == null) {
			return null;
		}

		return converterArqByte(f);

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
			cliente.notificar(nomeArq);
			// ja chama a interface do cliente avisando a disponibilidade do arq
			return;
		}
		ListaInterresados lista = getLista(nomeArq);
		if (lista == null) {
			ListaInterresados l = new ListaInterresados(nomeArq);
			l.getClientes().add(cliente);
			this.listaInterrados.add(l);
		} else {
			lista.getClientes().add(cliente);
		}

	}

	@Override
	public void cancelarRegistro(String nomeArq, InterfaceCliente cliente) throws RemoteException {
		ListaInterresados lista = getLista(nomeArq);
		for (InterfaceCliente c : lista.getClientes()) {
			if (c.equals(cliente)) {
				// remover ele da lista
				lista.getClientes().remove(c);
				return;
			}
		}
	}

	// retorna os codigos de sucesso
	@Override
	public int upload(byte[] f, String nome) throws RemoteException {
		// grava no sitema de arquivos
		// transformar os bytes em um arquivos
		File file = new File(".");

		this.arquivos.adicionarArq(file);

		notificar(nome);

		return 0;
	}

	public void notificar(String nomeArq) {
		ListaInterresados lista = this.getLista(nomeArq);
		for (InterfaceCliente c : lista.getClientes()) {
			try {
				c.notificar(nomeArq);
			} catch (RemoteException e) {
				System.out.println("Não foi possivel notificar o cliente " + c.toString() + " " + e.getMessage());
			}
		}

	}

	public byte[] converterArqByte(File f) {
		try {
			return Files.readAllBytes(f.toPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

}
