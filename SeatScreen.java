import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class SeatScreen extends JPanel implements ActionListener	{
	GridBagConstraints constraint;
	GridBagLayout gridbag = new GridBagLayout();
	JButton seatbtn[] = new JButton[41];
	String[] seatnum = {"1","2","3","4","5","6","7","8","9","10",
						"11","12","13","14","15","16","17","18","19","20",
						"21","22","23","24","25","26","27","28","29","30",
						"31","32","33","34","35","36","37","38","39","40","41"};

	static int selected = -1;
	String input;
	int[] seatstate;
	JButton cafe, lounge, entrance, locker1, locker2;
	Font smallfont = new Font("HY엽서M",Font.PLAIN,15);

	public SeatScreen(int[] seatarray) {
		seatstate = seatarray;
		setLayout(gridbag);
		constraint = new GridBagConstraints();
		constraint.fill = GridBagConstraints.BOTH;
		setBackground(new Color(230,225,255));

		for (int i=0; i<seatbtn.length; i++ ){
			seatbtn[i] = new JButton(seatnum[i]);
			seatbtn[i].addActionListener(this);
			seatbtn[i].setFont(smallfont);
			seatbtn[i].setBackground(new Color(210,255,130));
			
			//좌석 버튼 배치
			if(i<4) layout(seatbtn[i],0,4-i,1,1);
			else if(i<13) layout(seatbtn[i],i-3,0,1,1);
			else if(i<17) layout(seatbtn[i],10,i-12,1,1);
			else if(i<20) layout(seatbtn[i],i-15,2,1,1);
			else if(i<23) layout(seatbtn[i],i-18,3,1,1);
			else if(i<26) layout(seatbtn[i],i-17,2,1,1);
			else if(i<29) layout(seatbtn[i],i-20,3,1,1);
			else if(i<32) layout(seatbtn[i],i-27,5,1,1);
			else if(i<35) layout(seatbtn[i],i-30,6,1,1);
			else if(i<38) layout(seatbtn[i],i-29,5,1,1);
			else layout(seatbtn[i],i-32,6,1,1);

			if (seatstate[i] == 1) seatbtn[i].setEnabled(false); // 이미 입실상태인 좌석 선택불가
			else seatbtn[i].setEnabled(true);
		}

		cafe = new JButton("카페");
		cafe.setEnabled(false);
		
		lounge = new JButton("휴게실");
		lounge.setEnabled(false);
		
		entrance = new JButton("입구");
		entrance.setEnabled(false);
	
		locker1 = new JButton("사물함");
		locker1.setEnabled(false);
		
		locker2 = new JButton("사물함");
		locker2.setEnabled(false);

		layout(cafe,8,8,3,3);
		layout(lounge,0,8,3,3);
		layout(entrance,4,10,3,1);
		layout(locker1,0,5,1,3);
		layout(locker2,10,5,1,3);
	}

	public void actionPerformed(ActionEvent e){
		Object o = e.getSource();
		input = e.getActionCommand();
		selected = Integer.parseInt(input)-1;

		for (int i=0;i<seatbtn.length ;i++ )	{
			if(seatstate[i] == 0) { //비어있는 좌석에 한해서 선택한 좌석을 제외한 모든 좌석 클릭 가능
				if( o == seatbtn[i] ) seatbtn[i].setEnabled(false);
				else seatbtn[i].setEnabled(true);
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
