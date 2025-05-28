package fr.altaprofits.exercice;

import fr.altaprofits.exercice.vehicule.TypeDeVehicule;
import fr.altaprofits.exercice.vehicule.Vehicule;
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
        assertEquals(1, hangar.nombreDeVehiculeDansHangar());
    }

    @Test
    public void chaqueVehiculeEstAssigneAuBonBatiment() {
        Hangar hangar = new Hangar();
        for(TypeDeVehicule type : TypeDeVehicule.values()) {
            Vehicule vehicule = new Vehicule(type);
            hangar.entre(vehicule);
        }

        long nombreThéoriqueAéroport = Stream.of(TypeDeVehicule.values())
                .filter(vehicule -> vehicule.peutVoler() && !vehicule.peutNaviguer())
                .count();

        long nombreThéoriquePort = Stream.of(TypeDeVehicule.values())
                .filter(TypeDeVehicule::peutNaviguer)
                .count();

        long nombreThéoriqueGarage = Stream.of(TypeDeVehicule.values())
                .filter(TypeDeVehicule::peutRouler)
                .count();

        assertEquals(TypeDeVehicule.values().length, hangar.nombreDeVehiculeDansHangar());
        assertEquals(nombreThéoriqueAéroport, hangar.nombreDeVehiculesDansAeroport());
        assertEquals(nombreThéoriquePort, hangar.nombreDeVehiculeDansPort());
        assertEquals(nombreThéoriqueGarage, hangar.nombreDeVehiculesDansGarage());
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