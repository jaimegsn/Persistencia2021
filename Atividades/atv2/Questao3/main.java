import java.io.*;
import java.util.Properties;
import javax.swing.JOptionPane;

public class main {
    public static Properties getProperties(Properties prop)throws IOException{
        FileInputStream file = new FileInputStream("C:\\Users\\jaime\\Documents\\Persistencia\\Atividade 2\\Questao3\\config.properties");
        prop.load(file);
        return prop;
    }
public static void main(String[] args)throws IOException {
        String line = null;
        Properties props = new Properties();
        getProperties(props);
        int initLine = Integer.parseInt(props.getProperty("linha_inicial"));
        int endLine = Integer.parseInt(props.getProperty("linha_final"));
        String file = JOptionPane.showInputDialog("Digite o nome do arquivo");

        FileInputStream open = new FileInputStream("C:\\Users\\jaime\\Documents\\Persistencia\\Atividade 2\\Questao3\\"+file);
        InputStreamReader is = new InputStreamReader(open);
        BufferedReader br = new BufferedReader(is);
        
        int i = 0;
        while((endLine-1) >= i){  
            line = br.readLine(); 
            if(line != null && (i+1) >= initLine) System.out.println(line);  
            i++;
        }
    }
}