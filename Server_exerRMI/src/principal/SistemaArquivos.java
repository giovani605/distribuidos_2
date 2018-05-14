package principal;

import java.io.File;
import java.util.ArrayList;

//0-criar pasta separada oonde estarao os arquivos 

//1-implementar uma funçao de retornar nome de todos os arquivos
//2-implementar uma funcao que add novos arquivos (up)
//3-implementar uma funcao que retorna um arquivo quando passar nome por referencia

//carregar arquivo txt com class file
public class SistemaArquivos {
	public SistemaArquivos() {
		   File arquivo = new File("C:\\"); 
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
	public ArrayList<String> consultarTodosArquivos(){
	
		
	return null;	
	}
	public static void CriaPasta(){
		try {
            File caminho = new File("C:\\Desktop");
            caminho.mkdir();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Falha, diretorio nao criado");
            System.out.println(ex);
        }
		
	}
}
