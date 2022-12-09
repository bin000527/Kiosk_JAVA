public class NonExistedIdException extends Exception{
	public NonExistedIdException() {
		super("존재하지 않는 아이디");
	}
}
