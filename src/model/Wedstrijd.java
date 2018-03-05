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
	
	public void setTotaalPuntenTeams() {
		int oudeThuisTotaalPunten = this.thuisTeam.getTotaalPunten();
		int oudeUitTotaalPunten = this.uitTeam.getTotaalPunten();
		this.thuisTeam.setTotaalPunten(oudeThuisTotaalPunten + this.getWedstrijdPuntenThuisTeam());
		this.uitTeam.setTotaalPunten(oudeUitTotaalPunten + this.getWedstrijdPuntenUitTeam());
	}

	public void setDoelpuntenTeams() {
		int nieuweThuisVoorDoelpunten = this.voorDoelpunten + this.thuisTeam.getTotaalVoorDoelpunten();
		int nieuweThuisTegenDoelpunten = this.tegenDoelpunten + this.thuisTeam.getTotaalTegenDoelpunten();
		int nieuweUitVoorDoelpunten = this.tegenDoelpunten + this.uitTeam.getTotaalVoorDoelpunten();
		int nieuweUitTegenDoelpunten = this.voorDoelpunten + this.uitTeam.getTotaalTegenDoelpunten();
		
		this.thuisTeam.setTotaalVoorDoelpunten(nieuweThuisVoorDoelpunten);
		this.thuisTeam.setTotaalTegenDoelpunten(nieuweThuisTegenDoelpunten);
		this.uitTeam.setTotaalVoorDoelpunten(nieuweUitVoorDoelpunten);
		this.uitTeam.setTotaalTegenDoelpunten(nieuweUitTegenDoelpunten);

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
