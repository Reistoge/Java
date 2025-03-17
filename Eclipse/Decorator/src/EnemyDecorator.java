
public abstract class EnemyDecorator implements IEnemy{
	// el decorador.
	float desgaste;
	protected IEnemy enemy;
	protected EnemyDecorator(IEnemy e) {
		this.desgaste=1;
		this.enemy=e;
	}
	@Override
	public abstract float takeDamage(float damage);
}
