import java.util.Scanner;

public class SocSecProcessor {

	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		String name;
		String number;
		String respond;
		
		char answer = 'Y';
		
		while(Character.toUpperCase(answer) == 'Y') {
			try {
				System.out.print("Name? ");
				name = input.nextLine();
				
				System.out.print("SSN? ");
				number = input.nextLine();
				
				if(isValid(number)) {
					System.out.println(name + "" + number + "isValid");
				}
			} catch(SocSecException e) {
				System.out.println(e.getMessage()); 
			}
			
			System.out.print("Continue? ");
			respond = input.nextLine();
			answer = respond.charAt(0);
		}
	}
	
	private static boolean isValid(String number) throws SocSecException {
		boolean g = true;
		int index = 0; 
		
		if(number.length() != 11) {
			throw new SocSecException("wrong number of characters ");
		}
		
		for(index = 0; index < number.length(); index++) {
			if(index == 3 || index == 6) {
				if(number.charAt(index) != '-') {
					throw new SocSecException("dashes at the wrong position");
				}
			} else if(!Character.isDigit(number.charAt(index))) {
				throw new SocSecException("contains a character that is not a digit");
			}
		}
		
		return g;
	}
}
