package ch15;

public class test
{
    public static void main(String[] args)
    {
    	int data[][] = 
    		{
    				{1,2},
    				{3,4},
    				{5,6}
    		};
    	
    	int sum = 0;
    	
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                sum += data[i][j];
            }
        }
        
        System.out.println(sum);
    }
}