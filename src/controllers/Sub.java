import java.util.*;
class Sub
{
	public static void main(String args[])
	{
		String a="leetcodee";
		String b="interview";
		char a1[]=a.toCharArray();
		char b1[]=b.toCharArray();
		Arrays.sort(a1);
		Arrays.sort(b1);
		boolean fl=false;
		for (int i=0;i<a1.length;i++){
			if(a1[i]>=b1[i]) fl=true;
			else{
				fl=false;
				break;}
		}
		if(fl==false){
		for (int i=0;i<a1.length;i++){
			if(b1[i]>=a1[i]) fl=true;
			else{
				fl=false;
				break;} } }
		else System.out.println("true");
		System.out.println((fl==false)?"false":"true");
	}
}