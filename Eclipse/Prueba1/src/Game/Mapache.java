package Game;

public class Mapache {
	int n;
	boolean vivo;
	float vida,ataque;
	float vidaInicial;
	public Mapache(int n,float v, float a) {
		vida=v;
		vidaInicial=v;
		this.n=n;
		ataque=a;
	}
	public int getN() {
		return n;
	}
	public void setN(int n) {
		this.n = n;
	}
	public void atacar(Personaje p) {
		if(this.ataque>p.vidaInicial*0.6) {
			System.out.println("DAÑO SEVERO A TU "+p.getClase() +" "+p.getNombre());
		}
		p.setVida(p.getVida()-this.ataque);
		System.out.println(" Mapache ataca a "+p.getClase() +" "+p.getNombre()+"restandole "+this.ataque+ "puntos de vida");
		 
	}
	public boolean isVivo() {
		return vivo;
	}
	public void setVivo(boolean vivo) {
		this.vivo = vivo;
	}
	public float getVida() {
		return vida;
	}
	public void setVida(float vida) {
		this.vida = vida;
		if(vida> 0.7f*vidaInicial) {
			System.out.println("Has dañado severamente a mapache "+this.n);
		}
		
	}
	public float getAtaque() {
		return ataque;
	}
	public void setAtaque(float ataque) {
		this.ataque = ataque;
	}
}	
