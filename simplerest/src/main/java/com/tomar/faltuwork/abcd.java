package com.tomar.faltuwork;

class abcd{
	
	static int value=0;
	static boolean isIncrementing = true;
	
	public static void main(String gg[]){
		int value=0;
		boolean isIncrementing = true;
		
		 int times = 42;
		 int total = 3;
		 int spaces = times/2;
		
		for(int x=0;x<times;x++){
			
			if(x<times/2){
				total = total+1;
				spaces = spaces-1;
			}
			else{
				total = total-1;
				spaces = spaces+1;
			}
			
			int i=0;
			while(i<spaces){
				System.out.print(" ");
				i++;
			}
			int values=total-spaces;
			
			for( i=0; i<=values;i++){
				if(value==1)
					isIncrementing=true;
				if(value==9)
					isIncrementing=false;
				if(isIncrementing)
					System.out.print(++value);
				else
					System.out.print(--value);
			}
			System.out.println();
		}
		
	}
}