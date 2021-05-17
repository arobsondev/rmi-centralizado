package rmi.servidor;

import java.net.InetAddress;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Servidor extends ImplementaAcesso{

	public static void main(String[] args) {
		try {
			//criar objeto servidor
			ImplementaAcesso implHello = new ImplementaAcesso();
			
			//criar objeto stub do servidor
			Acesso stub = (Acesso) UnicastRemoteObject.exportObject(implHello, 12345);
			
			// adiciona rmi registry na porta padrão (Registry.REGISTRY_PORT)
			LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
			
			//Registry registro = LocateRegistry.getRegistry(IP);
			Registry registro = LocateRegistry.getRegistry(InetAddress.getLocalHost().getHostAddress());

			registro.bind("Acesso", stub);

			System.out.println(" >> Servidor pronto:");

		} catch (Exception e) {
			System.err.println("Erro no servidor ; " + e.toString());
			e.printStackTrace();
		}
	}
}
