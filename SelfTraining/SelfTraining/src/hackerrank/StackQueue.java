package hackerrank;

import java.util.ArrayList;
import java.util.Scanner;

public class StackQueue {
	
	ArrayList element;

	public StackQueue() {

		element = new ArrayList();
	}

	public void pushCharacter(char c) {

		element.add(c);

	}

	public void enqueueCharacter(char c) {

		element.add(c);

	}

	public char popCharacter() {

		return (char) element.remove(element.size() - 1);

	}

	public char dequeueCharacter() {

		return (char) element.remove(0);

	}

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        scan.close();

        // Convert input String to an array of characters:
        char[] s = input.toCharArray();

        // Create a Solution object:
        StackQueue p = new StackQueue();

        // Enqueue/Push all chars to their respective data structures:
        for (char c : s) {
            p.pushCharacter(c);
            p.enqueueCharacter(c);
        }

        // Pop/Dequeue the chars at the head of both data structures and compare them:
        boolean isPalindrome = true;
        for (int i = 0; i < s.length/2; i++) {
            if (p.popCharacter() != p.dequeueCharacter()) {
                isPalindrome = false;                
                break;
            }
        }

        //Finally, print whether string s is palindrome or not.
        System.out.println( "The word, " + input + ", is " 
                           + ( (!isPalindrome) ? "not a palindrome." : "a palindrome." ) );
    }
}	
	

