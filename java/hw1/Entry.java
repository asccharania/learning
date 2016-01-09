//
// DICTIONARY ENTRY
// 
// This class encapsulates a word and its definitions
//
// You may add new methods to this class as you like
// You MAY NOT change existing methods
//

package hw1;

public class Entry {
	public final String word;
	public String[] defns;

	public Entry(String word, String[] defns) {
		this.word = word;
		this.defns = defns;
	}

	public boolean sameWord(Entry e) {
		return (word == e.word);
	}

	public int compareWord(Entry e) {
		return (word.compareTo(e.word));
	}

	public String toString () {
		String entryString = word + ":\n";
		for (int i = 0; i < defns.length; i++) {
			entryString += "\t" + (i + 1) + ". " + defns[i] + "\n";
		}
		return entryString;
	}
}