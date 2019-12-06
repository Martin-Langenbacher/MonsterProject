
public abstract class Monster {

	//attributes
	private String name;
	private int damage; // ohne "privat" könnte ich meine Variable mit m.name = "TEST-Monster" ändern...
	private int life;   // mit privat kann ich nur die Variable in der Classe wechseln.
	private String type;
	
	
	//constructors
	public Monster() {
		this("NormalMonster");
	}
	
	
	public Monster(String name) {
		this.name = name;
		this.damage = 10;
		this.life = 39;
		this.type = "Normal"; 
	}
	// ------------> Andre: Warum mache ich die beiden überhaupt, wenn ich sie nicht aufrufen kann?
	// --> kann ich wahrscheinlich, wenn ich eine classe mache...?
	
	
	public Monster(String name, int damage, int life, String type) {
		// this.Punkt bedeutet, dass es um die Instanzvariable von oben geht!
		this.name = name;    // nur name = name; --> ist lokale Varible...
		this.damage = damage;
		this.life = life;
		this.type = type;
		
	}



	//getters and setters
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getDamage() {
		return damage;
	}


	public void setDamage(int damage) {
		this.damage = damage;
	}


	public int getLife() {
		return life;
	}


	public void setLife(int life) {
		this.life = life;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}

// method:
// theMonsterWhoHits is NOT this...
// "this." is the monster who gets the HIT...
	public void takeHit(Monster theMonsterWhoHits) {
		
		float factor = 1.0f; 
		
		//2,0
		switch (theMonsterWhoHits.getType()) {
		case "fire":
			if (this.getType().equals("grass")) {
				factor = 2f;
			}
			if (this.getType().equals("water")) {
				factor = 0.5f;
			}
			break;
		case "water":
			if (this.getType().equals("fire")) {
				factor = 2f;
			}
			if (this.getType().equals("grass")) {
				factor = 0.5f;
			}
			break;
		case "grass":
			if (this.getType().equals("water")) {
				factor = 2f;
			}
			if (this.getType().equals("fire")) {
				factor = 0.5f;
			}
			break;
			
		default:
			break;
		}
		
		
		
		// cast is needed because of the float: case --> (int)(was gecastet wird...)
		this.setLife((int)(this.getLife() - theMonsterWhoHits.getDamage() * factor));
		// theM --> getDamage...
		// Attacker --> makes Damage and the 
		
		
		if (this.getLife() > 0) {
			System.out.println(this.getName() + " has " + this.getLife() +" points remaining.");
		} else {
			System.out.println(this.getName() + " got hit with " + ((int)(theMonsterWhoHits.getDamage() * factor)) + " points.");
		}
		
	}
	
}
