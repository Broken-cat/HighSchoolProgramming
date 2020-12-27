
class Heap
{
    public int [] HeapArray; 
		
    public Heap() { HeapArray = null; }
		
    public void MakeHeap(int[] a, int depth)
    {
    	int heap_size = 0;
		for (int i = 0; i <= depth; i++)
			heap_size += (int) Math.pow(2, i);
		HeapArray = new int[heap_size];
		for(int i = 0; i < heap_size; i++)
			HeapArray[i] = -1;
		for(int i = 0; i < a.length; i++)
			Add(a[i]);
    }
		
    public int GetMax()
    {
    	HeapArray[0] = -1;
    	int i = 1;
    	while(HeapArray[i] >= 0 && i < HeapArray.length) 
    		i++;
    	HeapArray[0] = HeapArray[i];
    	HeapArray[i] = -1;
    	i = 0;
    	int k;
    	if (HeapArray[2*i+1] > HeapArray[2*i+2])
    		k = 1;
    	else 
    		k = 2;
    	if(HeapArray[0] < HeapArray[k])
    		
    		while (HeapArray[i] < HeapArray[(i+1)/2] || HeapArray[i] < HeapArray[(i+2)/2]) {
    			if(HeapArray[i] < HeapArray[(2*i)+1])
    	}
	// вернуть значение корня и перестроить кучу
	return -1; // если куча пуста
    }
    

    public boolean Add(int key)
    {
    	int i = 0;
    	while(HeapArray[i] >= 0 && i < HeapArray.length) {
    		i++;
    	}
    	if(HeapArray[i] == HeapArray.length-1 && HeapArray[i] >=0)
    		return false;
    	if(HeapArray[i] < 0)
    		HeapArray[i] = key;
    	while(HeapArray[(i-1)/2] < HeapArray[i] ) {
    		swap(HeapArray, (i-1)/2, i);
    		i = (i-1)/2;
    	}
    	return true;
    }
    
    
    public void swap(int[] arr, int i, int j) {
    	int temp = arr[i];
    	arr[i] = arr[j];
    	arr[j] = temp;
    }
	
}
