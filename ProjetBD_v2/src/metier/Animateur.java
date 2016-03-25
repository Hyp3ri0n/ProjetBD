package metier;

public class Animateur extends Personne {
	public Animateur() { super(); }
	public Animateur(int id, String nom, String prenom, String mail, String tel)
	{
		super(id, nom, prenom, mail, tel);
	}
	
	public String toString()
	{
		return this.getNom() + " " + this.getPrenom();
	}
}
