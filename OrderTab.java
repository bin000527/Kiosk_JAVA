import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;


class OrderTab extends JPanel implements ActionListener	{
	GridBagConstraints constraint;
	GridBagLayout gridbag = new GridBagLayout();
	JButton[] menub = new JButton[9]; // �޴� ��ư
	String[] menuname = {"�Ƹ޸�ī�� ","ī��� ","�ٴҶ�� ","�����̵� ","���̽�Ƽ "}; // �޴���
	int[] menuprice = {2000,3000,3000,3000,2500}; //�޴� ����
	JPanel[] menup = new JPanel[5];
	String[] menuimage = {"americano.png","latte.png","vanilla.png","lemonade.png","icetea.png"};//�޴� ����
	ImageIcon[] menui = new ImageIcon[5];
	JLabel[] menul = new JLabel[5];
	JPanel basket, basketp;
	JButton delete, payment;
	JLabel smenu, totalprice;
	String smenuname, smenuop;
	int smenuprice, price, menuans, menunum;
	String[] menuanswer = {"ICE","HOT"};
	String[] iceonlyanswer = {"Ȯ��","���"};
	Color bg = new Color(230,225,255);
	Font smallfont = new Font("HY����M",Font.PLAIN,15);

	public OrderTab() {
		setLayout(gridbag);
		constraint = new GridBagConstraints();
		constraint.fill = GridBagConstraints.NONE;
		setBackground(bg);


		for (int i=0;i<menub.length ;i++ )	{
			if (i<menuname.length)	{
				menui[i] = new ImageIcon(menuimage[i]);
				Image img = menui[i].getImage();
				Image changeImg = img.getScaledInstance(150,150,Image.SCALE_SMOOTH);
				ImageIcon icon = new ImageIcon(changeImg);

				menub[i] = new JButton(icon);
				menub[i].addActionListener(this);
				menub[i].setBackground(Color.WHITE);	

				menul[i] = new JLabel(menuname[i]+menuprice[i]+"��");
				menul[i].setHorizontalAlignment(JLabel.CENTER);	

				menup[i] = new JPanel(new BorderLayout());
				menup[i].add(menub[i],BorderLayout.CENTER);
				menup[i].add(menul[i],BorderLayout.SOUTH);
				menup[i].setBackground(bg);
			
				if(i<3) layout(menup[i],i,0,1,1);
				else layout(menup[i],i-3,1,1,1);
			} else {
				menub[i] = new JButton("�޴� �߰� ����");
				menub[i].setBackground(Color.WHITE);
				menub[i].setEnabled(false);

				if(i==5) layout(menub[i],2,1,1,1);
				else layout(menub[i],i-6,2,1,1);
			}
			
		}
		basket = new JPanel(new GridLayout(5,0));
		TitledBorder baskettb = new TitledBorder(new LineBorder(Color.black), "[ ���� �޴� ]");
		basket.setBorder(baskettb);
		basket.setBackground(bg);

		basketp = new JPanel();
		basketp.setBackground(bg);
		layout(basketp,3,0,3,2);
		
		layout(new JLabel("�� �����ݾ�"),3,2,1,1);

		totalprice = new JLabel("0 ��");
		totalprice.setHorizontalAlignment(JLabel.RIGHT);
		layout(totalprice,4,2,1,1);

		delete = new JButton("����");
		delete.setFont(smallfont);
		delete.setBackground(Color.WHITE);
		delete.addActionListener(this);
		layout(delete,4,3,1,1);

		payment = new JButton("����");
		payment.setFont(smallfont);
		payment.setBackground(new Color(185,255,180));
		payment.addActionListener(this);
		layout(payment,3,3,1,1);
	}

	public void actionPerformed(ActionEvent e){
		Object o = e.getSource();
		if(o == delete) {
			menunum = 0;
			basket.removeAll();
			price = 0;
			totalprice.setText(String.valueOf(price)+ "��");
			basketp.removeAll();
		} else {
			for (int i=0; i<menuname.length ; i++)	{
				if( o == menub[i] ) {
					boolean addmenu = false;
					smenuname = menuname[i];
					smenuprice = menuprice[i];
					if(o == menub[0] || o == menub[1] || o == menub[2]) { // ICE/HOT �ɼ� ���� ���� �޴�
						menuans = JOptionPane.showOptionDialog(this, "ICE or HOT", "�ɼ� ����",
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, menuanswer, null);	
						if (menuans == 0) {
							smenuop = "ICE";
							addmenu = true;
						} else if (menuans == 1) {
							smenuop = "HOT";
							addmenu = true;
						}
					} else if( o == menub[3] || o == menub[4]) { // ONLY ICE
						menuans = JOptionPane.showOptionDialog(this, "�����Ͻ� ����� ICE ONLY �Դϴ�.", "�ɼ� ����",
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, iceonlyanswer, null);	
						smenuop = "ICE";
						if (menuans == 0) addmenu = true;
					} 
					if(addmenu == true) {
						if(menunum==5) {
							JOptionPane.showMessageDialog(this,"���� ������ �޴� ������ 5�� �Դϴ�.");
						} else {
							if (menunum == 0) basketp.add(basket);
							smenu = new JLabel(smenuname+smenuop+" "+smenuprice+"��");
							price += smenuprice;
							smenu.setHorizontalAlignment(JLabel.LEFT);
							basket.add(smenu);
							totalprice.setText(String.valueOf(price)+ "��");
							menunum += 1;
						}
					}
				} 
			}
		}
	}
	
	public void layout(Component obj, int x, int y, int width, int height) {
		constraint.gridx = x;
		constraint.gridy = y;
		constraint.gridwidth = width;
		constraint.gridheight = height;
		add(obj, constraint);
	}
}