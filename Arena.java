import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Arena {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Monster id:
		String monsterId = "0";
		int amountOfMonstersInTheGame = 3;
		
		
		// create monster: --> ArrayList<Monsters> mit s geht nicht, da es keine Klasse dazu gibt!
		//                 --> UND in new können keine Monster erstellt werden, da es eine Abstrakte Klasse ist.
		ArrayList<Monster> monstersList = new ArrayList<>();
		monstersList.add(new FireMonster ("FireMonster", 50, 200));
		monstersList.add(new GrassMonster ("GrassMonster", 40, 230));
		monstersList.add(new WaterMonster ("WaterMonster", 30, 250));
		monstersList.add(new MartinMonster ("MartinMonster", 77, 277));
		
		monstersList.add(new MartinTrickMonster ());
		
		// new Monster geht nicht, da Monster "abstract" ist !
		
		// Erster Aufruf geht in z.B. FireMonster (mit 3 Parameter, dann von dort in Monster mit 4 Parameter.
		
		
		
		
		// Choose a monster:
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("Please choose a monster: ");
			System.out.println("1: FireMonster");
			System.out.println("2: GrassMonster");
			System.out.println("3: WaterMonster");
			
			monsterId = scanner.nextLine();
			
		} while (!(monsterId.equals("1") || monsterId.equals("2") || monsterId.equals("3")));
		
		System.out.println("You chose monster " + monsterId + " :");
		scanner.close();
		int chosenMonsterId = Integer.parseInt(monsterId);
		//System.out.println(", and the INTEGER is: " + chosenMonsterId + " :");
		//System.out.println();
		Monster playerMonster = monstersList.get(chosenMonsterId-1);
		System.out.println(playerMonster.getName() + " (Life: " +playerMonster.getLife() + ", Damage: " +playerMonster.getDamage() + ")");
		
		

		monstersList.remove(playerMonster);
		
		// Mische restliche Monster:
		Collections.shuffle(monstersList);
		Monster computerMonster = monstersList.get(0);
		System.out.println("You fight against: " + computerMonster.getName() + " (Life: " +computerMonster.getLife() + ", Damage: " +computerMonster.getDamage() + ")");
		
				// not used...
				// Random monster 2 - from the monsters, who are still left:
				// int randomNumber = (int) (Math.random()*100+2);
				// System.out.println(randomNumber);
		
		
		// Der Kampf beginnt:
		System.out.println();
		System.out.println("The fight starts...");
		System.out.println();
		
		
		
	
		
		do {
			//Player hits
			if (playerMonster.getLife() > 0)
				computerMonster.takeHit(playerMonster);
				// Aufruf von computerMonster (who takes the hit) und übergeben wird playerMonster (who hits...
				// ... this is theMonsterWhoHits - in the method (inside Monster)...
		
			//Computer hits
			if (computerMonster.getLife() > 0)
				playerMonster.takeHit(computerMonster);
			
			
			
			// Sleep: Eingebaut...
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// Sleep - ENDE
			
			
			
			
			
		} while (playerMonster.getLife() > 0 && computerMonster.getLife() > 0);
		
		if (playerMonster.getLife() <= 0)
			System.out.println(playerMonster.getName() + " is KO! You lost!");
		else
			System.out.println(computerMonster.getName() + " is KO! Player won!");
		
		
		}
		
		
	}




