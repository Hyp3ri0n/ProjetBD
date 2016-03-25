package debug;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 * mode deboggage
 * @author Fernandes - Martinier
 * @date 12/03/2016
 */
public final class Debug {
	private static boolean active = false;
	private static Component panel = null;
	
	/**
	 * active le mode deboggage de l'application
	 * ne définie pas de container pour afficher les pop-up
	 */
	public static void on() { active = true; }
	/**
	 * active le mode de deboggage de l'application
	 * @param container - Composant représentant la zone d'affichage possible des pop-up
	 */
	public static void on(Component container)
	{ 
		setContainer(container);;
		active = true;
	}
	/**
	 * change le container de l'application
	 * @param container - Composant représentant la zone d'affichage possible des pop-up
	 */
	public static void setContainer(Component container){ panel = container; }
	/**
	 * désactive le mode deboggage de l'application
	 */
	public static void off() { active = false; }
	/**
	 * permet de connaitre l'état d'activation du mode deboggage
	 * @return - true si le mode est activé
	 */
	public static boolean isActive() { return active; }
	public static Component getContainer() { return panel; }
	
	/**
	 * affichage de l'objet o dans le console si le mode deboggage est activé
	 * @param o - objet à afficher
	 */
	public static void console(Object o)
	{
		if(isActive() && o != null)
			System.out.println("[DEBUG] " + o.toString());
		else if(isActive())
			System.out.println("Object is NULL");
	}
	
	/**
	 * affichage de l'objet o dans une pop-up si le mode deboggage est activé
	 * @param o - objet à afficher
	 */
	public static void display(Object o)
	{
		if(isActive() && o != null)
			JOptionPane.showMessageDialog(getContainer(), o.toString());
		else if(isActive())
			JOptionPane.showMessageDialog(getContainer(), "Object : " + o);
	}
	
	/**
	 * affichage de l'objet o dans une pop-up si le mode deboggage est activé dans la zone container
	 * @param o - Objet à afficher
	 * @param container - zone d'affichage
	 */
	public static void display(Object o, Component container)
	{
		if(isActive() && o != null)
			JOptionPane.showMessageDialog(container, o.toString());
		else if(isActive())
			JOptionPane.showMessageDialog(container, "Object : " + o);
	}
}
