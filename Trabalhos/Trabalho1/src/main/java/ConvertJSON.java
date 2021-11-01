import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
public class ConvertJSON {

    public List<Produto> ler(String prod)throws IOException {

        InputStream os = new FileInputStream(prod);
        InputStreamReader osw = new InputStreamReader(os);
        BufferedReader  fr= new BufferedReader(osw);
        String linha;
        List<Produto> produtos = new ArrayList<>();

        while((linha = fr.readLine()) != null){
            String[] aux = (linha.split(";"));
            Produto pp = new Produto (aux[0], Integer.parseInt(aux[1]), Integer.parseInt(aux[2]), Float.parseFloat(aux[3]));
            produtos.add(pp);
        }
        System.out.println(produtos);
        return produtos;
    }

    public void converterJSON(Produto p) throws IOException {
        List<Produto> pr = ler("prod.csv");
        ObjectMapper om = new ObjectMapper();

        File arquivo = new File("prod.json");
        om.writerWithDefaultPrettyPrinter().writeValue(arquivo,pr);
        System.out.println("JSON Created");
    }
}
