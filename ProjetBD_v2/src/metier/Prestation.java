package metier;

import java.util.ArrayList;

public class Prestation {

	private int id;
	private Conferencier conferencier;
	private ArrayList<Support> supports;
	private double tarif;
	
	public Prestation()
	{
		this.supports = new ArrayList<Support>();
	}
	public Prestation(int id, Conferencier conferencier, double tarif)
	{
		this.id = id;
		this.conferencier = conferencier;
		this.tarif = tarif;
	}
	
	public void setId(int id) { this.id = id; }
	public void setConferencier(Conferencier conferencier) { this.conferencier = conferencier; }
	public void setTarif(double tarif) { this.tarif = tarif; }
	public void setSupports(ArrayList<Support> supports) { this.supports = supports; }
	
	public int getId() { return this.id; }
	public Conferencier getConferencier() { return this.conferencier; }
	public double getTarif() { return this.tarif; }
	public ArrayList<Support> getSupports() { return this.supports; }
	
	public boolean equals(Prestation p)
	{
		if(this.getConferencier() == p.getConferencier() && this.getSupports() == p.getSupports())
			return true;
		return false;
	}
}
