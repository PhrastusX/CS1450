
public class ArrayMoveTest {

	public static void main(String[] args) {
		
		ArrayMove newArray = new ArrayMove(10);
		
		newArray.setArray();
		
		newArray.moveDown(6);
		
		newArray.moveUp(1);
		
		System.out.println(newArray.getArray(0));

	}

}
