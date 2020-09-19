import java.util.*;
class MarksApp
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt(),c=0;
		char ar[]=new char[n];
		for (int i=0;i<n ;i++ )
		{
			char t=sc.next().charAt(0);
			if (t>0&&(t>='A'&&t<='E')) ar[i]=t;
			else 
			{
				System.out.println("Invalid");
				break;
			}
		}
		System.out.println("answers");
		char br[]=new char[n];
		for (int i=0;i<n ;i++ )
		{
			char t=sc.next().charAt(0);
			if (t>0&&(t>='A'&&t<='E')) br[i]=t;
			else 
			{
				System.out.println("Invalid");
				break;
			}
		}
		for (int i=0;i<n ;i++ ) if(ar[i]==br[i]) c++;
		System.out.println(c);
	}
}