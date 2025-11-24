# 📁 Projet Java : Implémentation du Pattern Composite

Ce projet a pour but de démontrer la mise en œuvre du **Pattern Composite** en Java, un **pattern de conception structurelle** [1] utilisé pour représenter les **structures arborescentes** (hiérarchies).

## 🧠 Ce que j'ai appris : Le Pattern Composite

Le Pattern Composite est essentiel dès que l'on doit modéliser une hiérarchie. L'objectif principal est de permettre à la partie cliente de manipuler un objet unique (la racine) et un objet composé (le composite) de la **même manière** .

### 1. Concept Fondamental
La valeur de ce pattern réside dans la capacité à appliquer une opération unique à l'élément racine de la structure, ce qui entraîne l'application de cette opération à tous les éléments de l'arbre via la **récursivité hiérarchique**.

### 2. Les Trois Rôles Clés
Le pattern se décline en trois éléments principaux :

1.  **Composante (Component)** :
    *   C'est la classe abstraite ou l'interface qui définit l'opération commune à tous les objets de la hiérarchie (ici, `print()`).
    *   Elle porte également les attributs communs, comme le **nom** et le **niveau (`level`)**. L'attribut `level` est crucial pour calculer l'**indentation** lors de l'affichage.

2.  **Élément Terminal (File / Leaf)** :
    *   Représente les feuilles de l'arbre, c'est-à-dire les éléments qui **ne contiennent pas** d'autres composants (par exemple, un fichier).
    *   Il implémente l'opération `print()` directement.

3.  **Composite (Folder)** :
    *   C'est l'élément clé qui peut contenir d'autres composants. Il représente un nœud interne de l'arbre (par exemple, un dossier).
    *   Le composite maintient une **liste de Composantes** (`List<Component> components`), représentant une relation **un à plusieurs**.
    *   Son implémentation de `print()` est **récursive** : elle affiche d'abord le composite lui-même, puis itère sur sa liste et appelle `print()` sur chaque sous-composant.

## 🏗️ Diagramme de Classes
<img width="936" height="717" alt="image" src="https://github.com/user-attachments/assets/0393ce77-8f7c-4e88-8140-a6b78d4d7aa3" />

Ce diagramme illustre clairement la relation d'héritage (File et Folder héritent de Component) et la relation d'agrégation/composition de **Folder** vers **Component** (le Folder contient une liste de Component), formant ainsi la structure arborescente.

## 💻 Implémentation Java : Système de Fichiers

L'exemple pratique choisi est la modélisation d'une structure de **système de fichiers** (Dossiers et Fichiers).

### Structure de la Hiérarchie
J'ai utilisé la méthode `addChild()` dans la classe `Folder` pour ajouter des composants. Cette méthode est également l'endroit idéal pour définir le niveau (`level`) du composant ajouté (`this.level + 1`), assurant ainsi que les tabulations seront correctes pour l'affichage hiérarchique.

### Code Client (Main.java)

Le code ci-dessous construit la hiérarchie et applique l'opération d'affichage **en appelant la méthode `print()` uniquement sur l'élément racine** (`root`) :

```java
public class Main {
    public static void main(String[] args) {
        Folder root = new Folder("/");

        root.addChild(new File("README.md"));
        root.addChild(new File("Configuration.xml"));

        Folder entitiesFolder = (Folder) root.addChild(new Folder("entities")); 
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
```

```shell
✅ Résultat de l'Exécution
Le pattern assure la propagation de l'opération print() à travers tous les niveaux de l'arbre, générant l'affichage correctement indenté :
Affichage de la hiérarchie du système de fichiers :
Folder: /
	File: README.md
	File: Configuration.xml
	Folder: entities
		File: Product.java
		File: Category.java
	Folder: repositories
		File: ProductRepository.java
		File: CategoryRepository.java
		Folder: utils
			File: Logger.java
