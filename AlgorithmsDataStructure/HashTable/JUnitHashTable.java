package HashTable;

import static org.junit.Assert.*;

import org.junit.Test;

public class JUnitHashTable {

	@Test
	public void test() {
		HashTable table = new HashTable(17, 2);
		table.put("John");
		table.put("Paul");
		table.put("Sarah");
		table.put("Alex");
		table.put("Johnotan");
		table.put("Michael");
		table.put("Wayne");
		table.put("David");
		
		table.put("Patrice");
		table.put("Rio");
		table.put("Nemanja");
		table.put("Marcus");
		table.put("Antony");
		table.put("Ole");
		table.put("Victor");
		table.put("Aaron");
		
		table.put("Luke");
		assertTrue(table.put("Paul") == -1);
		
		table.find("John");
		table.find("Paul");
		table.find("Sarah");
		table.find("Alex");
		table.find("Johnotan");
		table.find("Michael");
		table.find("Wayne");
		table.find("David");
		table.find("Patrice");
		table.find("Rio");
		table.find("Nemanja");
		table.find("Marcus");
		table.find("Antony");
		table.find("Ole");
		table.find("Victor");
		table.find("Aaron");
		table.find("Luke");
		
	}
	
	@Test
	public void find() {
		
	}

}
