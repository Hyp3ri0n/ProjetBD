package metier;

import java.util.ArrayList;

public class Prestataire {
	public static final int RESTAURATEUR = 1;
	public static final int HOTELIER = 2;
	public static final int NEGOCIATEUR = 3;
	public static final int EDITEUR = 4;
	
	private int id;
	private String nom;
	private String adresse;
	private ArrayList<Salle> salles;
	private int type;
	
	public Prestataire() {}
	
	public Prestataire(int id, String nom, String adresse, int type)
	{
		this.id = id;
		this.nom = nom;
		this.adresse = adresse;
		this.type = type;
	}
	
	public Prestataire(int id, String nom, String adresse, int type, ArrayList<Salle> salles)
	{
		this(id, nom, adresse, type);
		this.salles = salles;
	}
	
	public void setId(int id) { this.id = id; }
	public void setNom(String nom) { this.nom = nom; }
	public void setAdresse(String adresse) { this.adresse = adresse; }
	public void setType(int type) { this.type = type; }
	public void setSalles(ArrayList<Salle> salles) { this.salles = salles; }
	
	public int getId() { return this.id; }
	public String getNom() { return this.nom; }
	public String getAdresse() { return this.adresse; }
	public int getType() { return this.type; }
	public ArrayList<Salle> getSalles() { return this.salles; }
	public ArrayList<Salle> getSalles(int nbPlacesMin)
	{
		ArrayList<Salle> lesSalles = new ArrayList<Salle>();
		for(Salle s : this.getSalles())
		{
			if(s.getNbPlaces() >= nbPlacesMin)
				lesSalles.add(s);
		}
		
		return lesSalles;
	}
	
	public void ajouterSalle(Salle s) { this.salles.add(s); }
	
	public boolean equals(Prestataire p)
	{
		if(this.getAdresse() == p.getAdresse() && this.getNom() == p.getNom() && this.getType() == p.getType())
			return true;
		return false;
	}
}
