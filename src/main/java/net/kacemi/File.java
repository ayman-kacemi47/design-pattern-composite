package net.kacemi;

public class File extends Composant {

    public File( String name) {
        super( name);
    }

    @Override
    void print() {
        System.out.println(super.getTab()+"File: "+this.name);
    }
}
