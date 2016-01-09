//
// DICTIONARY CLASS 
// 
// This class uses an implementation of a basic dictionary and provides
// main functionality of a Symbol Table, the methods are:
//
// get, put, delete, contains, size.
//
// get : returns the definitions for the given word (if exists in dictionary)
//
// put : inserts a new definition for the given word,
//       unless the same exact definition already exists for the given word
//
// delete : deletes the given definition for the given word, and throws
//          an exception if the given definition for the given word does not
//          exist in the dictionary
//
// contains : returns if the dictionary contains an entry for the given word
//
// size : returns the total number of definitions in the dictionary
//
// HOMEWORK in this file is to implement:
//
// 1) public void put(String word, String defn)
// 2) public void delete(String word, String defn) throws Exception
//

package hw1;


public class DictionaryST<T extends BasicDict> {
	T dict;
	
	public DictionaryST (T dict) {
		this.dict = dict;
	}
	
	// Returns the list of definitions for the given word
	public String[] get(String word) {
		Entry e = dict.getClosestEntry(word);
		if (e != null && word == e.word) {
			return e.defns;
		} else {
			return null;
		}
	}

	// Inserts a new definition for the given word without duplicating definitions
	public void put(String word, String defn) {
		Entry e = dict.getClosestEntry(word);
		if (e.word == word) {
			for (int x= e.defns.length; x != -1; x--) {
				if (e.defns[x] != defn) {
					e.defns[x] = e.defns[x+1];
				}
			}
			e.defns[e.defns.length+2] = defn;
			this.dict.insert(e);
		}
	}
	
	// Deletes the definition for the given word, or throws an exception 
	public void delete(String word, String defn) throws Exception {
		Entry e = dict.getClosestEntry(word);
		if (word == e.word) {
			
		} else {
			throw new Exception("Nonexistent deletion!"); 
		}
	}
	
	// Checks whether a word is defined in the dictionary
	public boolean contains(String word) {
		Entry e = dict.getClosestEntry(word);
		return (e != null && word == e.word);
	}
	
	// Returns the total number of definitions in the dictionary
	public int size() {
		return dict.size();
	}
	
	// Returns a formatted string for the dictionary
	public String toString() {
		return dict.toString();
	}
}