package negocios;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

import metodos.CleanScreen;
import metodos.Produto;

public class ProdutoDao {
    
    private static ArrayList<Produto> produtosList = new ArrayList<>();
 
    static Scanner in = new Scanner(System.in);
    static float valorMenor;
    static float valorMaior;

    public static void cadastro() throws InterruptedException, IOException{

        CleanScreen limpar = new CleanScreen();

        limpar.LimpaTela(null);
        
        System.out.println("\n========================================");
        System.out.printf("========= CADASTRO DE PRODUTOS =========\n");
        System.out.println("========================================");

        System.out.print("\nQuantos Produtos que deseja criar: \n");
        int qtdProdutos = in.nextInt();

        System.out.println("\n========================================");

        for(int i=1; i<=qtdProdutos; i++){

            Produto produto = new Produto();
            
            System.out.println("\nInforme o nome do produto: ");
            produto.setNome(in.next());

            System.out.println("Informe o código do produto: ");
            produto.setCodigo(in.next());       
                
            System.out.println("Informe o valor do produto em R$: ");
            produto.setValor(Float.parseFloat(in.next()));

            System.out.println("Quantidade de produto em estoque: ");
            produto.setQuantEstoque(in.nextInt());  
            
            System.out.println("\n========================================");

            System.out.println("\nDigite 1 para confirmar cadastro \nou 0 para cancelar\n");
            if(in.nextInt() == 1) {

                if (produtosList == null)
                    produtosList = new ArrayList<Produto>();
                    
                produtosList.add(produto);

                System.out.printf("\nProduto cadastrado com sucesso.\n");
            } else {
                System.out.printf("\nCadastro cancelado.\n");
            }  
        }  
    }      
        
    public static void consulta() throws InterruptedException, IOException{

        CleanScreen limpar = new CleanScreen();

        limpar.LimpaTela(null);
        
        System.out.println("\n========================================");
        System.out.printf("========= CONSULTA DE PRODUTOS =========\n");
        System.out.println("========================================\n");

        if (produtosList == null || produtosList.isEmpty()){

            System.out.println("Não há produtos cadastrados!\n");

        } else {       

            System.out.print("Digite o código do produto:\n");
            String codigo = in.next();
            System.out.println("\n========================================\n");

            for(int i = 0; i < produtosList.size(); i++) {                
                Produto produto = produtosList.get(i);                                
                if(produto.getCodigo().equals(codigo)) {
                    System.out.println(produto); 
                    System.out.println("\n========================================\n");                                     
                }else{
                    System.out.println("\nCódigo não cadastrado!\n");
                    System.out.println("\n========================================\n");
                }                        
            }
        }
    }

    public static void listar() throws InterruptedException, IOException{

        CleanScreen limpar = new CleanScreen();

        limpar.LimpaTela(null);

        if (produtosList == null || produtosList.isEmpty()) { 
            System.out.printf("\nNão há Produtos cadastrados para exibir.\n");
            System.out.println("\n========================================\n");                    
        } else {    
            System.out.println("\n========================================");
            System.out.printf("========= PRODUTOS CADASTRADOS =========\n");
            System.out.println("========================================\n");

            
            for (int i = 0; i < produtosList.size(); i++) {
                Produto produto = produtosList.get(i);
                System.out.println(produto);
                System.out.println("\n========================================\n");
            }

            System.out.println("============= VALOR MINIMO =============");

            for(Produto produto:produtosList){
                
                if(produto.getValor()<valorMenor){
                    valorMenor=produto.getValor();
                    System.out.printf("\t\tR$:%.2f\n", valorMenor);
                }                
            }

            System.out.println("============= VALOR MEDIO ==============");

            double media = produtosList.stream()
                .collect(Collectors.averagingDouble(Produto::getValor));            
            System.out.printf("\t\tR$:%.2f\n", media);

            System.out.println("============= VALOR MAXIMO =============");

            for(Produto produto:produtosList){
                
                if(produto.getValor()>valorMaior){
                    valorMaior=produto.getValor();
                    System.out.printf("\t\tR$:%.2f\n", valorMaior);
                }
            }
        }
    }
        
    public static Produto findProduto(String codigo) {
        if (produtosList != null && !produtosList.isEmpty()) {
            for (Produto prod : produtosList) {
                if (prod.getCodigo().equals(codigo));
                    return prod;
            }
        }        
        return null;
    }
}
