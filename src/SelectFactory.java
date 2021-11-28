
public class SelectFactory {
	public static Select getSelect(String type) {
		
		if("adult".equalsIgnoreCase(type))
			return new adult(0);
		else if("child".equalsIgnoreCase(type)) 
			return new child(0);
		
		return null;
	}

}
