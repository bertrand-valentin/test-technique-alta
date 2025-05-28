package fr.altaprofits.exercice;

import fr.altaprofits.exercice.vehicule.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.stream.Stream;

public class Hangar {

	private Map<TypeDeVehicule, HashSet<Vehicule>> hangar = new HashMap<>();

	public Hangar() {
		for (TypeDeVehicule type : TypeDeVehicule.values()) {
			hangar.put(type, new HashSet<>());
		}
	}

	public void entre(Vehicule vehicule) {
		hangar.get(vehicule.getType()).add(vehicule);
	}

	public int nombreDeVehiculesDansAeroport() {
		return Stream.of(TypeDeVehicule.values())
				.filter(vehiculeType -> vehiculeType.peutVoler() && !vehiculeType.peutNaviguer())
				.map(typeDeVehicule -> hangar.get(typeDeVehicule).size())
				.reduce(0, Integer::sum);
	}

	public int nombreDeVehiculesDansGarage() {
		return Stream.of(TypeDeVehicule.values())
				.filter(TypeDeVehicule::peutRouler)
				.map(typeDeVehicule -> hangar.get(typeDeVehicule).size())
				.reduce(0, Integer::sum);
	}

	public int nombreDeVehiculeDansPort() {
		return Stream.of(TypeDeVehicule.values())
				.filter(TypeDeVehicule::peutNaviguer)
				.map(typeDeVehicule -> hangar.get(typeDeVehicule).size())
				.reduce(0, Integer::sum);
	}

	public int nombreDeVehiculeDansHangar() {
		return nombreDeVehiculeDansPort() + nombreDeVehiculesDansAeroport() + nombreDeVehiculesDansGarage();
	}

	private void imprimerDansConsole(Vehicule vehicule) {
		System.out.println("Vehicule de type "  + vehicule.getType().name().toLowerCase());
		System.out.println(vehicule);
	}

	private void imprimerDansFichier(Vehicule vehicule, File f) throws FileNotFoundException {
		PrintStream printStream = new PrintStream(new FileOutputStream(f));
		printStream.println("Vehicule de type "  + vehicule.getType().name().toLowerCase());
		printStream.println(vehicule);
	}

	public void imprimerToutDansConsole() {
        for (TypeDeVehicule type : TypeDeVehicule.values()) {
            hangar.get(type).forEach(this::imprimerDansConsole);
        }
    }

	public void imprimerToutDansFichier(File f) throws FileNotFoundException {
		for (TypeDeVehicule type : TypeDeVehicule.values()) {
			for (Vehicule vehicule : hangar.get(type)) {
				this.imprimerDansFichier(vehicule, f);
			}
		}
	}
}
