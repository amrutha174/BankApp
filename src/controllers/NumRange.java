import java.util.*;
class NumRange
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		ArrayList<Integer> al=new ArrayList<Integer>();
		boolean fl=false;
		for (int i=0;i<n;i++ )
		{
			int t=sc.nextInt();
			if(!al.contains(t)&&t<=n) al.add(t);
			else
			{
				System.out.println((fl==true)?"Good":"Bad");
				System.exit(0);
			}
		}
		ArrayList<Integer> bl=new ArrayList<Integer>();
		for (Integer d:al) bl.add(d);
		Collections.sort(bl);
		System.out.println(al+"\n"+bl);
		for (int i=0;i<al.size();i++ )
		{
			if(al.get(i)==bl.get(i))
			{
				fl=true;
			}
			else fl=false;
		}
		System.out.println((fl==true)?"Good":"Bad");
	}
}