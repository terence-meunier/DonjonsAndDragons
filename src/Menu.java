import java.util.Scanner;

public class Menu {

	// Objet Scanner pour récupèrer les entrées du clavier
	static Scanner input = new Scanner(System.in);
	// Objet Guerrier
	static Guerrier warrior = null;
	// Objet Magicien
	static Magicien wizard = null;

	// Menu principal
	private static int mainMenu() {
		System.out.println("--------------------------");
		System.out.println("--- DONJON AND DRAGONS ---");
		System.out.println("--------------------------");
		System.out.println("");
		System.out.println("--- MENU ---");
		System.out.println("	1 : Créer un Guerrier");
		System.out.println("	2 : Créer un Magicien");
		if (warrior != null) {
			System.out.println("	3 : Afficher " + warrior.getName());
			System.out.println("	4 : Quitter le programme");
		} else if (wizard != null) {
			System.out.println("	3 : Afficher " + wizard.getName());
			System.out.println("	4 : Quitter le programme");
		} else {
			System.out.println("	4 : Quitter le programme");
		}
		System.out.println("Entrez votre choix : ");
		int inputChoice = input.nextInt();
		input.nextLine();
		return inputChoice;
	}

	// Menu Character
	private static void characterMenu() {

		if (warrior != null) {
			int choice = 0;
			while (choice != 3) {
				System.out.println("-------------------------------------------");
				System.out.println("--- Menu Guerrier " + warrior.getName() + " ---");
				System.out.println("-------------------------------------------");
				System.out.println();
				System.out.println(" 1: Afficher ses stats");
				System.out.println(" 2: Modifier ses stats");
				System.out.println(" 3: Retour au menu principal");
				System.out.println();
				System.out.println("Entrez votre choix : ");
				choice = input.nextInt();
				switch (choice) {
				case 1: {
					System.out.println(warrior);
					break;
				}
				case 2: {
					// Menu modification du warrior
					System.out.println("Menu modification du warrior");
					break;
				}
				case 3: {
					break;
				}
				}
			}
		} else if (wizard != null) {
			int choice = 0;
			while (choice != 3) {
				System.out.println("-------------------------------------------");
				System.out.println("--- Menu Magicien " + wizard.getName() + " ---");
				System.out.println("-------------------------------------------");
				System.out.println();
				System.out.println(" 1: Afficher ses stats");
				System.out.println(" 2: Modifier ses stats");
				System.out.println(" 3: Retour au menu principal");
				System.out.println();
				System.out.println("Entrez votre choix : ");
				choice = input.nextInt();
				switch (choice) {
				case 1: {
					System.out.println(wizard);
					break;
				}
				case 2: {
					// Menu modification du warrior
					System.out.println("Menu modification du wizard");
					break;
				}
				case 3: {
					break;
				}
				}
			}
		}
	}

	// Ajouter un personnage de type Guerrier
	private static Guerrier addWarrior() {
		System.out.println("Entrez le nom du guerrier :");
		String name = input.nextLine();
		System.out.println("Entrez ces points de vie :");
		int lifeLevel = input.nextInt();
		System.out.println("Entrez sa force d'attaque :");
		int strongLevel = input.nextInt();
		input.nextLine();
		return new Guerrier(name, lifeLevel, strongLevel);
	}

	// Ajouter un personnage de type Magicien
	private static Magicien addWizard() {
		System.out.println("Entrez le nom du magicien :");
		String name = input.nextLine();
		System.out.println("Entrez ces points de vie :");
		int lifeLevel = input.nextInt();
		System.out.println("Entrez sa force d'attaque :");
		int strongLevel = input.nextInt();
		input.nextLine();
		return new Magicien(name, lifeLevel, strongLevel);
	}

	// Programme principal
	public static void main(String[] args) {
		int choice = 0;
		while (choice != 4) {
			choice = mainMenu();

			switch (choice) {
			case 1: {
				warrior = addWarrior();
				break;
			}
			case 2: {
				wizard = addWizard();
				break;
			}
			case 3: {
				characterMenu();
				break;
			}
			case 4: {
				break;
			}
			}
		}
		System.out.println("Fin du jeu");
		input.close();
	}

}
