package fr.altaprofits.exercice;

import fr.altaprofits.exercice.Batiments.Hangar;
import fr.altaprofits.exercice.vehicules.TypeDeVehicule;
import fr.altaprofits.exercice.vehicules.Vehicule;
import org.junit.After;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class HangarTest {
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
    @EnumSource(TypeDeVehicule.class)
    void toutVehiculePeutEtreAjouteAuHangar(TypeDeVehicule type) {
        Hangar hangar = new Hangar();
        Vehicule vehicule = new Vehicule(type);
        hangar.entre(vehicule);
        assertEquals(1, hangar.nombreTotal());
    }

    @Test
    public void chaqueVehiculeEstAssigneAuBonBatiment() {
        Hangar hangar = new Hangar();
        for(TypeDeVehicule type : TypeDeVehicule.values()) {
            Vehicule vehicule = new Vehicule(type);
            hangar.entre(vehicule);
        }

        long nombreThéoriqueAéroport = Stream.of(TypeDeVehicule.values())
                .filter(vehicule -> vehicule.seDéplaceDansLAir() && !vehicule.seDéplaceSurLEau())
                .count();

        long nombreThéoriquePort = Stream.of(TypeDeVehicule.values())
                .filter(TypeDeVehicule::seDéplaceSurLEau)
                .count();

        long nombreThéoriqueGarage = Stream.of(TypeDeVehicule.values())
                .filter(TypeDeVehicule::seDéplaceSurTerre)
                .count();

        assertEquals(TypeDeVehicule.values().length, hangar.nombreTotal());
        assertEquals(nombreThéoriqueAéroport, hangar.nombreDAeriens());
        assertEquals(nombreThéoriquePort, hangar.nombreDeMarins());
        assertEquals(nombreThéoriqueGarage, hangar.nombreDeTerrestres());
    }

    @ParameterizedTest
    @EnumSource(TypeDeVehicule.class)
    void lesVehiculesDuHangarPeuventEtreImprimes(TypeDeVehicule type) {
        Hangar hangar = new Hangar();
        Vehicule vehicule = new Vehicule(type);
        hangar.entre(vehicule);
        hangar.imprimerToutDansConsole();
        assertTrue(outContent.toString().contains(vehicule.getType().name().toLowerCase()));
    }

}