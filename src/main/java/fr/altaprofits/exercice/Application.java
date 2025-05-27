package fr.altaprofits.exercice;

import fr.altaprofits.exercice.vehicule.TypeDeVehicule;
import fr.altaprofits.exercice.vehicule.Vehicule;

public class Application {
    public static void main(String[] args) {
        Hangar hangar = new Hangar();

        Vehicule moto1 = new Vehicule(TypeDeVehicule.MOTO);
        Vehicule avion1 = new Vehicule(TypeDeVehicule.AVION);
        Vehicule avion2 = new Vehicule(TypeDeVehicule.AVION);
        Vehicule helico1 = new Vehicule(TypeDeVehicule.HELICOPTERE);
        Vehicule jetSki1 = new Vehicule(TypeDeVehicule.JETSKI);

        hangar.entre(moto1);
        hangar.entre(avion1);
        hangar.entre(avion2);
        hangar.entre(helico1);
        hangar.entre(jetSki1);

        hangar.imprimerToutDansConsole();

        System.out.println("Nombre de v�hicule dans le hangar : " + hangar.nombreDeVehiculeDansHangar());
        System.out.println("Nombre de v�hicule dans l'a�roport : " + hangar.nombreDeVehiculesDansAeroport());
        System.out.println("Nombre de v�hicule dans le garage : " + hangar.nombreDeVehiculesDansGarage());
        System.out.println("Nombre de v�hicule dans le port : " + hangar.nombreDeVehiculeDansPort());

        avion1.seDeplace(10, 30);
        avion1.seDeplace(30, 60);
        avion2.seDeplace(25, 55);
        helico1.seDeplace(23, 11);
        jetSki1.seDeplace(3, 9);
    }
}
