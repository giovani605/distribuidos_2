package principal;

import java.util.ArrayList;

import interfaces.InterfaceCliente;

public class ListaInterresados {
	private String nomeArq;
	private ArrayList<InterfaceCliente> clientes = new ArrayList<InterfaceCliente>();
	
	public ListaInterresados(String nomeArq) {
		this.setNomeArq(nomeArq);
	}

	public String getNomeArq() {
		return nomeArq;
	}

	public void setNomeArq(String nomeArq) {
		this.nomeArq = nomeArq;
	}

	public ArrayList<InterfaceCliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<InterfaceCliente> clientes) {
		this.clientes = clientes;
	}
	

}
