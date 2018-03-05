package mainvoetbalscores;

import java.util.Scanner;

import model.Team;
import model.Wedstrijd;

public class VoetbalscoresLauncher {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Hoeveel teams zijn er? ");
		int aantalTeams = scanner.nextInt();
		scanner.nextLine();

		Team[] teams = new Team[aantalTeams];

		for (int i = 0; i < teams.length; i++) {
			System.out.printf("Naam van team %d: ", i + 1);
			teams[i] = new Team(scanner.nextLine());
		}
		
		int aantalWedstrijden = getNumberOfGames(aantalTeams);
		Wedstrijd[] wedstrijden = new Wedstrijd[aantalWedstrijden];
		int index = 0;
		
		for (int thuis = 0; thuis < aantalTeams; thuis++) {
			for (int uit = 0; uit < aantalTeams; uit++) {
				if(uit != thuis) {
					wedstrijden[index] = new Wedstrijd(teams[thuis], teams[uit]);
					index++;
				}
			}
		}

		
		for (int i = 0; i < wedstrijden.length; i++) {
			System.out.printf("Geef van de wedstrijd %s-%s de voordoelpunten: ",
					wedstrijden[i].getThuisTeam().getTeamNaam(), wedstrijden[i].getUitTeam().getTeamNaam());
			wedstrijden[i].setVoorDoelpunten(scanner.nextInt());
			System.out.printf("Geef van de wedstrijd %s-%s de tegendoelpunten: ",
					wedstrijden[i].getThuisTeam().getTeamNaam(), wedstrijden[i].getUitTeam().getTeamNaam());
			wedstrijden[i].setTegenDoelpunten(scanner.nextInt());

			wedstrijden[i].setTotaalPuntenTeams();
			wedstrijden[i].setDoelpuntenTeams();
		}

		for (int i = 0; i < wedstrijden.length; i++) {
			wedstrijden[i].printUitslag();
		}

		for (int i = 0; i < teams.length; i++) {
			teams[i].printStatusTeam();
		}

	}

	public static int getNumberOfGames(int numberOfTeams) {
		return numberOfTeams * (numberOfTeams - 1);
	}

}
