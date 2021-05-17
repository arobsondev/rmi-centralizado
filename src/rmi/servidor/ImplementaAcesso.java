package rmi.servidor;

public class ImplementaAcesso implements Acesso{
	public static int block;
	
	public String entrar(int id) {
		Arquivo.gravarArquivoTexto("src/dados/log", "Processo " + id + " >> entrar()");
		return "Entrei\n";
	}
	
	public String acessarRecurso(int id, int opcao) {
		Arquivo.gravarArquivoTexto("src/dados/log", "Processo " + id + " >> acessarRecurso()");
		return (opcao == 2) ? escrita(id) : leitura(id);
	}
	
	public String sair(int id) {
		Arquivo.gravarArquivoTexto("src/dados/log", "Processo " + id + " >> sair()");
		return "Sai.\n";
	}
	
	private String leitura(int id) {
		Arquivo.gravarArquivoTexto("src/dados/log", "Processo " + id + " >> leitura()");
		return Arquivo.lerArquivo("src/dados/recurso");
	}
	
	private synchronized String escrita(int id) {
		try {
			Arquivo.gravarArquivoTexto("src/dados/log", "Processo " + id + " >> escrita()");
			
			Thread.sleep(3000);
			
			Arquivo.gravarArquivoTexto("src/dados/recurso", "Processo (" + id + ")");
			return "Escrevi.\n";
		} catch (InterruptedException e) {
			e.printStackTrace();
			return "Erro ao escrever.";
		}
	}
}