import java.util.Scanner;

public class Solution {


	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		char n=sc.next().charAt(0);
		int m1,m2,m3;
		m1=sc.nextInt();
		m2=sc.nextInt();
		m3=sc.nextInt();
		System.out.println(n+"\n"+(m1+m2+m3)/3);
		
	}

}
