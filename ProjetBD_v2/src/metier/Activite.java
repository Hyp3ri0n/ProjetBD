package metier;

import java.util.ArrayList;

public class Activite {
	
	private int id;
	private String libelle;
	private ArrayList<Prestation> prestations;
	
	public Activite() {}
	public Activite(int id, String libelle)
	{
		this.id = id;
		this.libelle = libelle;
		this.prestations = new ArrayList<Prestation>();
	}
	public Activite(int id, String libelle, ArrayList<Prestation> prestations)
	{
		this(id, libelle);
		this.prestations = prestations;
	}
	
	public void setId(int id) { this.id = id; }
	public void setLibelle(String libelle) { this.libelle = libelle; }
	public void setPrestations(ArrayList<Prestation> prestations) { this.prestations = prestations; }
	
	public int getId() { return this.id; }
	public String getLibelle() { return this.libelle; }
	public ArrayList<Prestation> getPrestations() { return this.prestations; }
	
	public void ajouterPrestation(Prestation p) { this.prestations.add(p); }
	public void ajouterPrestations(ArrayList<Prestation> prestation)
	{
		for(Prestation p : prestation)
		{
			ajouterPrestation(p);
		}
	}
	
	public boolean equals(Activite a)
	{
		if(this.getLibelle() == a.getLibelle() && this.getPrestations() == a.getPrestations())
			return true;
		return false;
	}
}
