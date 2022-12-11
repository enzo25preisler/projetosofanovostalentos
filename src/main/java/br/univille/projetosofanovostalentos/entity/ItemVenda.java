package br.univille.projetosofanovostalentos.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ItemVenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int quantidade;
    private float valorVenda;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    private ProdutoSofa produtoSofa;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
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
    public ProdutoSofa getProduto() {
        return produtoSofa;
    }
    public void setProduto(ProdutoSofa produtoSofa) {
        this.produtoSofa = produtoSofa;
    }

    public float getValorFinal(){
        return this.getValorVenda() * this.getQuantidade();
    }

    
}