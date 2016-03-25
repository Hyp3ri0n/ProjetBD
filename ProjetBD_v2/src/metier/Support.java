package metier;

public class Support {
	
	private int id;
	private String nom;
	private String fichier;
	
	public Support() {}
	public Support(int id, String nom, String fichier)
	{
		this.id = id;
		this.nom = nom;
		this.fichier = fichier;
	}
	
	public void setId(int id) { this.id = id; }
	public void setNom(String nom) { this.nom = nom; }
	public void setFichier(String fichier) { this.fichier = fichier; }
	
	public int getId() {return this.id; }
	public String getNom() { return this.nom; }
	public String getFichier() { return this.fichier; }
	
	public boolean equals(Support s)
	{
		if(this.getFichier() == s.getFichier() && this.getNom() == s.getNom())
			return true;
		return false;
	}
}
