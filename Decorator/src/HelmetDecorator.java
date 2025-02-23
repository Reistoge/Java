
public class HelmetDecorator extends EnemyDecorator{
	protected HelmetDecorator(IEnemy e) {
		super(e);
	}

	float defense;
 
	public float getDefense() {
		return defense;
	}

	public void setDefense(float defense) {
		this.defense = defense;
		this.desgaste=0;
	}

	@Override
	public float takeDamage(float damage) {
		this.desgaste-=0.5f;
		System.out.println("Le hacen daño al casco ---> *0.8 daño recibido");
		
		return this.enemy.takeDamage(damage*0.8f);
	}

}
