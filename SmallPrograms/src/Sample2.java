import java.util.ArrayList;
import java.util.List;

import com.chakri.strings.StringForeach;

public class Sample2 {

	public static void main(String[] args) {
		/*
		 * // TODO Auto-generated method stub int input1=5; int input2[][]=
		 * {{5,4},{3,2},{4,2},{2,1}}; String result= getJObIds(input1,input2);
		 * System.out.println(result);
		 */
StringForeach s=new StringForeach();
List<String> ls=new ArrayList<String>();
ls.add("abc");
ls.add("def");

s.ChakriForeach(ls);
	}

	private static String getJObIds(int input1, int[][] input2) {
		StringBuilder resultsb=new StringBuilder();
		resultsb.append(input1);
		int keypres=input1;
		for(int i=0;i<input2.length;i++) {
			
			if(input2[i][0]== keypres) {
				resultsb.append("-"+input2[i][1]);
				keypres=input2[i][1];
				i=-1;
			}
			
			
			
		}
		return resultsb.reverse().toString();
	}
	
	

}
