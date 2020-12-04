
public class recursive {

	public static void main(String[] args) {
		System.out.println(reversestring("chakri"));
		System.out.println(addsumofdigits("96345"));
	}

	private static String addsumofdigits(String string) {
		
		if(string.equals(""))
			return "0";
		// TODO Auto-generated method stub
		Integer it= Integer.parseInt(addsumofdigits(string.substring(1)))+Integer.parseInt(string.substring(0,1));
		return it.toString();
	}

	private static int addsumofdigits(int num) {
		// TODO Auto-generated method stub
		return num==0?0:num%10+addsumofdigits(num/10);
	}

	private static String reversestring(String str) {
		return  str.isEmpty()?str:reversestring(str.substring(1)) + str.charAt(0);			
	}

	
}
