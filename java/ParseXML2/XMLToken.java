package ParseXML2;

// Patrick Krebs 

public class XMLToken  {
	private String token = ""; 
	
	public XMLToken(String t) {
		token += t;
	}
	
	public boolean isTag(){
		if (token.matches("<[a-zA-Z0-9-]+>")){
			return true; 
		} else if(token.matches("</[a-zA-Z0-9-]+>")){
			return true;
		} else {
			return false;
			}
	}
	
	public boolean isWord(){
		if (!(this.isTag())){
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isClosingTag(){
		if (this.isTag() && (token.matches("</[a-zA-Z0-9-]+>"))){
			return true;
		}else {
			return false;
		}
	}
	
	public boolean isOpeningTag(){
		if (token.matches("<[a-zA-Z0-9-]+>") && this.isTag() ){
			return true;
		} else {
			return false;
		}
	}

	public String tagName(){
		if (this.isTag()) {
			if (this.isOpeningTag()){
			return token.substring(1, token.length()-1);
			} else if (this.isClosingTag()){
				return token.substring(2, token.length()-1);
			} else {
				return token.substring(1, token.length()-2);
			}
		}
		return "";
	}
	
	public String toString(){
		return token; 
	}
}