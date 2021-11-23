import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Serializa {
    Pessoa p = new Pessoa(1,"a","dsa","asd");
    List<Pessoa> lp = new ArrayList<>();

    public void addPessoa(){
        lp.add(p);
    }

    public void serializar() throws IOException{
        File f = new File("teste.json");
        ObjectMapper o = new ObjectMapper();
        o.writeValue(f,lp);

        File f2 = new File("teste.xml");
        XmlMapper x = new XmlMapper();
        x.writeValue(f2,lp);

        FileOutputStream fOut = new FileOutputStream("teste.txt");
        ObjectOutputStream oOut = new ObjectOutputStream(fOut);
        oOut.writeObject(lp);
        oOut.close();
    }
}
