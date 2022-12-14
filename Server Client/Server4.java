//chatting program via GUI
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

class Server4 extends Frame implements Runnable, ActionListener {
	Label l1, l2;
	Button b1, b2;
	TextArea t1, t2;
	DataInputStream dis;
	DataOutputStream dos;
	Thread th;
	Socket s;
	ServerSocket ss;
	String str;

	Server4() {
		super("Server");
		l1 = new Label("From Client :");
		t1 = new TextArea("", 10, 100, TextArea.SCROLLBARS_BOTH);// 10 rows,100 colomns
		t1.setEditable(false);

		l2 = new Label("To Client :");
		t2 = new TextArea("", 10, 100, TextArea.SCROLLBARS_BOTH);// 10 rows,100 colomns

		b1 = new Button("Enter");
		b2 = new Button("Clear");
		b1.addActionListener(this);
		b2.addActionListener(this);
		setLayout(null);

		l1.setBounds(50, 50, 100, 20);
		t1.setBounds(50, 80, 200, 100);
		l2.setBounds(50, 190, 100, 20);
		t2.setBounds(50, 220, 200, 100);
		b1.setBounds(50, 330, 70, 20);
		b2.setBounds(150, 330, 70, 20);
		add(l1);
		add(t1);
		add(l2);
		add(t2);
		add(b1);
		add(b2);

		setSize(400, 400);
		setVisible(true);

		try {
			ss = new ServerSocket(5051);
			s = ss.accept();
			dos = new DataOutputStream(s.getOutputStream());
			dis = new DataInputStream(s.getInputStream());
			th = new Thread(this);
			th.start();
		} catch (Exception e) {
		}
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	public void actionPerformed(ActionEvent e) {
		Button b = (Button) e.getSource();
		if (b == b2)
			t1.setText("");
		else {
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date date = new Date();
			str = "\n"+formatter.format(date) + "\n" + t2.getText();
			try {
				dos.writeUTF(str);
			} catch (Exception e2) {
			}
			t2.setText("");
		}
	}

	public void run() {
		while (true) {
			try {
				str = dis.readUTF();
			} catch (Exception e1) {
			}
			str = t1.getText() + "\n" + str;
			t1.setText(str);
		}
	}

	public static void main(String[] args) {
		Server4 a = new Server4();
	}
}
