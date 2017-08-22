package assignment1;

public class JoinTwoArrayList<E> extends ArrayList<E>{
	// join Two Given Arrays 
	public void joinTwoArrayList(ArrayList<E> array1 , ArrayList<E> array2){
		int length2 = array2.size();
		for(int i=0 ; i<length2 ; i++){
			array1.add(array2.getElement(i));
		}
	}
}
