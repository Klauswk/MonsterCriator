package Classes;

public class Item {
		String Nome;
		String Id;
		int Dano;
		int Defesa;
		int Velocidade;
		int Vida;
		int Tipo;
		int preco;
		int pos;

		String Descricao;
		
		public Item()
		{
			
		}
		public Item(String id , int POS ,String nome, int dano, int defesa, int velocidade, int tipo, String descricao)
		{
			setId(id);
			setNome(nome);
			setDano(dano);
			setDefesa(defesa);
			setVelocidade(velocidade);
			setTipo(tipo);
			setPos(POS);
			setDescricao(descricao);
		}
		
		public Item(String id , String nome, int dano, int defesa, int velocidade, int tipo, String descricao)
		{
			setId(id);
			setNome(nome);
			setDano(dano);
			setDefesa(defesa);
			setVelocidade(velocidade);
			setTipo(tipo);
			setDescricao(descricao);
		}
		
		public int getTipo() {
			return Tipo;
		}
		public void setTipo(int tipo) {
			Tipo = tipo;
		}
		public String getNome() {
			return Nome;
		}
		public void setNome(String nome) {
			Nome = nome;
		}
		public int getDano() {
			return Dano;
		}
		public void setDano(int dano) {
			Dano = dano;
		}
		public int getDefesa() {
			return Defesa;
		}
		public void setDefesa(int defesa) {
			Defesa = defesa;
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
		public int getVida() {
			return Vida;
		}
		public void setVida(int vida) {
			Vida = vida;
		}
		public String getDescricao() {
			return Descricao;
		}
		public void setDescricao(String descricao) {
			Descricao = descricao;
		}
		public int getPreco() {
			return preco;
		}
		public void setPreco(int preco) {
			this.preco = preco;
		}
		public int getPos() {
			return pos;
		}
		public void setPos(int pos) {
			this.pos = pos;
		}
		

}
