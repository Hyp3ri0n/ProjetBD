package metier;

public class Pause {
	public enum TypePause
	{
		DEJEUNER("Dejeuner", 0),
		PAUSE_AM("Pause Matinée", 1),
		PAUSE_PM("Pause Après-midi", 2);
		
		private String libelle;
		private int indice;
		private TypePause(String libelle, int poisition)
		{
			this.libelle = libelle;
			this.indice = poisition;
		}
		
		public String toString() { return this.libelle; }
		public int getIndice() { return this.indice; }
		public static TypePause getEnum(int i) { return TypePause.values()[i]; }
	}
	
	private double tarif;
	private Prestataire prestataire;
	private TypePause type;
	
	public Pause() {}
	public Pause(Prestataire prestataire, double tarif, TypePause type)
	{
		this.prestataire = prestataire;
		this.tarif = tarif;
		this.type = type;
	}
	
	public void setTarif(double tarif) { this.tarif = tarif; }
	public void setPrestataire(Prestataire prestataire) { this.prestataire = prestataire; }
	public void setType(TypePause type) { this.type = type; }
	
	public double getTarif() { return this.tarif; }
	public Prestataire getPrestataire() { return this.prestataire; }
	public TypePause getType() { return this.type; }
	
	public boolean equals(Pause p)
	{
		if(this.getPrestataire() == p.getPrestataire() && this.getTarif() == p.getTarif() && this.getType() == p.getType())
			return true;
		return false;
	}
}
