package fr.altaprofits.exercice.animaux;

import fr.altaprofits.exercice.Déplacement;

public enum TypeDAnimal implements Déplacement {
    AIGLE (true,false,false),
    DAUPHIN(false,true,false),
    OISEAU(true,false,false),
    POISSON(false,true,false),
    ANE(false,false,true),
    VACHE(false,false,true),
    CANARD(true,true,false);

    private final boolean vole;
    private final boolean nage;
    private final boolean marche;

    TypeDAnimal(boolean vole, boolean nage, boolean marche) {
        this.vole = vole;
        this.nage = nage;
        this.marche = marche;
    }

    @Override
    public boolean seDéplaceSurTerre() {
        return marche;
    }

    @Override
    public boolean seDéplaceSurLEau() {
        return nage;
    }

    @Override
    public boolean seDéplaceDansLAir() {
        return vole;
    }
}
