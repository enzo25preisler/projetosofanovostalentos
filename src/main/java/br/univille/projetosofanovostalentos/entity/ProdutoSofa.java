package br.univille.projetosofanovostalentos.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class ProdutoSofa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank(message = "*Este Campo deve ser preenchido!")
    private String modelo;
    @NotBlank(message = "*Este Campo deve ser preenchido!")
    private String cor;
    @NotBlank(message = "*Este Campo deve ser preenchido!")
    private String largura;
    @NotBlank(message = "*Este Campo deve ser preenchido!")
    private String comprimento;
    private float preco;

    @Override
    public String toString() {
        return getModelo();
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
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
