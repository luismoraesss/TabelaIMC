import java.util.Scanner;
import java.util.InputMismatchException;  
import java.util.Locale;
public class Main { 
    private static Scanner input = new Scanner(System.in).useLocale(Locale.US);

    public static void main(String[] args) {
        Calculo calculo = new Calculo();

        lerNome(calculo);
        limparTela();
        lerGenero(calculo);
        limparTela();
        lerAltura(calculo);
        limparTela();
        lerPeso(calculo);
        limparTela();

        input.close();
        
        calculo.calcularImc();
    }

    private static void lerNome(Calculo calculo) {
        System.out.println("Digite seu nome:");
        calculo.setNome(input.next());
    }

    private static void lerGenero(Calculo calculo) {
        while (true) {
            System.out.println("Selecione seu gênero (m - masculino, f - feminino, n - prefiro não informar):");
            char genero = input.next().toLowerCase().charAt(0);
            if (genero == 'm' || genero == 'f' || genero == 'n') {
                calculo.setGenero(genero);
                break;
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void lerAltura(Calculo calculo) {
        while (true) {
            try {
                System.out.println("Digite sua altura (em metros):");
                calculo.setAltura(input.nextDouble());
                break;
            } catch (InputMismatchException e) {
                System.out.println("Valor inválido. Por favor, digite um número válido.");
                input.next(); // limpa o buffer do scanner
            }
        }
    }

    private static void lerPeso(Calculo calculo) {
        while (true) {
            try {
                System.out.println("Digite seu peso (em kg):");
                calculo.setPeso(input.nextDouble());
                break;
            } catch (InputMismatchException e) {
                System.out.println("Valor inválido. Por favor, digite um número válido.");
                input.next(); // limpa o buffer do scanner
            }
        }
    }

    private static void limparTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
