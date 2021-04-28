import java.util.Scanner;

public class Menu {
	
	static Scanner input = new Scanner(System.in);
	
	private static int mainMenu() {
		System.out.println("--------------------------");
		System.out.println("--- DONJON AND DRAGONS ---");
		System.out.println("--------------------------");
		System.out.println("");
		System.out.println("--- MENU ---");
		System.out.println("	1 : Créer un Guerrier");
		System.out.println("	2 : Créer un Magicien");
		System.out.println("	3 : Quitter le programme");
		System.out.println("Entrez votre choix : ");
		int inputChoice = input.nextInt();
		input.nextLine();
		return inputChoice;
	}

	private static Guerrier addWarrior() {
		System.out.println("Entrez le nom du guerrier :");
		String name = input.nextLine();
		System.out.println("Entrez ces points de vie :");
		int lifeLevel = input.nextInt();
		System.out.println("Entrez sa force d'attaque :");
		int strongLevel = input.nextInt();
		return new Guerrier(name, lifeLevel, strongLevel);
	}
	
	private static Magicien addWizard() {
		String name = input.nextLine();
		int lifeLevel = input.nextInt();
		int strongLevel = input.nextInt();
		return new Magicien(name, lifeLevel, strongLevel);
	}

	public static void main(String[] args) {
		int choice = 0;
		while (choice != 3) {
			choice = mainMenu();
			
			switch (choice) {
			case 1: {
				Guerrier warrior = addWarrior();
				System.out.println(warrior);
				break;
			}
			case 2: {
				Magicien wizard = addWizard();
				System.out.println(wizard);
				break;
			}
			case 3: {
				break;
			}
			}
		}
		System.out.println("Fin du jeu");
		input.close();
	}

}
