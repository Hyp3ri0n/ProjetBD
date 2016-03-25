package metier;

import java.util.Date;

public class Inscription {
	private Personne personne;
	private Date date;
	
	public Inscription() {}
	public Inscription(Personne personne, Date date)
	{
		this.personne = personne;
		this.date = date;
	}
	
	public void setPersonne(Personne personne) { this.personne = personne; }
	public void setDate(Date date) { this.date = date; }
	
	public Personne getPersonne() { return this.personne; }
	public Date getDate() { return this.date; }
}
