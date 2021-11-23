import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Serializa s = new Serializa();
        Deserializar d = new Deserializar();
        s.addPessoa();
        s.serializar();
        d.desiralizacao();
    }
}
