import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import interfaces.InterfaceCliente;

public class InterfaceClienteImpl extends UnicastRemoteObject implements InterfaceCliente {

	protected InterfaceClienteImpl() throws RemoteException {
		super();
	}

	@Override
	public void notificar(String nomeArq) {
		System.out.println("Arquivo " + nomeArq + " disponivel");
	}

}
