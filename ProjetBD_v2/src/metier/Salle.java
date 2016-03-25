package metier;

public class Salle {
	
	private int id;
	private String nom;
	private int nbPlaces;
	private double tarif;
	private Prestataire prestataire;
	
	public Salle() {}
	
	public Salle(int id, String nom, int nbPlaces, double tarif)
	{
		this.id = id;
		this.nom = nom;
		this.nbPlaces = nbPlaces;
		this.tarif = tarif;
	}
	
	public Salle(int id, String nom, int nbPlaces, double tarif, Prestataire prestataire)
	{
		this(id, nom, nbPlaces, tarif);
		this.prestataire = prestataire;
	}

	public void setId(int id) { this.id = id; }
	public void setNom(String nom) { this.nom = nom; }
	public void setNbPlaces(int nbPlaces) { this.nbPlaces = nbPlaces; }
	public void setTarif(double tarif) { this.tarif = tarif; }
	public void setPrestataire(Prestataire p) { this.prestataire = p; }
	
	public int getId() { return this.id; }
	public String getNom() { return this.nom; }
	public int getNbPlaces() { return this.nbPlaces; }
	public double getTarif() { return this.tarif; }
	public Prestataire getPrestataire() { return this.prestataire; }
}
