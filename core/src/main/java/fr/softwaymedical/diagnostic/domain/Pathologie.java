package fr.softwaymedical.diagnostic.domain;

public enum Pathologie {
    PROBLEME_CARDIAQUE(UniteMedicale.CARDIOLOGIE),
    FRACTURE(UniteMedicale.TRAUMATOLOGIE);

    private final UniteMedicale uniteMedicale;

    Pathologie(UniteMedicale uniteMedicale) {
        this.uniteMedicale = uniteMedicale;
    }

    public UniteMedicale getUniteMedicale() {
        return uniteMedicale;
    }
}
