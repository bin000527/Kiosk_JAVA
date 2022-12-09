import java.util.ArrayList;

class SeatSystem{
	static int seatcheck[] = new int[41];
	ArrayList<String> namearray = new ArrayList<>();
	ArrayList<String> idarray = new ArrayList<>();
	ArrayList<String> pwarray = new ArrayList<>();
	ArrayList<String> phonenumarray = new ArrayList<>();
	ArrayList<Integer> memberstate = new ArrayList<Integer>(); //�� �ε����� ȸ���� �Խ� �����ΰ�?
	ArrayList<Integer> memberseat = new ArrayList<Integer>();//�� �ε����� ȸ���� �¼� ( �Խǻ��¶�� �¼���ȣ, ��ǻ��¶�� -1 )

	public SeatSystem(){ // SeatSystem()�� ó�� ȣ��Ǹ� seatcheck�迭�� ��� ���� 0���� �ʱ�ȭ ( ��� �¼��� ������� ) 
		for(int i=0; i<seatcheck.length; i++){
			seatcheck[i] = 0;
		}
	}
	
	public synchronized void ckin(int seatnum, int index) { //�Խ� ( ������ �¼� ��ȣ, ȸ�� ����Ʈ���� ���� �α��ε� ����� �ε����� �Ű������� ���� )
		seatcheck[seatnum] = 1; //���õ� �¼��� �Խǻ��·� �ٲ� ( 0 : ����, 1 : �Խ� ) 
		memberstate.set(index,1); //index ȸ���� ���� �Խǻ���
		memberseat.set(index,seatnum);//indexȸ���� �¼� : seatnum
	}

	public synchronized void ckout(int seatnum, int index) { //��� ( �Խ��ߴ� �¼���ȣ, ȸ���� �ε����� �Ű������� ���� )
		seatcheck[seatnum] = 0; // seatnum �¼��� ����
		memberstate.set(index,0); // index ȸ���� ����� -> 0
		memberseat.set(index,-1); // index ȸ���� ��������ν� ȸ���� �¼��� ������ -> -1 ( �¼� ��ȣ�� 0���� �����̹Ƿ� -1 )
	}

	public synchronized void join(String name, String id, String pw, String pnum) { //ȸ������ ( �̸�, id, pw, ��ȭ��ȣ�� �Ű������� ���� )
		// �� ���ڸ� arraylist�� �߰��ϰ�, ���� �Խ� ���̹Ƿ� memberstate�� 0, memberseat�� -1
		namearray.add(name);
		idarray.add(id);
		pwarray.add(pw);
		phonenumarray.add(pnum);
		memberstate.add(0);
		memberseat.add(-1);
	}
}
