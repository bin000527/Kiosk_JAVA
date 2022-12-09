import java.util.ArrayList;

class SeatSystem{
	static int seatcheck[] = new int[41];
	ArrayList<String> namearray = new ArrayList<>();
	ArrayList<String> idarray = new ArrayList<>();
	ArrayList<String> pwarray = new ArrayList<>();
	ArrayList<String> phonenumarray = new ArrayList<>();
	ArrayList<Integer> memberstate = new ArrayList<Integer>(); //각 인덱스의 회원이 입실 상태인가?
	ArrayList<Integer> memberseat = new ArrayList<Integer>();//각 인덱스의 회원의 좌석 ( 입실상태라면 좌석번호, 퇴실상태라면 -1 )

	public SeatSystem(){ // SeatSystem()이 처음 호출되면 seatcheck배열의 모든 값을 0으로 초기화 ( 모든 좌석이 비어있음 ) 
		for(int i=0; i<seatcheck.length; i++){
			seatcheck[i] = 0;
		}
	}
	
	public synchronized void ckin(int seatnum, int index) { //입실 ( 선택한 좌석 번호, 회원 리스트에서 현재 로그인된 사람의 인덱스를 매개변수로 받음 )
		seatcheck[seatnum] = 1; //선택된 좌석을 입실상태로 바꿈 ( 0 : 공석, 1 : 입실 ) 
		memberstate.set(index,1); //index 회원은 현재 입실상태
		memberseat.set(index,seatnum);//index회원의 좌석 : seatnum
	}

	public synchronized void ckout(int seatnum, int index) { //퇴실 ( 입실했던 좌석번호, 회원의 인덱스를 매개변수로 받음 )
		seatcheck[seatnum] = 0; // seatnum 좌석은 공석
		memberstate.set(index,0); // index 회원은 퇴실함 -> 0
		memberseat.set(index,-1); // index 회원이 퇴실함으로써 회원의 좌석은 없어짐 -> -1 ( 좌석 번호가 0부터 시작이므로 -1 )
	}

	public synchronized void join(String name, String id, String pw, String pnum) { //회원가입 ( 이름, id, pw, 전화번호를 매개변수로 받음 )
		// 각 인자를 arraylist에 추가하고, 아직 입실 전이므로 memberstate는 0, memberseat는 -1
		namearray.add(name);
		idarray.add(id);
		pwarray.add(pw);
		phonenumarray.add(pnum);
		memberstate.add(0);
		memberseat.add(-1);
	}
}
