import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import servicoInterface.InterfaceCliente;

public class InterfaceClienteImpl extends UnicastRemoteObject implements InterfaceCliente {

	protected InterfaceClienteImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void notificar(String nomeArq) {
		// TODO Auto-generated method stub
		
	}

}
