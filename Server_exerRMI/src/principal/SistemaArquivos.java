package principal;

import java.io.File;
import java.util.ArrayList;

import javax.swing.JOptionPane;

//0-criar pasta separada oonde estarao os arquivos 

//1-implementar uma funçao de retornar nome de todos os arquivos
//2-implementar uma funcao que add novos arquivos (up)
//3-implementar uma funcao que retorna um arquivo quando passar nome por referencia
//4- implementa uma funcao que retorna os bytes de um arquivo
//carregar arquivo txt com class file

public class SistemaArquivos {
	public SistemaArquivos() {
		String diretorioAtual = new File(".").getAbsolutePath();
		File arquivo = new File(diretorioAtual); 
	    File[] file = arquivo.listFiles(); 
	        if(file != null){ 
	            int length = file.length; 
	            for(int i = 0; i < length; ++i){ 
	                File f = file[i]; 
	                if(f.isFile()){ 
	                    System.out.println(f.getName()); 
	                } 
	                else if(f.isDirectory()){ 
	                    System.out.println("Diretorio: " + f.getName()); 
	                } 
	            }
	}
		
	}
	public ArrayList<String> consultarTodosArquivos(){
		return null;	
	}
	public static void CriaPasta(){
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
		
		
		
		return null;
	}
	public void adicionarArq(File f) {
		
	}
}
