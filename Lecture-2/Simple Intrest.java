import java.util.* ;
import java.io.*; 
class Solution {
	
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		int p,n,si;
		float r;
		p=sc.nextInt();
		r=sc.nextFloat();
		n=sc.nextInt();
		si=(int)(p*r*n)/100;
		System.out.println(si);		
		
	}
}
