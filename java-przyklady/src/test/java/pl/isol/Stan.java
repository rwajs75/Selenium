package pl.isol;

public class Stan {
    public String nazwaStanu;

    public Stan() {
        this.nazwaStanu = "";
    }

    public String getNazwaStanu() {
        return nazwaStanu;
    }

    @Override
    public String toString() {
        return "Stan{" + "nazwaStanu='" + nazwaStanu + '\'' + '}';
    }
}
