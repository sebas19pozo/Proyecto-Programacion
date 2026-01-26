package principal;

public class Personaje {
	
	//Atributos del Jugador
	protected int vida;
	protected int energia;
	protected double dinero;
	protected int manaBase;
	protected int ataque;
	protected int inteligencia;
	protected int nivel;
	protected double experiencia;
	protected int puntosDeMejora;
	protected double expMax;
	
	
	


	public Personaje(int vida, int energia, double dinero, int manaBase, int ataque, int inteligencia, int nivel,
			double experiencia, int puntosDeMejora, double expMax) {
		super();
		this.vida = vida;
		this.energia = energia;
		this.dinero = dinero;
		this.manaBase = manaBase;
		this.ataque = ataque;
		this.inteligencia = inteligencia;
		this.nivel = nivel;
		this.experiencia = experiencia;
		this.puntosDeMejora = puntosDeMejora;
		this.expMax=expMax;
	}


	//GETTERS Y SETTERS
	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getEnergia() {
		return energia;
	}

	public void setEnergia(int energia) {
		this.energia = energia;
	}

	public double getDinero() {
		return dinero;
	}

	public void setDinero(double dinero) {
		this.dinero = dinero;
	}

	public int getManaBase() {
		return manaBase;
	}

	public void setManaBase(int manaBase) {
		this.manaBase = manaBase;
	}
	
	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public int getInteligencia() {
		return inteligencia;
	}

	public void setInteligencia(int inteligencia) {
		this.inteligencia = inteligencia;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public double getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(double experiencia) {
		experiencia = experiencia;
	}

	public int getPuntosDeMejora() {
		return puntosDeMejora;
	}

	public void setPuntosDeMejora(int puntosDeMejora) {
		this.puntosDeMejora = puntosDeMejora;
	}

	public double getExpMax() {
		return expMax;
	}

	public void setExpMax(double expMax) {
		this.expMax = expMax;
	}


	
	
	//***********************METODOS*************************
	
	
	
	//Esto devuelve la cantidad de mana modificada por la estadistica de inteligencia
	protected int getManaMaximo () {
		return manaBase = (inteligencia * 10);
	}
	
	//Metodo subida de Nivel
	protected int levelUp(double experiencia) {
		
		if(getExperiencia()>=getExpMax()) {
			
			expMax *=1.15;
			puntosDeMejora+=3;
	
		}
		return puntosDeMejora;
	}
	
	//METODO DE ATAQUE
	
	protected void atacar(int ataque) {
		
		System.out.println("Haz atacado ");
		
	}
	
}
	
	