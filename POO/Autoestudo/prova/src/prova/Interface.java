package prova;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;

/**
 */
public class Interface extends JFrame {
	private HashMap<String, Telefone> redeTelefonica = new HashMap<>();

	private JPanel contentPane;
	private JTextField txtNomeUsuario;
	private JTextField txtEndereco;
	private JFormattedTextField txtDataInstalacao;
	private JFormattedTextField txtNumeroTelefone;
	private JFormattedTextField txtNumeroTelefoneConsulta;
	private JComboBox cbxTipoViagem;
	private JComboBox cbxConexaoInternet;
	private JTextField txtRamoAtividade;
	private JTextField txtQtdeOcorrencias;
	private DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public Interface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 500);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNomeUser = new JLabel("Nome usu�rio:");
		lblNomeUser.setBounds(10, 10, 118, 39);
		contentPane.add(lblNomeUser);

		txtNomeUsuario = new JTextField();
		txtNomeUsuario.setColumns(10);
		txtNomeUsuario.setBounds(124, 10, 330, 24);
		contentPane.add(txtNomeUsuario);

		JLabel lblEndereco = new JLabel("Endere�o:");
		lblEndereco.setBounds(10, 50, 118, 39);
		contentPane.add(lblEndereco);

		txtEndereco = new JTextField();
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(124, 50, 330, 24);
		contentPane.add(txtEndereco);

		JLabel lblDataInstalacao = new JLabel("Data Instala��o:");
		lblDataInstalacao.setBounds(10, 90, 118, 39);
		contentPane.add(lblDataInstalacao);

		MaskFormatter mascaraData = null;
		try {
			mascaraData = new MaskFormatter("##/##/####");
			mascaraData.setPlaceholderCharacter('_');
		} catch (ParseException excp) {
			System.err.println("Erro na formata��o: " + excp.getMessage());
		}
		txtDataInstalacao = new JFormattedTextField(mascaraData);
		txtDataInstalacao.setColumns(10);
		txtDataInstalacao.setBounds(124, 90, 330, 24);
		contentPane.add(txtDataInstalacao);

		JLabel lblNumero = new JLabel("N�mero:");
		lblNumero.setBounds(10, 130, 118, 39);
		contentPane.add(lblNumero);

		MaskFormatter mascaraTelefone = null;
		try {
			mascaraTelefone = new MaskFormatter("(##) ####-####");
			mascaraTelefone.setPlaceholderCharacter('_');
		} catch (ParseException excp) {
			System.err.println("Erro na formata��o: " + excp.getMessage());
		}
		txtNumeroTelefone = new JFormattedTextField(mascaraTelefone);
		txtNumeroTelefone.setColumns(10);
		txtNumeroTelefone.setBounds(124, 130, 330, 24);
		contentPane.add(txtNumeroTelefone);

		JLabel lblTipoLinha = new JLabel("Tipo linha:");
		lblTipoLinha.setBounds(10, 170, 118, 39);
		contentPane.add(lblTipoLinha);

		cbxTipoViagem = new JComboBox();
		cbxTipoViagem.setBounds(124, 170, 118, 29);
		cbxTipoViagem.setModel(listarTiposLinhasTelefonicas());
		cbxTipoViagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cbxTipoViagem.getSelectedIndex() == 0) {
					cbxConexaoInternet.setEnabled(true);
					txtRamoAtividade.setEnabled(false);
					txtQtdeOcorrencias.setEnabled(false);
				} else if (cbxTipoViagem.getSelectedIndex() == 1) {
					cbxConexaoInternet.setEnabled(false);
					txtRamoAtividade.setEnabled(true);
					txtQtdeOcorrencias.setEnabled(false);
				} else if (cbxTipoViagem.getSelectedIndex() == 2) {
					cbxConexaoInternet.setEnabled(false);
					txtRamoAtividade.setEnabled(false);
					txtQtdeOcorrencias.setEnabled(true);
				}
			}
		});
		contentPane.add(cbxTipoViagem);

		JLabel lblConexaoInternet = new JLabel("Conex�o internet:");
		lblConexaoInternet.setBounds(10, 210, 118, 39);
		contentPane.add(lblConexaoInternet);

		cbxConexaoInternet = new JComboBox();
		cbxConexaoInternet.setBounds(124, 210, 118, 29);
		cbxConexaoInternet.setModel(listarConexaoInternet());
		contentPane.add(cbxConexaoInternet);

		JLabel lblRamoAtividade = new JLabel("Ramo atividade:");
		lblRamoAtividade.setBounds(10, 250, 118, 39);
		contentPane.add(lblRamoAtividade);

		txtRamoAtividade = new JTextField();
		txtRamoAtividade.setColumns(10);
		txtRamoAtividade.setBounds(124, 250, 330, 24);
		txtRamoAtividade.setEnabled(false);
		contentPane.add(txtRamoAtividade);

		JLabel lblQtdeOcorrencias = new JLabel("Qtde ocorr�ncias:");
		lblQtdeOcorrencias.setBounds(10, 280, 118, 39);
		contentPane.add(lblQtdeOcorrencias);

		txtQtdeOcorrencias = new JTextField();
		txtQtdeOcorrencias.setColumns(10);
		txtQtdeOcorrencias.setBounds(124, 280, 330, 24);
		txtQtdeOcorrencias.setEnabled(false);
		contentPane.add(txtQtdeOcorrencias);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		btnCadastrar.setBackground(Color.LIGHT_GRAY);
		btnCadastrar.setBounds(10, 320, 445, 27);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nomeUsuario = txtNomeUsuario.getText();
				String endereco = txtEndereco.getText();
				String dataInstalacao = txtDataInstalacao.getText();
				String numero = formatarCampo(txtNumeroTelefone.getText());
				String tipoLinha = (String) cbxTipoViagem.getSelectedItem();

				if (redeTelefonica.containsKey(numero)) {
					JOptionPane.showMessageDialog(null, "N�mero j� cadastrado!");
					return;
				}

				if (nomeUsuario.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Nome de usu�rio inv�lido!");
					return;
				}
				if (endereco.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Endere�o inv�lido!");
					return;
				}

				if (numero.contains("_")) {
					JOptionPane.showMessageDialog(null, "Numero inv�lido!");
					return;
				}

				try {
					LocalDate data = LocalDate.parse(dataInstalacao, formatador);

					Telefone telefone;

					if (tipoLinha.equals("Residencial")) {
						boolean conexao = cbxConexaoInternet.getSelectedIndex() == 0;
						telefone = new Residencial();
						((Residencial) telefone).setPossuiInternet(conexao);
						;
					} else if (tipoLinha.equals("Comercial")) {
						String ramo = txtRamoAtividade.getText();

						if (ramo.isEmpty()) {
							JOptionPane.showMessageDialog(null, "Ramo de atividade inv�lida!");
							return;
						}
						telefone = new Comercial();
						((Comercial) telefone).setRamoAtividade(ramo);

					} else {
						String qtdeOcorrencias = txtQtdeOcorrencias.getText();

						if (qtdeOcorrencias.isEmpty() || !validarInteger(qtdeOcorrencias)) {
							JOptionPane.showMessageDialog(null, "Quantidade ocorr�ncias inv�lida!");
							return;
						}
						telefone = new Especializada();
						((Especializada) telefone).setQuantidadeOcorrencias(Integer.parseInt(qtdeOcorrencias));
					}
					telefone.setNomeUsuario(nomeUsuario);
					telefone.setNumero(numero);
					telefone.setEnderecoInstalacao(endereco);
					telefone.setDataInstalacao(data);
					redeTelefonica.put(telefone.getNumero(), telefone);

					limparCampos();
					JOptionPane.showMessageDialog(null, "Linha telefonica cadastrada com sucesso!");
				} catch (DateTimeParseException exc) {
					JOptionPane.showMessageDialog(null, "Data de instala��o com formato inv�lido");
				}
			}
		});
		contentPane.add(btnCadastrar);

		JLabel lblNumeroConsulta = new JLabel("N�mero consultar:");
		lblNumeroConsulta.setBounds(10, 350, 118, 39);
		contentPane.add(lblNumeroConsulta);

		txtNumeroTelefoneConsulta = new JFormattedTextField(mascaraTelefone);
		txtNumeroTelefoneConsulta.setColumns(10);
		txtNumeroTelefoneConsulta.setBounds(128, 360, 150, 24);
		contentPane.add(txtNumeroTelefoneConsulta);

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		btnConsultar.setBackground(Color.LIGHT_GRAY);
		btnConsultar.setBounds(290, 360, 165, 24);
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String numero = formatarCampo(txtNumeroTelefoneConsulta.getText());
				Telefone telefone = redeTelefonica.get(numero);
				if (telefone == null) {
					JOptionPane.showMessageDialog(null, "N�mero n�o localizado");
					return;
				}
				String mensagem = "Nome usuario: " + telefone.getNomeUsuario() + "\n Endere�o instala��o: "
						+ telefone.getEnderecoInstalacao() + "\n Data instala��o: " + telefone.getDataInstalacao()
						+ "\n N�mero: " + telefone.getNumero() + "\n Valor a pagar: R$ "
						+ telefone.calcularCustoFixoMensal();
				JOptionPane.showMessageDialog(null, mensagem);
			}
		});
		contentPane.add(btnConsultar);

		JButton btnConsultarFaturamento = new JButton("Consultar faturamento");
		btnConsultarFaturamento.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		btnConsultarFaturamento.setBackground(Color.LIGHT_GRAY);
		btnConsultarFaturamento.setBounds(290, 400, 165, 24);
		btnConsultarFaturamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double valorTotal = 0;
				for (Telefone t : redeTelefonica.values()) {
					valorTotal += t.calcularCustoFixoMensal(); // polimorfismo
				}
				JOptionPane.showMessageDialog(null, "Total faturado: R$ " + valorTotal);
			}
		});
		contentPane.add(btnConsultarFaturamento);
	}

	private String formatarCampo(String campo) {
		return campo.replace("(", "").replace(")", "").replace(" ", "").replace("-", "");
	}

	private void limparCampos() {
		txtNomeUsuario.setText("");
		txtEndereco.setText("");
		txtDataInstalacao.setValue(null);
		txtNumeroTelefone.setValue(null);
		cbxTipoViagem.setSelectedIndex(0);
	}

	public DefaultComboBoxModel<String> listarConexaoInternet() {
		DefaultComboBoxModel<String> dados = new DefaultComboBoxModel<String>();
		dados.addElement("Sim");
		dados.addElement("N�o");
		return dados;
	}

	public DefaultComboBoxModel<String> listarTiposLinhasTelefonicas() {
		DefaultComboBoxModel<String> dados = new DefaultComboBoxModel<String>();
		dados.addElement("Residencial");
		dados.addElement("Comercial");
		dados.addElement("Especializacao");
		return dados;
	}

	public boolean validarInteger(String valor) {
		try {
			Integer.parseInt(valor);
		} catch (NumberFormatException | NullPointerException e) {
			return false;
		}
		return true;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface window = new Interface();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}