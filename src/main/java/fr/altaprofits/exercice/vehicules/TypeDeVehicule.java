package fr.altaprofits.exercice.vehicules;

import fr.altaprofits.exercice.Déplacement;

public enum TypeDeVehicule implements Déplacement {
    AVION (true,false,false),
    BATEAU(false,true,false),
    HELICOPTERE(true,false,false),
    JETSKI(false,true,false),
    MOTO(false,false,true),
    VOITURE(false,false,true),
    HYDRAVION(true,true,false);

    private final boolean vole;
    private final boolean navigue;
    private final boolean roule;

    TypeDeVehicule(boolean vole, boolean navigue, boolean roule) {
        this.vole = vole;
        this.navigue = navigue;
        this.roule = roule;
    }

    @Override
    public boolean seDéplaceSurTerre() {
        return roule;
    }

    @Override
    public boolean seDéplaceSurLEau() {
        return navigue;
    }

    @Override
    public boolean seDéplaceDansLAir() {
        return vole;
    }
}
