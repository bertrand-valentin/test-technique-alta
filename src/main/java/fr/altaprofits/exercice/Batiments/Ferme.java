package fr.altaprofits.exercice.Batiments;

import fr.altaprofits.exercice.Batiment;
import fr.altaprofits.exercice.animaux.Animal;
import fr.altaprofits.exercice.animaux.TypeDAnimal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.stream.Stream;

public class Ferme implements Batiment {

	private Map<TypeDAnimal, HashSet<Animal>> ferme = new HashMap<>();

	public Ferme() {
		for (TypeDAnimal type : TypeDAnimal.values()) {
			ferme.put(type, new HashSet<>());
		}
	}

	public void entre(Animal animal) {
		ferme.get(animal.getType()).add(animal);
	}

	private int nombreDAnimauxDansVoliere() {
		return Stream.of(TypeDAnimal.values())
				.filter(animalType -> animalType.seDéplaceDansLAir() && !animalType.seDéplaceSurLEau())
				.map(TypeDAnimal -> ferme.get(TypeDAnimal).size())
				.reduce(0, Integer::sum);
	}

	private int nombreDAnimauxDansEtable() {
		return Stream.of(TypeDAnimal.values())
				.filter(TypeDAnimal::seDéplaceSurTerre)
				.map(TypeDAnimal -> ferme.get(TypeDAnimal).size())
				.reduce(0, Integer::sum);
	}

	private int nombreDAnimauxDansLaMare() {
		return Stream.of(TypeDAnimal.values())
				.filter(TypeDAnimal::seDéplaceSurLEau)
				.map(TypeDAnimal -> ferme.get(TypeDAnimal).size())
				.reduce(0, Integer::sum);
	}

	private int nombreDAnimauxDansLaFerme() {
		return nombreDAnimauxDansEtable() + nombreDAnimauxDansLaMare() + nombreDAnimauxDansVoliere();
	}

	private void imprimerDansConsole(Animal animal) {
		System.out.println("animal de type "  + animal.getType().name().toLowerCase());
		System.out.println(animal);
	}

	private void imprimerDansFichier(Animal animal, File f) throws FileNotFoundException {
		PrintStream printStream = new PrintStream(new FileOutputStream(f));
		printStream.println("animal de type "  + animal.getType().name().toLowerCase());
		printStream.println(animal);
	}

	public void imprimerToutDansConsole() {
        for (TypeDAnimal type : TypeDAnimal.values()) {
            ferme.get(type).forEach(this::imprimerDansConsole);
        }
    }

	public void imprimerToutDansFichier(File f) throws FileNotFoundException {
		for (TypeDAnimal type : TypeDAnimal.values()) {
			for (Animal animal : ferme.get(type)) {
				this.imprimerDansFichier(animal, f);
			}
		}
	}

	@Override
	public int nombreDAeriens() {
		return nombreDAnimauxDansVoliere();
	}

	@Override
	public int nombreDeMarins() {
		return nombreDAnimauxDansLaMare();
	}

	@Override
	public int nombreDeTerrestres() {
		return nombreDAnimauxDansEtable();
	}

	@Override
	public int nombreTotal() {
		return nombreDAnimauxDansLaFerme();
	}
}
