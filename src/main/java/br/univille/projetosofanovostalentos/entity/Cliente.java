package br.univille.projetosofanovostalentos.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne(cascade = {CascadeType.REFRESH,CascadeType.MERGE})
    private Pessoa pessoaCli;

    public Pessoa getPessoaCli() {
        return pessoaCli;
    }

    public void setPessoaCli(Pessoa pessoaCli) {
        this.pessoaCli = pessoaCli;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
}
