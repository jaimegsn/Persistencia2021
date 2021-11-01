import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Produto p = new Produto(null,0,0,0);
        Savecsv save = new Savecsv();
        ConvertJSON j = new ConvertJSON();
        ConvertXML x = new ConvertXML();
        List<Produto> p2 = new ArrayList<>();

        p.setNome(JOptionPane.showInputDialog("Digite o Nome do Produto"));
        p.setPreco(Integer.parseInt(JOptionPane.showInputDialog("Digite o Preço do Produto")));
        p.setQtd(Integer.parseInt(JOptionPane.showInputDialog("Digite a Quantidade do Produto")));
        p.setPeso(Float.parseFloat(JOptionPane.showInputDialog("Digite o Peso do Produto")));
        save.addProduto(p);

        p2.add(p);

        j.converterJSON(p);
        x.ConverterXML(p);


    }
}

