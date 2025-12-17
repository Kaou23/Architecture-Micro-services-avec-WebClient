package com.example.servicecar.entities;

// Pas de @Entity ici, c'est juste une boite pour recevoir les données JSON
public class Client {
    private Long id;
    private String nom;
    private Float age;

    // Getters et Setters (Génère-les avec Alt+Inser)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public Float getAge() { return age; }
    public void setAge(Float age) { this.age = age; }
}