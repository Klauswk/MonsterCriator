package Janelas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.io.File;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class JanelaMain extends JFrame {

	private JPanel contentPane;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaMain frame = new JanelaMain();
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
	public JanelaMain() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("src/Imagens/Icon.png"));
		
		setTitle("GC1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnPrograma = new JMenu("Programa");
		menuBar.add(mnPrograma);
		
		JMenu mnNovo = new JMenu("Novo");
		mnPrograma.add(mnNovo);
		
		JMenuItem mntmItem = new JMenuItem("Item");
		mntmItem.setMnemonic(1);
		mntmItem.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				new CriaItem().show();
			}
		});
		mnNovo.add(mntmItem);
		
		JMenuItem mntmMonstro = new JMenuItem("Monstro");
		mntmMonstro.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				new CriaMonstro().show();
			}
		});
		mnNovo.add(mntmMonstro);
		
		JMenuItem mntmAbrir = new JMenuItem("Abrir...");
		mntmAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnPrograma.add(mntmAbrir);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mnPrograma.add(mntmSair);
		
		JMenu mnItems = new JMenu("Items");
		menuBar.add(mnItems);
		
		JMenuItem mntmNovoItem = new JMenuItem("Novo Item");
		mntmNovoItem.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				new CriaItem().show();
			}
		});
		mnItems.add(mntmNovoItem);
		
		JMenuItem mntmListarItems = new JMenuItem("Listar/Editar/Deletar Items");
		mntmListarItems.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				new ListarItems().show();
			}
		});
		mnItems.add(mntmListarItems);
		
		JMenu mnMonstros = new JMenu("Monstros");
		menuBar.add(mnMonstros);
		
		JMenuItem mntmNovoMonstro = new JMenuItem("Novo Monstro");
		mntmNovoMonstro.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				new CriaMonstro().show();
			}
		});
		mnMonstros.add(mntmNovoMonstro);
		
		JMenuItem mntmListarMonstros = new JMenuItem("Listar Monstros");
		mntmListarMonstros.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				new ListarMonstros().show();
			}
		});
		mnMonstros.add(mntmListarMonstros);
		
		JMenuItem mntmExcluirMonstro = new JMenuItem("Excluir Monstro");
		mnMonstros.add(mntmExcluirMonstro);
		
		JMenuItem mntmEditarMonstro = new JMenuItem("Editar Monstro");
		mnMonstros.add(mntmEditarMonstro);
		
		JMenu mnMagias = new JMenu("Magias");
		menuBar.add(mnMagias);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 442, 252);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNovoItem = new JButton("Novo Item");
		btnNovoItem.setMnemonic('i');
		btnNovoItem.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				new CriaItem().show();
			}
		});
		btnNovoItem.setIcon(new ImageIcon("src/Imagens/stonecutter_axe.gif"));
		btnNovoItem.setBounds(32, 52, 140, 36);
		panel.add(btnNovoItem);
		
		JButton btnNovoMonstro = new JButton("Novo Monstro");
		btnNovoMonstro.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				new CriaMonstro().show();
			}
		});
		btnNovoMonstro.setMnemonic('e');
		btnNovoMonstro.setIcon(new ImageIcon("src/Imagens/Troll.gif"));
		btnNovoMonstro.setBounds(200, 52, 189, 36);
		panel.add(btnNovoMonstro);
		
		JButton btnNovaMagia = new JButton("Nova Magia");
		btnNovaMagia.setMnemonic('m');
		btnNovaMagia.setIcon(new ImageIcon("src/Imagens/Ability_fire_32x32.png"));
		btnNovaMagia.setBounds(32, 131, 140, 29);
		panel.add(btnNovaMagia);
	}

	@SuppressWarnings("unused")
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	
	public void listFiles(String folder){
		File directory = new File(folder);
		File[] contents = directory.listFiles();
		for ( File f : contents) {
		  System.out.println(f.getAbsolutePath());
		}
	}
}
