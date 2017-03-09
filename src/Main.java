import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static final List<String> ALPHABET = new ArrayList<>(Arrays.asList( "A", "B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z" ));
	public static List<String> rotor1 = new ArrayList<>(Arrays.asList( "M","N","B","V","C","X","Z","Q","W","E","R","T","Y","U","I","O","P","L","K","J","H","G","F","D","S","A" ));
	public static List<String> rotor2 = new ArrayList<>(Arrays.asList( "A","J","D","K","S","I","R","U","X","B","L","H","W","T","M","C","Q","G","Z","N","P","Y","F","V","O","E" ));
	public static List<String> rotor3 = new ArrayList<>(Arrays.asList( "Q","W","E","R","T","Y","U","I","O","P","A","S","D","F","G","H","J","K","L","Z","X","C","V","B","M","N" ));
	public static List<String> reflector = new ArrayList<>(Arrays.asList("Y","R","U","H","Q","S","L","D","P","X","N","G","O","K","M","I","E","B","F","Z","C","W","V","J","A","T"));
	
	public static void main(String[] args) {
		String message = readMessageFromFile("InputFile.txt").toUpperCase();
		String processedMessage = processMessage(message).replaceAll("QQ", " ");
		writeMessageToFile(processedMessage, "OutputFile.txt");
		System.out.println(processedMessage);
	}
	
	//Process a single letter
	public static String processLetter(String letter) {
		letter = alphabetToRotor(letter, rotor1);
		letter = alphabetToRotor(letter, rotor2);
		letter = alphabetToRotor(letter, rotor3);
		letter = alphabetToRotor(letter, reflector);
		letter = rotorToAlphabet(letter, rotor3);
		letter = rotorToAlphabet(letter, rotor2);
		letter = rotorToAlphabet(letter, rotor1);
		return letter;
	}
	
	//Process an entire message
	public static String processMessage(String message) {
		int letterCounter = 1;
		String processedMessage = "";
		//Analyze each character in message
		for (int i = 0, max = message.length(); i < max; i++) {
			String letter = message.substring(i, i + 1); 
			if (letter.equals(" ")) {	//If space
				processedMessage += processLetter("Q");
				rotateAllRotors(letterCounter);
				letterCounter++;
				processedMessage += processLetter("Q");
				rotateAllRotors(letterCounter);
				letterCounter++;
			} else if (!ALPHABET.contains(letter)) {	//If lineSeparator
				processedMessage += System.lineSeparator();;
				i++;
			} else {
				//Pass rotors
				letter = processLetter(letter);
		
				//Add the letter to the translated message
				processedMessage += letter;
				
				//Rotate the rotors
				rotateAllRotors(letterCounter);
				letterCounter++;
			}
		}
		return processedMessage;
	}
	
	//Writes a message to a file
	public static void writeMessageToFile(String message, String fileName) {
		BufferedWriter bw = null;
		FileWriter fw = null;
		try {
			String content = message;
			fw = new FileWriter(fileName);
			bw = new BufferedWriter(fw);
			bw.write(content);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
				if (fw != null)
					fw.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	//Reads a message from a file
	public static String readMessageFromFile(String fileName) {
		String rawMessage = "";
		try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			StringBuilder sb = new StringBuilder();
		    String line = br.readLine();
		    while (line != null) {
		        sb.append(line);
		        sb.append(System.lineSeparator());
		        line = br.readLine();
		    }
		    rawMessage = sb.toString();
		    br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return rawMessage;
	}
	
	//Converts a letter from the alphabet to its specified rotor equivalent
	public static String alphabetToRotor(String letter, List<String> rotor) {
		int index = ALPHABET.indexOf(letter);
		return rotor.get(index);
	}
	
	//Converts a letter on a specified rotor to its alphabet equivalent 
	public static String rotorToAlphabet(String letter, List<String> rotor) {
		int index = rotor.indexOf(letter);
		return ALPHABET.get(index);
	}
	
	//Rotates all rotors
	public static void rotateAllRotors (int letterCounter) {
		rotateRotor(rotor1);
		if ((letterCounter % 3) == 0) {
			rotateRotor(rotor3);
			rotateRotor(rotor2);
		} else if ((letterCounter % 2) == 0) {
			rotateRotor(rotor2);
		}
	}
	
	//Rotates a specified rotor
	public static void rotateRotor(List<String> rotor) {
		rotor.add(rotor.remove(0));
	}
	
	//Converts an Array to an ArrayList
	public static List<String> arrayToArrayList (String array[]) {
		List<String> l = new ArrayList<String>();
		for (String s: array) {
			l.add(s);
		}
		return l;
	}
}
