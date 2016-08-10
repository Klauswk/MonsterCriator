package Classes;


import java.util.Random;

public class Monstro {
	private String Id;
	private int VidaMax;
	private int Ataque;
	private int Defesa;
	private int Velocidade;
	private int VidaAtual;
	private int Level;
	private double Dinheiro;
	private int XpDada;
	private String Nome;
	private String Loot;
	private int Fraqueza;
	
	public Monstro()
	{
		
	}
	
	public Monstro(String nome, int Level, int vida, int ataque, int defesa,int velocidade ,double dinheiro, int Xpdada)
	{
		setNome(nome);
		setVidaMax(vida+2*Level);
		setAtaque(ataque+2*Level);
		setDefesa(defesa+2*Level);
		setDinheiro(dinheiro+2*Level);
		setXpDada(Xpdada);
	}
	
	public Monstro(String nome,String ID,int level, int vida, int ataque, int defesa,int velocidade ,int fraqueza,double dinheiro, int xpdada, String loot)
	{
		setNome(nome);
		setId(ID);
		setLevel(level);
		setVidaMax(vida);
		setAtaque(ataque);
		setDefesa(defesa);
		setVelocidade(velocidade);
		setDinheiro(dinheiro);
		setXpDada(xpdada);
		setFraqueza(fraqueza);
		setLoot(loot);
	}
	public void setLevel(int aux)
	{
		Level = aux;
	}
	public int getLevel()
	{
		return Level;
	}
	
	public void setNome(String aux)
	{
		Nome = aux;
	}
	public String getNome()
	{
		return Nome;
	}
	
	public void setXpDada(int aux)
	{
		XpDada = aux;
	}
	public int getXpdada()
	{
		return XpDada;
	}
	
	public void setDinheiro(double aux)
	{
		Dinheiro = aux;
	}
	public double getDinheiro()
	{
		return Dinheiro;
	}
	
	public void setAtaque(int aux)
	{
		Ataque = aux;
	}
	public int getAtaque()
	{
		return Ataque;
	}
	public void setDefesa(int aux)
	{
		Defesa = aux;
	}
	public int getDefesa()
	{
		return Defesa;
	}
	public void setVidaMax(int aux)
	{
		VidaMax = aux;
		setVidaAtual(aux);
	}
	public int getVidaMax()
	{
		return VidaMax;
	}
	public void setVidaAtual(int aux)
	{
		VidaAtual = aux;
	}
	public int getVidaAtual()
	{
		return VidaAtual;
	}
	
	public int getVelocidade() {
		return Velocidade;
	}

	public void setVelocidade(int velocidade) {
		Velocidade = velocidade;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public int tomardano(int dano)
	{
		int aux = getVidaAtual() - dano;
		setVidaAtual(aux);
		return dano;
	}
	public void atribui()
	{
		setNome(Nome);
		setVidaMax(VidaMax+2*(Level+3));
		setAtaque(Ataque+2*(Level+3));
		setDefesa(Defesa+2*(Level+3));
		setDinheiro(Dinheiro+2*(Level+3));
		setXpDada(XpDada+(Level+3));
	}
	public void setLoot(String id)
	{
		Loot = id;
	}
	public String getLoot()
	{
		return Loot;
	}
	
	public int getFraqueza() {
		return Fraqueza;
	}

	public void setFraqueza(int fraqueza) {
		Fraqueza = fraqueza;
	}
	
	public void setFraqueza(String fraqueza) {
		if(fraqueza == "Espada")
		{
			Fraqueza = 4; 
		}
		else if(fraqueza == "Machado")
		{
			Fraqueza = 5;
			
		}
		else if(fraqueza == "Clava")
		{
			Fraqueza = 8;
			
		}
		else if(fraqueza == "Fogo")
		{
			Fraqueza = 9;
			
		}else if(fraqueza == "Gelo")
		{
			Fraqueza = 10;
			
		}else if(fraqueza == "Eletricidade")
		{

			Fraqueza = 11;
			
		}
	}

	public void AdicionarLoot(String id)
	{
		Loot = Loot + "#" + id; 
	}
	
}
