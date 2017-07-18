package Assignments;

public class Remainder {
	public int rem(int a,int b)
	{
	    if (b==0){
	    	System.out.println("Divisor cannot be zero.");
	    	return -1;
	    }
	    if(b<0){
	    	
	    	return rem(a,(-1)*b);
	    }
	    if(a<0){
	    	return rem((-1)*a,b);
	    }
		int x=a;
	   
	    if(x>=b)
	    {
	        x=x-b;
	        x = rem(x,b);
	    }
	    return x;
	}
}
