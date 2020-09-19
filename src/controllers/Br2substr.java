import java.util.*;
class Br2substr{
static boolean CanBreak(String A, String B)
{
    A = sortString(A);
    B = sortString(B);
    boolean ans1 = true, ans2 = true;
    for(int i = 0; i < A.length(); i++)
    {
        if (A.charAt(i) < B.charAt(i))
            ans1 = false;
        if (B.charAt(i) < A.charAt(i))
            ans2 = false;
    }
    return ans1 || ans2;
}
 
static String sortString(String inputString) 
{ 
    char tempArray[] = inputString.toCharArray(); 
    Arrays.sort(tempArray); 
    return new String(tempArray); 
} 
public static void main(String[] args)
{
    String A = "abc", B = "xya";
    if (CanBreak(A, B))
        System.out.println("Yes");
    else
        System.out.println("No");
}
}