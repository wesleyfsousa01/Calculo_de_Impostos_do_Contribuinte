package aplicacao;

import entidades.Contribuinte;
import entidades.PessoaFisica;
import entidades.PessoaJuridica;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Programa{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Contribuinte> contribuintes = new ArrayList<>();

        System.out.print("Entre com o número de contribuintes: ");
        int n = sc.nextInt();
        for(int i=1; i<=n; i++){
            System.out.println("Contribuinte #" +i +" Dados:");
            System.out.print("Pessoa fisica ou pessoa juridica (f/j)? ");
            char tipo = sc.next().charAt(0);
            System.out.print("Nome: ");
            String nome = sc.next();
            System.out.print("Renda anual: ");
            double rendaAnual = sc.nextDouble();

            if(tipo == 'f'){
                System.out.print("Despesas com Saúde: ");
                double despesas = sc.nextDouble();
                contribuintes.add(new PessoaFisica(nome,rendaAnual,despesas));
            }else if (tipo == 'j'){
                System.out.print("Número de funcionários: ");
                int numFuncionarios = sc.nextInt();
                contribuintes.add(new PessoaJuridica(nome,rendaAnual,numFuncionarios));

            }
        }

        System.out.println("IMPOSTOS: ");
        double totalDeImpostos = 0;
        for (Contribuinte c: contribuintes){
            totalDeImpostos += c.taxa();
            System.out.println("-----------");
            System.out.println(String.format(c.getNome() +" $ " +"%.2f",c.taxa()));
        }

        System.out.println("-----------");
        System.out.println("Total de Impostos: " + totalDeImpostos);
    }
}
