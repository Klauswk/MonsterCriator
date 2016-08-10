package Janelas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Toolkit;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.ImageIcon;

import Classes.Item;
import Classes.Monstro;

@SuppressWarnings("serial")
public class CriaMonstro extends JFrame {

	private JPanel contentPane;
	private JTextField tfVelocidade;
	private JTextField tfDefesa;
	private JTextField tfAtaque;
	private JTextField tfId;
	private JTextField tfNome;
	private JTextField tfVida;
	private JTextField tfXp;
	private JTextField tfLevel;
	private JTextField tfProcura;
	private JTextField tfProcuraNome;
	private JTextField tfProcuraDescricao;
	private JTextField tfProcuraId;
	private JTextField tfProcuraAtaque;
	private JTextField tfProcuraDefesa;
	private JTextField tfProcuraVelocidade;
	private Vector <Item> items = new Vector<Item>();
	private JTextField tfProcuraTipo;
	private Monstro monstro = new Monstro();
	private Vector <Item> Loot = new Vector<Item>();
	JComboBox<String> cbLoot = new JComboBox<String>();
	int pos=0;
	private JTextField tfDinheiro;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CriaMonstro frame = new CriaMonstro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CriaMonstro() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		setIconImage(Toolkit.getDefaultToolkit().getImage("src/Imagens/Icon.png"));
		setAutoRequestFocus(false);
		setTitle("Criador de Monstros");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JInternalFrame internalFrame = new JInternalFrame("Procurar...");
		internalFrame.setFrameIcon(new ImageIcon("src/Imagens/Icon.png"));
		internalFrame.setClosable(true);
		internalFrame.setMaximizable(true);
		internalFrame.setIconifiable(true);
		try {
			internalFrame.setIcon(true);
		} catch (PropertyVetoException e1) {
			e1.printStackTrace();
		}
		internalFrame.setBounds(234, 117, 442, 273);
		contentPane.add(internalFrame);
		internalFrame.getContentPane().setLayout(null);
		
		JLabel lblDigiteONome = new JLabel("Digite o Nome do Item:");
		lblDigiteONome.setBounds(10, 11, 117, 14);
		internalFrame.getContentPane().add(lblDigiteONome);
		
		final JComboBox<String> cbFraqueza = new JComboBox<String>();
		cbFraqueza.setBounds(70, 120, 86, 22);
		contentPane.add(cbFraqueza);
		cbFraqueza.addItem("Espada");
		cbFraqueza.addItem("Machado");
		cbFraqueza.addItem("Clava");
		cbFraqueza.addItem("Fogo");
		cbFraqueza.addItem("Gelo");
		cbFraqueza.addItem("Eletricidade");
		
		final JComboBox<String> cbProcurarPor = new JComboBox<String>();
		cbProcurarPor.setBounds(246, 7, 67, 22);
		cbProcurarPor.addItem("id");
		cbProcurarPor.addItem("nome");
		cbProcurarPor.addItem("tipo");
		cbProcurarPor.addItem("descricao");
		internalFrame.getContentPane().add(cbProcurarPor);
		tfProcura = new JTextField();
		tfProcura.setBounds(127, 8, 117, 20);
		internalFrame.getContentPane().add(tfProcura);
		tfProcura.setColumns(10);
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					ProcuraItem(tfProcura.getText(),cbProcurarPor.getSelectedItem().toString());
			}
		});
		btnProcurar.setBounds(323, 7, 91, 23);
		internalFrame.getContentPane().add(btnProcurar);
		
		JLabel label_1 = new JLabel("Nome: ");
		label_1.setBounds(10, 42, 75, 14);
		internalFrame.getContentPane().add(label_1);
		
		tfProcuraNome = new JTextField();
		tfProcuraNome.setEditable(false);
		tfProcuraNome.setColumns(10);
		tfProcuraNome.setBounds(70, 39, 86, 20);
		internalFrame.getContentPane().add(tfProcuraNome);
		
		tfProcuraDescricao = new JTextField();
		tfProcuraDescricao.setEditable(false);
		tfProcuraDescricao.setColumns(10);
		tfProcuraDescricao.setBounds(234, 39, 86, 20);
		internalFrame.getContentPane().add(tfProcuraDescricao);
		
		JLabel label_2 = new JLabel("ID: ");
		label_2.setBounds(10, 67, 46, 14);
		internalFrame.getContentPane().add(label_2);
		
		tfProcuraId = new JTextField();
		tfProcuraId.setEditable(false);
		tfProcuraId.setColumns(10);
		tfProcuraId.setBounds(70, 61, 86, 20);
		internalFrame.getContentPane().add(tfProcuraId);
		
		tfProcuraAtaque = new JTextField();
		tfProcuraAtaque.setEditable(false);
		tfProcuraAtaque.setColumns(10);
		tfProcuraAtaque.setBounds(70, 86, 86, 20);
		internalFrame.getContentPane().add(tfProcuraAtaque);
		
		JLabel label_3 = new JLabel("Ataque:");
		label_3.setBounds(10, 89, 75, 14);
		internalFrame.getContentPane().add(label_3);
		
		JLabel label_5 = new JLabel("Defesa:");
		label_5.setBounds(10, 110, 75, 14);
		internalFrame.getContentPane().add(label_5);
		
		tfProcuraDefesa = new JTextField();
		tfProcuraDefesa.setEditable(false);
		tfProcuraDefesa.setColumns(10);
		tfProcuraDefesa.setBounds(70, 107, 86, 20);
		internalFrame.getContentPane().add(tfProcuraDefesa);
		
		tfProcuraVelocidade = new JTextField();
		tfProcuraVelocidade.setEditable(false);
		tfProcuraVelocidade.setColumns(10);
		tfProcuraVelocidade.setBounds(70, 128, 86, 20);
		internalFrame.getContentPane().add(tfProcuraVelocidade);
		
		JLabel label_6 = new JLabel("Velocidade:");
		label_6.setBounds(10, 131, 75, 14);
		internalFrame.getContentPane().add(label_6);
		
		JLabel lbProcuraDescricao = new JLabel("Descri\u00E7\u00E3o");
		lbProcuraDescricao.setBounds(166, 42, 46, 14);
		internalFrame.getContentPane().add(lbProcuraDescricao);
		
		JButton btnProximo = new JButton("Proximo");
		btnProximo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pos++;
				if(pos > (items.size()-1))
				{
					pos = 0;
			      	tfProcuraNome.setText(items.get(pos).getNome());
			        tfProcuraAtaque.setText(String.valueOf(items.get(pos).getDano()));
			        tfProcuraDefesa.setText(String.valueOf(items.get(pos).getDefesa()));
			        tfProcuraVelocidade.setText(String.valueOf(items.get(pos).getVelocidade()));
			        tfProcuraId.setText(items.get(pos).getId());
			        tfProcuraDescricao.setText(items.get(pos).getDescricao());
			        tfProcuraTipo.setText(String.valueOf(items.get(pos).getTipo()));
				}
				else
				{
			      	tfProcuraNome.setText(items.get(pos).getNome());
			        tfProcuraAtaque.setText(String.valueOf(items.get(pos).getDano()));
			        tfProcuraDefesa.setText(String.valueOf(items.get(pos).getDefesa()));
			        tfProcuraVelocidade.setText(String.valueOf(items.get(pos).getVelocidade()));
			        tfProcuraId.setText(items.get(pos).getId());
			        tfProcuraDescricao.setText(items.get(pos).getDescricao());
			        tfProcuraTipo.setText(String.valueOf(items.get(pos).getTipo()));
					
				}
			}
		
	});
		btnProximo.setBounds(323, 41, 91, 23);
		internalFrame.getContentPane().add(btnProximo);
		
		JButton btnAnterior = new JButton("Anterior");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pos --;
				if(pos >= 0)
				{	
			      	tfProcuraNome.setText(items.get(pos).getNome());
			        tfProcuraAtaque.setText(String.valueOf(items.get(pos).getDano()));
			        tfProcuraDefesa.setText(String.valueOf(items.get(pos).getDefesa()));
			        tfProcuraVelocidade.setText(String.valueOf(items.get(pos).getVelocidade()));
			        tfProcuraId.setText(items.get(pos).getId());
			        tfProcuraDescricao.setText(items.get(pos).getDescricao());
			        tfProcuraTipo.setText(String.valueOf(items.get(pos).getTipo()));
				}
				else
				{
					pos = items.size()-1;
			      	tfProcuraNome.setText(items.get(pos).getNome());
			        tfProcuraAtaque.setText(String.valueOf(items.get(pos).getDano()));
			        tfProcuraDefesa.setText(String.valueOf(items.get(pos).getDefesa()));
			        tfProcuraVelocidade.setText(String.valueOf(items.get(pos).getVelocidade()));
			        tfProcuraId.setText(items.get(pos).getId());
			        tfProcuraDescricao.setText(items.get(pos).getDescricao());
			        tfProcuraTipo.setText(String.valueOf(items.get(pos).getTipo()));
					
				}
			    }
		});
		btnAnterior.setBounds(323, 63, 91, 23);
		internalFrame.getContentPane().add(btnAnterior);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(10, 155, 46, 14);
		internalFrame.getContentPane().add(lblTipo);
		
		tfProcuraTipo = new JTextField();
		tfProcuraTipo.setEditable(false);
		tfProcuraTipo.setBounds(70, 152, 86, 20);
		internalFrame.getContentPane().add(tfProcuraTipo);
		tfProcuraTipo.setColumns(10);
		
		JButton btnAdicionarLoot = new JButton("Adicionar Loot");
		btnAdicionarLoot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Loot.add(items.get(pos));
				atualizaComboBox();
				internalFrame.setVisible(false);
				Separador();
			}
		});
		btnAdicionarLoot.setBounds(345, 224, 91, 23);
		internalFrame.getContentPane().add(btnAdicionarLoot);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				if(tfNome.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Há um campo em Branco!!");
				}
				else if(tfId.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Há um campo em Branco!!");
				}
				else if(tfAtaque.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Há um campo em Branco!!");
				}
				else if(tfDefesa.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Há um campo em Branco!!");
				}
				else if(tfVelocidade.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Há um campo em Branco!!");
				}
				else if(tfXp.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Há um campo em Branco!!");
				}
				else if(tfDinheiro.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Há um campo em Branco!!");
				}
				else if(tfVida.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Há um campo em Branco!!");
				}
				else if(tfLevel.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Há um campo em Branco!!");
				}
				else
				{
					monstro.setVidaMax(Integer.parseInt(tfVida.getText().toString()));
					monstro.setLevel(Integer.parseInt(tfLevel.getText().toString()));
					monstro.setFraqueza(cbFraqueza.getSelectedItem().toString());
					monstro.setNome(tfNome.getText().toString());
					monstro.setId(tfId.getText().toUpperCase().toString());
					monstro.setAtaque(Integer.parseInt(tfAtaque.getText().toString()));
					monstro.setDefesa(Integer.parseInt(tfDefesa.getText().toString()));
					monstro.setVelocidade(Integer.parseInt(tfVelocidade.getText().toString()));
					monstro.setXpDada(Integer.parseInt(tfXp.getText().toString()));
					monstro.setDinheiro(Integer.parseInt(tfDinheiro.getText().toString()));
					monstro.setLoot(Separador());
					CriaOuAbre();
					InserirMonstro();
				}
			}
		});
		btnSalvar.setBounds(351, 250, 91, 23);
		contentPane.add(btnSalvar);
		
		JLabel label = new JLabel("Nome: ");
		label.setBounds(10, 14, 46, 14);
		contentPane.add(label);
		
		tfVelocidade = new JTextField();
		tfVelocidade.setColumns(10);
		tfVelocidade.setBounds(70, 100, 86, 20);
		contentPane.add(tfVelocidade);
		
		JLabel lblVelocidade = new JLabel("Velocidade:");
		lblVelocidade.setBounds(10, 103, 75, 14);
		contentPane.add(lblVelocidade);
		
		JLabel lblDefesa = new JLabel("Defesa:");
		lblDefesa.setBounds(10, 82, 75, 14);
		contentPane.add(lblDefesa);
		
		tfDefesa = new JTextField();
		tfDefesa.setColumns(10);
		tfDefesa.setBounds(70, 79, 86, 20);
		contentPane.add(tfDefesa);
		
		JLabel lblAtaque = new JLabel("Ataque:");
		lblAtaque.setBounds(10, 61, 75, 14);
		contentPane.add(lblAtaque);
		
		tfAtaque = new JTextField();
		tfAtaque.setColumns(10);
		tfAtaque.setBounds(70, 58, 86, 20);
		contentPane.add(tfAtaque);
		
		tfId = new JTextField();
		tfId.setColumns(10);
		tfId.setBounds(70, 33, 86, 20);
		contentPane.add(tfId);
		
		JLabel label_4 = new JLabel("ID: ");
		label_4.setBounds(10, 39, 46, 14);
		contentPane.add(label_4);
		
		tfNome = new JTextField();
		tfNome.setColumns(10);
		tfNome.setBounds(70, 11, 86, 20);
		contentPane.add(tfNome);
		
		JLabel lblVida = new JLabel("Vida:");
		lblVida.setBounds(191, 14, 35, 14);
		contentPane.add(lblVida);
		
		tfVida = new JTextField();
		tfVida.setBounds(224, 11, 86, 20);
		contentPane.add(tfVida);
		tfVida.setColumns(10);
		
		JLabel lblXp = new JLabel("Xp:");
		lblXp.setBounds(194, 36, 22, 14);
		contentPane.add(lblXp);
		
		tfXp = new JTextField();
		tfXp.setColumns(10);
		tfXp.setBounds(224, 33, 86, 20);
		contentPane.add(tfXp);
		
		JLabel lblLevel = new JLabel("Level:");
		lblLevel.setBounds(181, 58, 35, 14);
		contentPane.add(lblLevel);
		
		tfLevel = new JTextField();
		tfLevel.setColumns(10);
		tfLevel.setBounds(224, 55, 86, 20);
		contentPane.add(tfLevel);
		
		JLabel lblFraqueza = new JLabel("Fraqueza:");
		lblFraqueza.setBounds(10, 128, 60, 14);
		contentPane.add(lblFraqueza);

		
		cbLoot.setBounds(224, 99, 191, 22);
		contentPane.add(cbLoot);
		
		JLabel lblLoots = new JLabel("Loots");
		lblLoots.setBounds(181, 103, 35, 14);
		contentPane.add(lblLoots);
		
		JButton btnAddLoot = new JButton("Add Loot");
		btnAddLoot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				internalFrame.setVisible(true);
				
			}
		});
		btnAddLoot.setBounds(224, 124, 91, 23);
		contentPane.add(btnAddLoot);
		
		tfDinheiro = new JTextField();
		tfDinheiro.setBounds(224, 79, 86, 20);
		contentPane.add(tfDinheiro);
		tfDinheiro.setColumns(10);
		
		JLabel lblDinheiro = new JLabel("Dinheiro:");
		lblDinheiro.setBounds(170, 82, 46, 14);
		contentPane.add(lblDinheiro);
		

	}
	
	private void ProcuraItem(String Nome, String Like)
	{
		if (Nome.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Não há nada digitado no campo de pesquisa!");
			
		} 
		else {
			Connection c = null;
		    Statement stmt = null;
			ResultSet rs;
		    try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:src/ListaItems.db");
		      System.out.println("Opened database successfully");
		      
		      stmt = c.createStatement();
		      rs = stmt.executeQuery( "SELECT * FROM ListaItems WHERE " + Like + " LIKE '%" + Nome + "%';" );
		      items.clear();

			      while(rs.next())
			      {
			    	    String id = rs.getString("id");
				        String nome = rs.getString("nome");
				        int dano = Integer.parseInt(rs.getString("dano"));
				        int defesa = Integer.parseInt(rs.getString("defesa"));
				        int velocidade = Integer.parseInt(rs.getString("velocidade"));
				        String descricao = rs.getString("descricao");
				        int tipo = Integer.valueOf(rs.getString("tipo"));
				        items.add(new Item(id,nome,dano,defesa,velocidade,tipo,descricao));       
			      }
			      if(items.size() > 0)
			      {
				      	tfProcuraNome.setText(items.get(0).getNome());
				        tfProcuraAtaque.setText(String.valueOf(items.get(0).getDano()));
				        tfProcuraDefesa.setText(String.valueOf(items.get(0).getDefesa()));
				        tfProcuraVelocidade.setText(String.valueOf(items.get(0).getVelocidade()));
				        tfProcuraId.setText(items.get(0).getId());
				        tfProcuraDescricao.setText(items.get(0).getDescricao());
				        tfProcuraTipo.setText(String.valueOf(items.get(0).getTipo()));    
			      }
			      else
			      {
			    	  JOptionPane.showMessageDialog(null, "Não foram encontrados resultados!");
			      }
  

			    stmt.close();
			    rs.close();
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
		    System.out.println("Finished Operation");
		}
	
	}
	
	private void CriaOuAbre()
	{
		 Connection c = null;
		    Statement stmt = null;
		    try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:src/ListaMonstros.db");
		      System.out.println("Opened database successfully");
		      stmt = c.createStatement();
		      String sql = "CREATE TABLE IF NOT EXISTS ListaMonstros ( " +
		      		"id 	    TEXT NOT NULL," +
		      		"nome       TEXT NOT NULL," +
		      		"level      TEXT NOT NULL," +
		      		"vida       TEXT NOT NULL," +
		      		"ataque     TEXT NOT NULL," +
					"defesa     TEXT NOT NULL, " +
					"velocidade TEXT NOT NULL, " +
					"xpdada		TEXT NOT NULL," +
					"dinheiro	TEXT NOT NULL," +
					"loot		TEXT NOT NULL," +
					"fraqueza   TEXT NOT NULL)";
		      stmt.executeUpdate(sql);
		      stmt.close();
		      c.close();
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
		    System.out.println("Table created successfully");
	  }
	
	
	private void InserirMonstro()
	{
		 	Connection c = null;
		    Statement stmt = null;
		    try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:src/ListaMonstros.db");
		      c.setAutoCommit(false);
		      System.out.println("Banco Aberto!");

		      stmt = c.createStatement();
		      String sql = "INSERT INTO ListaMonstros (id,nome,level,vida,ataque, defesa, velocidade, loot, fraqueza, xpdada, dinheiro)" +
		      "VALUES ('" +
		      	String.valueOf(monstro.getId()) + "','" +
				String.valueOf(monstro.getNome()) + "','" +
				String.valueOf(monstro.getLevel()) + "','" +
				String.valueOf(monstro.getVidaMax()) + "','" +
				String.valueOf(monstro.getAtaque()) + "','" +
				String.valueOf(monstro.getDefesa()) + "','" +
				String.valueOf(monstro.getVelocidade()) + "','" +
				String.valueOf(monstro.getLoot()) + "','" +
				String.valueOf(monstro.getFraqueza()) + "','" +
				String.valueOf(monstro.getXpdada()) + "','" +
				String.valueOf(monstro.getDinheiro()) + "');";
		      	
		      stmt.executeUpdate(sql);
		      stmt.close();
		      c.commit();
		      c.close();
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
		    System.out.println("Records created successfully");
		  }
		
		private String Separador() {
			String loot = new String();
			for (int i = 0; i < cbLoot.getItemCount(); i++) {
					loot = loot + "#"+ cbLoot.getItemAt(i).toString();
			}
				return loot;
			}
			
		public void atualizaComboBox()
		{
				cbLoot.addItem(Loot.get(Loot.size()-1).getId());
		}
	}
