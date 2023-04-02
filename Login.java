//Fonte Princportal: https://www.geeksforgeeks.org/java-swing-simple-user-registration-form/?ref=rp
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.UnknownHostException;

public class Login extends JFrame
implements ActionListener {
	// Components of the Form
    private JFrame frame;
	private Container c;
	private JLabel loginText;
    private JLabel t_port;
    private JLabel t_nome;
    private JLabel t_serve;
    private JLabel t_senha;
    private JLabel t_adm;
    private JLabel text1;
    private JLabel text2;
	private JTextField nome;
    private JTextField port;
	private JTextField serve;
    private JPasswordField senha;
	private JButton admBt;
	private JButton envBt;
	private JPanel bg_text;

	// constructor, to initialize the components
	// with default values.
	public Login()
	{
        frame = new JFrame();
        c = frame.getContentPane();

		setTitle("Registration Form");
		setBounds(300, 90, 900, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

		c = getContentPane();
		c.setLayout(null);
        c.setBackground(Color.WHITE);

		loginText = new JLabel("Sign In");
		loginText.setFont(new Font("Arial", Font.BOLD, 30));
		loginText.setSize(300, 33);
		loginText.setLocation(41, 80);
		c.add(loginText);

        t_nome = new JLabel("Nome:");
        t_nome.setFont(new Font("Arial", Font.PLAIN, 15));
        t_nome.setSize(63, 24);
        t_nome.setForeground(Color.GRAY);
        t_nome.setLocation(41, 145);
        c.add(t_nome);

		nome = new JTextField();
		nome.setFont(new Font("Arial", Font.PLAIN, 13));
		nome.setSize(365, 48);
		nome.setLocation(41, 170);
        nome.setBorder(null);
        nome.setForeground(Color.DARK_GRAY);
        nome.setBackground(Color.LIGHT_GRAY);
		c.add(nome);

        t_serve = new JLabel("Servidor:");
        t_serve.setFont(new Font("Arial", Font.PLAIN, 15));
        t_serve.setForeground(Color.GRAY);
        t_serve.setSize(63, 24);
        t_serve.setLocation(41, 240);
        c.add(t_serve);

		serve = new JTextField();
		serve.setFont(new Font("Arial", Font.PLAIN, 13));
		serve.setSize(365, 48);
        serve.setBorder(null);
		serve.setLocation(41, 265);
        serve.setBackground(Color.LIGHT_GRAY);
		c.add(serve);

        t_port = new JLabel("Porta:");
        t_port.setFont(new Font("Arial", Font.PLAIN, 15));
        t_port.setSize(63, 24);
        t_port.setForeground(Color.GRAY);
        t_port.setLocation(41, 320);
        c.add(t_port);

        port = new JTextField();
		port.setFont(new Font("Arial", Font.PLAIN, 12));
		port.setSize(175, 28);
        port.setBorder(null);
		port.setLocation(95, 320);
        port.setBackground(Color.LIGHT_GRAY);
		c.add(port);

		envBt = new JButton("ENVIAR");
		envBt.setFont(new Font("Arial", Font.BOLD, 15));
		envBt.setSize(190, 45);
		envBt.setLocation(119, 410);
        envBt.setForeground(Color.WHITE);
        envBt.setBackground(Color.decode("#9882CD"));
		envBt.addActionListener(this);
		c.add(envBt);

        t_adm = new JLabel("Logar como ADM Servidor");
        t_adm.setFont(new Font("Arial", Font.PLAIN, 12));
        t_adm.setSize(200, 24);
        t_adm.setForeground(Color.DARK_GRAY);
        t_adm.setLocation(152, 455);
        c.add(t_adm);

        admBt = new JButton();
		admBt.setSize(10, 10);
        admBt.setBackground(Color.GRAY);
		admBt.setLocation(132, 461);
        admBt.addActionListener(this);
		c.add(admBt);

        text1 = new JLabel("Bem-Vinda(o)!");
        text1.setFont(new Font("Arial", Font.BOLD, 40));
        text1.setForeground(Color.WHITE);
        text1.setSize(340, 87);
        text1.setLocation(530, 215);
        c.add(text1);

        text2 = new JLabel("Insira seus dados e entre em um bate-papo");
        text2.setFont(new Font("Arial", Font.PLAIN, 17));
        text2.setForeground(Color.WHITE);
        text2.setSize(390, 80);
        text2.setLocation(505, 260);
        c.add(text2);

        bg_text = new JPanel();
		bg_text.setSize(450, 600);
        bg_text.setBackground(Color.decode("#9882CD"));
		bg_text.setLocation(450, 0);
		c.add(bg_text);

        t_senha = new JLabel("Senha ADM:");
        t_senha.setFont(new Font("Arial", Font.PLAIN, 11));
        t_senha.setSize(63, 24);
        t_senha.setForeground(Color.WHITE);
        t_senha.setLocation(180, 360);
        c.add(t_senha);

        senha = new JPasswordField();
		senha.setFont(new Font("Arial", Font.CENTER_BASELINE, 11));
		senha.setSize(130, 25);
		senha.setLocation(150, 380);
        senha.setBorder(null);
        senha.setBackground(Color.decode("#E3DCF1"));
        senha.setVisible(false);
		c.add(senha);
        

		setVisible(true);
	}

	// method actionPerformed()
	// to get the action performed
	// by the user and act accordingly
	public void actionPerformed(ActionEvent e)
	{
        Gerenciador manager = new Gerenciador();

        if (e.getSource() == admBt) {
                senha.setVisible(true);
                t_senha.setForeground(Color.DARK_GRAY);
		}

        if (e.getSource() == envBt) {
            String u_nome, server;
            int porta;

            u_nome = nome.getText();
            server = serve.getText();
            porta =  Integer.parseInt(port.getText());

            //Logar usário com dados
            try {
                manager.client(server, porta, u_nome);
            } catch (UnknownHostException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            }

            String s;
            s = senha.getSelectedText();
            if(s == "admServer"){
            //Logar Servidor
            try {
                manager.server(porta);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            }
        }

    }

// Driver Code


	public static void main(String[] args) throws Exception
	{
		Login f = new Login();
	}
}
