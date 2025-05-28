package fr.altaprofits.exercice;

import fr.altaprofits.exercice.Batiments.Ferme;
import fr.altaprofits.exercice.animaux.TypeDAnimal;
import fr.altaprofits.exercice.animaux.Animal;
import org.junit.After;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FermeTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @ParameterizedTest()
    @EnumSource(TypeDAnimal.class)
    void toutAnimalPeutEtreAjouteALaFerme(TypeDAnimal type) {
        Ferme ferme = new Ferme();
        Animal animal = new Animal(type);
        ferme.entre(animal);
        assertEquals(1, ferme.nombreTotal());
    }

    @Test
    public void chaqueAnimalEstAssigneAuBonBatiment() {
        Ferme ferme = new Ferme();
        for(TypeDAnimal type : TypeDAnimal.values()) {
            Animal animal = new Animal(type);
            ferme.entre(animal);
        }

        long nombreThéoriqueVoliere = Stream.of(TypeDAnimal.values())
                .filter(animal -> animal.seDéplaceDansLAir() && !animal.seDéplaceSurLEau())
                .count();

        long nombreThéoriqueMare = Stream.of(TypeDAnimal.values())
                .filter(TypeDAnimal::seDéplaceSurLEau)
                .count();

        long nombreThéoriqueEtable = Stream.of(TypeDAnimal.values())
                .filter(TypeDAnimal::seDéplaceSurTerre)
                .count();

        assertEquals(TypeDAnimal.values().length, ferme.nombreTotal());
        assertEquals(nombreThéoriqueVoliere, ferme.nombreDAeriens());
        assertEquals(nombreThéoriqueMare, ferme.nombreDeMarins());
        assertEquals(nombreThéoriqueEtable, ferme.nombreDeTerrestres());
    }

    @ParameterizedTest
    @EnumSource(TypeDAnimal.class)
    void lesAnimalsDuHangarPeuventEtreImprimes(TypeDAnimal type) {
        Ferme ferme = new Ferme();
        Animal animal = new Animal(type);
        ferme.entre(animal);
        ferme.imprimerToutDansConsole();
        assertTrue(outContent.toString().contains(animal.getType().name().toLowerCase()));
    }

}