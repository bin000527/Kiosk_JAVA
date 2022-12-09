import java.awt.*;
import javax.swing.*;

class MainScreen extends JFrame{
	JTabbedPane tab;
	OrderTab order;
	UseStudyCafe checkin;
	JPanel checkout;
	Font font = new Font("HY엽서M", Font.PLAIN, 15);

	public MainScreen() {
		setTitle("서예빈 1912739 스터디카페 키오스크");
		tab = new JTabbedPane();
		checkin = new UseStudyCafe();
		checkout = checkin.ckoutlogin;
		order = new OrderTab();

		tab.addTab("입실",checkin);
		tab.addTab("퇴실",checkout);
		tab.addTab("메뉴 주문",order);
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
