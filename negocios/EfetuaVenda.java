package negocios;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

import metodos.CleanScreen;
import metodos.Produto;
import metodos.Venda;

public class EfetuaVenda {

     static ArrayList<Venda> vendasList = new ArrayList<>();
   
    static Scanner in = new Scanner(System.in);
    static String localTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    
    String codigo;  
    int opcao;  
    Produto produto;
    

    public EfetuaVenda() {
        
        vendasList = new ArrayList<Venda>();
    }    

    public static void Vendas() throws InterruptedException, IOException{

        CleanScreen limpar = new CleanScreen();

        limpar.LimpaTela(null);
        
        System.out.println("\n========================================");
        System.out.printf("========== CONSUMO DO CLIENTE ==========\n");
        System.out.println("========================================\n");

        for(int i=1; i<= 1; i++){

            System.out.println("Insira o código do produto:");
            String codigo = in.nextLine();
            Produto produto = ProdutoDao.findProduto(codigo);
            
            if (produto == null) {
                System.out.println("\nCódigo não cadastrado!");
                
            } else {
                System.out.printf("\nProduto: %s \nEstoque: %d\n", produto.getNome(), produto.getQuantEstoque());
                Venda venda = new Venda();
                venda.setProduto(produto);
        
                System.out.println("\nQual a quantidade de produtos?");
                venda.setQuantidade(in.nextInt());
        
                System.out.printf("\t\tValor unitário R$:%.2f\n", produto.getValor());           
        
                venda.setValorVenda(produto.getValor()*venda.getQuantidade());
            
                System.out.printf("\t\tTOTAL R$:%.2f\n", venda.getValorVenda());

                System.out.println("\nValor dado pelo cliente?");
                venda.setPagoCliente(in.nextFloat());
                
                System.out.printf("\t\tTROCO R$:%.2f\n", venda.getPagoCliente() - venda.getValorVenda() );
                    
                System.out.println("\t\t" + localTime);
                venda.setData(localTime);

                vendasList.add(venda);

                produto.setQuantEstoque(produto.getQuantEstoque() - venda.getQuantidade());
            }
        }
    }

    public static void VendasPorPeriodo() throws InterruptedException, IOException{

        CleanScreen limpar = new CleanScreen();

        limpar.LimpaTela(null);
        
        System.out.flush();
        if (vendasList == null || vendasList.isEmpty()) { 
            System.out.printf("\nNão há Vendas no caixa\n");
            System.out.println("\n========================================\n");                    
        } else {    
            System.out.println("\n========================================");
            System.out.printf("========== VENDAS DETALHADAS ==========\n");
            System.out.println("========================================\n");

            
            for (int i = 0; i < vendasList.size(); i++) {
                Venda venda = vendasList.get(i);
                System.out.println(venda);
                System.out.println("\n========================================\n");
            }

            System.out.println("======== VALOR MEDIO DAS VENDAS ========");

            double media = vendasList.stream()
                .collect(Collectors.averagingDouble(Venda::getValorVenda));
            
            System.out.printf("\t\tR$:%.2f\n", media);

            System.out.println("\n========= SOMATORIO DAS VENDAS =========");

            double somatorio = vendasList.stream()
                .collect(Collectors.summingDouble(Venda::getValorVenda));
            
            System.out.printf("\t\tR$:%.2f\n",somatorio);
        }
    }
}
