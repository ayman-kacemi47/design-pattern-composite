package net.kacemi;

import java.util.ArrayList;
import java.util.List;

public class Folder extends Composant {
    List<Composant> composants = new ArrayList<Composant>();

    public Folder(String name) {
        super(name);
    }

    public Composant addChild(Composant composant){
        composant.level = this.level + 1;
        composants.add(composant);
        return composant;
    }


    @Override
    void print() {
        System.out.println(super.getTab()+"Folder: "+this.name);
        composants.forEach(leaf->leaf.print());

    }
}
