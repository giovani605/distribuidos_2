package interfaces;

import java.io.File;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface InterfaceCliente extends Remote{
	
	public void notificar(String nomeArq) throws RemoteException;

}
