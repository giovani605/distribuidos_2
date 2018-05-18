package principal;

import java.util.ArrayList;

import interfaces.InterfaceCliente;

public class ListaInterresados {
	private String nomeArq;
	private ArrayList<Interresado> clientes = new ArrayList<Interresado>();

	public ListaInterresados(String nomeArq) {
		this.setNomeArq(nomeArq);
	}

	public String getNomeArq() {
		return nomeArq;
	}

	public void setNomeArq(String nomeArq) {
		this.nomeArq = nomeArq;
	}

	public ArrayList<Interresado> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Interresado> clientes) {
		this.clientes = clientes;
	}

}
