package net.kacemi;

public class Main {
    public static void main(String[] args) {


        Folder root = new Folder("/");

        root.addChild(new File("README.md"));
        root.addChild(new File("Configuration.xml"));

        Folder entitiesFolder = (Folder) root.addChild(new Folder("entities")); // Le niveau est désormais 1 [9, 10].
        Folder reposFolder = (Folder) root.addChild(new Folder("repositories"));

        entitiesFolder.addChild(new File("Product.java"));
        entitiesFolder.addChild(new File("Category.java"));

        reposFolder.addChild(new File("ProductRepository.java"));
        reposFolder.addChild(new File("CategoryRepository.java"));


        Folder utilsFolder = (Folder) reposFolder.addChild(new Folder("utils"));


        utilsFolder.addChild(new File("Logger.java"));



        System.out.println("Affichage de la hiérarchie du système de fichiers :");


        root.print();


    }
}