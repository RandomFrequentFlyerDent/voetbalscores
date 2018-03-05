package model;

public class Wedstrijd {
	private Team thuisTeam;
	private Team uitTeam;
	private int voorDoelpunten;
	private int tegenDoelpunten;

	public Wedstrijd(Team thuisTeam, Team uitTeam, int voorDoelpunten, int tegenDoelpunten) {
		this.thuisTeam = thuisTeam;
		this.uitTeam = uitTeam;
		this.voorDoelpunten = voorDoelpunten;
		this.tegenDoelpunten = tegenDoelpunten;
	}

	public Wedstrijd(Team thuisTeam, Team uitTeam) {
		this(thuisTeam, uitTeam, 0, 0);
	}

	public Wedstrijd() {
		this(new Team(), new Team(), 0, 0);
	}

	public Team getThuisTeam() {
		return this.thuisTeam;
	}

	public void setThuisTeam(Team thuisTeam) {
		this.thuisTeam = thuisTeam;
	}

	public Team getUitTeam() {
		return this.uitTeam;
	}

	public void setUitTeam(Team uitTeam) {
		this.uitTeam = uitTeam;
	}

	public int getVoorDoelpunten() {
		return this.voorDoelpunten;
	}

	public void setVoorDoelpunten(int voorDoelpunten) {
		this.voorDoelpunten = voorDoelpunten;
	}

	public int getTegenDoelpunten() {
		return this.tegenDoelpunten;
	}

	public void setTegenDoelpunten(int tegenDoelpunten) {
		this.tegenDoelpunten = tegenDoelpunten;
	}

	public int getWedstrijdPuntenThuisTeam() {
		int aantalPunten;

		if (this.voorDoelpunten > this.tegenDoelpunten) {
			aantalPunten = 3;
		} else if (this.voorDoelpunten == this.tegenDoelpunten) {
			aantalPunten = 1;
		} else {
			aantalPunten = 0;
		}

		return aantalPunten;

	}

	public int getWedstrijdPuntenUitTeam() {
		int aantalPunten;

		if (this.voorDoelpunten < this.tegenDoelpunten) {
			aantalPunten = 3;
		} else if (this.voorDoelpunten == this.tegenDoelpunten) {
			aantalPunten = 1;
		} else {
			aantalPunten = 0;
		}

		return aantalPunten;

	}

	public void setTotaalPuntenThuisTeam() {
		int totaalPunten = this.thuisTeam.getTotaalPunten();
		totaalPunten += this.getWedstrijdPuntenThuisTeam();
		this.thuisTeam.setTotaalPunten(totaalPunten);
	}

	public void setTotaalPuntenUitTeam() {
		int totaalPunten = this.uitTeam.getTotaalPunten();
		totaalPunten += this.getWedstrijdPuntenUitTeam();
		this.uitTeam.setTotaalPunten(totaalPunten);
	}

	public void setDoelpuntenTeams() {
		// get all current total goals
		int thuisVoorDoelpunten = this.thuisTeam.getTotaalVoorDoelpunten();
		int thuisTegenDoelpunten = this.thuisTeam.getTotaalTegenDoelpunten();
		int uitVoorDoelpunten = this.uitTeam.getTotaalVoorDoelpunten();
		int uitTegenDoelpunten = this.uitTeam.getTotaalTegenDoelpunten();

		// get all total goals after this match
		thuisVoorDoelpunten += this.voorDoelpunten;
		thuisTegenDoelpunten += this.tegenDoelpunten;
		uitVoorDoelpunten += this.tegenDoelpunten;
		uitTegenDoelpunten += this.voorDoelpunten;

		// update total goals in the team objects
		this.thuisTeam.setTotaalVoorDoelpunten(thuisVoorDoelpunten);
		this.thuisTeam.setTotaalTegenDoelpunten(thuisTegenDoelpunten);
		this.uitTeam.setTotaalVoorDoelpunten(uitVoorDoelpunten);
		this.uitTeam.setTotaalTegenDoelpunten(uitTegenDoelpunten);

	}

	public void printUitslag() {
		System.out.printf("Uitslag van de wedstrijd %s-%s: %d-%d\n", this.thuisTeam.getTeamNaam(),
				this.uitTeam.getTeamNaam(), this.voorDoelpunten, this.tegenDoelpunten);
	}

	public void printWedstrijdPunten() {
		System.out.printf("Dit levert %d wedstrijdpunt voor %s en %d wedstrijdpunt voor %s\n",
				this.getWedstrijdPuntenThuisTeam(), this.thuisTeam.getTeamNaam(), this.getWedstrijdPuntenUitTeam(),
				this.uitTeam.getTeamNaam());
	}
}
