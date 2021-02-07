
public class SortLevel {
	
	 public static void SelectionSortStep( int array[], int i )
     {
       int temp = array[i];
       int min = findMin(array, i);
       array[i] = array[min];
       array[min] = temp;
     }
	 
	 public static int findMin(int array[], int from) {
		 int min = array[from];
		 for(int i = from; i < array.length; i++) {
			 if(array[min] > array[i])
				 min = i;
		 }
		 return min;
	 }
	 
	 public static boolean BubbleSortStep ( int array[] )
     {
	   boolean result = false;
	   for(int i = 0; i < array.length; i+=2) {
		   if(array[i] > array[i+1]) {
			   result = true;
			   int temp = array[i];
			   array[i] = array[i+1];
			   array[i+1] = temp;
		   }
	   }
       return result;
     }
}
