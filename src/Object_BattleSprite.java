import java.awt.Image;

/*
 * Sprite.java
 * Diese Klasse stellt eine darstellbare Spielfigur dar. Dies k�nnen Gegner, 
 * Objekte und auch der Character selbst sein.
 * Jeder Character hat f�r jede der Richtungen in die er schauen kann 3 Animationen.
 * Eine Standanimation und zwei Laufanimationen.
 * Seine Position wird nicht in Pixeln gespeichert sondern in dem Spielfeld, auf dem er
 * gerade steht. Die Gr��e eines Tiles betr�gt 32 Pixel also w�rde einer Position von
 * (32, 32) der Position (1, 1) entsprechen.
 * Movecounter, move_distance und moving sind nur f�r die Laufanimation wichtig
 * 'old_x' und 'old_y' speichern die Koordinaten des characters vor einer eventuellen
 * bewegung, um zu pr�fen ob er sich bewegt hat und animiert werden muss.
 */

public class Object_BattleSprite extends Abstract_SubScene {
	
	public int x;
	public int y;
	public int action;
	public boolean busy;
	
	private int animation;
	private int ani_delta;
	private int delay;
	private int tick;
	private Object_BattleSpriteSet spriteset;
	
	Object_BattleSprite (String filename, int x, int y, int delay, Object_Game game) {
		super(game);
		spriteset = new Object_BattleSpriteSet(filename);
		this.x = x;
		this.y = y;
		this.action = Object_BattleSpriteSet.ANIMATION_STAND;
		this.busy = false;
		this.animation = 1;
		this.ani_delta = 1;
		this.delay = delay;
		this.tick = 0;
	}
	
	public void updateData() {
		switch (this.action) {
			//Hier noch einfuegen!!!
		}
		this.tick++;
		if (this.tick == this.delay) {
			this.tick = 0;
			this.animation += this.ani_delta;
			if (this.animation != 2) {
				this.ani_delta *= -1;
			}
		}
	}
	
	public void updateScreen() {
		this.screen.drawImage(this.spriteset.getSprite(this.action, this.animation), this.x, this.y, null);
	}
}
