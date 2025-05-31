import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite um número de CEP para consulta: ");
        String cep = sc.nextLine();

        BuscaCEP buscaCEP = new BuscaCEP();

        try {
            Endereco endereco = buscaCEP.buscaEndereco(cep);
            System.out.println(endereco);

            GeradorDeArquivo gerador = new GeradorDeArquivo();
            gerador.criaJson(endereco);
        } catch (RuntimeException | IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Finalizando aplicação");
        }
    }
}