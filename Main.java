/*
This is all color use in this code
	RED = "\033[91m";
	GREEN = "\033[92m";
	BLUE = "\033[94m";	
	END = "\033[0m";	
*/

import java.util.Scanner;

class Song {
	String title;
	Song next;

	Song (String title) {
		this.title = title;
		this.next = null;
	}
}	// End of Song class

class Playlist {
	Scanner sc = new Scanner(System.in);	
	private Song head;

	void addSong(String title) {
		Song newSong = new Song(title);
		if (head == null) {
			head = newSong;
			return;
		}
		Song current = head;
		while (current.next != null) {
			current = current.next;
		}
		current.next = newSong;	
	}	// End of addSong method

	void removeSong() {
		if (head == null) {
			System.out.printf("\033[94mNo song in playlist\033[0m\n");
			return;	
		}	
		
		System.out.printf("\033[94mWhich song you want to remove?: \033[0m");
		String newTitle = sc.nextLine();
		
		if (head.title.equals(newTitle)) {
			head = head.next;
			return;	
		}	
		
		Song current = head;	
		while(current.next != null) {
			if (current.next.title.equals(newTitle)) {
				current.next = current.next.next;	
				return;	
			}
		}
		System.out.printf("\033[94mNot found\n\033[0m");
	}	// End of removeSong method

	void display() {
		System.out.printf("\n\033[91m----------Your song----------\033[0m\n");	
		if (head == null) {
			System.out.printf("\033[92m(Empty)\033[0m\n");
			System.out.printf("\033[91m-----------------------------\033[0m\n\n");	
			return;
		}
		Song current = head;	
		int count = 1;	
		while (current != null) {
			System.out.printf("\033[92m%d. %s\033[0m\n", count++, current.title);
			current = current.next;	
		}	
		System.out.printf("\033[91m-----------------------------\033[0m\n\n");	
	}	// End of display method
}	// End of Playlist class

public class Main {
	public static void main(String[] args) {
		startup();	
		getInput();
	}	// End of main method
		
	static void startup() {
		System.out.printf("\033[91mHello!!, Welcome to my side project \"Songs play list\"\033[0m\n");
		System.out.printf("\033[91mLet's start: \033[0m\n");	
	}	// End of startup method

	static void endProgram() {
		System.out.printf("\033[91mThank you for using this program, Byeee~~~~\033[0m\n");
		System.exit(0);	
	}	// End of endProgram method

	static void getInputText() {
		System.out.printf("\033[94mPress \"a\" to add song\n");	
		System.out.printf("\033[94mPress \"r\" to remove song\n");	
		System.out.printf("\033[94mPress \"q\" to exit\n");
		System.out.printf("\033[94mInput: \033[0m");	
	}	// End of getInputText method

	static void getInput() {
		Scanner sc = new Scanner(System.in);	
		Playlist playlist = new Playlist();		
		getInputText();	
		while(true) {
			switch(sc.nextLine().toLowerCase()) {
				case "a":
					System.out.printf("\033[94mEnter song title: \033[0m");
					String title = sc.nextLine();
					playlist.addSong(title);
					break;
				
				case "r":
					playlist.removeSong();
					break;

				case "q":
					endProgram();
					break;

				default:
					System.out.printf("\033[94mMaybe you entered wrong command\033[0m\n");	
			}
			playlist.display();		
			getInputText();	
		}
	}	// End of getInput method
}	// End of Main class
