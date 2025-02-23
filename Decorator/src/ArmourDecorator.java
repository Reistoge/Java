
public class ArmourDecorator extends EnemyDecorator{
	float attack,defense;
	
	String color;
	public float getAttack() {
		return attack;
	}

	public void setAttack(float attack) {
		this.attack = attack;
	}

	public float getDefense() {
		return defense;
	}

	public void setDefense(float defense) {
		this.defense = defense;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	protected ArmourDecorator(IEnemy e) {
		super(e);
		this.attack=5;
		this.defense=3;
		// TODO Auto-generated constructor stub
	}

	@Override
	public float takeDamage(float damage) {
		this.desgaste-=0.5f;
		System.out.println("le hacen daño a la armadura ---> *0.3 el daño recibido");
		return this.enemy.takeDamage(damage*(defense/100));
		
	}

 
}
