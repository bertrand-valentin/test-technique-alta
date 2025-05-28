package fr.altaprofits.exercice.vehicules;

import fr.altaprofits.exercice.Point;
import fr.altaprofits.exercice.Possession;

public class Vehicule implements Possession {
    private static Integer idIndex = 0; //gérer avec une map si id incrémenté par type
    private final String reference;
    private Point position;
    private final TypeDeVehicule type;

    public Vehicule(TypeDeVehicule type) {
        this.type = type;
        this.reference = type.name().toLowerCase() + "-" + ++idIndex; //possibilité d'ajouter un substring pour juste la 1ere lettre
    }

    @Override
    public TypeDeVehicule getType() {
        return type;
    }

    public void seDeplace(int x, int y) {
        Point destination = new Point(x,y); //KISS, mais éventuellement améliorable pour prise en charge de plusieurs modes de déplacement
        if (this.type.seDéplaceDansLAir()) {
            vole(destination);
        } else if (this.type.seDéplaceSurTerre()) {
            roule(destination);
        } else if (this.type.seDéplaceSurLEau()) {
            navigue(destination);
        } else {
            System.out.printf("Exception personnalisée à intégrer : Véhicule de type %s (Ref : %s), aurait aimé se déplacer de la position %s vers %s\n", type.name().toLowerCase(), reference, position, destination);
        }
    }

    private void roule(Point destination) {
        System.out.printf("Véhicule de type %s (Ref : %s), roule de la position %s vers %s\n", type.name().toLowerCase(), reference, position, destination);
        position = destination;
    }

    private void vole(Point destination) {
        System.out.printf("Véhicule de type %s (Ref : %s), vole de la position %s vers %s\n", type.name().toLowerCase(), reference, position, destination);
        position = destination;
    }

    private void navigue(Point destination) {
        System.out.printf("Véhicule de type %s (Ref : %s), navigue de la position %s vers %s\n", type.name().toLowerCase(), reference, position, destination);
        position = destination;
    }
}
