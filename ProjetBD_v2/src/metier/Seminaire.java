package metier;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import metier.Pause.TypePause;

public class Seminaire {
	
	public enum TypeSeminaire
	{
		JOURNEE(0, "Journée", 6, 3),
		DEMI_AM(1, "Matinée", 3, 2),
		DEMI_PM(2, "Après-midi", 3, 2);
		
		private String libelle;
		private int indice;
		private int activiteMax;
		private int pauseMax;
		TypeSeminaire(int indice, String lib, int maxAct, int maxPause)
		{
			this.libelle = lib;
			this.indice = indice;
			this.activiteMax = maxAct;
			this.pauseMax = maxPause;
		}
		
		public String toString() { return this.libelle; }
		public int getIndice() { return this.indice; }
		public int getNbActivite() { return this.activiteMax; }
		public int getNbPause() { return this.pauseMax; }
		public static TypeSeminaire getEnum(int i) { return TypeSeminaire.values()[i]; }
	};
	
	private int id;
	private String theme;
	private int nbPlaces;
	private Date date;
	private TypeSeminaire type;
	private Salle salle;
	private Animateur animateur;
	private ArrayList<Activite> activites;
	private ArrayList<Inscription> inscriptions;
	private ArrayList<Pause> pauses;
	private boolean valide;
	private double tarif; 

	public Seminaire()
	{
		this.activites = new ArrayList<Activite>();
		this.inscriptions = new ArrayList<Inscription>();
		this.pauses = new ArrayList<Pause>();
		this.valide = false;
	}
	public Seminaire(int id, String theme, int nbPlaces, Date date, TypeSeminaire type, Animateur animateur)
	{
		this();
		this.id = id;
		this.theme = theme;
		this.nbPlaces = nbPlaces;
		this.date = date;
		this.type = type;
		this.animateur = animateur;
	}
	public Seminaire(int id, String theme, int nbPlaces, Date date, TypeSeminaire type, Animateur animateur, Salle salle)
	{
		this(id, theme, nbPlaces, date, type, animateur);
		this.salle = salle;
	}	
	public Seminaire(int id, String theme, int nbPlaces, Date date, TypeSeminaire type, Animateur animateur, Salle salle, ArrayList<Activite> activites)
	{
		this(id, theme, nbPlaces, date, type, animateur, salle);
		this.activites = activites;
	}
	
	
	public void setId(int id) { this.id = id; }
	public void setTheme(String theme) { this.theme = theme; }
	public void setAnimateur(Animateur animateur) { this.animateur = animateur; }
	public void setDate(Date date) { this.date = date; }
	public void setActivites(ArrayList<Activite> activites){ this.activites = activites; }
	public void setType(TypeSeminaire type) { this.type = type; }
	public void setPauses(ArrayList<Pause> pauses) { this.pauses = pauses; }
	public void setNbPlaces(int nbPlaces) { this.nbPlaces = nbPlaces; }
	public void setInscriptions(ArrayList<Inscription> inscriptions) { this.inscriptions = inscriptions; }
	public void setSalle(Salle salle) { this.salle = salle; }
	public void setTarif(double tarif) { this.tarif = tarif; }
	
	public int getId() { return this.id;}
	public Animateur getAnimateur() { return this.animateur; }
	public String getTheme() { return this.theme; }
	public Date getDate() { return this.date; }
	public String getDateFormat()
	{
		SimpleDateFormat format = new SimpleDateFormat("dd MMMM yyyy", Locale.FRANCE);
		return format.format(this.getDate());
	}
	public ArrayList<Activite> getActivites() { return this.activites; }
	public TypeSeminaire getType() { return this.type; }
	public double getTarif() { return this.tarif; }
	public double getRecetteMax() { return this.getNbPlaces() * this.getTarif(); }
	public double getRecetteMin() { return (this.getNbPlaces() / 2) * this.getTarif(); }
	public double getDepenseMax() { return this.getDepense(this.getNbPlaces()); }
	public double getDepenseMin() { return this.getDepense(this.getNbPlaces() / 2 + 1); }
	private double getDepense(int nbParticipant)
	{
		double prix = 0;
		prix += this.getSalle().getTarif();
		for(Pause p : this.getPauses())
			prix += p.getTarif() * nbParticipant;
		
		for(Activite a : this.getActivites())
			for(Prestation p : a.getPrestations())
				prix += p.getTarif();
		
		return prix;
	}
	public ArrayList<Pause> getPauses() { return this.pauses; }
	public Pause getPause(TypePause typePause)
	{
		Pause pause = null;
		for(Pause p : this.getPauses())
		{
			if(p.getType() == typePause)
				pause =  p;
		}
		return pause;
	}
	public int getNbPlaces() { return this.nbPlaces; }
	public ArrayList<Inscription> getInscriptions() { return this.inscriptions; }
	public Salle getSalle() { return this.salle; }

	public ArrayList<Inscription> getListeAttente()
	{
		ArrayList<Inscription> listeAttente = new ArrayList<Inscription>();
		for(int i = this.getNbPlaces(); i < this.getInscriptions().size(); i++)
		{
			listeAttente.add(this.getInscriptions().get(i));
		}

		return listeAttente;
	}
	public ArrayList<Inscription> getListeParticipants()
	{
		ArrayList<Inscription> participants = new ArrayList<Inscription>();
		for(int i = 0; i < this.getNbPlaces(); i++)
		{
			participants.add(this.getInscriptions().get(i));
		}

		return participants;
	}
	
	public void ajouterParticipant(Personne participant)
	{
		if(!participe(participant))
			this.inscriptions.add(new Inscription(participant, new Date()));
	}
	public void supprimerInscription(Personne p)
	{
		for(Inscription i : this.getInscriptions())
		{
			if(i.getPersonne().equals(p))
				this.getInscriptions().remove(i);
		}
		this.getInscriptions().remove(p);
	}
	public boolean participe(Personne p)
	{
		boolean participe = false;
		for(Inscription i : this.getInscriptions())
		{
			if(i.getPersonne().equals(p))
			{
				participe = true;
				break;
			}
		}
		
		return participe;
	}
	
	public void ajouterActivite(Activite activite) throws Exception
	{
		if(this.getActivites().size() == this.getType().getNbActivite())throw new Exception("Nombre d'activités dépassées");
		this.getActivites().add(activite);
	}
	public void supprimerActivite(Activite activite) { this.getActivites().remove(activite); }
	
	public void ajouterPause(Pause p) throws Exception
	{
		if(this.getPause(p.getType()) != null) throw new Exception("Pause déjà comprise");
		if(this.getPauses().size() >= this.getType().getNbPause()) throw new Exception("Nombre de pauses depassées");
		if(this.getType() == TypeSeminaire.DEMI_AM && p.getType() == TypePause.PAUSE_PM) throw new Exception("Pause PM non comprise dans le seminaire");
		if(this.getType() == TypeSeminaire.DEMI_PM && p.getType() == TypePause.PAUSE_AM) throw new Exception("Pause AM non comprise dans le seminaire");
			
		this.pauses.add(p);
	}
	public void supprimerPause(Pause p) { this.getPauses().remove(p); }
	
	public boolean validerSeminaire()
	{
		if((this.getSalle() != null) && (this.getNbPlaces() >= (this.getNbPlaces() / 2)))
			this.valide = true;
		return this.valide;
	}
	
	public String toString()
	{
		StringBuffer str = new StringBuffer();
		str.append("Séminaire du ").append(this.getDateFormat()).append(" (").append(this.getType().toString()).append(")");
		str.append("\nThème : ").append(this.getTheme());
		str.append("\nTarif par personne : ").append(this.getTarif());
		str.append("\nNombre de places : ").append(this.getNbPlaces());
		str.append(" (").append(this.getNbPlaces() - this.getInscriptions().size()).append(" restante(s))");
		str.append("\nAnimateur : ").append(this.getAnimateur().toString());
		str.append("\nRepas prévu : ");
		if(this.getPause(TypePause.DEJEUNER) != null) str.append(" Oui");
		else str.append(" Non");
		return str.toString();
	}
	public boolean equals(Seminaire s)
	{
		boolean date = this.getDate() == s.getDate() ? true : false;
		boolean theme = this.getTheme() == s.getTheme() ? true : false;
		boolean animateur = this.getAnimateur() == s.getAnimateur() ? true : false;
		boolean salle = this.getSalle() == s.getSalle() ? true : false;
		boolean type = this.getType() == s.getType() ? true : false;
		
		if(date && theme && animateur && salle && type)
			return true;
		return false;
	}
	
	/**
	 * indique la possibilité d'ajouter la pause p au séminaire s
	 * @param s TypeSeminaire représentant le type de séminaire
	 * @param p TypePause représentant le type de pause
	 * @return true si la pause est compatible false dans l'autre cas
	 */
	public static boolean pauseCompatible(TypeSeminaire s, TypePause p)
	{
		if(s == TypeSeminaire.DEMI_AM && p == TypePause.PAUSE_PM) return false;
		if(s == TypeSeminaire.DEMI_PM && p == TypePause.PAUSE_AM) return false;
		return true;
	}
}
