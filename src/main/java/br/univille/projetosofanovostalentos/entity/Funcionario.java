package br.univille.projetosofanovostalentos.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

@Entity
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private float salario;
    @NotBlank(message = "*Este Campo deve ser preenchido!")
    private String cargo;
    @OneToOne
    private Pessoa pessoaFun;
    
    public Pessoa getPessoaFun() {
        return pessoaFun;
    }
    public void setPessoaFun(Pessoa pessoaFun) {
        this.pessoaFun = pessoaFun;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public float getSalario() {
        return salario;
    }
    public void setSalario(float salario) {
        this.salario = salario;
    }
    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
