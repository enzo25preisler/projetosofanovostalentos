package br.univille.projetosofanovostalentos.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProdutoSofa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String cor;
    private String largura;
    private String comprimento;
    private float preco;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getCor() {
        return cor;
    }
    public void setCor(String cor) {
        this.cor = cor;
    }
    public String getLargura() {
        return largura;
    }
    public void setLargura(String largura) {
        this.largura = largura;
    }
    public String getComprimento() {
        return comprimento;
    }
    public void setComprimento(String comprimento) {
        this.comprimento = comprimento;
    }
    public float getPreco() {
        return preco;
    }
    public void setPreco(float preco) {
        this.preco = preco;
    }
}
