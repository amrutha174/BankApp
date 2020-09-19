import java.util.*;
class RepStr
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		String r=sc.nextLine();
		StringBuffer sb=new StringBuffer(r.charAt(0)+"");
		for(int i=0;i<r.length()-1;i++)
		{
			if(r.charAt(i)!=r.charAt(i+1))
			{
				sb.append(r.charAt(i+1));
			}
			else
			{
				r=r.replaceFirst(r.charAt(i)+"","");
			}
		}
		System.out.println(sb);
	}
}