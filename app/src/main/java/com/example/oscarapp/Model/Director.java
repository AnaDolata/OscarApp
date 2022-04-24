package com.example.oscarapp.Model;

public class Director {
    private int id;
    String nome;

    public String getNome() { return nome; }
    public int getId() { return id; }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setId(int id) { this.id = id; }
}
