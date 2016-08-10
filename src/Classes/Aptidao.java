package Classes;


public class Aptidao {
	
	private String Nome;
	private int Level;
	private float xp;
	private int boostAtk;
	private int boostDef;
	private int boostSpd;
	private double next;
	
	public Aptidao(String nome, int level, float xp, int boostAtk,
			int boostDef, int boostSpd) {
		super();
		Nome = nome;
		Level = level;
		this.xp = xp;
		this.boostAtk = boostAtk;
		this.boostDef = boostDef;
		this.boostSpd = boostSpd;
		experienceForLevel();
	}

	public String getNome() {
		return Nome;
	}




	public void setNome(String nome) {
		Nome = nome;
	}




	public int getLevel() {
		return Level;
	}




	public void setLevel(int level) {
		Level = level;
	}




	public float getXp() {
		return xp;
	}




	public void setXp(float xp) {
		this.xp = xp;
	}




	public int getBoostAtk() {
		return boostAtk;
	}




	public void setBoostAtk(int boostAtk) {
		this.boostAtk = boostAtk;
	}




	public int getBoostDef() {
		return boostDef;
	}




	public void setBoostDef(int boostDef) {
		this.boostDef = boostDef;
	}




	public int getBoostSpd() {
		return boostSpd;
	}




	public void setBoostSpd(int boostSpd) {
		this.boostSpd = boostSpd;
	}




	public double getNext() {
		return next;
	}

	private void experienceForLevel()
	{
			double aux;
			aux = Level;
			aux = (50 * (Level) * (Level) * (Level) - 150 * (Level) * (Level) + 400 * (Level)) / 3;
			next = aux;
	}
	
	public void Upar()
	{
			if(xp >= next)
			{
				Level++;
				experienceForLevel();
				boostAtk+=1;
				boostDef+=1;
				boostSpd+=1;
				xp = 0;
			}
	}
	
	public void incrementaXp(int incrementa)
	{
		xp = xp + incrementa;
		Upar();
	}


	
}
