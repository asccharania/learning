package Music;

// Patrick Krebs 

public class PlayPianoScale {

	public static void main(String[] args) {
		EqualTemperedFrequency f = new EqualTemperedFrequency(27.5);
		for (int i = 0; i < 89; i++ ){
			f.play(.2);
			f = f.next();	
		}
	}

}
