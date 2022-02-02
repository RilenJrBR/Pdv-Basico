package programa;


import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import menuVendas.MenuDeVend;
import metodos.CleanScreen;
import negocios.ProdutoDao;



public class ProdutoApplication {
    public static void main(String[] args) throws InterruptedException, IOException {
        
        String localTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        int opcao;
        Scanner in = new Scanner(System.in);
        MenuDeVend menuDV = new MenuDeVend();

        do {           
            
            System.out.println("\n========================================");
            System.out.printf("========== Biroska Beer do Zé ==========\n");
            System.out.println("========================================" );            
            System.out.println("\n========================================");
            System.out.println("================= MENU =================");
            System.out.println("========================================\n");
            System.out.println("1 - Incluir produto");
            System.out.println("2 - Consultar produto");
            System.out.println("3 - Listagem de produto");
            System.out.println("4 - Menu de vendas");
            System.out.println("0 - Sair");
            System.out.println("\n========================================");
            System.out.println("========= " + localTime + " ==========");
            System.out.println("========================================\n");
            System.out.print("Opção: ");
            

            opcao = in.nextInt();
            in.nextLine();

            if (opcao == 1) {

                ProdutoDao.cadastro();

                voltarMenu(in);

            } else if (opcao == 2) {

                ProdutoDao.consulta();
                
                voltarMenu(in);
                
            } else if (opcao == 3) {

                ProdutoDao.listar();

                voltarMenu(in);
                
            } else if (opcao == 4) {

                menuDV.menuVendas();

                voltarMenu(in);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               
            } else if (opcao != 0) {
                System.out.println("\nOpção inválida!");
            }
        } while (opcao != 0);

        System.out.println("Fim do programa!");

        in.close();
    }

    private static void voltarMenu(Scanner in) throws InterruptedException, IOException {
        System.out.println("\nPressione ENTER para voltar ao menu.");
        in.nextLine();

        CleanScreen limpar = new CleanScreen();

        limpar.LimpaTela(null);
    }
}
