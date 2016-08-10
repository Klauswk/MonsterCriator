package Classes;
import java.util.Random;

public class Heroi {
	private int VidaMax;
	private int Ataque;
	private int Defesa;
	private int VidaAtual;
	private double Xpproximolevel;
	private int Xp;
	private int level;
	private double dinheiro;
	private Item Arma;
	private Item Armadura;
	private Item Calça;
	private Item Bota;
	private Item Capacete;
	private Item Escudo;
	private String Nome;
	private int Velocidade;
	private Aptidao espadaAptidao;
	private Aptidao machadoAptidao;
	private Aptidao escudoAptidao;

	public Heroi()
	{
		
	}
	

	
	public Heroi(int vidaMax, int ataque, int defesa,int xp, int level, double dinheiro, Item arma, Item armadura,
			Item calça, Item bota, Item capacete, Item escudo, String nome,
			int velocidade, Aptidao espadaAptidao, Aptidao machadoAptidao,
			Aptidao escudoAptidao) {
		super();
		VidaMax = vidaMax;
		setVidaAtual(vidaMax);
		Ataque = ataque;
		Defesa = defesa;
		Xp = xp;
		this.level = level;
		this.dinheiro = dinheiro;
		Arma = arma;
		Armadura = armadura;
		Calça = calça;
		Bota = bota;
		Capacete = capacete;
		Escudo = escudo;
		Nome = nome;
		Velocidade = velocidade;
		this.espadaAptidao = espadaAptidao;
		this.machadoAptidao = machadoAptidao;
		this.escudoAptidao = escudoAptidao;
		setXpproximolevel();
	}


	public void setNome(String aux)
	{
		Nome = aux;
	}
	public String getNome()
	{
		return Nome;
	}
	public void setLevel(int aux)
	{
		level = aux;
	}
	public int getLevel()
	{
		return level;
	}
	
	public void setDinheiro(double aux)
	{
		dinheiro = aux;
	}
	public double getDinheiro()
	{
		return dinheiro;
	}
	public void incrementaDinheiro(double acrescimo)
	{
		acrescimo = acrescimo + getDinheiro();
		setDinheiro(acrescimo);
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
	public void setXpproximolevel()
	{
		double aux;
		aux = level;
		aux = (50 * (level) * (level) * (level) - 150 * (level) * (level) + 400 * (level)) / 3;
		Xpproximolevel = aux;
	}
	public double getXpproximolevel()
	{
		return Xpproximolevel;
	}
	public void setXp(int aux)
	{
		Xp = aux;
	}
	public int getXptotal()
	{
		return Xp;
	}
	public void setVidaAtual(int aux)
	{
		VidaAtual = aux;
	}
	public int getVidaAtual()
	{
		return VidaAtual;
	}
	
	public void IncrementaXp(int Exp)
	{
		int aux = getXptotal() + Exp;
		setXp(aux);
	}
	public boolean Upar()
	{
		int aux;
		Random random = new Random();
			if(getXptotal() >= getXpproximolevel())
			{
				level++;
				setVidaMax(VidaMax +10);
				aux = getAtaque() + random.nextInt(5);
				setAtaque(aux);
				aux = getDefesa() + random.nextInt(5);
				setDefesa(aux);
				aux = getVelocidade() + random.nextInt(5);
				setVelocidade(aux);
				setXp(0);
				setXpproximolevel();
				return true;
			}
		return false;
	}
	
	public int tomardano(int dano)
	{
		int aux = getVidaAtual() - dano;
		setVidaAtual(aux);
		return dano;
	}
	
	public Item getArmadura() {
		return Armadura;
	}

	public void setArmadura(Item armadura) {
		Armadura = armadura;
	}

	public Item getCalça() {
		return Calça;
	}

	public void setCalça(Item calça) {
		Calça = calça;
	}

	public Item getBota() {
		return Bota;
	}

	public void setBota(Item bota) {
		Bota = bota;
	}

	public Item getCapacete() {
		return Capacete;
	}

	public void setCapacete(Item capacete) {
		Capacete = capacete;
	}

	public Item getArma() {
		return Arma;
	}

	public void setWeapon(Item arma) {
		Arma = arma;
	}
	public Item getEscudo() {
		return Escudo;
	}

	public void setEscudo(Item escudo) {
		Escudo = escudo;
	}

	public Aptidao getEspadaAptidao() {
		return espadaAptidao;
	}



	public void setEspadaAptidao(Aptidao espadaAptidao) {
		this.espadaAptidao = espadaAptidao;
	}



	public Aptidao getMachadoAptidao() {
		return machadoAptidao;
	}



	public void setMachadoAptidao(Aptidao machadoAptidao) {
		this.machadoAptidao = machadoAptidao;
	}



	public Aptidao getEscudoAptidao() {
		return escudoAptidao;
	}



	public void setEscudoAptidao(Aptidao escudoAptidao) {
		this.escudoAptidao = escudoAptidao;
	}



	public int getVelocidade() {
		return Velocidade;
	}

	public void setVelocidade(int velocidade) {
		Velocidade = velocidade;
	}

	public void Equipa(Item aux)
	{
		switch (aux.getTipo())
		{
		
		case 0:
			setArmadura(aux);
			break;
		case 1:
			setCalça(aux);
			break;
		
		case 2:
			setBota(aux);
			break;
			
		case 3:
			setCapacete(aux);
			break;
		
		case 4:
			setWeapon(aux);
			break;
		
		case 5:
			setWeapon(aux);
			break;
				
		case 6:
			setEscudo(aux);
			break;
		
		}
	}
	
	
	public int ModificadorAtk()
	{
		if(Arma.getTipo()==4)
		{
			return Arma.getDano() + Armadura.getDano() + Calça.getDano() + Bota.getDano() + Capacete.getDano() + espadaAptidao.getBoostAtk();
		}
		else if(Arma.getTipo() == 5)
		{
			return Arma.getDano() + Armadura.getDano() + Calça.getDano() + Bota.getDano() + Capacete.getDano() + machadoAptidao.getBoostAtk();
		}
		else
		{
			return Arma.getDano() + Armadura.getDano() + Calça.getDano() + Bota.getDano() + Capacete.getDano();
		}
		
	}
	
	public int ModificadorDef()
	{
		if(Arma.getTipo()==4)
		{
			return Arma.getDefesa() + Armadura.getDefesa() + Calça.getDefesa() + Bota.getDefesa() + Capacete.getDefesa()+ espadaAptidao.getBoostDef();	
		}
		else if(Arma.getTipo()==5)
		{
			return Arma.getDefesa() + Armadura.getDefesa() + Calça.getDefesa() + Bota.getDefesa() + Capacete.getDefesa() + machadoAptidao.getBoostDef();
		}
		else
		{
			return Arma.getDefesa() + Armadura.getDefesa() + Calça.getDefesa() + Bota.getDefesa() + Capacete.getDefesa();
		}
	}
	
	public int ModificadorSpd()
	{
		if(Arma.getTipo()==4)
		{
			return Arma.getVelocidade() + Armadura.getVelocidade() + Calça.getVelocidade() + Bota.getVelocidade() + Capacete.getVelocidade()+ espadaAptidao.getBoostSpd();	
		}
		else if(Arma.getTipo()==5)
		{

			return Arma.getVelocidade() + Armadura.getVelocidade() + Calça.getVelocidade() + Bota.getVelocidade() + Capacete.getVelocidade()+ machadoAptidao.getBoostSpd();}
		
		else
		{
			return Arma.getVelocidade() + Armadura.getVelocidade() + Calça.getVelocidade() + Bota.getVelocidade() + Capacete.getVelocidade();
		}
		}
	}
