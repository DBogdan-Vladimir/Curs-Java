package main;


// utility class, all methods should be static
public class Battle {
	public static void startFight(Warrior w1, Warrior w2) throws InterruptedException {
		while(true) {
			if(getDamage(w1,w2).contentEquals("GAME OVER!")) {
				System.out.println("GAME OVER!");
				break;
			}
			if(getDamage(w2,w1).contentEquals("GAME OVER!")) {
				System.out.println("GAME OVER!");
				break;
			}
		}
	}
	public static String getDamage(Warrior wA, Warrior wB) throws InterruptedException {
		int wADmg = wA.getDamage();
		int wBDef = wB.getDef();
		
		int dmg2WarB = wADmg - wBDef;
		if(dmg2WarB > 0) {
			wB.setHealth(wB.getHealth() - dmg2WarB);
		}else dmg2WarB = 0;
		
		System.out.printf("%s attacks %s and deals "
				+ "%d Damage\n", wA.getName(), wB.getName(), dmg2WarB);
		
		System.out.printf("%s has %d health\n\n",wB.getName(), wB.getHealth());
		
		Thread.sleep(1250);
		
		if(wB.getHealth() <= 0) {
			System.out.printf("%s has died and %s is " + "victorious\n",wB.getName(),wA.getName());
			return "GAME OVER!";
		} else return "FIGHT AGAIN!";
	}
}
