package Questao1;
import java.io.*;

import javax.swing.JOptionPane;

public class questao1{

    private static void gravador(String arquivo, byte[] a) {
        try(FileOutputStream gravador = new FileOutputStream(arquivo)){
            gravador.write(a);
            JOptionPane.showMessageDialog(null, "Arquivo Gravado com Sucesso");
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    private static byte[] pegarBytes(String arquivo) {
        byte[] bytes = null;
        try(InputStream leitor = new BufferedInputStream(new FileInputStream(arquivo));){
            bytes = leitor.readAllBytes();
            
        }catch (IOException e){
            e.printStackTrace();
        }
        return bytes;
    }

    public static void main(String[] args) throws IOException {
        long time = System.currentTimeMillis();
        byte[] c = null;
        String arquivoOrigem = JOptionPane.showInputDialog("Insira o nome do arquivo de origem");
        c = pegarBytes(arquivoOrigem);
        
        String arquivoDestino = JOptionPane.showInputDialog("Insira o nome do arquivo de destino");
        gravador(arquivoDestino,c);
        JOptionPane.showMessageDialog(null,"O tempo total de execução é: "+ (System.currentTimeMillis() - time)/1000+"s   ("+(System.currentTimeMillis() - time)+"ms)");

    }
}