package metodos;

public class Venda {

    private String data;
    private Produto produto;
    private int quantidade;
    private float valorVenda;
    private float pagoCliente;
    

    public Venda() {        
    }

    public String getData() {
        return data;
    }

    public void setData(String localTime) {
        this.data = localTime;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(float valorVenda) {
        this.valorVenda = valorVenda;
    }

    public float getPagoCliente() {
        return pagoCliente;
    }

    public void setPagoCliente(float pagoCliente) {
        this.pagoCliente = pagoCliente;
    }   
    
    @Override
    public String toString(){        
        return String.format("%s \nQuantidade: %s  \n\tValor da venda: R$:%.2f \nData e Hora: %s",
    produto, quantidade, valorVenda, data);
    }
}