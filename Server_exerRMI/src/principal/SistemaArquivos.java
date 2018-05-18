package principal;

import java.io.File;
import java.util.ArrayList;

import javax.swing.JOptionPane;

//0-criar pasta separada oonde estarao os arquivos 

//1-implementar uma funçao de retornar nome de todos os arquivos
//2-implementar uma funcao que add novos arquivos (up)
//3-implementar uma funcao que retorna um arquivo quando passar nome por referencia
//4-implementa uma funcao que retorna os bytes de um arquivo
//carregar arquivo txt com class file

public class SistemaArquivos {
	private String PATH;

	public SistemaArquivos(String PATH) {
		this.PATH = PATH;
		String diretorioAtual = new File(".").getAbsolutePath();

		if (PATH == diretorioAtual) {

		}

	}

	public ArrayList<String> consultarTodosArquivos() {
		return null;
	}

	public static void CriaPasta() {
		String diretorioAtual = new File(".").getAbsolutePath();

		try {
			File caminho = new File(diretorioAtual);
			caminho.mkdir();
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Falha, diretorio nao criado");
			System.out.println(ex);
		}

	}

	public File getArquivo(String nomeArq) {

		return new File(PATH + "/" + nomeArq);
	}

	public void adicionarArq(File f) {

	}
}
