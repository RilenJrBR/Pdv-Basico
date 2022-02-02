package menuVendas;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import metodos.CleanScreen;
import negocios.EfetuaVenda;

public class MenuDeVend {

    public void menuVendas () throws InterruptedException, IOException{

        CleanScreen limpar = new CleanScreen();

        limpar.LimpaTela(null);
        
        
        String localTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        int opcao;
        Scanner in = new Scanner(System.in);
        EfetuaVenda venda = new EfetuaVenda();

        do {           
                  
            System.out.println("\n========================================");
            System.out.println("============ MENU DE VENDAS ============");
            System.out.println("========================================\n");
            System.out.println("1 - Venda por periodo - Detalhado");
            System.out.println("2 - Realizar venda");
            System.out.println("0 - Voltar ao menu inicial");
            System.out.println("\n========================================");
            System.out.println("========= " + localTime + " ==========");
            System.out.println("========================================\n");
            System.out.print("Opção: ");
            

            opcao = in.nextInt();
            in.nextLine();

            if (opcao == 1) {

                EfetuaVenda.VendasPorPeriodo();
                
                voltarMenu(in);

            } else if (opcao == 2) {

                EfetuaVenda.Vendas();
                
                voltarMenu(in);
            }
            
        } while (opcao != 0);

        System.out.println("\nFim da venda!\n");

        voltarMenu(in);

    }

    private static void voltarMenu(Scanner in) throws InterruptedException, IOException  {
        
    }    
}
