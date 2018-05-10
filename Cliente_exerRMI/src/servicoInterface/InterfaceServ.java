package servicoInterface;

import java.io.File;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface InterfaceServ extends Remote {

	public ArrayList<String> consultar() throws RemoteException ; 

	public byte[] download(String nomeArq) throws RemoteException;

	public void registrarInteresse(String nomeArq) throws RemoteException;

	public void cancelarRegistro(String nomeArq) throws RemoteException;
}
