 

public class Personaje {
	String nombre,clase;

	
	float vida,mana,destreza,inteligencia,exp,escudo,ataque=-1;
	
	float vidaInicial,manaI,destrezaI,inteligenciaI,escudoI,ataqueI;
	boolean vivo;
	int nivel;
	String[] datos;
	public Personaje(String [] d,String c){
		vivo=true;
		datos=d;
		nombre=d[0];
		clase=c;
		nivel=1;
		vidaInicial=Float.parseFloat(d[1]) ;
		if(c.equals("mago")) {
			vida=Float.parseFloat(d[1]) ;
			mana=Float.parseFloat(d[2]);
			manaI=Float.parseFloat(d[2]);
			ataque=Float.parseFloat(d[3]);
			ataqueI=Float.parseFloat(d[3]);
			inteligencia=Float.parseFloat(d[4]);
			inteligenciaI=Float.parseFloat(d[4]);
			
			
		}
		else if(c.equals("clerigo")) {
			vida=Float.parseFloat(d[1]);
			mana=Float.parseFloat(d[2]);
			manaI=Float.parseFloat(d[2]);
			inteligencia=Float.parseFloat(d[3]);
			inteligenciaI=Float.parseFloat(d[3]);
		}
		else if(c.equals("cazador")) {
			vida=Float.parseFloat(d[1]);
			ataque=Float.parseFloat(d[2]);
			ataqueI=Float.parseFloat(d[2]);
			destreza=Float.parseFloat(d[3]);
			destrezaI=Float.parseFloat(d[3]);
		}
		else if(c.equals("guerrero")) {
			vida=Float.parseFloat(d[1]);
			escudo=Float.parseFloat(d[2]);
			escudoI=Float.parseFloat(d[2]);
			ataque=Float.parseFloat(d[3]);
			ataqueI=Float.parseFloat(d[3]);
		}
		
		
	}
	@Override
	public String toString() {
		return "Personaje [nombre=" + nombre + ", clase=" + clase + ", vida=" + vida + ", mana=" + mana + ", destreza="
				+ destreza + ", inteligencia=" + inteligencia + ", exp=" + exp + ", escudo=" + escudo + ", ataque="
				+ ataque + ", vivo=" + vivo + ", nivel=" + nivel + "]";
	}
	
	public float getAtaque() {
		return ataque;
	}
	public void setAtaque(float ataque) {
		this.ataque = ataque;
	}
	public void accion() {
		
	}
	public String MostrarAtributos() {
			if(this.clase.equals("mago")) {
				return "Mago "+this.nombre+": \n"
						+ "nivel: "+this.nivel+"\n"
						+ "vivo: "+this.vivo+"\n"
						+ "vida: "+this.vida+ "\n"
						+ "mana: "+this.mana+"\n"
						+ "ataque: "+this.ataque+"\n"
						+ "inteligencia: "+this.inteligencia;
						
			}
			else if(this.clase.equals("clerigo")) {
				return "Clerigo "+this.nombre+": \n"
						+ "nivel: "+this.nivel+"\n"
						+ "vivo: "+this.vivo+"\n"
						+ "vida: "+this.vida+ "\n"
						+ "mana: "+this.mana+"\n"
						+ "inteligencia: "+this.inteligencia;
				
			}
			else if(this.clase.equals("cazador")) {
				return "Cazador "+this.nombre+": \n"
						+ "nivel: "+this.nivel+"\n"
						+ "vivo: "+this.vivo+"\n"
						+ "vida: "+this.vida+ "\n"
						+ "ataque: "+this.ataque+"\n"
						+ "destreza: "+this.destreza;
				
			}
			else if(this.clase.equals("guerrero")) {
				return "Guerrero "+this.nombre+": \n"
						+ "nivel: "+this.nivel+"\n"
						+ "vivo: "+this.vivo+"\n"
						+ "vida: "+this.vida+ "\n"
						+ "ataque: "+this.ataque+"\n"
						+ "escudo: "+this.escudo;
				
			}
			return "";
	 
	}
	public void curar(Personaje P) {
		float currentVida=P.getVida();
		float formula=this.inteligencia+(0.3f*mana);
		P.setVida(currentVida+ (int) formula);
		System.out.println(this.nombre+"cura "+ formula+" puntos de vida a "+P.getNombre());
		System.out.println(P.getClase()+" "+P.getNombre()+ " ahora tiene "+P.getVida()+"puntos de vida  ");
	}
	public void atacar(Mapache M) {
		int currentVida=(int) M.getVida();
		if(this.clase.equals("mago")){
			int formula=(int) (this.ataque+(0.5f*this.inteligencia));
			System.out.println("Mago "+this.nombre+" Ataca a Mapache"+M.getN());
			M.setVida(currentVida-formula);
			System.out.println("Mapache "+ M.getN()+" recibe "+formula+" puntos de daño! ");
		}
		else if(this.clase.equals("cazador")) {
			int formula=(int) (this.ataque+(0.8f*this.destreza));
			System.out.println("Cazador "+this.nombre+" Ataca a Mapache"+M.getN());
			M.setVida(currentVida-formula);
			System.out.println("Mapache "+ M.getN()+" recibe "+formula+" puntos de daño! ");
		}
		else if(this.clase.equals("guerrero")) {
			int formula=(int) (this.ataque+(0.8f*this.escudo));
			System.out.println("Guerrero "+this.nombre+" Ataca a Mapache"+M.getN());
			M.setVida(currentVida-formula);
			System.out.println("Mapache "+ M.getN()+" recibe "+formula+" puntos de daño! ");
		}
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getClase() {
		return clase;
	}
	public void setClase(String clase) {
		this.clase = clase;
	}
	public float getVida() {
		return vida;
	}
	public void setVida(float vida) {
		if(vida>=vidaInicial) {
			vida=vidaInicial;
		}
		if(vida<=0) {
			this.vivo=false;
			vida=0;
		}
		this.vida = vida;
	}
	public float getMana() {
		return mana;
	}
	public void setMana(float mana) {
		this.mana = mana;
	}
	public float getDestreza() {
		return destreza;
	}
	public void setDestreza(float destreza) {
		this.destreza = destreza;
	}
	public float getInteligencia() {
		return inteligencia;
	}
	public void setInteligencia(float inteligencia) {
		this.inteligencia = inteligencia;
	}
	public float getExp() {
		return exp;
	}
	public void setExp(float exp) {
		
		this.exp = exp;
		if(this.exp>=1000) {
			setNivel();
		}
	}
	public float isEscudo() {
		return escudo;
	}
	public void setEscudo(float escudo) {
		this.escudo = escudo;
	}
	public boolean isVivo() {
		return vivo;
	}
	public void setVivo(boolean vivo) {
		this.vivo = vivo;
	}
	public int getNivel() {
		return nivel;
	}
	public void setNivel() {
		
		this.nivel+=1;
		if(this.clase.equals("mago")) {
			 setMana((int) this.manaI*1.05f);
			 setAtaque((int) this.ataqueI*1.05f);
			 setInteligencia((int) this.inteligencia*1.05f);
		}
		else if(this.clase.equals("clerigo")) {
			setMana((int) this.manaI*1.05f);
			setInteligencia((int) this.inteligenciaI*1.05f);
			
		}
		else if(this.clase.equals("cazador")) {
			setAtaque((int) this.ataqueI*1.05f);
			setDestreza((int) this.destrezaI*1.05f);
			 
		}
		else if(this.clase.equals("guerrero")) {
			setAtaque((int) this.ataqueI*1.05f);
			 if(this.escudo>0) {
				 setEscudo((int) this.escudoI*1.05f);
			 }
			
		}
		
	}
	
}
