
public class ArrayMove {
	private int[] array;
	
	ArrayMove(int length){
		array = new int[length];
	}
	
	public void setArray() {
		for(int i = 0; i < array.length; i++) {
			array[i]= i *2;
		}//for
	}//setArray
	
	public int getArray(int index) {
		return array[index];
	}
	
	public void moveUp(int index) {
		if (index != 0) {
			array[index-1] = array[index];
		}
		else {
			System.out.println("You cannont move a number past the start of array");
		}
	}//moveUp
	
	public void moveDown(int index) {
		if(array.length > index) {
			array[index+1] = array[index];
		}
		else {
			System.out.println("You cannot move a number past the end of the array");
		}
		
	}
}
