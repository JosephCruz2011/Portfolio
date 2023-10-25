//CPSC 50300 Assignment Week 2				
//Joe Cruz 	
//Question 2
//
//This program is designed to simulate the Caesar Cipher with using UpperCase letters. The ? spots were filled in and 
//comments were placed to explain what was written in. 

import java.util.Arrays;

/** Class for doing encryption and decryption using the Caesar Cipher. */
public class CaesarCipher2 {

  //generated the encoder and decoder arrays with size of 26. This can be changed based off
  //the number of letters in the alphabet of choice (i.e. Greek: 24, English:26, Russian:33, Italian:21). 
  protected char[] encoder = new char [26];        // Encryption array
  protected char[] decoder = new char [26];        // Decryption array

  /** Constructor that initializes the encryption and decryption arrays */
  public CaesarCipher2(int rotation) {
	  
	// range determined is for the length of the encoder array since both the decoder and encoder arrays
	// should be of the same size it doesn't matter which one it is.
	
    for (int  k = 0; k<encoder.length; k++) {
    	
    		//This moves the alphabet over to the right (so the first letter is replaced with the letter that is the rotation's distance to the right.
    		//For instance for English and a rotation of 3, the 'A' will be replaced with a 'D'. 
    		//To use for other languages, the first letter in uppercase of the language desired needs to be used instead of 'A'. 
    		encoder[k] = (char)('A' + (k+ rotation) %encoder.length);
    		
    		//This moves the alphabet over to the left (so the first letter is replaced with the letter that is the rotation's distance to the left.
    		//For instance for English and a rotation of 3, the 'A' will be replaced with a 'X'.
    		//To use for other languages, the first letter in uppercase of the language desired needs to be used instead of 'A'. 
    		decoder[k] = (char)('A' + (k- rotation + encoder.length)%encoder.length); 
    }
  }

  /** Returns String representing encrypted message. */
  public String encrypt(String message) {
    return transform(message, encoder);               // use encoder array
  }

  /** Returns decrypted message given encrypted secret. */
  public String decrypt(String coded) {
    return transform(coded, decoder);                // use decoder array
  }

  /** Returns transformation of original String using given code. */
  private String transform(String original, char[] code) {
    char[] msg = original.toCharArray();
    for (int k=0; k < msg.length; k++) {
      if (Character.isUpperCase(msg[k])) {              // we have a letter to change when the message is in Capitals 
    	int j = msg[k] - 'A';							// will be value from 0 to 25
        msg[k] = code[j];} 								// replace the character				
      }
    
  return new String(msg);}
  
  /** Simple main method for testing the Caesar cipher */
  public static void main(String[] args) {
    CaesarCipher2 cipher = new CaesarCipher2(3);
    System.out.println("Encryption code = " + new String(cipher.encoder));
    System.out.println("Decryption code = " + new String(cipher.decoder));
    String message = "THE EAGLE IS IN PLAY; MEET AT JOE'S.";
    String coded = cipher.encrypt(message);
    System.out.println("Secret:  " + coded);
    String answer = cipher.decrypt(coded);
    System.out.println("Message: " + answer);         // should be plaintext again
}
}
