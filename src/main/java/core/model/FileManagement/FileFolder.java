package core.model.FileManagement;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FileFolder {

	 private static Logger logger = Logger.getLogger(FileFolder.class);
	 private MyFolder folder;
	 private List<File> files;
	 private Iterator<File> filesIterator;
	 private boolean loaded = false;
	 public FileFolder(MyFolder folder){
	 	 this.folder = folder;
	 }

	 public boolean isLoaded(){
	 	 return loaded;
	 }

	 public void loadfiles(){
	 	 files = this.getStringPathtoFiles(folder.getFilesList());
	 	 filesIterator = files.iterator();
	 	 loaded = true;
	 }
	 public String readNextFile(){
	 	 String fileinfo= "";
	 	 if(loaded){
	 	 	if(filesIterator.hasNext()){
	 	 		 File thefile = filesIterator.next();
	 	 		 fileinfo =  getStringFromFile(thefile);
			}
		 }
	 	 return fileinfo;
	 }
	 private String getStringFromFile(File file){
		  StringBuffer sb = new StringBuffer();//constructs a string buffer with no characters
		  try {
			   BufferedReader br = new BufferedReader(new FileReader(file));  //creates a buffering character input stream
			   String line;
			   while ((line = br.readLine()) != null) {
					sb.append(line);
			   }
			   br.close();
		  }catch(IOException e){
			   logger.debug(e);
		  }
		  return sb.toString();
	 }
	 private List<File> getStringPathtoFiles(List<String> paths){
	 	 List<File> files = new ArrayList<>();
	 	 File file;
	 	 for(String pathfile: paths){
	 	 	 file = new File(pathfile);
	 	 	 files.add(file);
		 }
	 	 return files;
	 }

	 public int getfilestotal(){
	 	 return this.files.size();
	 }


	 public void clear(){
	 	 this.files.clear();
	 	 this.filesIterator = null;
	 	 this.loaded = false;
	 }
}
