
public class Warrior {
	//protected so it can't be changed outside of class
	protected String name = "Warrior";
	public int health = 0;
	public int maxDmg = 0;
	public int maxDef = 0;
	
	public Warrior() {
		}
	
	public Warrior(String name, int health,int maxDmg, int maxDef) {
		this.setName(name);
		this.health = health;
		this.maxDmg = maxDmg;
		this.maxDef = maxDef;
	}
	
	public int damage() {
		return 1+(int)(Math.random()*((maxDmg-1)+1));
	}
	
	public int defense() {
		return 1+(int)(Math.random()*((maxDef-1)+1));
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
}
