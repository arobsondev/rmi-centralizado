package rmi.servidor;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Acesso extends Remote{
	
	String entrar(int id) throws RemoteException;
	String acessarRecurso(int id, int opcao) throws RemoteException;
	String sair(int id) throws RemoteException;
	
}
