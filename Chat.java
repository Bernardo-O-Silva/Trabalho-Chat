import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Chat extends JFrame
implements ActionListener {
	// Components of the Form
	private Container c;

    private JLabel t_user;
    private JLabel t_ola;
    private JLabel t_left;
    private JLabel t_nome;
    private JPanel bg_left;
    private JTextField users;

    private JLabel t_adrres;
	private JLabel t_Nuser;
	private JTextField n_adrres;
	private JTextField n_user;
    private JPanel bg_top;

    private JTextField chat;
    private JTextField mensage;
	private JButton m_envBt;
    private JPanel bg_main;

	// constructor, to initialize the components
	// with default values.
	public Chat()
	{
		setTitle("Registration Form");
		setBounds(300, 90, 900, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

		c = getContentPane();
		c.setLayout(null);
        c.setBackground(Color.decode("#EDEDED"));

        //Painel Lateral

        t_ola = new JLabel("Oi,");
        t_ola.setFont(new Font("Arial", Font.BOLD, 40));
        t_ola.setSize(165, 40);
        t_ola.setForeground(Color.WHITE);
        t_ola.setLocation(32, 15);
        c.add(t_ola);
        
        t_nome = new JLabel("......!");
        t_nome.setFont(new Font("Arial", Font.BOLD, 32));
        t_nome.setForeground(Color.WHITE);
        t_nome.setSize(165, 50);
        t_nome.setLocation(32, 60);
        c.add(t_nome);
        
        t_left = new JLabel("Participe do bate-papo");
        t_left.setFont(new Font("Arial", Font.PLAIN, 15));
        t_left.setForeground(Color.WHITE);
        t_left.setSize(165, 50);
        t_left.setLocation(32, 93);
        c.add(t_left);

        t_user = new JLabel("Usuarios:");
        t_user.setFont(new Font("Arial", Font.BOLD, 18));
        t_user.setSize(170, 30);
        t_user.setForeground(Color.WHITE);
        t_user.setLocation(32, 150);
        c.add(t_user);

		users = new JTextField();
		users.setFont(new Font("Arial", Font.PLAIN, 14));
		users.setSize(170, 360);
		users.setLocation(23, 180);
        users.setBorder(null);
        users.setForeground(Color.DARK_GRAY);
        users.setBackground(Color.WHITE);
		c.add(users);
        
        bg_left = new JPanel();
		bg_left.setSize(219, 600);
        bg_left.setBackground(Color.decode("#9882CD"));
		bg_left.setLocation(0, 0);
		c.add(bg_left);

        //Painel Topo

        t_adrres = new JLabel("Server addres: ");
        t_adrres.setFont(new Font("Arial", Font.BOLD, 13));
		t_adrres.setSize(100, 40);
		t_adrres.setLocation(310, 35);
        t_adrres.setForeground(Color.darkGray);
		c.add(t_adrres);

        n_adrres = new JTextField("x");
		n_adrres.setFont(new Font("Arial", Font.BOLD, 13));
		n_adrres.setSize(50, 40);
		n_adrres.setLocation(420, 35);
        n_adrres.setBorder(null);
        n_adrres.setForeground(Color.DARK_GRAY);
        n_adrres.setBackground(Color.decode("#CBBFE8"));
        n_adrres.setEditable(false);
		c.add(n_adrres);

        t_Nuser = new JLabel("User Online: ");
        t_Nuser.setFont(new Font("Arial", Font.BOLD, 13));
		t_Nuser.setSize(200, 40);
		t_Nuser.setLocation(620, 35);
        t_Nuser.setForeground(Color.darkGray);
		c.add(t_Nuser);

        n_user = new JTextField("x");
		n_user.setFont(new Font("Arial", Font.BOLD, 13));
		n_user.setSize(50, 40);
		n_user.setLocation(720, 35);
        n_user.setBorder(null);
        n_user.setForeground(Color.DARK_GRAY);
        n_user.setBackground(Color.decode("#CBBFE8"));
        n_user.setEditable(false);
		c.add(n_user);
        
        bg_top = new JPanel();
		bg_top.setSize(609, 65);
        bg_top.setBackground(Color.decode("#CBBFE8"));
		bg_top.setLocation(255, 25);
		c.add(bg_top);

        //Painel main

        mensage = new JTextField(" Insira sua mensagem aqui...");
		mensage.setFont(new Font("Arial", Font.PLAIN, 13));
		mensage.setSize(430, 45);
		mensage.setLocation(255, 470);
        mensage.setForeground(Color.DARK_GRAY);
        mensage.setBackground(Color.WHITE);
		c.add(mensage);

        m_envBt = new JButton("ENVIAR");
		m_envBt.setFont(new Font("Arial", Font.BOLD, 15));
		m_envBt.setSize(180, 45);
		m_envBt.setLocation(685, 470);
        m_envBt.setForeground(Color.WHITE);
        m_envBt.setBackground(Color.decode("#9882CD"));
		m_envBt.addActionListener(this);
		c.add(m_envBt);

        chat = new JTextField();
		chat.setFont(new Font("Arial", Font.PLAIN, 13));
		chat.setSize(610, 370);
		chat.setLocation(255, 84);
        chat.setBorder(null);
        chat.setForeground(Color.DARK_GRAY);
        chat.setBackground(Color.WHITE);
        chat.setEditable(false);
		c.add(chat);

        bg_main = new JPanel();
		bg_main.setSize(685, 600);
		bg_main.setLocation(220, 0);
		c.add(bg_main);

		setVisible(true);
	}

	// method actionPerformed()
	// to get the action performed
	// by the user and act accordingly
	public void actionPerformed(ActionEvent e)
	{


        if (e.getSource() == m_envBt) {
            //enviar mensagem ao servidor
        }

    }

// Driver Code


	public static void main(String[] args) throws Exception
	{
		Chat f = new Chat();
	}
}
