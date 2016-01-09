//
// SORTED ARRAY DICTIONARY
// 
// This class uses a sorted array to organize the entries in a dictionary.
//
// HOMEWORK in this file is to implement:
//
// 1) public Entry getClosestEntry(String w)
// 2) public void delete(String w) throws Exception
// 3) public void insert(Entry e)
// 4) public int size()
//

package hw1;

public class SortedArray implements BasicDict {
	private final int minSize = 8;
	public Entry[] entries;
	
	// Empty dictionary constructor
	public SortedArray () {
		entries = new Entry[minSize];
	}

	// This method returns the closest word entry in the dictionary
	// in alphabetical order
	public Entry getClosestEntry(String w) {
		for (int x = 0; x != this.entries.length + 1; x++) {
			if (this.entries[x].word.compareTo(w) == 0) {
				return this.entries[x];
			} else if (this.entries[x].word.compareTo(w) == -1) {
				return this.entries[x];
			}
		}
		return this.getClosestEntry(w);
	}
	
	// This method removes a whole entry from the dictionary
	public void delete(String w) throws Exception { 
		Entry e = this.getClosestEntry(w);
		if (e.word == w) {
			this.delete(w);
		}
		throw new Exception("Nonexistent deletion!");
	}

	// This method inserts a new entry into the dictionary
	public void insert(Entry e) {
		this.insert(e);
	}
	
	// This method returns the total number of definitions. Note that
	// this is different than the total number of words defined. 
	public int size() {
		int size = 0; 
		for (int x = 0; x < this.entries.length; x++) {
			for (int y = 0; y != this.entries[x].defns.length; y++) {
				size = size + 1;
			}
		}
		return size; 
	}

	// Recursively computes a formatted string for partial dictionary
	private String entriesToString(int i) {
		if (i < entries.length && entries[i] != null) {
			return entries[i].toString() + entriesToString(i + 1);
		} else {
			return "";
		}
	}

	// Returns a formatted string for the whole dictionary
	public String toString () {
		return entriesToString(0);
	}
}