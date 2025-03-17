
public class Main {
	public static void main(String[] args) {

		// Este patron se encarga de "decorar" a las clases.
		// nos referimos con decorar porque podemos tanto como agregar funcionalidades o
		// atributos extra.
		// la logica detras de decorator es tener una abstraccion de elemento el cual
		// puede ser referenciado hacia "decoradores" el cual tambien siguen la ley de
		// abstraccion del elemento decorado.
		// osea que el elemento decorado puede tener distintas cadenas de decoradores
		// todas apuntando finalmente hacia el elemento decorado.
		System.out.println("A un enemigo le haran X de daño");
		System.out.println("Si tienen casco se le multiplicara el daño por 0.8");
		System.out.println("Si tienen armadura se le multiplicara el daño por 0.3");
		System.out.println("Si tienen botas cuando el enemigo caiga se multiplicara el daño por la altura y 0.5");
		System.out.println("Al recibir daño de todos sus componentes se desgastan un 50%");
		System.out.println("1) ");

		IEnemy enemy = new BaseEnemy();
		enemy.takeDamage(20);
		// como un enemigo con casco sigue siendo un enemigo simplemente debemos de
		// referenciar el nuevo casco con el enemigo para que el casco "apunte" hacia
		// nuestra instancia.

		IEnemy enemyWithHelmet = new HelmetDecorator(enemy);
		enemyWithHelmet.takeDamage(10);
		// nuestro enemigo ahora tiene un decorador casco que apunta hacia él por lo
		// tanto cuando le hagan daño al casco podremos amortiguar la cantidad de daño.

		IEnemy enemyWithHelmetAndArmour = new ArmourDecorator(enemyWithHelmet);
		enemyWithHelmetAndArmour.takeDamage(30);
		// armadura.takeDamage(20) ---> casco.takeDamage(un valor) -----> enemigo.takeDamage(un valor) .
		// agregamos otro decorador más pero estab vez una armadura para esto debemos
		// hacer que apunte al casco para que despues apunte al enemigo y asi amortiguar
		// aun más el daño o simplemente dañar la armadura (funcionalidad extra)

		IEnemy enemyWithOtherHelmet = new HelmetDecorator(enemy);
		enemyWithOtherHelmet.takeDamage(50);
		// este seria otra rama es como si tuviese un casco que no esta usando o podria
		// ser un casco en otra parte del enemigo que afecte a otra zona.
		// aun asi sigue apuntando hacia el enemigo pero en otra rama de ejecucion.

	}
}
