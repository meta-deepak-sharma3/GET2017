package PF_Session_1;

import static org.junit.Assert.*;

import org.junit.Test;

public class SortArrayTest {

	@Test
	public void sortarrayTest() {
		
		  SortArray sa = new SortArray();
		  int a[] = {2,5,7,9,12} , b[] = {1,2,4,5,7,11,12};
		  int expected[] = {1,2,4,5,7,9,11,12,0,0,0,0} , c[] = new int[20];
		  int result[] = new int[a.length+ b.length];
		  Boolean flag = true;
		  
		  result = sa.sortArray(a, b, c);
		  
		  if(expected.equals(result)){
			  flag = true;
		  }
		  
		  else {
			  flag = false;
		  }
		  
		System.out.print(flag);
	}

}
