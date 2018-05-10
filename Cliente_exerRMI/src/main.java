import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import servicoInterface.InterfaceServ;

public class main {

	public static void main(String[] args) {

		try {
			Registry naming = LocateRegistry.getRegistry("localhost", 8080);
			InterfaceServ server = (InterfaceServ) naming.lookup("Server");
			server.consultar();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
