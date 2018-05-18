package principal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;

import interfaces.InterfaceCliente;
import interfaces.InterfaceServ;

public class InterfaceServImpl extends UnicastRemoteObject implements InterfaceServ {

	private SistemaArquivos arquivos;

	protected InterfaceServImpl() throws RemoteException {
		super();
		arquivos = new SistemaArquivos("arquivos");
	}

	// Retorna todos os arquivos disponiveis para o cliente
	@Override
	public ArrayList<String> consultar() {
		// System.out.println("consultando");
		return arquivos.consultarTodosArquivos();
	}

	// Envia ao cliente o arquivo(bytes) desejado
	@Override
	public byte[] download(String nomeArq) {

		File f = arquivos.getArquivo(nomeArq);
		// retorna o arquivo
		if (f == null) {
			return null;
		}

		return arquivos.converterArqByte(f);

	}

	// Pensar como fazer isso
	private ArrayList<ListaInterresados> listaInterrados = new ArrayList<>();

	// Recupera a lista de interessados pelo nome do arquivo
	private ListaInterresados getLista(String nomeArq) {
		for (ListaInterresados l : listaInterrados) {
			if (l.getNomeArq().equals(nomeArq)) {
				return l;
			}
		}
		return null;
	}

	// Registra o interesse do usuario em um arquivo
	@Override
	public void registrarInteresse(String nomeArq, InterfaceCliente cliente, Date dataValidade) throws RemoteException {

		ListaInterresados lista = getLista(nomeArq);
		if (lista == null) {
			ListaInterresados l = new ListaInterresados(nomeArq);
			l.getClientes().add(new Interresado(cliente, dataValidade));
			this.listaInterrados.add(l);
		} else {
			lista.getClientes().add(new Interresado(cliente, dataValidade));
		}

	}

	// Cancela o interesse em um arquivo
	@Override
	public void cancelarRegistro(String nomeArq, InterfaceCliente cliente) throws RemoteException {
		ListaInterresados lista = getLista(nomeArq);
		for (Interresado c : lista.getClientes()) {
			if (c.getInterf().equals(cliente)) {
				// remover ele da lista
				lista.getClientes().remove(c);
				return;
			}
		}
	}

	// Recebe um arquivo do cliente
	@Override
	public int upload(byte[] f, String nome) throws RemoteException {
		arquivos.gravarArq(f, nome);
		notificar(nome);

		return 0;
	}

	// Notifica os clientes interresados
	public void notificar(String nomeArq) {
		ListaInterresados lista = this.getLista(nomeArq);
		if (lista == null)
			return;
		for (Interresado c : lista.getClientes()) {
			Date dataAtual = new Date();
			if (dataAtual.before(c.getDataValidade())) {
				try {
					c.getInterf().notificar(nomeArq);
				} catch (RemoteException e) {
					System.out.println("Não foi possivel notificar o cliente " + c.toString() + " " + e.getMessage());
				}
			}
		}
		// remove todos os interresados
		this.listaInterrados.remove(lista);

	}

}
