package cse360assign2;

public class SimpleList {
	private int count;
	private int list[];
	
	public SimpleList() {
		this.count = 0;
		list = new int[10];
	}
	
	public void add(int num) {
		 if (count == 0) {
	           list[count] = num;
	           count++;
	       } else if (count < 10) {
	           for (int i = count; i >= 0; i--) {
	               list[i + 1] = list[i];
	           }
	           list[0] = num;
	           count++;
	       } else {
	    	   int temp[] = new int[count + count/2];
	    	   for (int i = 0; i < count && i < count + count/2; i ++) {
	    		   temp[i] = list[i];
	    	   }
	    	   list = temp;
	           for (int i = count; i >= 0; i--) {
	               list[i + 1] = list[i];
	           }
	           list[0] = num;
	           count++;
	       }
	   }

	   public void remove(int num) { // removes number from away
	       int index = search(num);
	       if (index != -1) {
	           for (int i = index; i < count - 1; i++) {
	               list[i] = list[i + 1];
	           }
	           count--;
	       } else {
	           System.out.println("element not found");
	       }
	       
	       if (count < 3*list.length/4) { // if the count is less then 75% capacity 
	    	   
	    	   
	       }
	   }

	   public int count() {
	       return count;
	   }
	   public int search(int num) {
	       int index = -1;
	       int i = 0;
	       while(i < count) {
	           if (list[i] == num) {
	               index = i;
	           }
	           i++;
	       }
	       return index;
	   }
	   @Override
	   public String toString() {
		   String str = "";
		   int index = 0;
		   while (index != count) {
			   str += list[index] + ", ";
			   index++;
		   }
		   return str;	   
	   }
	   public int first() {
	        if (count == 0) {
	             throw new RuntimeException("list is empty!");
	        }
	        return list[0];
	    }
}