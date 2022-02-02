package metodos;

public class Produto {
    private String nome;
    private String codigo;    
    private float valor;
    private int quantEstoque;

    public Produto() {        
    }

    public String getCodigo(){
        return codigo;
    }

    public void setCodigo(String codigo){
        this.codigo = codigo;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public float getValor(){
        return valor;
    }

    public void setValor(Float valor){
        this.valor = valor;
    }

    public int getQuantEstoque(){
        return quantEstoque;
    }

    public void setQuantEstoque(int quantEstoque){
        this.quantEstoque = quantEstoque;
    }

    @Override
    public String toString(){        
        return String.format("Produto: %s - \tCodigo: %s - \nValor unitario R$:%.2f - \nQuantidade em Estoque: %s",
        nome, codigo, valor, quantEstoque);
    }  
}
