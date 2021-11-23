import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class Deserializar {

    public void desiralizacao() throws IOException, ClassNotFoundException {
        List<Pessoa> lp = new ArrayList<>();
        FileInputStream fOut= new FileInputStream("teste.txt");
        ObjectInputStream oOut= new ObjectInputStream(fOut);
        System.out.println(oOut.readObject());
        oOut.close();
    }
}
