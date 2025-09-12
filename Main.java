/*
This is all color use in this code
	RED = "\033[91m";
	GREEN = "\033[92m";
	BLUE = "\033[94m";	
	END = "\033[0m";	
*/

import java.util.Scanner;

class Song {
	public String title;
	public Song next;
	public Song previous;

	public Song(String title) {
		this.title = title;
		this.next = null;
		this.previous = null;
	}	// End of constructure
}	// End of Song class

class Playlist {
	private Song head;
	private Song tail;	

	public Playlist() {
		this.head = null;
		this.tail = null;
	}	// End of constructure

	public static void display() {
		System.out.printf("\033[91m-----Your Playlist-----\033[0m\n");	
		Song current = head;	
		while (current != null) {
			System.out.printf("\t\033[92m%s\033[0m\n", current.title);
			current = current.next;	
		}
	}	// End of display method

	public static void addSong(String title) {
		Node newSong = new Node(title);
		if (head == null) {
			head = newSong;
			tail = newSong;
		} else {
			tail.next = newSong;
			newSong.previous = tail;
			tail = newSong;
		}
	}	// End of add method

	public static void removeSong() {

	}
}	// End of Playlist class

public class Main {
	public static void main(String[] args) {
		startup();	
		getInput();
	}	// End of main method
		
	static void startup() {
		System.out.printf("\033[91mHello!!, Welcome to my side project \"Songs play list\"\033[0m\n");
		System.out.printf("\033[91mLet start: \033[0m\n");	
	}	// End of startup method

	static void endProgram() {
		System.out.printf("\033[91mThank for use this program, Byeee~~~~\033[0m\n");
		System.exit(0);	
	}	// End of endProgram method

	static void getInputText() {
		System.out.printf("\033[94mPress \"a\" for add song\n");	
		System.out.printf("\033[94mPress \"r\" for add song\n");	
		System.out.printf("\033[94mPress \"q\" for exit\n");
		System.out.printf("\033[94mInput: \033[94m");	
	}	// End of getInputText method

	static void getInput() {
		Scanner sc = new Scanner(System.in);	
		getInputText();	
		while(true) {
			switch(sc.nextLine().toLowerCase()) {
				case "a":
					break;
				
				case "r":
					break;
				
				case "q":
					endProgram();
					break;

				default:
					System.out.printf("\033[94Maybe you enter wrong command\033[0m\n");	
			}	
			getInputText();	
		}
	}	// End of getInput method
}	// End of Main class

