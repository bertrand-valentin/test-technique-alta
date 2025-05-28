package fr.altaprofits.exercice.animaux;

import fr.altaprofits.exercice.Point;
import fr.altaprofits.exercice.Possession;

public class Animal implements Possession {
    private static Integer idIndex = 0; //gérer avec une map si id incrémenté par type
    private final String reference;
    private Point position;
    private final TypeDAnimal type;

    public Animal(TypeDAnimal type) {
        this.type = type;
        this.reference = type.name().toLowerCase() + "-" + ++idIndex; //possibilité d'ajouter un substring pour juste la 1ere lettre
    }

    @Override
    public TypeDAnimal getType() {
        return type;
    }

    public void seDeplace(int x, int y) {
        Point destination = new Point(x,y); //KISS, mais éventuellement améliorable pour prise en charge de plusieurs modes de déplacement
        if (this.type.seDéplaceDansLAir()) {
            vole(destination);
        } else if (this.type.seDéplaceSurTerre()) {
            marche(destination);
        } else if (this.type.seDéplaceSurLEau()) {
            nage(destination);
        } else {
            System.out.printf("Exception personnalisée à intégrer : Animal de type %s (Ref : %s), aurait aimé se déplacer de la position %s vers %s\n", type.name().toLowerCase(), reference, position, destination);
        }
    }

    private void marche(Point destination) {
        System.out.printf("Animal de type %s (Ref : %s), marche de la position %s vers %s\n", type.name().toLowerCase(), reference, position, destination);
        position = destination;
    }

    private void vole(Point destination) {
        System.out.printf("Animal de type %s (Ref : %s), vole de la position %s vers %s\n", type.name().toLowerCase(), reference, position, destination);
        position = destination;
    }

    private void nage(Point destination) {
        System.out.printf("Animal de type %s (Ref : %s), nage de la position %s vers %s\n", type.name().toLowerCase(), reference, position, destination);
        position = destination;
    }
}
