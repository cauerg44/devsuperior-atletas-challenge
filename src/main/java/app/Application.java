package app;

import java.util.Locale;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        String nome;
        char sexo;
        double altura, peso;
        int qntHomens = 0, qntMulheres = 0;
        double somaDosPeso = 0, maiorAltura = -1, alturaDasMulheres = 0;
        double mediaDosPesos = 0, porcentagemHomens = 0, alturaMediaMulheres = 0;

        System.out.print("Qual a quantidade de atletas? ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Digite os dados do atleta numero " + (i + 1) + ":");
            System.out.print("Nome: ");
            sc.nextLine();
            nome = sc.nextLine();
            System.out.print("Sexo: ");
            sexo = sc.next().charAt(0);
            while (sexo != 'F' && sexo != 'M') {
                System.out.print("Valor inválido! Favor digitar F ou M: ");
                sexo = sc.next().charAt(0);
            }
            System.out.print("Altura: ");
            altura = sc.nextDouble();
            while (altura <= 0.0) {
                System.out.print("Valor inválido! Favor digitar um valor positivo: ");
                altura = sc.nextDouble();
            }
            System.out.print("Peso: ");
            peso = sc.nextDouble();
            while(peso == 0) {
                System.out.print("Valor inválido! Favor digitar um valor positivo: ");
                peso = sc.nextDouble();
            }

            if(sexo == 'M'){
                qntHomens++;
            } else {
                qntMulheres++;
                alturaDasMulheres += altura;
            }

            if (altura > maiorAltura){
                maiorAltura = altura;
            }

            somaDosPeso += peso;
        }

        mediaDosPesos = somaDosPeso / n;
        porcentagemHomens = (qntHomens * 100.0) / n;
        alturaMediaMulheres = (qntMulheres > 0) ? alturaDasMulheres / qntMulheres : 0;

        System.out.println("RELATÓRIO:");

        System.out.printf("Peso médio dos atletas: %.2f%n", mediaDosPesos);
        System.out.printf("Atleta mais alto: %.2f%n", maiorAltura);
        System.out.printf("Porcentagem de homens: %.1f%%%n", porcentagemHomens);
        if (qntMulheres == 0) {
            System.out.println("Não há mulheres cadastradas");
        } else {
            System.out.printf("Altura média das mulheres: %.2f%n", alturaMediaMulheres);
        }

        sc.close();
    }
}
