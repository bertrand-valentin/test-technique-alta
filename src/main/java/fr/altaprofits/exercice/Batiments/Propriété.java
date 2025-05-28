package fr.altaprofits.exercice.Batiments;

import fr.altaprofits.exercice.Batiment;

import java.util.Set;

public class Propriété {

    private Set<Batiment> batiments;

    public Propriété(Set<Batiment> batiments) {
        this.batiments = batiments;
    }

    public int nombreDeVolants() {
        return batiments.stream()
                .mapToInt(Batiment::nombreDAeriens)
                .sum();
    }

    public int nombreDeMarins() {
        return batiments.stream()
                .mapToInt(Batiment::nombreDeMarins)
                .sum();
    }

    public int nombreDeTerrestres() {
        return batiments.stream().mapToInt(Batiment::nombreDeTerrestres).sum();
    }

    public int nombreTotal() {
        return batiments.stream().mapToInt(Batiment::nombreTotal).sum();
    }
}
