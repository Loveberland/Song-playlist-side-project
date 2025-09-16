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
	}	// End of constructor
}	// End of Song class

class Playlist {
	private Song head;
	private Song tail;	

	public Playlist() {
		this.head = null;
		this.tail = null;
	}	// End of constructor

	public void display() {
		System.out.printf("\033[91m-----Your Playlist-----\033[0m\n");	
		Song current = head;	
		if (current == null) {
			System.out.printf("\033[94m(Empty)\033[0m\n");
		}
		while (current != null) {
			System.out.printf("\033[92m%s\033[0m\n", current.title);
			current = current.next;	
		}
		System.out.printf("\033[91m-----------------------\033[0m\n");
	}	// End of display method

	public void addSong(String title) {
		Song newSong = new Song(title);
		if (head == null) {
			head = newSong;
			tail = newSong;
		} else {
			tail.next = newSong;
			newSong.previous = tail;
			tail = newSong;
		}
	}	// End of addSong method

	public void removeSong() {
		if (tail == null) {
			System.out.printf("\033[91mPlaylist is empty, nothing to remove.\033[0m\n");
			return;
		}
		System.out.printf("\033[91mRemoved: %s\033[0m\n", tail.title);
		if (head == tail) { // only one song
			head = null;
			tail = null;
		} else {
			tail = tail.previous;
			tail.next = null;
		}
	}	// End of removeSong method
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
