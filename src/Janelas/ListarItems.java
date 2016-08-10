package Janelas;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.border.BevelBorder;

import Classes.Item;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JInternalFrame;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

@SuppressWarnings("serial")
public class ListarItems extends JFrame {

	private JPanel contentPane;
	private JTable tbResultado;
	private JComboBox<String> cbOrderBy;
	private Vector<Item> items = new Vector<Item>();
	private JTextField tfNome;
	private JTextField tfDescricao;
	private JTextField tfId;
	private JTextField tfAtaque;
	private JTextField tfDefesa;
	private JTextField tfVelocidade;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarItems frame = new ListarItems();
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
	public ListarItems() {
		setTitle("GC1.0");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListarItems.class.getResource("/Imagens/Icon.png")));
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tbResultado = new JTable();
		tbResultado.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tbResultado.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "ID", "Ataque", "Defesa", "Velocidade", "Tipo", "Descricao"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, true, true, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tbResultado.getColumnModel().getColumn(0).setResizable(false);
		tbResultado.getColumnModel().getColumn(0).setPreferredWidth(90);
		tbResultado.getColumnModel().getColumn(1).setPreferredWidth(100);
		tbResultado.getColumnModel().getColumn(2).setPreferredWidth(45);
		tbResultado.getColumnModel().getColumn(3).setPreferredWidth(45);
		tbResultado.getColumnModel().getColumn(4).setPreferredWidth(60);
		tbResultado.getColumnModel().getColumn(6).setPreferredWidth(100);
		
		final JInternalFrame ifEditaItem = new JInternalFrame("Editando...");
		ifEditaItem.setBounds(230, 194, 382, 313);
		contentPane.add(ifEditaItem);
		ifEditaItem.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("Nome: ");
		label.setBounds(10, 14, 75, 14);
		ifEditaItem.getContentPane().add(label);
		
		tfNome = new JTextField();
		tfNome.setColumns(10);
		tfNome.setBounds(70, 11, 86, 20);
		ifEditaItem.getContentPane().add(tfNome);
		
		tfDescricao = new JTextField();
		tfDescricao.setColumns(10);
		tfDescricao.setBounds(234, 11, 86, 20);
		ifEditaItem.getContentPane().add(tfDescricao);
		
		JLabel label_1 = new JLabel("Descricao:");
		label_1.setBounds(166, 14, 58, 14);
		ifEditaItem.getContentPane().add(label_1);
		
		tfId = new JTextField();
		tfId.setColumns(10);
		tfId.setBounds(70, 33, 86, 20);
		ifEditaItem.getContentPane().add(tfId);
		
		JLabel label_2 = new JLabel("ID: ");
		label_2.setBounds(10, 39, 46, 14);
		ifEditaItem.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("Ataque:");
		label_3.setBounds(10, 61, 75, 14);
		ifEditaItem.getContentPane().add(label_3);
		
		tfAtaque = new JTextField();
		tfAtaque.setColumns(10);
		tfAtaque.setBounds(70, 58, 86, 20);
		ifEditaItem.getContentPane().add(tfAtaque);
		
		tfDefesa = new JTextField();
		tfDefesa.setColumns(10);
		tfDefesa.setBounds(70, 79, 86, 20);
		ifEditaItem.getContentPane().add(tfDefesa);
		
		JLabel label_4 = new JLabel("Defesa:");
		label_4.setBounds(10, 82, 75, 14);
		ifEditaItem.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("Velocidade:");
		label_5.setBounds(10, 103, 75, 14);
		ifEditaItem.getContentPane().add(label_5);
		
		tfVelocidade = new JTextField();
		tfVelocidade.setColumns(10);
		tfVelocidade.setBounds(70, 100, 86, 20);
		ifEditaItem.getContentPane().add(tfVelocidade);
		
		final JRadioButton rbCapacete = new JRadioButton("Capacete");
		buttonGroup.add(rbCapacete);
		rbCapacete.setBounds(98, 124, 109, 23);
		ifEditaItem.getContentPane().add(rbCapacete);
		
		final JRadioButton rbEspada = new JRadioButton("Espada");
		buttonGroup.add(rbEspada);
		rbEspada.setBounds(10, 124, 75, 23);
		ifEditaItem.getContentPane().add(rbEspada);
		
		final JRadioButton rbMachado = new JRadioButton("Machado");
		buttonGroup.add(rbMachado);
		rbMachado.setBounds(10, 141, 86, 23);
		ifEditaItem.getContentPane().add(rbMachado);
		
		final JRadioButton rbCalca = new JRadioButton("Calca");
		buttonGroup.add(rbCalca);
		rbCalca.setBounds(98, 141, 109, 23);
		ifEditaItem.getContentPane().add(rbCalca);
		
		final JRadioButton rbArmadura = new JRadioButton("Armadura");
		buttonGroup.add(rbArmadura);
		rbArmadura.setBounds(98, 176, 109, 23);
		ifEditaItem.getContentPane().add(rbArmadura);
		
		final JRadioButton rbBota = new JRadioButton("Bota");
		buttonGroup.add(rbBota);
		rbBota.setBounds(98, 159, 109, 23);
		ifEditaItem.getContentPane().add(rbBota);
		
		final JRadioButton rbClava = new JRadioButton("Clava");
		buttonGroup.add(rbClava);
		rbClava.setBounds(10, 159, 75, 23);
		ifEditaItem.getContentPane().add(rbClava);
		
		final JRadioButton rbEscudo = new JRadioButton("Escudo");
		buttonGroup.add(rbEscudo);
		rbEscudo.setBounds(10, 176, 75, 23);
		ifEditaItem.getContentPane().add(rbEscudo);
		
		JButton btnAtualiza = new JButton("Atualiza");
		btnAtualiza.setBounds(285, 253, 91, 23);
		ifEditaItem.getContentPane().add(btnAtualiza);
		
		JButton btnCancela = new JButton("Cancela");
		btnCancela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ifEditaItem.setVisible(false);
			}
		});
		btnCancela.setBounds(0, 253, 91, 23);
		ifEditaItem.getContentPane().add(btnCancela);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.setBounds(144, 253, 91, 23);
		ifEditaItem.getContentPane().add(btnDeletar);
		ifEditaItem.setClosable(true);
		ifEditaItem.setMaximizable(true);
		ifEditaItem.setVisible(false);
		tbResultado.setBounds(10, 77, 755, 485);
		contentPane.add(tbResultado);

		cbOrderBy = new JComboBox<String>();
		cbOrderBy.setBounds(180, 9, 70, 22);
		cbOrderBy.addItem("id");
		cbOrderBy.addItem("dano");
		cbOrderBy.addItem("defesa");
		cbOrderBy.addItem("velocidade");
		cbOrderBy.addItem("tipo");
		cbOrderBy.addItem("descricao");
		contentPane.add(cbOrderBy);

		final JComboBox<String> cbAscDesc = new JComboBox<String>();
		cbAscDesc.setBounds(180, 42, 70, 22);
		cbAscDesc.addItem("ASC");
		cbAscDesc.addItem("DESC");
		contentPane.add(cbAscDesc);

		final JComboBox<String> cbFiltro = new JComboBox<String>();
		cbFiltro.setBounds(10, 9, 91, 22);
		cbFiltro.addItem("Todos");
		cbFiltro.addItem("Armas");
		cbFiltro.addItem("Equipamentos");
		cbFiltro.addItem("Espadas");
		cbFiltro.addItem("Machados");
		cbFiltro.addItem("Clavas");
		cbFiltro.addItem("Armaduras");
		cbFiltro.addItem("Capacetes");
		cbFiltro.addItem("Calcas");
		cbFiltro.addItem("Botas");
		cbFiltro.addItem("Escudos");
		contentPane.add(cbFiltro);

		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ProcuraItem("null",cbOrderBy.getSelectedItem().toString(),cbAscDesc.getSelectedItem().toString(),cbFiltro.getSelectedItem().toString());
			}
		});
		btnProcurar.setBounds(10, 38, 91, 23);
		contentPane.add(btnProcurar);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 61, 46, 14);
		contentPane.add(lblNome);

		JLabel lblId = new JLabel("Id");
		lblId.setBounds(150, 61, 46, 14);
		contentPane.add(lblId);

		JLabel lblAtaque = new JLabel("Ataque");
		lblAtaque.setBounds(272, 61, 46, 14);
		contentPane.add(lblAtaque);

		JLabel lblDefesa = new JLabel("Defesa");
		lblDefesa.setBounds(353, 61, 46, 14);
		contentPane.add(lblDefesa);

		JLabel lblVelocidade = new JLabel("Velocidade");
		lblVelocidade.setBounds(429, 61, 64, 14);
		contentPane.add(lblVelocidade);

		JLabel lblDescricao = new JLabel("Descricao");
		lblDescricao.setBounds(639, 61, 46, 14);
		contentPane.add(lblDescricao);

		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(527, 61, 46, 14);
		contentPane.add(lblTipo);
		
		final JTextArea tfQuery = new JTextArea();
		tfQuery.setToolTipText("Digite o Query puro para pesquisa avan\u00E7ada");
		tfQuery.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		tfQuery.setFont(new Font("Arial", Font.PLAIN, 13));
		tfQuery.setBounds(272, 9, 414, 43);
		contentPane.add(tfQuery);
		
		JButton btnNewButton = new JButton("QA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ProcuraItem(tfQuery.getText().toString());
			}
		});
		btnNewButton.setToolTipText("Pesquisa Query Avan\u00E7ada");
		btnNewButton.setBounds(696, 9, 69, 43);
		contentPane.add(btnNewButton);
		
		tbResultado.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int linha_selecionada = tbResultado.getSelectedRow();
				tfNome.setText(tbResultado.getValueAt(linha_selecionada, 0).toString());
				tfId.setText(tbResultado.getValueAt(linha_selecionada, 1).toString());
				tfAtaque.setText(tbResultado.getValueAt(linha_selecionada, 2).toString());
				tfDefesa.setText(tbResultado.getValueAt(linha_selecionada, 3).toString());
				tfVelocidade.setText(tbResultado.getValueAt(linha_selecionada, 4).toString());
				tfDescricao.setText(tbResultado.getValueAt(linha_selecionada, 6).toString());
				int tipo = (int) tbResultado.getValueAt(linha_selecionada, 5);
				switch(tipo)
				{
				case 0:
					rbArmadura.doClick();
					break;

				case 1:
					rbCalca.doClick();
					break;
				case 2:
					rbBota.doClick();					
					break;
				case 3:
					rbCapacete.doClick();
					break;
				case 4:
					rbEspada.doClick();
					break;
				case 5:
					rbMachado.doClick();
					break;
				case 6:
					rbEscudo.doClick();
					break;
				case 7:
					rbClava.doClick();
					break;
				
				}
				ifEditaItem.setVisible(true);
				
			}
		});
		
		btnAtualiza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int tipo=0;
				if(rbArmadura.isEnabled())
				{
					tipo = 0;
				}
				else if(rbCalca.isEnabled()){
					tipo = 1;
				}
				else if(rbBota.isEnabled()){
					tipo =2;
				}
				else if(rbCapacete.isEnabled()){
					tipo = 3;
				}
				else if(rbEspada.isEnabled()){
					tipo =4;
				}
				else if(rbMachado.isEnabled()){
					tipo = 5;
				}
				else if(rbEscudo.isEnabled()){
					tipo = 6;
				}
				else if(rbClava.isEnabled()){
					tipo = 7;
				}
				AtualizaItems(new Item(tfId.getText().toString() , tfNome.getText().toString(), Integer.parseInt(tfAtaque.getText().toString()), 
						Integer.parseInt(tfDefesa.getText().toString()), Integer.parseInt(tfVelocidade.getText().toString()), tipo, 
						tfDescricao.getText().toString()));
				ifEditaItem.setVisible(false);
			}
		});
		
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int tipo=0;
				if(rbArmadura.isEnabled())
				{
					tipo = 0;
				}
				else if(rbCalca.isEnabled()){
					tipo = 1;
				}
				else if(rbBota.isEnabled()){
					tipo =2;
				}
				else if(rbCapacete.isEnabled()){
					tipo = 3;
				}
				else if(rbEspada.isEnabled()){
					tipo =4;
				}
				else if(rbMachado.isEnabled()){
					tipo = 5;
				}
				else if(rbEscudo.isEnabled()){
					tipo = 6;
				}
				else if(rbClava.isEnabled()){
					tipo = 7;
				}
				DeletaItem(new Item(tfId.getText().toString() , tfNome.getText().toString(), Integer.parseInt(tfAtaque.getText().toString()), 
						Integer.parseInt(tfDefesa.getText().toString()), Integer.parseInt(tfVelocidade.getText().toString()), tipo, 
						tfDescricao.getText().toString()));
				ifEditaItem.setVisible(false);
			}
		});

	}

	protected void DeletaItem(Item item) {
		Connection c;
	    Statement stmt;
	    try {
	      Class.forName("org.sqlite.JDBC");
	      c = DriverManager.getConnection("jdbc:sqlite:src/ListaItems.db");
	      c.setAutoCommit(false);
	      System.out.println("Banco Aberto!");

	      stmt = c.createStatement();
	      String sql = "DELETE from ListaItems WHERE id = '" + item.getId() +"';";
	      stmt.executeUpdate(sql);	
  
	      stmt.close();
	      c.commit();
	      c.close();
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
	    System.out.println("Records deleted successfully");
	}

	protected void AtualizaItems(Item item) {
				Connection c;
			    Statement stmt;
			    try {
			      Class.forName("org.sqlite.JDBC");
			      c = DriverManager.getConnection("jdbc:sqlite:src/ListaItems.db");
			      c.setAutoCommit(false);
			      System.out.println("Banco Aberto!");

			      stmt = c.createStatement();
			      String sql = "UPDATE ListaItems set nome = '" + item.getNome() + "' WHERE id = '" + item.getId() +"';";
			      stmt.executeUpdate(sql);	
			      sql = "UPDATE ListaItems set dano = '" + Integer.parseInt(tfAtaque.getText().toString()) + "' WHERE id = '" + item.getId() +"';";
			      stmt.executeUpdate(sql);	
			      sql = "UPDATE ListaItems set defesa = '" + Integer.parseInt(tfDefesa.getText().toString()) + "' WHERE id = '" + item.getId() +"';";
			      stmt.executeUpdate(sql);	
			      sql = "UPDATE ListaItems set velocidade = '" + Integer.parseInt(tfVelocidade.getText().toString()) + "' WHERE id = '" + item.getId() +"';";
			      stmt.executeUpdate(sql);	
			      sql = "UPDATE ListaItems set descricao = '" + tfDescricao.getText().toString() + "' WHERE id = '" + item.getId() +"';";
			      stmt.executeUpdate(sql);	
			      sql = "UPDATE ListaItems set tipo = '" + item.getTipo() + "' WHERE id = '" + item.getId() +"';";
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

	private void ProcuraItem(String Query)
	{
		if (Query.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Não há nada digitado no campo de pesquisa!");

		} 
		else
		{
			Connection c = null;
			Statement stmt = null;
			ResultSet rs;

			try {
				Class.forName("org.sqlite.JDBC");
				c = DriverManager.getConnection("jdbc:sqlite:src/ListaItems.db");
				System.out.println("Opened database successfully");
				stmt = c.createStatement();
				rs = stmt.executeQuery( Query );
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
					DefaultTableModel modelo = (DefaultTableModel)tbResultado.getModel();
					modelo.setNumRows(0);
					for (int i = 0; i < items.size(); i++) {
							modelo.addRow(new Object[] {items.get(i).getNome(),items.get(i).getId(),items.get(i).getDano(),items.get(i).getDefesa(),items.get(i).getVelocidade(),items.get(i).getTipo(),items.get(i).getDescricao()});
						}
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
		}

		System.out.println("Finished Operation");
	}
	
	private void ProcuraItem(String Nome, String OrderBy, String Ordem, String Filtro)
	{
		if (Nome.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Não há nada digitado no campo de pesquisa!");

		} 
		else
		{
			Connection c = null;
			Statement stmt = null;
			ResultSet rs;

			int filtro = 20;

			switch(Filtro)
			{
			case "Todos":
				filtro = 10;
				break;
			case "Armas":
				filtro = 9;
				break;
			case "Equipamentos":
				filtro = 11;
				break;
			case "Armaduras":
				filtro = 0;
				break;
			case "Calcas":
				filtro = 1;
				break;
			case "Botas":
				filtro = 2;
				break;
			case "Capacetes":
				filtro = 3;
				break;
			case "Espadas":
				filtro = 4;
				break;
			case "Machados":
				filtro = 5;
				break;
			case "Escudos":
				filtro = 6;
				break;
			case "Clavas":
				filtro = 7;
				break;	
			}

			try {
				Class.forName("org.sqlite.JDBC");
				c = DriverManager.getConnection("jdbc:sqlite:src/ListaItems.db");
				System.out.println("Opened database successfully");
				stmt = c.createStatement();
				rs = stmt.executeQuery( "SELECT * FROM ListaItems ORDER BY "+ OrderBy + " " + Ordem+ ";" );
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
					DefaultTableModel modelo = (DefaultTableModel)tbResultado.getModel();
					modelo.setNumRows(0);
					for (int i = 0; i < items.size(); i++) {

						if(filtro == 10)
						{
							modelo.addRow(new Object[] {items.get(i).getNome(),items.get(i).getId(),items.get(i).getDano(),items.get(i).getDefesa(),items.get(i).getVelocidade(),items.get(i).getTipo(),items.get(i).getDescricao()}); 
						}
						else if(filtro == 9)
						{
							if((items.get(i).getTipo() == 4)||(items.get(i).getTipo() == 5)||(items.get(i).getTipo() == 7))
							{
								modelo.addRow(new Object[] {items.get(i).getNome(),items.get(i).getId(),items.get(i).getDano(),items.get(i).getDefesa(),items.get(i).getVelocidade(),items.get(i).getTipo(),items.get(i).getDescricao()});
							}
						}
						else if(filtro == 11)
						{
							if((items.get(i).getTipo() == 0)||(items.get(i).getTipo() == 1)||(items.get(i).getTipo() == 2)||(items.get(i).getTipo() == 3)||(items.get(i).getTipo() == 6))
							{
								modelo.addRow(new Object[] {items.get(i).getNome(),items.get(i).getId(),items.get(i).getDano(),items.get(i).getDefesa(),items.get(i).getVelocidade(),items.get(i).getTipo(),items.get(i).getDescricao()});
							}
						}
						else if(filtro == items.get(i).getTipo())
						{
							modelo.addRow(new Object[] {items.get(i).getNome(),items.get(i).getId(),items.get(i).getDano(),items.get(i).getDefesa(),items.get(i).getVelocidade(),items.get(i).getTipo(),items.get(i).getDescricao()});
						}

					}
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
		}

		System.out.println("Finished Operation");
	}
}
