import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Hashtable;


public interface IBattleActor {

	//Alle Statusvariablen des BattleActors
	
	public String getName();
	public int getHP();
	public int getMaxHP();
	public int getMP();
	public int getMaxMP();
	public int getATK();
	public int getDEF();
	public int getSpeed();
	public int getMaxSpeed();
	public int getActionCost(); //Wie viel "Speed" eine Aktion den Actor kostet. Sollte bei 0.3*Speed bis 0.5*Speed liegen
	public int getIQ();
	
	//Liste von Items, Zaubern und Waffen
	
	public ArrayList<Entity> getItems();
	public ArrayList<Entity> getSkills();
	
	//Die Ausr�stung soll so verwaltet werden, dass jeder Spieler immer nur eine Waffe,
	//eine R�stung, etc. tragen kann.
	//Dann kann man auf die Ausr�stung einfach mit den Strings "weapon", "armor", "shield", etc.
	//zugreifen.
	public Hashtable<String, Entity> getEquipment();
	
	//BattleSprite
	public BufferedImage getBattleSprite();
	
	//Die Daten im BattleActor werden w�hrend des Kampfes genutzt und ver�ndert.
	//writeBack() �bertr�gt alle diese Daten auf die tats�chliche Spielerentit�t
	//Damit die �nderungen auch nach dem Kapmf wirksam sind
	public void writeBack();
	
	void reduceSpeed();
	void resetSpeed();
	
}
