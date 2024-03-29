package Insegnamenti;

import myExceptions.*;

public abstract class Check {
	
	public static void orario(String orario) throws HourFormatException { // controlla che la stringa sia un orario
		boolean isOk = false;
		if(orario.length() <= 5) {
			byte i = 0;
			while (i < orario.length() && orario.charAt(i) != ':')
				i++;
				
			if(orario.length() == 4 && i == 1 &&  // formato h:mm
			   Character.isDigit(orario.charAt(0)) && Character.isDigit(orario.charAt(2)) && Character.isDigit(orario.charAt(3)))
			{
				if(Integer.parseInt(orario.substring(0, 1)) >= 0 &&
						Integer.parseInt(orario.substring(2, 4)) >= 0 && Integer.parseInt(orario.substring(2, 4)) <= 60)
					isOk = true;
			}
			if(orario.length() == 5 && i == 2 &&  // formato hh:mm
			   Character.isDigit(orario.charAt(0)) && Character.isDigit(orario.charAt(1)) &&
			   Character.isDigit(orario.charAt(3)) && Character.isDigit(orario.charAt(4)))
			{
				if(Integer.parseInt(orario.substring(0, 2)) >= 0 && Integer.parseInt(orario.substring(0, 2)) <= 23 &&
						Integer.parseInt(orario.substring(3, 5)) >= 0 && Integer.parseInt(orario.substring(3, 5)) <= 60)
					isOk = true;
			}
		}
		if(!isOk)
			throw new HourFormatException("\nFormato orario non valido, riprova!");
	}
	
	public static boolean isEmpty(Object[] obj) {
		
		boolean empty = true;
		for(Object o : obj)
			if (o != null) {
				empty = false;
				break;
			}
		return empty;
	}

}
