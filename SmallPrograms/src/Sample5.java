
public class Sample5 {

	

	private static int findkey1(int input1, int input2, int input3) {
		int[] array= {input1,input2,input3};
		
		Integer thous=Integer.parseInt(((Integer)input1).toString().substring(0, 1));
		Integer hund=Integer.parseInt(((Integer)input1).toString().substring(1, 2));
		Integer tens=Integer.parseInt(((Integer)input1).toString().substring(2, 3));
		Integer units=Integer.parseInt(((Integer)input1).toString().substring(3));;
		for(int curr:array) {
			if(thous>Integer.parseInt(((Integer)curr).toString().substring(0, 1))) {
				thous=Integer.parseInt(((Integer)curr).toString().substring(0, 1)); 
			}
		    if(hund<Integer.parseInt(((Integer)curr).toString().substring(1, 2))) {
					hund=Integer.parseInt(((Integer)curr).toString().substring(1, 2)) ;
		    }
		    if(tens>Integer.parseInt(((Integer)curr).toString().substring(2, 3))) {
						tens=Integer.parseInt(((Integer)curr).toString().substring(2, 3)); 
		    }
			if(units<Integer.parseInt(((Integer)curr).toString().substring(3))) {
							units=Integer.parseInt(((Integer)curr).toString().substring(3)); 
			}
			
		}
		return Integer.parseInt(thous.toString()+hund.toString()+tens.toString()+units.toString());
	}

	private static int findkey(int input1, int input2, int input3) {
		int result=0;
		int[] arrayinput={input1,input2,input3};
		StringBuilder sb=new StringBuilder();
		Integer key1=-1;
		for(int curr:arrayinput) {
			int keyloop=curr/1000;
			if(key1==-1) {
				key1=keyloop;	
			}
			else if(keyloop<key1) {
				key1=keyloop;
			}else {
				
			}
			
		}
		sb.append(key1.toString());
		Integer key2=-1;
		for(int curr:arrayinput) {
			Integer keyloop=curr/100;
			keyloop=Integer.parseInt(keyloop.toString().substring(1));
			if(key2==-1) {
				key2=keyloop;	
			}
			else if(keyloop>key2) {
				key2=keyloop;
			}else {
				
			}
			
		}
		sb.append(key2.toString());
		
		Integer key3=-1;
		for(int curr:arrayinput) {
			Integer keyloop=curr/10;
			keyloop=Integer.parseInt(keyloop.toString().substring(2));
			if(key3==-1) {
				key3=keyloop;	
			}
			else if(keyloop<key3) {
				key3=keyloop;
			}else {
				
			}
			
		}
		sb.append(key3.toString());
		
		
		Integer key4=-1;
		for(int curr:arrayinput) {
			Integer keyloop=curr;
			keyloop=Integer.parseInt(keyloop.toString().substring(3));
			if(key4==-1) {
				key4=keyloop;	
			}
			else if(keyloop>key4) {
				key4=keyloop;
			}else {
				
			}
			
		}
		sb.append(key4.toString());
		
		
		return Integer.parseInt(sb.toString());
	}

}
