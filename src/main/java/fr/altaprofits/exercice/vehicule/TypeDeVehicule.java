package fr.altaprofits.exercice.vehicule;

public enum TypeDeVehicule {
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

    public boolean peutVoler() {
        return vole;
    }

    public boolean peutNaviguer() {
        return navigue;
    }

    public boolean peutRouler() {
        return roule;
    }
}
