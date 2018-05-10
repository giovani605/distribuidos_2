package principal;

import java.io.File;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import interfaces.InterfaceServ;

public class InterfaceServImpl extends UnicastRemoteObject implements InterfaceServ {

	protected InterfaceServImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	

	@Override
	public ArrayList<String> consultar() {
		System.out.println("chameou");
		return null;
	}

	@Override
	public byte[] download(String nomeArq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void registrarInteresse(String nomeArq) {
		// TODO Auto-generated method stub

	}

	@Override
	public void cancelarRegistro(String nomeArq) {
		// TODO Auto-generated method stub

	}

}
