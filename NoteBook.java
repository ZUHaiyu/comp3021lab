package base;

import java.util.ArrayList;

public class NoteBook {
	private ArrayList<Folder> folders;
	
	public NoteBook() {
		folders = new ArrayList<Folder>();
	}
	public boolean createTextNote(String folderName, String title) {
		TextNote note = new TextNote(title);
		return insertNote(folderName, note);
	}
	public boolean createImageNote(String folderName, String title) {
		ImageNote note = new ImageNote(title); 
		return insertNote(folderName, note);
	}
	public ArrayList<Folder> getFolders(){
		return folders;
	}
	public boolean insertNote(String folderName, Note note) {
		Folder f = null;
		for(Folder f1 : folders) {
			if(folderName == f1.getName())
				f = f1;
			else
				f = new Folder(folderName);
		}
	
		boolean step2 = false;
		for(Note n: f.getNotes()) {
			if(n.equals(note))
				step2 = true;
		}
		if(step2 == true) {
			System.out.println("Creating note " + note.getTitle() + "under folder " + folderName + " failed");
			return false;
		}
		else {
			f.addNote(note);
			return true;				
		}
	}
}