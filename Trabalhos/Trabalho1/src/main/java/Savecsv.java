import java.io.*;
public class Savecsv {
    public void addProduto(Produto p1) throws IOException{
        try{
            FileWriter nf = new FileWriter("prod.csv",true);
            PrintWriter p =  new PrintWriter(nf);
            p.println(p1);
            p.close();
            nf.close();
            System.out.println("Salvo com Sucesso");

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
