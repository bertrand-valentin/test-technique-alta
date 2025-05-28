package fr.altaprofits.exercice.vehicule;

import fr.altaprofits.exercice.Point;

public class Vehicule {
    private static Integer idIndex = 0; //gérer avec une map si id incrémenté par type
    private final String reference;
    private Point position;
    private final TypeDeVehicule type;

    public Vehicule(TypeDeVehicule type) {
        this.type = type;
        this.reference = type.name().toLowerCase() + "-" + ++idIndex; //possibilité d'ajouter un substring pour juste la 1ere lettre
    }

    public TypeDeVehicule getType() {
        return type;
    }

    public void seDeplace(int x, int y) {
        Point destination = new Point(x,y); //KISS, mais éventuellement améliorable pour prise en charge de plusieurs modes de déplacement
        if (this.type.peutVoler()) {
            vole(destination);
        } else if (this.type.peutRouler()) {
            roule(destination);
        } else if (this.type.peutNaviguer()) {
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
