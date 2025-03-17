
public class BotasDecorator extends EnemyDecorator{
	protected BotasDecorator(IEnemy e) {
		super(e);
		// TODO Auto-generated constructor stub
	}

	@Override
	public float takeDamage(float damage) {
		
		return enemy.takeDamage(damage);
	}
	public float dañoPorCaida(float altura) {
		
		return altura*0.5f*9.8f;
	}
	

}
