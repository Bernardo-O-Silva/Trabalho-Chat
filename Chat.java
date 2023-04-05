import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Chat extends JFrame
implements ActionListener {
	// Components of the Form
    private JFrame frame;
	private Container container;

    private JLabel t_ola;
    private JLabel t_nome;

    private JLabel t_server;
    private JLabel t_adrres;
	private JLabel t_port;
	private JTextField n_adrres;
	private JTextField n_port;
    private JPanel bg_top;

    private JTextArea chat;
    private JScrollPane scroll;
    private JTextField mensage;
	private JButton m_envBt;

    private String digitado;
    private boolean jaEnviou = false;

    public String nome_user;
    public String adr_server;
    public int port_server;
    public boolean admin;

    private boolean saiu = false;

	// constructor, to initialize the components
	// with default values.
	public Chat(String nome_us, String server, Boolean adm_server, int porta_sv)
	{
        //Variaveis do construtor para a classe
        nome_user = nome_us;
        adr_server = server;
        port_server = porta_sv;
        admin = adm_server;

        frame = new JFrame();
        container = frame.getContentPane();

		setTitle("Chat");
		setBounds(300, 90, 900, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

		container = getContentPane();
		container.setLayout(null);
        container.setBackground(Color.decode("#DACCDD"));

        //Painel topo

        // Texto Oi + nome usuário 
        t_ola = new JLabel("Oi,"); 
        t_nome = new JLabel(nome_user + "!");
        //Personalizações
        //Texto Oi
        t_ola.setFont(new Font("Arial", Font.BOLD, 32));
        t_ola.setSize(165, 40);
        t_ola.setForeground(Color.WHITE);
        t_ola.setLocation(90, 15);
        container.add(t_ola);
        //Legenda Nome Usuario
        t_nome.setFont(new Font("Arial", Font.BOLD, 42));
        t_nome.setForeground(Color.WHITE);
        t_nome.setSize(250, 50);
        t_nome.setLocation(90, 50);
        container.add(t_nome);
        
        // Texto Servidor
        t_server = new JLabel("   Servidor"); 
        //Personalizações
        t_server.setFont(new Font("Arial", Font.BOLD, 17));
        t_server.setSize(405, 35);
        t_server.setLocation(360, 15);
        t_server.setOpaque(true);
        t_server.setBackground(Color.WHITE);
        t_server.setForeground(Color.decode("#9882CD"));
        container.add(t_server);

        // Texto Address e enderço do servidor
        t_adrres = new JLabel("  Address: ");
        n_adrres = new JTextField(adr_server);
        //Personalizações
        //Texto Addres
        t_adrres.setFont(new Font("Arial", Font.BOLD, 16));
		t_adrres.setSize(90, 30);
		t_adrres.setLocation(360, 55);
        t_adrres.setForeground(Color.WHITE);
        t_adrres.setOpaque(true);
        t_adrres.setBackground(Color.decode("#CBBFE8"));
		container.add(t_adrres);
        //Legenda endereço servidor
		n_adrres.setFont(new Font("Arial", Font.BOLD, 15));
		n_adrres.setSize(120, 20);
		n_adrres.setLocation(455, 58);
        n_adrres.setBorder(null);
        n_adrres.setForeground(Color.WHITE);
        n_adrres.setBackground(Color.decode("#9882CD"));
        n_adrres.setEditable(false);
		container.add(n_adrres);

        // Texto Port e porta do servidor
        t_port = new JLabel("  Port:"); 
        n_port = new JTextField(String.valueOf(port_server));
        //Personalizações
        //Texto Port
        t_port.setFont(new Font("Arial", Font.BOLD, 16));
		t_port.setSize(60, 30);
		t_port.setLocation(600, 55);
        t_port.setForeground(Color.WHITE);
        t_port.setOpaque(true);
        t_port.setBackground(Color.decode("#CBBFE8"));
		container.add(t_port);
        //Legenda porta do servidor
		n_port.setFont(new Font("Arial", Font.BOLD, 15));
		n_port.setSize(120, 20);
		n_port.setLocation(665, 60);
        n_port.setBorder(null);
        n_port.setForeground(Color.WHITE);
        n_port.setBackground(Color.decode("#9882CD"));
        n_port.setEditable(false);
		container.add(n_port);
        
        //Background do topo
        bg_top = new JPanel();
		bg_top.setSize(900, 110);
        bg_top.setBackground(Color.decode("#9882CD"));
		bg_top.setLocation(0, 0);
		container.add(bg_top);

        //Painel main
        //Campo de texto mensagem e botão de envio
        mensage = new JTextField();
        m_envBt = new JButton("ENVIAR");
        //Chat (onde são impressas as mensagens)
        chat = new JTextArea();
        //Personalizações
        //Campo de texto mensagem
		mensage.setFont(new Font("Arial", Font.PLAIN, 13));
		mensage.setSize(620, 45);
		mensage.setLocation(40, 490);
        mensage.setForeground(Color.DARK_GRAY);
        mensage.setBackground(Color.WHITE);
		container.add(mensage);
        //Botão de envio
		m_envBt.setFont(new Font("Arial", Font.BOLD, 15));
		m_envBt.setSize(200, 45);
		m_envBt.setLocation(650, 490);
        m_envBt.setForeground(Color.WHITE);
        m_envBt.setBackground(Color.decode("#9882CD"));
		m_envBt.addActionListener(this);
		container.add(m_envBt);
        //Area Chat
		chat.setFont(new Font("Arial", Font.PLAIN, 13));
		chat.setSize(810, 350);
		chat.setLocation(40, 125);
        chat.setBorder(null);
        chat.setForeground(Color.DARK_GRAY);
        chat.setBackground(Color.WHITE);
        chat.setEditable(false);
        //Rolagem do Chat
        scroll = new JScrollPane(chat);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setBounds(40, 125, 810, 350);
        container.add(scroll);

        if(admin == true){
            mensage.setVisible(false);
            mensage.setEditable(false);
            m_envBt.setText("Fechar Servidor");
            m_envBt.setBackground(Color.decode("#FF7878"));
		    m_envBt.addActionListener(this);
        }

		setVisible(true);

	}

    /* admin == true
     * adiminstrador(servidor) logou no Chat
     * 
     * admin == false
     * usuário(cliente) logou no Chat
     */

	public void actionPerformed(ActionEvent e)
	{

        if(admin == false){
            if (e.getSource() == m_envBt) {
                this.digitado = mensage.getText();
                this.mensage.setText("");
                this.jaEnviou = true;
            }
        }   else{
            if (e.getSource() == m_envBt) {
                this.saiu = true;
                setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                this.dispose();
            }
        }

    }

    public void erro_in(){
        //Muda o tamanho da tela e cor de fundo da tela (container)
        setBounds (300, 90, 600, 400);
        container.setBackground (Color.WHITE);

        //Tira a visbilidade dos itens não utilizados
        t_server.setVisible(false); 
        t_adrres.setVisible(false);
        t_port.setVisible(false);
        n_adrres.setVisible(false);
        n_port.setVisible(false);
        chat.setVisible(false);
        scroll.setVisible(false);

        //Altera texto e tamanho das fontes
        t_ola.setFont(new Font("Arial", Font.BOLD, 35));
        t_nome.setFont(new Font("Arial", Font.BOLD, 25));
        
        t_ola.setText("Ocorreu um ERRO!");
        t_nome.setText("Confira os dados inseridos");
        
        t_ola.setLocation (30, 50);     t_nome.setLocation (30, 100);
        
        t_ola.setSize(600, 40);          t_nome.setSize(600, 50);
        
        //Altera posição background, botão e texto
        bg_top.setSize(600, 250); 
        m_envBt.setText("SAIR");
        m_envBt.setLocation (200, 300);
    }


    public void setMessage(String msg){

        this.chat.append(msg+"\n");

    }

    public String getDigitado(){

        this.jaEnviou = false;
        return this.digitado;

    }

    public void setNull(){

        this.digitado = null;

    }

    public boolean foiEnviado(){

        return this.jaEnviou;

    }

    public JTextField getTxt(){

        return this.mensage;

    }    

    public boolean getSaiu(){

        return this.saiu;

    }


}
