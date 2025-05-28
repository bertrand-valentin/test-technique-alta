package fr.altaprofits.exercice;

import fr.altaprofits.exercice.Batiments.Ferme;
import fr.altaprofits.exercice.Batiments.Hangar;
import fr.altaprofits.exercice.Batiments.Propriété;
import fr.altaprofits.exercice.animaux.Animal;
import fr.altaprofits.exercice.animaux.TypeDAnimal;
import fr.altaprofits.exercice.vehicules.TypeDeVehicule;
import fr.altaprofits.exercice.vehicules.Vehicule;

import java.util.Set;

public class Application {
    public static void main(String[] args) {
        Hangar hangar = new Hangar();
        Ferme ferme = new Ferme();

        Propriété propriété = new Propriété(Set.of(hangar, ferme));

        Vehicule moto1 = new Vehicule(TypeDeVehicule.MOTO);
        Vehicule avion1 = new Vehicule(TypeDeVehicule.AVION);
        Vehicule avion2 = new Vehicule(TypeDeVehicule.AVION);
        Vehicule helico1 = new Vehicule(TypeDeVehicule.HELICOPTERE);
        Vehicule jetSki1 = new Vehicule(TypeDeVehicule.JETSKI);

        Animal ane1 = new Animal(TypeDAnimal.ANE);
        Animal oiseau1 = new Animal(TypeDAnimal.OISEAU);
        Animal oiseau2 = new Animal(TypeDAnimal.OISEAU);
        Animal aigle1 = new Animal(TypeDAnimal.AIGLE);
        Animal dauphin1 = new Animal(TypeDAnimal.DAUPHIN);

        hangar.entre(moto1);
        hangar.entre(avion1);
        hangar.entre(avion2);
        hangar.entre(helico1);
        hangar.entre(jetSki1);

        ferme.entre(ane1);
        ferme.entre(oiseau1);
        ferme.entre(oiseau2);
        ferme.entre(aigle1);
        ferme.entre(dauphin1);

        hangar.imprimerToutDansConsole();

        System.out.println("Nombre de véhicule dans le hangar : " + hangar.nombreTotal());
        System.out.println("Nombre de véhicule dans l'a�roport : " + hangar.nombreDAeriens());
        System.out.println("Nombre de véhicule dans le garage : " + hangar.nombreDeTerrestres());
        System.out.println("Nombre de véhicule dans le port : " + hangar.nombreDeMarins());

        System.out.println("Nombre d'animaux dans l'étable' : " + ferme.nombreDeTerrestres());
        System.out.println("Nombre d'animaux dans la volière : " + ferme.nombreDAeriens());
        System.out.println("Nombre d'animaux dans la mare : " + ferme.nombreDeMarins());
        System.out.println("Nombre d'animaux dans la ferme : " + ferme.nombreTotal());

        System.out.println("Nombre total de terrestres : " + propriété.nombreDeTerrestres());
        System.out.println("Nombre total de volants : " + propriété.nombreDeVolants());
        System.out.println("Nombre total de marins : " + propriété.nombreDeMarins());
        System.out.println("Nombre total de possessions : " + propriété.nombreTotal());

        avion1.seDeplace(10, 30);
        avion1.seDeplace(30, 60);
        avion2.seDeplace(25, 55);
        helico1.seDeplace(23, 11);
        jetSki1.seDeplace(3, 9);

        ane1.seDeplace(10, 30);
        ane1.seDeplace(30, 60);
        oiseau1.seDeplace(25, 55);
        oiseau2.seDeplace(23, 11);
        aigle1.seDeplace(3, 9);
    }
}
