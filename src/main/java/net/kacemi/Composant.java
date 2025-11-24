package net.kacemi;

public abstract class Composant {
    protected   int level;
    protected   String name;

    public Composant(String name) {
        this.name = name;
    }

    abstract void print();

    String getTab(){
        String tab = "";
        for (int i = 0; i < level; i++){
            tab += "\t";
        }
        return tab;
    }

}
