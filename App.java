import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean jogarNovamente = true;

        while (jogarNovamente) {
            int dimensao = solicitarDimensaoTabuleiro(sc);
            JogaJogoDaVelha jogo = new JogaJogoDaVelha(dimensao);

            int resultado = jogar(jogo);

            exibirResultado(resultado);

            jogarNovamente = perguntarJogarNovamente(sc);
        }

        System.out.println("Espero que tenha gostado");
        sc.close();
    }

    
    private static int solicitarDimensaoTabuleiro(Scanner sc) {
        System.out.println("Bom jogo");
        System.out.println("Escolha a dimensão do tabuleiro: ");
        return sc.nextInt();
    }

 
    private static int jogar(JogaJogoDaVelha jogo) {
        int resultado = jogo.poePecaAutomatico();

        while (resultado == 2) {
            System.out.println(jogo.toString());
            System.out.println("Vez de jogar " + (jogo.getJogador() == 1 ? "X" : "O"));
            System.out.println("\n");
            resultado = jogo.poePecaAutomatico();
        }

        System.out.println(jogo.toString());
        return resultado;
    }

  
    private static void exibirResultado(int resultado) {
        if (resultado == 1) {
            System.out.println("1 vencedor");
        } else if (resultado == -1) {
            System.out.println("-1 vencedor");
        } else if (resultado == 0) {
            System.out.println("0 empate");
        }
    }

    
    private static boolean perguntarJogarNovamente(Scanner sc) {
        int resposta;
        do {
            System.out.println("Jogar novamente (1 - Sim / 0 - Não): ");
            while (!sc.hasNextInt()) {
                System.out.println("Somente 0 ou 1.");
                sc.nextLine(); 
            }
            resposta = sc.nextInt();
            if (resposta != 0 && resposta != 1) {
                System.out.println("Valor inválido. Digite 1 para sim e 0 para não");
            }
        } while (resposta != 0 && resposta != 1);

        return resposta == 1;
    }
}
