package rmi.cliente;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

import rmi.servidor.Acesso;

public class Cliente {
	
private Cliente() {}
	
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("Informe o nome/endereço do RMIRegistry: ");
		String host = teclado.nextLine();
		
		System.out.print("Informe o id desse processo: ");
		int id = teclado.nextInt();
		
		try {
			Registry registro = LocateRegistry.getRegistry(host);
			
			Acesso stub = (Acesso) registro.lookup("Acesso");

			boolean aux = true;
			while (aux) {
				System.out.println("1. Entar\n2. Sair");
				int res = teclado.nextInt();
				
				if(res == 1) {
					System.out.println("\nMensagem de resposta: " + stub.entrar(id));
					
					while (aux) {
						System.out.println("1. Ler\n2. Escrever\n3. Sair");
						res = teclado.nextInt();
						if (res == 1 || res == 2) {
							System.out.println("Acessando...");
							System.out.println(stub.acessarRecurso(id, res));
						}else {
							System.out.println(stub.sair(id));
							aux = false;
						}
					}
					aux = true;
				}else {
					System.out.println("Mensagem de resposta: " + stub.sair(id));
					aux = false;
				}
			}

			teclado.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
