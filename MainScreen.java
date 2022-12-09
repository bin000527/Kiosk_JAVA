import java.awt.*;
import javax.swing.*;

class MainScreen extends JFrame{
	JTabbedPane tab;
	OrderTab order;
	UseStudyCafe checkin;
	JPanel checkout;
	Font font = new Font("HY����M", Font.PLAIN, 15);

	public MainScreen() {
		setTitle("������ 1912739 ���͵�ī�� Ű����ũ");
		tab = new JTabbedPane();
		checkin = new UseStudyCafe();
		checkout = checkin.ckoutlogin;
		order = new OrderTab();

		tab.addTab("�Խ�",checkin);
		tab.addTab("���",checkout);
		tab.addTab("�޴� �ֹ�",order);
		tab.setBackgroundAt(0,new Color(255,200,200));
		tab.setBackgroundAt(1,new Color(255,250,150));
		tab.setBackgroundAt(2,new Color(185,255,180));

		tab.setFont(font);

		getContentPane().add(tab);
		getContentPane().setBackground(Color.white);
		setSize(800,500);
		setVisible(true);
	}
}
