package Janelas;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import Classes.FileFilters;
import Classes.Item;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class CriaItem extends JFrame {

	private JPanel contentPane;
	private JTextField tfNome;
	private JTextField tfId;
	private JTextField tfAtaque;
	private JTextField tfDefesa;
	private JTextField tfVelocidade;
	private JRadioButton rdbtnEspada;
	private JRadioButton rdbtnMachado;
	private JRadioButton rdbtnEscudo;
	private final ButtonGroup RadioTipo = new ButtonGroup();
	private JLabel lblDescricao;
	private JTextField tfDescricao;
	Item item = new Item();
	private JRadioButton rdbtnArmadura;
	private JRadioButton rdbtnCapacete;
	private JRadioButton rdbtnCalca;
	private JRadioButton rdbtnBota;
	private JButton btnNewButton;
	String Caminho;
	private JRadioButton rdbtnClava;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CriaItem frame = new CriaItem();
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
	public CriaItem() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage("src//Imagens//Icon.png"));
		setTitle("Criador de Items");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome: ");
		lblNewLabel.setBounds(10, 11, 75, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID: ");
		lblNewLabel_1.setBounds(10, 36, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblAtaque = new JLabel("Ataque:");
		lblAtaque.setBounds(10, 58, 75, 14);
		contentPane.add(lblAtaque);
		
		JLabel lblDefesa = new JLabel("Defesa:");
		lblDefesa.setBounds(10, 79, 75, 14);
		contentPane.add(lblDefesa);
		
		JLabel lblVelocidade = new JLabel("Velocidade:");
		lblVelocidade.setBounds(10, 100, 75, 14);
		contentPane.add(lblVelocidade);
		
		tfNome = new JTextField();
		tfNome.setBounds(70, 8, 86, 20);
		contentPane.add(tfNome);
		tfNome.setColumns(10);
		
		tfId = new JTextField();
		tfId.setBounds(70, 30, 86, 20);
		contentPane.add(tfId);
		tfId.setColumns(10);
		
		tfAtaque = new JTextField();
		tfAtaque.setBounds(70, 55, 86, 20);
		contentPane.add(tfAtaque);
		tfAtaque.setColumns(10);
		
		tfDefesa = new JTextField();
		tfDefesa.setBounds(70, 76, 86, 20);
		contentPane.add(tfDefesa);
		tfDefesa.setColumns(10);
		
		tfVelocidade = new JTextField();
		tfVelocidade.setBounds(70, 97, 86, 20);
		contentPane.add(tfVelocidade);
		tfVelocidade.setColumns(10);
		
		rdbtnEspada = new JRadioButton("Espada");
		rdbtnEspada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				item.setTipo(4);
			}
		});
		RadioTipo.add(rdbtnEspada);
		rdbtnEspada.setBounds(47, 141, 75, 23);
		contentPane.add(rdbtnEspada);
		
		rdbtnMachado = new JRadioButton("Machado");
		rdbtnMachado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				item.setTipo(5);
			}
		});
		RadioTipo.add(rdbtnMachado);
		rdbtnMachado.setBounds(47, 158, 86, 23);
		contentPane.add(rdbtnMachado);
		
		rdbtnEscudo = new JRadioButton("Escudo");
		rdbtnEscudo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				item.setTipo(6);
			}
		});
		RadioTipo.add(rdbtnEscudo);
		rdbtnEscudo.setBounds(47, 193, 75, 23);
		contentPane.add(rdbtnEscudo);
		
		lblDescricao = new JLabel("Descricao:");
		lblDescricao.setBounds(166, 11, 58, 14);
		contentPane.add(lblDescricao);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
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
				else if(tfDescricao.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Há um campo em Branco!!");
				}
				else {
				item.setNome(tfNome.getText().toString());
				item.setId(tfId.getText().toUpperCase().toString());
				item.setDano(Integer.parseInt(tfAtaque.getText().toString()));
				item.setDefesa(Integer.parseInt(tfDefesa.getText().toString()));
				item.setVelocidade(Integer.parseInt(tfVelocidade.getText().toString()));
				item.setDescricao(tfDescricao.getText().toString());
				CriaOuAbre();
				Inserir();
				tfNome.setText(null);
				tfId.setText(null);
				tfAtaque.setText(null);
				tfDefesa.setText(null);
				tfVelocidade.setText(null);
				tfDescricao.setText(null);
				}
			}
			
		});
		btnAdicionar.setBounds(351, 250, 91, 23);
		contentPane.add(btnAdicionar);
		
		tfDescricao = new JTextField();
		tfDescricao.setBounds(234, 8, 86, 20);
		contentPane.add(tfDescricao);
		tfDescricao.setColumns(10);
		
		rdbtnArmadura = new JRadioButton("Armadura");
		rdbtnArmadura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				item.setTipo(0);
			}
		});
		RadioTipo.add(rdbtnArmadura);
		rdbtnArmadura.setBounds(135, 193, 109, 23);
		contentPane.add(rdbtnArmadura);
		
		rdbtnCapacete = new JRadioButton("Capacete");
		rdbtnCapacete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				item.setTipo(3);
			}
		});
		RadioTipo.add(rdbtnCapacete);
		rdbtnCapacete.setBounds(135, 141, 109, 23);
		contentPane.add(rdbtnCapacete);
		
		rdbtnCalca = new JRadioButton("Calca");
		rdbtnCalca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				item.setTipo(1);
			}
		});
		RadioTipo.add(rdbtnCalca);
		rdbtnCalca.setBounds(135, 158, 109, 23);
		contentPane.add(rdbtnCalca);
		
		rdbtnBota = new JRadioButton("Bota");
		rdbtnBota.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				item.setTipo(2);
			}
		});
		RadioTipo.add(rdbtnBota);
		rdbtnBota.setBounds(135, 176, 109, 23);
		contentPane.add(rdbtnBota);
		
		final JLabel lbImagem = new JLabel("");
		lbImagem.setIcon(null);
		lbImagem.setBounds(263, 36, 144, 106);
		contentPane.add(lbImagem);
		
		btnNewButton = new JButton("Procurar Imagem");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.setDialogTitle("Selecione a Imagem");
				chooser.setFileFilter(new FileFilters());
				File f = new File("src/Imagens");
				File Path;
				chooser.setCurrentDirectory(f);
				int checker = chooser.showOpenDialog(null);
				if(checker == JFileChooser.APPROVE_OPTION)
				{
					Path = chooser.getSelectedFile();
					Caminho = Path.getAbsolutePath();
					lbImagem.setIcon(new ImageIcon(Caminho));
					
				}
			}
		});
		btnNewButton.setBounds(263, 141, 144, 23);
		contentPane.add(btnNewButton);
		
		rdbtnClava = new JRadioButton("Clava");
		rdbtnClava.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				item.setTipo(7);
			}
		});
		RadioTipo.add(rdbtnClava);
		rdbtnClava.setBounds(47, 176, 75, 23);
		contentPane.add(rdbtnClava);
	}
	
	private void CriaOuAbre()
	{
		 Connection c = null;
		    Statement stmt = null;
		    try {
		      Class.forName("org.sqlite.JDBC").newInstance();
		      c = DriverManager.getConnection("jdbc:sqlite:src/ListaItems.db");
		      System.out.println("Opened database successfully");

		      stmt = c.createStatement();
		      String sql = "CREATE TABLE IF NOT EXISTS ListaItems ( " +
		      		"id 	    TEXT NOT NULL," +
		      		"imagem     TEXT , " +
		      		"nome       TEXT NOT NULL," +
		      		"dano       TEXT NOT NULL," +
					"defesa     TEXT NOT NULL, " +
					"velocidade TEXT NOT NULL, " +
					"tipo		TEXT NOT NULL," +
					"descricao  TEXT NOT NULL)";
		      stmt.executeUpdate(sql);
		      stmt.close();
		      c.close();
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
		    System.out.println("Table created successfully");
	  }
	
	private void Inserir()
	{
			Connection c;
		    Statement stmt;
		    try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:src/ListaItems.db");
		      c.setAutoCommit(false);
		      System.out.println("Banco Aberto!");

		      stmt = c.createStatement();
		      String sql = "INSERT INTO ListaItems (id,nome, dano, defesa, velocidade, tipo ,descricao)" +
		      "VALUES ('" +
		      	String.valueOf(item.getId()) + "','" +
				String.valueOf(item.getNome()) + "','" +
				String.valueOf(item.getDano()) + "','" +
				String.valueOf(item.getDefesa()) + "','" +
				String.valueOf(item.getVelocidade()) + "','" +
				String.valueOf(item.getTipo()) + "','"
				+ item.getDescricao().toString() + "');";
		      
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
	}
