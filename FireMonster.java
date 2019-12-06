
public class FireMonster extends Monster{

	public FireMonster(String name, int damage, int life) {
		super(name, damage, life, "fire");
		
		//Instanzvariable
		//this.type = "fire"; --> Dies gehört in die Ober-Type, also Monster!
		// Der sorgt selbständig für seinen Startwert!
		
	}
 
	
}
