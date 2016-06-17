package gui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import redeSocial.Mensagem;
import redeSocial.RedeSocial;
import redeSocial.TipoRelacao;
import redeSocial.Utilizador;
import javax.swing.JTextArea;

public class Main extends JFrame {

	private JPanel contentPane;
	private JTextField tf_nome;
	private JTextField tf_cidade;
	private JTextField tf_nif;
	private JTextField tf_mail;
	private JPasswordField tf_password;
	private JComboBox cbEstadoCivil;
	private JPanel panel_adicionarR;
	private JPanel panel_adicionarU;
	private JComboBox comboBoxU;

	static ArrayList<Utilizador> listaGuardados = new ArrayList<Utilizador>();
	private JComboBox comboBoxR;
	private JTextField tf_login1;
	private JTextField tf_login2;
	private JPanel panel_login;
	
	public static Utilizador login = new Utilizador();
	private JTextField tf_assunto;
	private JPanel panel_M;
	private JComboBox comboBox_Destino;
	private JTextArea textArea;
	private JScrollPane scroll;
	private JTextArea textArea_LM;
	private JPanel panel_LM;
	private JPanel panel_LP;
	private JTextArea textArea_LP;
	private JScrollPane scroll1;
	private JPanel panel_LU;
	private JTextArea textArea_LU;
	private JScrollPane scroll2;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					if (frame.lerDados() == true) {

						frame.panel_adicionarU.setVisible(false);
						frame.panel_adicionarR.setVisible(false);
						frame.panel_login.setVisible(true);
					}
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
	public Main() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 559, 337);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		layeredPane.setBounds(6, 6, 168, 303);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		layeredPane.add(panel, "name_1465695370535940000");
		
		JButton btnNovoUtilizador = new JButton("Adicionar Utilizador");
		btnNovoUtilizador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				panel_adicionarR.setVisible(false);
				panel_adicionarU.setVisible(true);
			}
		});
		btnNovoUtilizador.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		
		JButton btnAdicionarRelacionamento = new JButton("Adicionar Relação");
		btnAdicionarRelacionamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				panel_adicionarU.setVisible(false);
				panel_adicionarR.setVisible(true);
				
				adicionarRelacao(login);
				
				
				
			}
		});
		btnAdicionarRelacionamento.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		
		JButton btnSalvarDados = new JButton("Guardar Dados");
		btnSalvarDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				RedeSocial rs = new RedeSocial();
				ArrayList<Utilizador> listaU = rs.getUtilizadors();
		    	if (listaU.isEmpty()) {
		    		JLabel label = new JLabel("Não foram adicionados novos utilizadores, logo não é necessário gravar no ficheiro.");
					label.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
					JOptionPane.showMessageDialog(null,label,"ERRO",JOptionPane.WARNING_MESSAGE);
		    		return;
		    	}
		    	
		    	try {
		    		
		    		System.out.println("GOODBYE!!!");
			    	FileWriter writer = new FileWriter("/Users/tltr/Desktop/output.txt", true); 
			    	
			    	for (Utilizador utilizador1 : listaU) {
						writer.write(utilizador1.getNome()+"\n");
						writer.write(utilizador1.getCidade()+"\n");
						writer.write(utilizador1.getEstadoCivil()+"\n");
						writer.write(utilizador1.getNumContribuinte()+"\n");
						writer.write(utilizador1.getEmail()+"\n\n");
					}
			    	writer.close();
			    	
				} catch (Exception e2) {
					// TODO: handle exception
				}
		    }
		});
				
				
				
			
		btnSalvarDados.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		
		JButton btnLerDados = new JButton("Ler Dados");
		btnLerDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				lerDados();
			}
		});
		btnLerDados.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		
		JButton btnListarPedidos = new JButton("Listar Pedidos");
		btnListarPedidos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				panel_adicionarU.setVisible(false);
				panel_adicionarR.setVisible(false);
				panel_LM.setVisible(false);
				panel_M.setVisible(false);
				panel_LP.setVisible(true);
				
				TipoRelacao tr = TipoRelacao.PROFISSIONAL;
				tr.listarPedidosDeAmizade();
				
				textArea_LP.setText("");
				ArrayList<TipoRelacao> listaPedidos = tr.getPedidos();
				for (int i = 0; i < listaPedidos.size(); i++) {
					textArea_LP.append("-------------------------------\n");
					textArea_LP.append("Nº de Pedido de Amizade: "+(i+1)+"\n");
					textArea_LP.append("\t- Utilizador que Enviou Pedido: '"+listaPedidos.get(i).getUtilizadorQueEnvia()+"'\n");
					textArea_LP.append("\t- Utilizador que Recebe Pedido: '"+listaPedidos.get(i).getUtilizadorQueRecebe()+"'\n");
					textArea_LP.append("\t- Tipo do Pedido Efectuado (FAMILIAR, PROFISSIONAL, AMIGO): '"+listaPedidos.get(i).getRelacionamento()+"'\n");
					textArea_LP.append("-------------------------------\n\n");
				}
			}
		});
		btnListarPedidos.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		
		JButton btnListarUtilizadores = new JButton("Listar Utilizadores");
		btnListarUtilizadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				panel_adicionarU.setVisible(false);
				panel_adicionarU.setVisible(false);
				panel_adicionarR.setVisible(false);
				panel_LM.setVisible(false);
				panel_M.setVisible(false);
				panel_LP.setVisible(false);
				panel_LU.setVisible(true);
				
				
				textArea_LU.setText("");
				
				RedeSocial rs = new RedeSocial();
				if (rs.listarUtilizadores() == null) {
					System.out.println("vazio");
					
					try {
						
						System.out.println("------Listagem------");
						System.out.println("N.∫ de Utilizadores: " + listaGuardados.size() + " Amigos");
						textArea_LU.append("N.∫ de Utilizadores: " + listaGuardados.size() + " Amigos\n\n");
						for (Utilizador utilizador : listaGuardados) {
							
							System.out.println("ID: " + utilizador.hashCode());
							System.out.println("Nome: " + utilizador.getNome());
							System.out.println("Cidade: " + utilizador.getCidade());
							System.out.println("Estado Civil: " + utilizador.getEstadoCivil());
							System.out.println("Nif: " + utilizador.getNumContribuinte());
							System.out.println("E-mail: " + utilizador.getEmail());
							System.out.println("Password: " + utilizador.getPassword() + "\n\n");
							
							textArea_LU.append("----------------------------------------\n\n");
							textArea_LU.append("Nome: " + utilizador.getNome() + "\n");
							textArea_LU.append("Cidade: " + utilizador.getCidade() + "\n");
							textArea_LU.append("Estado Civil: " + utilizador.getEstadoCivil() + "\n");
							textArea_LU.append("Nif: " + utilizador.getNumContribuinte() + "\n");
							textArea_LU.append("E-mail: " + utilizador.getEmail() + "\n");
							textArea_LU.append("Password: " + utilizador.getPassword() + "\n");
							textArea_LU.append("----------------------------------------\n\n");
						}
						
					} catch (Exception e2) {
						// TODO: handle exception
						System.err.println("Não existem utilizadores guardados na base de dados!");
					}
				}
				else {
					
					try {
						
						System.out.println("------Listagem------");
						System.out.println("N.∫ de Utilizadores: " + rs.getUtilizadors() + " Amigos");
						textArea_LU.append("N.∫ de Utilizadores: " + rs.getUtilizadors().size() + " Amigos\n\n");
						for (Utilizador utilizador : rs.getUtilizadors()) {
							
							textArea_LU.append("----------------------------------------\n\n");
							textArea_LU.append("Nome: " + utilizador.getNome() + "\n");
							textArea_LU.append("Cidade: " + utilizador.getCidade() + "\n");
							textArea_LU.append("Estado Civil: " + utilizador.getEstadoCivil() + "\n");
							textArea_LU.append("Nif: " + utilizador.getNumContribuinte() + "\n");
							textArea_LU.append("E-mail: " + utilizador.getEmail() + "\n");
							textArea_LU.append("Password: " + utilizador.getPassword() + "\n");
							textArea_LU.append("----------------------------------------\n\n");
						}
						
					} catch (Exception e2) {
						// TODO: handle exception
						System.err.println("Não foram criados novos utilizadores!");
					}

				}
			}
		});
		btnListarUtilizadores.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		
		JButton btnEnviarMensagem = new JButton("Enviar Mensagem");
		btnEnviarMensagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				panel_adicionarU.setVisible(false);
				panel_adicionarR.setVisible(false);
				panel_M.setVisible(true);
				
				adicionarDestinatario();
			}
		});
		btnEnviarMensagem.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		
		JButton btnListarMensagens = new JButton("Listar Mensagens");
		btnListarMensagens.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textArea_LM.setText("");
				panel_adicionarU.setVisible(false);
				panel_adicionarR.setVisible(false);
				panel_M.setVisible(false);
				panel_LM.setVisible(true);
				
				RedeSocial rs = new RedeSocial();
				int num = 1;
				for (Mensagem mensagem : rs.getMensagens()) {
					textArea_LM.append("-----------------------------------\n\n");
					textArea_LM.append("Mensagem nº : "+num+"\n\n");
					textArea_LM.append("Remetente: '"+mensagem.getUtilizadorQueEnvia()+"'\n");
					textArea_LM.append("Destinatário: '"+mensagem.getUtilizadorQueRecebe()+"'\n");
					textArea_LM.append("Assunto: '"+mensagem.getAssuntoMensagem()+"'\n");
					textArea_LM.append("Mensagem:'\n");
					textArea_LM.append(mensagem.getTextoMensagem()+"'\n\n");
					textArea_LM.append("-----------------------------------\n\n");
					num++;
				}
			}
		});
		btnListarMensagens.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNovoUtilizador)
						.addComponent(btnAdicionarRelacionamento, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnListarPedidos, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnListarUtilizadores, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnEnviarMensagem, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnListarMensagens, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSalvarDados, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnLerDados, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(19, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNovoUtilizador)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnAdicionarRelacionamento)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnListarPedidos)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnListarUtilizadores)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnEnviarMensagem)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(btnListarMensagens)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSalvarDados)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnLerDados)
					.addGap(27))
		);
		panel.setLayout(gl_panel);
		
		JLayeredPane layeredPane_1 = new JLayeredPane();
		layeredPane_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		layeredPane_1.setBounds(186, 6, 367, 303);
		contentPane.add(layeredPane_1);
		layeredPane_1.setLayout(new CardLayout(0, 0));
		
		panel_adicionarU = new JPanel();
		layeredPane_1.add(panel_adicionarU, "name_1465696193157095000");
		panel_adicionarU.setLayout(null);
		
		JLabel lblAdicionarUtilizador = new JLabel("Adicionar Utilizador");
		lblAdicionarUtilizador.setFont(new Font("Lucida Grande", Font.BOLD, 11));
		lblAdicionarUtilizador.setBounds(6, 6, 113, 16);
		panel_adicionarU.add(lblAdicionarUtilizador);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblNome.setBounds(16, 34, 61, 16);
		panel_adicionarU.add(lblNome);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblCidade.setBounds(16, 58, 61, 16);
		panel_adicionarU.add(lblCidade);
		
		JLabel lblEstadoCivil = new JLabel("Estado Civil");
		lblEstadoCivil.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblEstadoCivil.setBounds(16, 86, 61, 16);
		panel_adicionarU.add(lblEstadoCivil);
		
		JLabel lblNif = new JLabel("NIF");
		lblNif.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblNif.setBounds(16, 114, 61, 16);
		panel_adicionarU.add(lblNif);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblEmail.setBounds(16, 142, 61, 16);
		panel_adicionarU.add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblPassword.setBounds(16, 170, 61, 16);
		panel_adicionarU.add(lblPassword);
		
		tf_nome = new JTextField();
		tf_nome.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		tf_nome.setBounds(89, 34, 134, 16);
		panel_adicionarU.add(tf_nome);
		tf_nome.setColumns(10);
		
		tf_cidade = new JTextField();
		tf_cidade.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		tf_cidade.setColumns(10);
		tf_cidade.setBounds(89, 58, 134, 16);
		panel_adicionarU.add(tf_cidade);
		
		tf_nif = new JTextField();
		tf_nif.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		tf_nif.setColumns(10);
		tf_nif.setBounds(89, 114, 134, 16);
		panel_adicionarU.add(tf_nif);
		
		tf_mail = new JTextField();
		tf_mail.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		tf_mail.setColumns(10);
		tf_mail.setBounds(89, 142, 134, 16);
		panel_adicionarU.add(tf_mail);
		
		tf_password = new JPasswordField();
		tf_password.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		tf_password.setBounds(89, 169, 134, 16);
		panel_adicionarU.add(tf_password);
		
		cbEstadoCivil = new JComboBox();
		cbEstadoCivil.setModel(new DefaultComboBoxModel(new String[] {"Solteiro", "Casado", "Divorciado", "Viuvo"}));
		cbEstadoCivil.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		cbEstadoCivil.setBounds(89, 86, 134, 16);
		panel_adicionarU.add(cbEstadoCivil);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String nome =tf_nome.getText();
				String cidade =tf_cidade.getText();
				String estadoCivil =cbEstadoCivil.getSelectedItem().toString();
				String nif = tf_nif.getText();
				String email =tf_mail.getText();
				String password =tf_password.toString();
				
				Utilizador utilizador = new Utilizador();
				
				utilizador.setNome(nome);
				utilizador.setCidade(cidade);
				utilizador.setEstadoCivil(estadoCivil);
				utilizador.setNumContribuinte(nif);
				utilizador.setEmail(email);
				utilizador.setPassword(password);
				
				RedeSocial rS = new RedeSocial();
				rS.adicionarUtilizador(utilizador);
				
			}
		});
		btnAdicionar.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		btnAdicionar.setBounds(16, 221, 117, 29);
		panel_adicionarU.add(btnAdicionar);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nif = tf_nif.getText();
				
				if (nif.equals("")) {	
					JLabel label = new JLabel("Indique o NIF do utilizador que pretende remover");
					label.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
					JOptionPane.showMessageDialog(null,label,"ERRO",JOptionPane.WARNING_MESSAGE);
					return;
				}
				
				RedeSocial rs = new RedeSocial();
				rs.removerUtilizador(tf_nif.getText());
				
			
				
				
				
			}
		});
		btnRemover.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		btnRemover.setBounds(145, 220, 117, 29);
		panel_adicionarU.add(btnRemover);
		
		panel_adicionarR = new JPanel();
		layeredPane_1.add(panel_adicionarR, "name_1465696196543646000");
		panel_adicionarR.setLayout(null);
		
		JLabel lblAdicionarRelao = new JLabel("Adicionar Relação");
		lblAdicionarRelao.setFont(new Font("Lucida Grande", Font.BOLD, 11));
		lblAdicionarRelao.setBounds(6, 6, 113, 16);
		panel_adicionarR.add(lblAdicionarRelao);
		
		JLabel lblUtilizadores = new JLabel("Utilizadores");
		lblUtilizadores.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblUtilizadores.setBounds(16, 43, 61, 16);
		panel_adicionarR.add(lblUtilizadores);
		
		comboBoxU = new JComboBox();
		comboBoxU.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		comboBoxU.setBounds(26, 78, 195, 16);
		panel_adicionarR.add(comboBoxU);
		
		JButton btnPedido = new JButton("Fazer Pedido");
		btnPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nomeQuemEnviaPedido = comboBoxU.getSelectedItem().toString();
				String tipoPedido = comboBoxR.getSelectedItem().toString();
				
				
				System.out.println(nomeQuemEnviaPedido);
				System.out.println(tipoPedido);
								
				Utilizador user2 = new Utilizador();
				user2.setNome(comboBoxU.getSelectedItem().toString());
				
				TipoRelacao tR = null;
				if (comboBoxR.getSelectedItem().toString().equals("Amizade"))
					tR = TipoRelacao.AMIGO;
				
				if (comboBoxR.getSelectedItem().toString().equals("Familiar"))
					tR = TipoRelacao.FAMILIAR;
				
				if (comboBoxR.getSelectedItem().toString().equals("Profissional"))
					tR = TipoRelacao.PROFISSIONAL;
				
				tR.setUtilizadorQueEnvia(login.getNome());
				tR.setUtilizadorQueRecebe(user2.getNome());
				tR.setRelacionamento(tR.toString());
				tR.pedidoAmizade();
		
			}
		});
		btnPedido.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		btnPedido.setBounds(42, 185, 113, 29);
		panel_adicionarR.add(btnPedido);
		
		comboBoxR = new JComboBox();
		comboBoxR.setModel(new DefaultComboBoxModel(new String[] {"Amizade", "Familiar", "Profissional"}));
		comboBoxR.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		comboBoxR.setBounds(26, 138, 195, 16);
		panel_adicionarR.add(comboBoxR);
		
		JLabel lblTipoRelao = new JLabel("Tipo Relação");
		lblTipoRelao.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblTipoRelao.setBounds(16, 110, 83, 16);
		panel_adicionarR.add(lblTipoRelao);
		
		panel_login = new JPanel();
		layeredPane_1.add(panel_login, "name_1465710240792185000");
		panel_login.setLayout(null);
		
		JLabel label = new JLabel("Adicionar Utilizador");
		label.setFont(new Font("Lucida Grande", Font.BOLD, 11));
		label.setBounds(6, 6, 113, 16);
		panel_login.add(label);
		
		JLabel label_1 = new JLabel("Nome");
		label_1.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		label_1.setBounds(16, 35, 61, 16);
		panel_login.add(label_1);
		
		tf_login1 = new JTextField();
		tf_login1.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		tf_login1.setColumns(10);
		tf_login1.setBounds(63, 35, 144, 16);
		panel_login.add(tf_login1);
		
		JLabel lblNif_1 = new JLabel("Nif");
		lblNif_1.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblNif_1.setBounds(16, 63, 61, 16);
		panel_login.add(lblNif_1);
		
		tf_login2 = new JTextField();
		tf_login2.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		tf_login2.setColumns(10);
		tf_login2.setBounds(63, 63, 144, 16);
		panel_login.add(tf_login2);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String loginNome = tf_login1.getText();
				String loginNif = tf_login2.getText();
				
				RedeSocial rs = new RedeSocial();
				String resultado = rs.procurarUtilizador(loginNif);
				
				if (resultado == null) {
					for (int i = 0; i < listaGuardados.size(); i++) {
						if (listaGuardados.get(i).getNumContribuinte().equals(loginNif)) {
							 System.out.println("Encontrei o utilizador '"+listaGuardados.get(i).getNome()+"'");
							 login = listaGuardados.get(i);
							 panel_login.setVisible(false);
							 panel_adicionarR.setVisible(true);
							 adicionarRelacao(login);
						}
					}
					
				}
					
				
			}
		});
		btnEntrar.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		btnEntrar.setBounds(63, 91, 90, 29);
		panel_login.add(btnEntrar);
		
		panel_M = new JPanel();
		layeredPane_1.add(panel_M, "name_1465713394191337000");
		panel_M.setLayout(null);
		
		JLabel lblEnviarMensagem = new JLabel("Enviar Mensagem");
		lblEnviarMensagem.setFont(new Font("Lucida Grande", Font.BOLD, 11));
		lblEnviarMensagem.setBounds(6, 16, 113, 16);
		panel_M.add(lblEnviarMensagem);
		
		comboBox_Destino = new JComboBox();
		comboBox_Destino.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		comboBox_Destino.setBounds(89, 44, 134, 16);
		panel_M.add(comboBox_Destino);
		
		JLabel lblAssunto = new JLabel("Destinatário");
		lblAssunto.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblAssunto.setBounds(16, 44, 61, 16);
		panel_M.add(lblAssunto);
		
		JLabel lblAssunto_1 = new JLabel("Assunto");
		lblAssunto_1.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblAssunto_1.setBounds(16, 72, 61, 16);
		panel_M.add(lblAssunto_1);
		
		tf_assunto = new JTextField();
		tf_assunto.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		tf_assunto.setColumns(10);
		tf_assunto.setBounds(89, 72, 134, 16);
		panel_M.add(tf_assunto);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String assunto = tf_assunto.getText();
				String texto = textArea.getText();
				
				Mensagem m1 = new Mensagem();
				m1.setUtilizadorQueEnvia(login.getNome());
				m1.setUtilizadorQueRecebe(comboBox_Destino.getSelectedItem().toString());
				m1.setAssuntoMensagem(assunto);
				m1.setTextoMensagem(texto);
				RedeSocial rs = new RedeSocial();
				rs.mensagens.add(m1);
				System.out.println("A mensagem foi enviada com sucesso!"); 
				
				
			}
		});
		btnEnviar.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		btnEnviar.setBounds(6, 253, 117, 29);
		panel_M.add(btnEnviar);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		textArea.setBounds(16, 128, 318, 82);
		scroll = new JScrollPane(textArea);
		scroll.setBounds(16, 128, 318, 82);
		panel_M.add(scroll);
		
		JLabel lblMensagem = new JLabel("Mensagem");
		lblMensagem.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblMensagem.setBounds(16, 100, 61, 16);
		panel_M.add(lblMensagem);
		
		panel_LM = new JPanel();
		layeredPane_1.add(panel_LM, "name_1465714516713593000");
		panel_LM.setLayout(null);
		
		JLabel lblListarMensagens = new JLabel("Listar Mensagens");
		lblListarMensagens.setFont(new Font("Lucida Grande", Font.BOLD, 11));
		lblListarMensagens.setBounds(6, 6, 113, 16);
		panel_LM.add(lblListarMensagens);
		
		textArea_LM = new JTextArea();
		textArea_LM.setEditable(false);
		textArea_LM.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		textArea_LM.setBounds(16, 34, 316, 219);
		JScrollPane scroll = new JScrollPane(textArea_LM);
		scroll.setBounds(16, 34, 316, 219);
		panel_LM.add(scroll);
		
		panel_LP = new JPanel();
		layeredPane_1.add(panel_LP, "name_1465717282360871000");
		panel_LP.setLayout(null);
		
		JLabel lblListarPedidos = new JLabel("Listar Pedidos");
		lblListarPedidos.setFont(new Font("Lucida Grande", Font.BOLD, 11));
		lblListarPedidos.setBounds(6, 6, 113, 16);
		panel_LP.add(lblListarPedidos);
		
		textArea_LP = new JTextArea();
		textArea_LP.setEditable(false);
		textArea_LP.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		textArea_LP.setBounds(18, 36, 312, 215);
		scroll1 = new JScrollPane(textArea_LP);
		scroll1.setBounds(18, 36, 312, 215);
		panel_LP.add(scroll1);
		
		panel_LU = new JPanel();
		layeredPane_1.add(panel_LU, "name_1465717931160817000");
		panel_LU.setLayout(null);
		
		JLabel lblListarUtilizadores = new JLabel("Listar Utilizadores");
		lblListarUtilizadores.setFont(new Font("Lucida Grande", Font.BOLD, 11));
		lblListarUtilizadores.setBounds(6, 6, 113, 16);
		panel_LU.add(lblListarUtilizadores);
		
		textArea_LU = new JTextArea();
		textArea_LU.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		textArea_LU.setEditable(false);
		textArea_LU.setBounds(20, 38, 308, 211);
		scroll2 = new JScrollPane(textArea_LU);
		scroll2.setBounds(20, 38, 308, 211);
		panel_LU.add(scroll2);
	}

	protected void adicionarDestinatario() {
		
		// TODO Auto-generated method stub
		
		comboBox_Destino.removeAllItems();
		RedeSocial rs = new RedeSocial();
		ArrayList<Utilizador> listaUtilizadores = rs.listarUtilizadores();
		try {
			
			for (int i = 0 ; i < listaUtilizadores.size(); i++) {
				if (!login.getNumContribuinte().equals(listaUtilizadores.get(i).getNumContribuinte()))
					comboBox_Destino.addItem(listaUtilizadores.get(i).getNome());
			}
			
		} catch (NullPointerException e2) {
			// TODO: handle exception
			
			System.err.println("Não existem utilizadores criados agora!");
			try {
				
				for (int i = 0 ; i < listaGuardados.size(); i++) {
					if (!login.getNumContribuinte().equals(listaGuardados.get(i).getNumContribuinte()))
						comboBox_Destino.addItem(listaGuardados.get(i).getNome());
				}
				
			} catch (Exception e3) {
				// TODO: handle exception
				System.err.println("Não existem utilizadores guardados na base de dados!");

			}
			
			
		}
		
		
	}

	protected void adicionarRelacao(Utilizador login) 
	{
		// TODO Auto-generated method stub
	
		comboBoxU.removeAllItems();
		RedeSocial rs = new RedeSocial();
		ArrayList<Utilizador> listaUtilizadores = rs.listarUtilizadores();
		try {
			
			for (int i = 0 ; i < listaUtilizadores.size(); i++) {
				if (!login.getNumContribuinte().equals(listaUtilizadores.get(i).getNumContribuinte()))
					comboBoxU.addItem(listaUtilizadores.get(i).getNome());
			}
			
		} catch (NullPointerException e2) {
			// TODO: handle exception
			
			System.err.println("Não existem utilizadores criados agora!");
			try {
				
				for (int i = 0 ; i < listaGuardados.size(); i++) {
					if (!login.getNumContribuinte().equals(listaGuardados.get(i).getNumContribuinte()))
						comboBoxU.addItem(listaGuardados.get(i).getNome());
				}
				
			} catch (Exception e3) {
				// TODO: handle exception
				System.err.println("Não existem utilizadores guardados na base de dados!");

			}
			
			
		}
		
	}

	protected boolean lerDados() 
	{
		// TODO Auto-generated method stub
	

		
		BufferedReader br = null;
		String ficheiro = "/Users/tltr/Desktop/output.txt";
		
		String nome="";
		String cidade="";
		String ec="";
		String nif="";
		String mail="";
		String pass="";
		
		try {

			String sCurrentLine;
			br = new BufferedReader(new FileReader(ficheiro));
			 
			int lineCount = 1;
			int num = 0;
			while ((sCurrentLine = br.readLine()) != null) {
				if (lineCount == 6) {
					System.out.println("Utilizador "+num);
					Utilizador u = new Utilizador();
					u.setNome(nome);
					u.setCidade(cidade);
					u.setEstadoCivil(ec);
					u.setNumContribuinte(nif);
					u.setEmail(mail);
					u.setPassword(pass);
//					u.guardarUtilizador();
//					upload.add(u);
					listaGuardados.add(u);
					lineCount = 1;
					num++;

					
				}
				else {
					
					if (lineCount == 1) {
						nome = sCurrentLine;
						System.out.println("NOME >>> "+nome);
					}
					if (lineCount == 2) {
						cidade = sCurrentLine;
						System.out.println("CIDADE >>> "+cidade);
					}
					if (lineCount == 3) {
						ec = sCurrentLine;
						System.out.println("ESTADO_CIVIL >>> "+ec);
					}
					if (lineCount == 4) {
						nif = sCurrentLine;
						System.out.println("NIF >>> "+nif);
					}
					if (lineCount == 5) {
						mail = sCurrentLine;
						System.out.println("MAIL >>> "+mail+"\n\n");
					}
//					if (lineCount == 6) {
//						pass = sCurrentLine;
//						System.out.println("PASSWORD >>> "+pass+"\n\n");
//					}
					
//					System.out.println("current line >>> "+sCurrentLine);
					lineCount++;
				}
				
				
			}
		} catch (FileNotFoundException e0) {
			System.out.println("O ficheiro indicado ::: '"+ficheiro+"' ::: Não Existe...");

		} catch (IOException e1) {
			e1.printStackTrace();
		}finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();

			}
		}
		
		System.out.println("\n\n LISTADOS >>> "+listaGuardados.size());
		
		if (listaGuardados.isEmpty())
			return false;
		else
			return true;
	
		
	}
}
