import java.util.Scanner;

public class Menu {
	
	static Scanner input = new Scanner(System.in);
	static Guerrier warrior = null;
	static Magicien wizard = null;
	
	private static int mainMenu() {
		System.out.println("--------------------------");
		System.out.println("--- DONJON AND DRAGONS ---");
		System.out.println("--------------------------");
		System.out.println("");
		System.out.println("--- MENU ---");
		System.out.println("	1 : Créer un Guerrier");
		System.out.println("	2 : Créer un Magicien");
		System.out.println("	3 : Quitter le programme");
		if (warrior != null) {
			System.out.println("	4 : Afficher le guerrier " + warrior.getName());
		}
		System.out.println("Entrez votre choix : ");
		int inputChoice = input.nextInt();
		input.nextLine();
		return inputChoice;
	}
	
	private static void warriorMenu() {
		int choice = 0;
		while (choice != 3) {
			System.out.println("-------------------------------------------");
			System.out.println("--- Warrior : " + warrior.getName() + " ---");
			System.out.println("-------------------------------------------");
			System.out.println();
			System.out.println(" 1: Afficher ses stats");
			System.out.println(" 2: Afficher ses stats");
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
				System.out.println("Menu de modificatino du warrior");
				break;
			}
			case 3: {
				break;
			}
			}
		}
	}

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
	
	private static Magicien addWizard() {
		String name = input.nextLine();
		int lifeLevel = input.nextInt();
		int strongLevel = input.nextInt();
		input.nextLine();
		return new Magicien(name, lifeLevel, strongLevel);
	}

	public static void main(String[] args) {	
		int choice = 0;
		while (choice != 3) {
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
				break;
			}
			case 4: {
				warriorMenu();
			}
			}
		}
		System.out.println("Fin du jeu");
		input.close();
	}

}
