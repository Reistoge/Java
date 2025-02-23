
public class BaseEnemy implements IEnemy{
	
	@Override
	public float takeDamage(float damage) {
		
		System.out.println("Le han hecho "+damage+" de daño al enemigo");
		return damage;
		
	}

}
