import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

class UseStudyCafe extends JPanel implements ActionListener
{
	JButton login, signup, loginbtn, lgcancel, signupbtn, sucancel, selectcancel, ok, loginbtn2, lgcancel2, findid, findpw, findid2, findpw2;
	JPanel loginscreen, signupscreen, checkininit, loginscreen2, ckoutlogin;
	JLabel lgidl, lgpwl, suidl, supwl, supwckl, sunamel, suphonenuml, lgidl2, lgpwl2;
	JTextField lgidtf, suidtf, sunametf, suphonenumtf, lgidtf2;
	JPasswordField lgpwtf, supwtf, supwck, lgpwtf2;

	GridBagConstraints constraint = new GridBagConstraints();
	GridBagLayout gridbag = new GridBagLayout();

	SeatScreen seatscreen;
	SeatSystem seatsystem = new SeatSystem();
	Join joinmem = new Join(seatsystem);
	CheckIn checkin = new CheckIn(seatsystem);
	CheckOut checkout = new CheckOut(seatsystem);

	String inputname, inputid, inputpw, inputpwck, inputpn;
	int index, answer; 
	int memnum = 0;

	boolean checkinstart = false;
	boolean joinstart = false;
	boolean checkoutstart = false;

	Color bg = new Color(230,225,255);
	Color pink = new Color(255,150,150);
	Color blue = new Color(130,170,250);
	Color yellow = new Color(255,250,150);
	Color gray = new Color(230,230,230);

	Font bigfont = new Font("HY����M",Font.PLAIN,20);
	Font smallfont = new Font("HY����M",Font.PLAIN,15);
	Font smallestfont = new Font("HY����M",Font.PLAIN,10);

	InputTextField itf = new InputTextField(); // Exception

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy�� MM�� dd�� hh�� mm�� ");

	public UseStudyCafe() {
		
		//�Խ� �ʱ�ȭ��
		login = new JButton("�α���");
		login.addActionListener(this);
		login.setFont(bigfont);
		login.setBackground(pink);

		signup = new JButton("ȸ������");
		signup.addActionListener(this);
		signup.setFont(bigfont);
		signup.setBackground(blue);

		checkininit = new JPanel();
		checkininit.add(login);
		checkininit.add(signup);
		checkininit.setBackground(bg);

		add(checkininit);
		setBackground(bg);
		
		//�α��� ȭ�� ( �Խ� )
		loginscreen = new JPanel();
		loginscreen.setLayout(gridbag);
		constraint.fill = GridBagConstraints.BOTH;
		loginscreen.setBackground(bg);

		lgidl = new JLabel("ID");
		lgidtf = new JTextField(15);
		lgpwl = new JLabel("PW");
		lgpwtf = new JPasswordField(15);
		lgpwtf.setEchoChar('*');

		loginbtn = new JButton("�α���");
		loginbtn.addActionListener(this);
		loginbtn.setFont(smallfont);
		loginbtn.setBackground(pink);

		lgcancel = new JButton("���");
		lgcancel.addActionListener(this);
		lgcancel.setFont(smallfont);
		lgcancel.setBackground(Color.WHITE);

		findid = new JButton("ID ã��");
		findid.addActionListener(this);
		findid.setFont(smallestfont);
		findid.setBackground(gray);

		findpw = new JButton("PW ã��");
		findpw.addActionListener(this);
		findpw.setFont(smallestfont);
		findpw.setBackground(gray);

		layoutP(loginscreen,lgidl,0,0,1,1);
		layoutP(loginscreen,lgpwl,0,1,1,1);
		layoutP(loginscreen,lgidtf,1,0,2,1);
		layoutP(loginscreen,lgpwtf,1,1,2,1);
		layoutP(loginscreen,loginbtn,1,2,1,1);
		layoutP(loginscreen,lgcancel,2,2,1,1);
		layoutP(loginscreen,findid,3,0,1,1);
		layoutP(loginscreen,findpw,3,1,1,1);
		
		//�α��� ȭ�� ( ��� )
		loginscreen2 = new JPanel();
		loginscreen2.setBackground(bg);
		loginscreen2.setLayout(gridbag);
		constraint.fill = GridBagConstraints.BOTH;

		lgidl2 = new JLabel("ID");
		lgidtf2 = new JTextField(15);
		lgpwl2 = new JLabel("PW");
		lgpwtf2 = new JPasswordField(15);
		lgpwtf2.setEchoChar('*');

		loginbtn2 = new JButton("�α���");
		loginbtn2.addActionListener(this);
		loginbtn2.setFont(smallfont);
		loginbtn2.setBackground(yellow);

		lgcancel2 = new JButton("���");
		lgcancel2.addActionListener(this);
		lgcancel2.setFont(smallfont);
		lgcancel2.setBackground(Color.WHITE);

		findid2 = new JButton("ID ã��");
		findid2.addActionListener(this);
		findid2.setFont(smallestfont);
		findid2.setBackground(gray);

		findpw2 = new JButton("PW ã��");
		findpw2.addActionListener(this);
		findpw2.setFont(smallestfont);
		findpw2.setBackground(gray);

		layoutP(loginscreen2,lgidl2,0,0,1,1);
		layoutP(loginscreen2,lgpwl2,0,1,1,1);
		layoutP(loginscreen2,lgidtf2,1,0,2,1);
		layoutP(loginscreen2,lgpwtf2,1,1,2,1);
		layoutP(loginscreen2,loginbtn2,1,2,1,1);
		layoutP(loginscreen2,lgcancel2,2,2,1,1);
		layoutP(loginscreen2,findid2,3,0,1,1);
		layoutP(loginscreen2,findpw2,3,1,1,1);
		
		ckoutlogin = new JPanel(new BorderLayout());
		ckoutlogin.setBackground(bg);
		ckoutlogin.add(loginscreen2,BorderLayout.NORTH);

		//ȸ�� ���� ȭ�� ( �Խ� )
		signupscreen = new JPanel();
		signupscreen.setLayout(gridbag);
		signupscreen.setBackground(bg);

		suidl = new JLabel("ID");
		suidtf = new JTextField(15);
		supwl = new JLabel("PW");
		supwtf = new JPasswordField(15);
		supwtf.setEchoChar('*');
		supwckl = new JLabel("PW Ȯ��");
		supwck = new JPasswordField(15);
		supwck.setEchoChar('*');
		sunamel = new JLabel("�̸�");
		sunametf = new JTextField(15);
		suphonenuml = new JLabel("��ȭ��ȣ");
		suphonenumtf = new JTextField(15);

		signupbtn = new JButton("ȸ������");
		signupbtn.addActionListener(this);
		signupbtn.setFont(smallfont);
		signupbtn.setBackground(blue);
		
		sucancel = new JButton("���");
		sucancel.addActionListener(this);
		sucancel.setFont(smallfont);
		sucancel.setBackground(Color.WHITE);

		layoutP(signupscreen,sunamel,0,0,1,1);
		layoutP(signupscreen,suidl,0,1,1,1);
		layoutP(signupscreen,supwl,0,2,1,1);
		layoutP(signupscreen,supwckl,0,3,1,1);
		layoutP(signupscreen,suphonenuml,0,4,1,1);
		layoutP(signupscreen,sunametf,1,0,2,1);
		layoutP(signupscreen,suidtf,1,1,2,1);
		layoutP(signupscreen,supwtf,1,2,2,1);
		layoutP(signupscreen,supwck,1,3,2,1);
		layoutP(signupscreen,suphonenumtf,1,4,2,1);
		layoutP(signupscreen,signupbtn,1,5,1,1);
		layoutP(signupscreen,sucancel,2,5,1,1);

		ok = new JButton("Ȯ��");
		ok.addActionListener(this);
		ok.setFont(smallfont);
		ok.setBackground(new Color(200,215,180));

		selectcancel = new JButton("��� �� �α׾ƿ�");
		selectcancel.addActionListener(this);
		selectcancel.setFont(smallfont);
		selectcancel.setBackground(Color.WHITE);
	}

	public void actionPerformed(ActionEvent e){
		Object o = e.getSource();
		if(o == login) {
			removeAll();
			add(loginscreen);
			revalidate();
			repaint();
		} else if(o == signup) {
			removeAll();
			add(signupscreen);
			revalidate();
			repaint();
		} else if(o == loginbtn){
			inputid = (String)lgidtf.getText();
			inputpw = (String)lgpwtf.getText();
			try	{
				itf.checktfblank(inputid); 
				itf.checktfblank(inputpw);
				itf.checkexistedid(seatsystem.idarray,inputid);
				index = seatsystem.idarray.indexOf(inputid);
				itf.checkdiffpw(seatsystem.pwarray.get(index),inputpw);
				itf.checkstate(seatsystem.memberstate.get(index));

				seatscreen  =  new SeatScreen(seatsystem.seatcheck);
				seatscreen.layout(selectcancel,8,11,3,1);
				seatscreen.layout(ok,7,11,1,1);
				removeAll();
				add(seatscreen);
				revalidate();
				repaint();
				lgidtf.setText(null);
				lgpwtf.setText(null);
			}	catch (BlankException be)	{ JOptionPane.showMessageDialog(loginscreen,"��ĭ�� ä���ּ���."); }
				catch (NonExistedIdException neie)	{ JOptionPane.showMessageDialog(loginscreen,"�������� �ʴ� ���̵� �Դϴ�.");}
				catch (DiffpwException de)	{ JOptionPane.showMessageDialog(loginscreen,"��й�ȣ�� ���� �ʽ��ϴ�.");}
				catch (CheckinStateException cise) { JOptionPane.showMessageDialog(loginscreen,"�̹� �Խ� ���� �Դϴ�.");}
		} else if ( o == signupbtn )	{
			inputname = (String)sunametf.getText();
			inputid = (String)suidtf.getText();
			inputpw = (String)supwtf.getText();
			inputpwck = (String)supwck.getText();
			inputpn = (String)suphonenumtf.getText();
			try	{
				itf.checktfblank(inputname);
				itf.checktfblank(inputid);
				itf.checktfblank(inputpw);
				itf.checktfblank(inputpwck);
				itf.checktfblank(inputpn);
				itf.checksameid(seatsystem.idarray,inputid);
				itf.checkdiffpw(inputpw, inputpwck);
				itf.checksamepn(seatsystem.phonenumarray,inputpn);
				if (joinstart == false)	{
					joinmem.start();
					joinstart = true;
				} else joinmem.run();
				JOptionPane.showMessageDialog(signupscreen,"ȸ������ �Ϸ�");
				removeAll();
				add(loginscreen);
				revalidate();
				repaint();
				sunametf.setText(null);
				suidtf.setText(null);
				supwtf.setText(null);
				supwck.setText(null);
				suphonenumtf.setText(null);
			}	catch (BlankException be)	{ JOptionPane.showMessageDialog(signupscreen,"��ĭ�� ä���ּ���."); }
				catch (ExistedSameIdException esie)	{ JOptionPane.showMessageDialog(signupscreen,"������ ���̵� �����մϴ�."); }
				catch (DiffpwException esie)	{ JOptionPane.showMessageDialog(signupscreen,"��й�ȣ Ȯ���� �ٽ� ���ּ���."); }
				catch (ExistedSamePnException espe) { JOptionPane.showMessageDialog(signupscreen,"������ ��ȣ�� ������ ���̵� �����մϴ�."); }
		} else if(o == lgcancel || o == sucancel ){
			removeAll();
			add(checkininit);
			revalidate();
			repaint();
			sunametf.setText(null);
			suidtf.setText(null);
			supwtf.setText(null);
			supwck.setText(null);
			suphonenumtf.setText(null);
			lgidtf.setText(null);
			lgpwtf.setText(null);
		} else if(o == ok) {
			if(seatscreen.selected == -1) JOptionPane.showMessageDialog(seatscreen,"�¼��� �������ּ���.");
			else {
				if (checkinstart == false) {
					checkin.start();
					checkinstart = true;
				} else checkin.run();
				Timestamp citime = new Timestamp(System.currentTimeMillis());
				JOptionPane.showMessageDialog(seatscreen,sdf.format(citime)+seatsystem.namearray.get(index)+"��, �Խ� �Ϸ�");
				removeAll();
				add(checkininit);
				revalidate();
				repaint();
				seatscreen.selected = -1;
			}
		} else if(o == loginbtn2){
			String inputid = (String)lgidtf2.getText();
			String inputpw = (String)lgpwtf2.getText();
			try {
				itf.checktfblank(inputid);
				itf.checktfblank(inputpw);
				itf.checkexistedid(seatsystem.idarray,inputid);
				index = seatsystem.idarray.indexOf(inputid);
				itf.checkdiffpw(seatsystem.pwarray.get(index),inputpw);
				itf.checkoutstate(seatsystem.memberstate.get(index));

				String comsg = seatsystem.namearray.get(index)+"��, ����Ͻðڽ��ϱ�? [ �¼���ȣ : "+(seatsystem.memberseat.get(index)+1)+" ]";
				answer = JOptionPane.showConfirmDialog(loginscreen2, comsg, "��� Ȯ��", JOptionPane.YES_NO_OPTION);

				if(answer == JOptionPane.YES_OPTION) {
					if (checkoutstart == false)	{
						checkout.start();
						checkoutstart = true;
					} else checkout.run();
					lgidtf2.setText(null);
					lgpwtf2.setText(null);
					Timestamp cotime = new Timestamp(System.currentTimeMillis());
					JOptionPane.showMessageDialog(loginscreen2,sdf.format(cotime)+seatsystem.namearray.get(index)+"��, ��� �Ϸ�");
				} 
			}
			catch (BlankException be)	{ JOptionPane.showMessageDialog(loginscreen,"��ĭ�� ä���ּ���."); }
			catch (NonExistedIdException neie)	{ JOptionPane.showMessageDialog(loginscreen,"�������� �ʴ� ���̵� �Դϴ�.");}
			catch (DiffpwException de)	{ JOptionPane.showMessageDialog(loginscreen,"��й�ȣ�� ���� �ʽ��ϴ�.");}
			catch (CheckinStateException cise) { JOptionPane.showMessageDialog(loginscreen,"�̹� ��� ���� �Դϴ�.");}
		} else if(o == lgcancel2){
			lgidtf2.setText(null);
			lgpwtf2.setText(null);
		} else if( o == selectcancel ) {
			seatscreen.selected = -1;
			removeAll();
			add(loginscreen);
			revalidate();
			repaint();
		} else if ( o == findid || o == findid2 ) {
			String id;
			if(o == findid) id = JOptionPane.showInputDialog(loginscreen, "��ȭ��ȣ�� �Է��ϼ���", "���̵� ã��", JOptionPane.OK_CANCEL_OPTION);
			else id = JOptionPane.showInputDialog(loginscreen2, "��ȭ��ȣ�� �Է��ϼ���", "���̵� ã��", JOptionPane.OK_CANCEL_OPTION);
			try {
				itf.checkexistedid(seatsystem.phonenumarray,id);
				index = seatsystem.phonenumarray.indexOf(id);
				if(o == findid) JOptionPane.showMessageDialog(loginscreen,"�ش� ��ȣ�� ���Ե� ���̵�� ["+seatsystem.idarray.get(index)+"] �Դϴ�.");
				else JOptionPane.showMessageDialog(loginscreen2,"�ش� ��ȣ�� ���Ե� ���̵�� ["+seatsystem.idarray.get(index)+"] �Դϴ�.");
			} catch (NonExistedIdException neie) {
				if(o == findid) JOptionPane.showMessageDialog(loginscreen,"�ش� ��ȣ�� ���Ե� ���̵�� �����ϴ�.");
				else JOptionPane.showMessageDialog(loginscreen2,"�ش� ��ȣ�� ���Ե� ���̵�� �����ϴ�.");}
		} else if ( o == findpw || o == findpw2 ) {
			String pw;
			if( o == findpw ) pw = JOptionPane.showInputDialog(loginscreen, "ID�� �Է��ϼ���", "��й�ȣ ã��", JOptionPane.OK_CANCEL_OPTION);
			else pw = JOptionPane.showInputDialog(loginscreen2, "ID�� �Է��ϼ���", "��й�ȣ ã��", JOptionPane.OK_CANCEL_OPTION);
			try {
				itf.checkexistedid(seatsystem.idarray,pw);
				index = seatsystem.idarray.indexOf(pw);
				if( o == findpw) JOptionPane.showMessageDialog(loginscreen,"�ش� ���̵��� ��й�ȣ�� ���Խ� �Էµ� ��ȭ��ȣ�� �߼۵˴ϴ�.");
				else JOptionPane.showMessageDialog(loginscreen2,"�ش� ���̵��� ��й�ȣ�� ���Խ� �Էµ� ��ȭ��ȣ�� �߼۵˴ϴ�.");
			} catch (NonExistedIdException neie) {
				if(o == findpw ) JOptionPane.showMessageDialog(loginscreen,"�������� �ʴ� ���̵� �Դϴ�.");
				else JOptionPane.showMessageDialog(loginscreen2,"�������� �ʴ� ���̵� �Դϴ�.");}
		} 
	}

	public void layout(Component obj, int x, int y, int width, int height) {
		constraint.gridx = x;
		constraint.gridy = y;
		constraint.gridwidth = width;
		constraint.gridheight = height;
		add(obj, constraint);
	}

	public void layoutP(JPanel p, Component obj, int x, int y, int width, int height) {
		constraint.gridx = x;
		constraint.gridy = y;
		constraint.gridwidth = width;
		constraint.gridheight = height;
		p.add(obj, constraint);
	}
	
	class Join extends Thread	{
		public Join(SeatSystem s) {
			seatsystem = s;
		}

		public void run() {
			seatsystem.join(inputname, inputid, inputpw, inputpn);
		}
	}

	class CheckIn extends Thread	{
		public CheckIn(SeatSystem s) {
			seatsystem = s;
		}

		public void run() {
			seatsystem.ckin(seatscreen.selected, index);
		}
	}



	class CheckOut extends Thread	{
		public CheckOut(SeatSystem s) {
			seatsystem = s;
		}

		public void run() {
			seatsystem.ckout(seatsystem.memberseat.get(index), index);
		}
	}
}