import static org.junit.Assert.*;

import org.junit.Test;

public class LinkedTest {

	@Test
	public void test() {
		LinkedList test = new LinkedList();
		test.addInTail(new Node(5));
		test.showHead();
		test.showTail();
		test.addInTail(new Node(6));
		test.showHead();
		test.showTail();
		test.remove(5);
		test.remove(5);
		test.clear();
		for(int i = 0; i < 100; i++)
			test.addInTail(new Node(i));
		test.display();
		test.remove(9);
		test.display();	
		test.removeAll(8);
		test.display();
		test.removeAll(7);
		test.removeAll(0);
		test.display();
		test.insertAfter(new Node (3), new Node(6));
		test.insertAfter(new Node (99), new Node(1));
		test.display();
		test.removeAll(6);
		test.remove(99);
		test.remove(1);
		test.remove(1);
		assertNotNull(test.find(2));
		test.display();
		test.clear();
		assertNull(test.find(2));
		test.addInTail(new Node(2));
		assertNotNull(test.find(2));
		test.display();
		for(int i = 0; i < 4;i++)
		test.addInTail(new Node(1));
		test.display();
		test.remove(1);
		test.remove(2);
		test.display();
		test.addInTail(new Node(2));
		test.insertAfter(new Node(1), new Node(3));
		test.remove(1);
		assertNotNull(test.find(3));
		assertNotNull(test.find(2));
		test.remove(2);
		assertNull(test.find(2));
		test.insertAfter(new Node(3), new Node(2));
		for(int i = 0; i < 3; i++)test.insertAfter(new Node(3), new Node(3));
		test.insertAfter(new Node(2), new Node(4));
		test.display();
		test.removeAll(3);
		test.removeAll(1);
		test.display();
		test.clear();
		test.addInTail(new Node(2));
		test.display();
		test.removeAll(2);
		assertNull(test.find(2));
		for(int i = 0; i < 3;i++)test.addInTail(new Node(2));
		test.addInTail(new Node(4));
		test.addInTail(new Node(3));
		test.addInTail(new Node(2));
		test.removeAll(2);
		test.display();
		test.clear();
		test.addInTail(new Node(1));
		test.addInTail(new Node(1));
		test.addInTail(new Node(1));
		test.addInTail(new Node(2));
		test.addInTail(new Node(1));
		test.display();
		test.remove(1);
		test.remove(1);
		test.remove(1);
		test.display();
		test.removeAll(1);
		test.display();
		for(int i = 0; i < 7;i++)test.addInTail(new Node(i));
		test.insertAfter(new Node(6), new Node(1));
		test.insertAfter(new Node(1), new Node(1));
		
		test.display();
		test.remove(2);
		test.display();
		test.remove(6);
		test.display();
		test.remove(0);
		test.display();
		test.removeAll(1);
		test.display();
	}
}

	/*Head --> 5
Tail --> 5
Head --> 5
Tail --> 6
List (head ---> tail): 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 97 98 99 
Head --> 0
Tail --> 99
List (head ---> tail): 0 1 2 3 4 5 6 7 8 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 97 98 99 
Head --> 0
Tail --> 99
List (head ---> tail): 0 1 2 3 4 5 6 7 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 97 98 99 
Head --> 0
Tail --> 99
List (head ---> tail): 1 2 3 4 5 6 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 97 98 99 
Head --> 1
Tail --> 99
List (head ---> tail): 1 2 3 6 4 5 6 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 97 98 99 1 
Head --> 1
Tail --> 1
List (head ---> tail): 2 3 4 5 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 97 98 
Head --> 2
Tail --> 98
List (head ---> tail): 2 
Head --> 2
Tail --> 2
List (head ---> tail): 2 1 1 1 1 
Head --> 2
Tail --> 1
List (head ---> tail): 1 1 1 
Head --> 1
Tail --> 1
List (head ---> tail): 3 3 3 3 2 4 1 1 
Head --> 3
Tail --> 1
List (head ---> tail): 2 4 
Head --> 2
Tail --> 4
List (head ---> tail): 2 
Head --> 2
Tail --> 2
List (head ---> tail): 4 3 
Head --> 4
Tail --> 3
List (head ---> tail): 1 1 1 2 1 
Head --> 1
Tail --> 1
List (head ---> tail): 2 1 
Head --> 2
Tail --> 1
List (head ---> tail): 2 
Head --> 2
Tail --> 2
List (head ---> tail): 2 0 1 1 2 3 4 5 6 1 
Head --> 2
Tail --> 1
List (head ---> tail): 0 1 1 2 3 4 5 6 1 
Head --> 0
Tail --> 1
List (head ---> tail): 0 1 1 2 3 4 5 1 
Head --> 0
Tail --> 1
List (head ---> tail): 1 1 2 3 4 5 1 
Head --> 1
Tail --> 1
List (head ---> tail): 2 3 4 5 
Head --> 2
Tail --> 5*/
	

