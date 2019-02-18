package main;


public class Warrior {
	//protected so it can't be changed outside of class
	protected String name = "Warrior";
	private int health = 0;
	private int maxDmg = 0;
	private int maxDef = 0;
	
	public Warrior() {
		}
	
	public Warrior(String name, int health,int maxDmg, int maxDef) {
		this.setName(name);
		this.setHealth(health);
		this.setDamage(maxDmg);
		this.setDef(maxDef);
	}
	
		
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getDamage() {
		return 1+(int)(Math.random()*((maxDmg-1)+1));
	}
	public void setDamage(int maxDmg) {
		this.maxDmg = maxDmg;
	}
	public int getDef() {
		return 1+(int)(Math.random()*((maxDef-1)+1));
	}
	public void setDef(int maxDef) {
		this.maxDef = maxDef;
	}
}
