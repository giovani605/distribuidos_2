
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
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
		// String diretorioAtual = new File(".").getAbsolutePath();
		File file = new File(PATH);
		if (!file.exists()) {
			file.mkdir();
		}
	}

	public ArrayList<String> consultarTodosArquivos() {
		ArrayList<String> lista = new ArrayList<>();
		for (String s : new File(this.PATH + "/").list()) {
			lista.add(s);
		}
		return lista;
	}

	public static void CriaPasta(String Path) {
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

	public byte[] converterArqByte(File f) {
		byte[] vetor = new byte[(int) f.length()];
		try {
			FileInputStream input = new FileInputStream(f);
			input.read(vetor);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return vetor;

	}

	public void gravarArq(byte[] bytes, String nomeArq) {
		File f = new File(this.PATH + "/" + nomeArq);
		try {
			FileOutputStream output = new FileOutputStream(f);
			output.write(bytes);
			output.flush();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
