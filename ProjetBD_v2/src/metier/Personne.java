package metier;

public class Personne {
	
	private int id;
	private String nom;
	private String prenom;
	private String adresse;
	private String telephone;
	private String mail;
	
	public Personne(){}
	public Personne(int id, String nom, String prenom, String mail, String tel)
	{
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.telephone = tel;
	}
	
	public Personne(int id, String nom, String prenom, String adresse, String mail, String tel)
	{
		this(id, nom, prenom, mail, tel);
		this.adresse = adresse;
	}
	
	public void setId(int id) { this.id = id; }
	public void setNom(String nom) { this.nom = nom; }
	public void setPrenom(String prenom) { this.prenom = prenom; }
	public void setTelephone(String tel) { this.telephone = tel; }
	public void setAdresse(String adresse) { this.adresse = adresse; }
	public void setMail(String mail) { this.mail = mail; }
	
	public int getId() { return this.id; }
	public String getNom() { return this.nom; }
	public String getPrenom() { return this.prenom; }
	public String getMail() { return this.mail; }
	public String getTelephone() { return this.telephone; }
	public String getAdresse() { return this.adresse; }
	
	public boolean equals(Personne p)
	{
		if(this.getMail() == p.getMail())
			return true;
		return false;
	}
}
