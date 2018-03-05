package model;

public class Team {
	private String teamNaam;
	private int totaalPunten;
	private int totaalVoorDoelpunten;
	private int totaalTegenDoelpunten;
	
	public Team(String teamNaam, int totaalPunten, int totaalVoorDoelpunten, int totaalTegenDoelpunten) {
		this.teamNaam = teamNaam;
		this.totaalPunten = totaalPunten;
		this.totaalVoorDoelpunten = totaalVoorDoelpunten;
		this.totaalTegenDoelpunten = totaalTegenDoelpunten;
	}
	
	public Team(String teamNaam) {
		this(teamNaam, 0, 0, 0);
	}
	
	public Team() {
		this("", 0, 0, 0);
	}
	
	public String getTeamNaam() {
		return this.teamNaam;
	}
	
	public void setTeamNaam(String teamNaam) {
		this.teamNaam = teamNaam;
	}
	
	public int getTotaalPunten() {
		return this.totaalPunten;
	}
	
	public void setTotaalPunten(int totaalPunten) {
		this.totaalPunten = totaalPunten;
	}
	
	public int getTotaalVoorDoelpunten() {
		return this.totaalVoorDoelpunten;
	}
	
	public void setTotaalVoorDoelpunten(int totaalVoorDoelpunten) {
		this.totaalVoorDoelpunten = totaalVoorDoelpunten;
	}
	
	public int getTotaalTegenDoelpunten() {
		return this.totaalTegenDoelpunten;
	}
	
	public void setTotaalTegenDoelpunten(int totaalTegenDoelPunten) {
		this.totaalTegenDoelpunten = totaalTegenDoelPunten;
	}
	
	public int getDoelSaldo() {
		return this.totaalVoorDoelpunten - this.totaalTegenDoelpunten;
	}
	
	public void printStatusTeam() {
		System.out.printf("Het team %s heeft %d wedstrijdpunt en een doelsaldo van %d\n",
				this.getTeamNaam(), this.totaalPunten, this.getDoelSaldo());
	}

}
