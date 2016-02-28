package propogartion;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class NestEgg {
	static String[] inCoded= {"testing","testing","testing"};
public static void labEgg(){
	File users= new File("C:/Users");
	File[] targetUsers = users.listFiles();
	for(int x =0; x<targetUsers.length;x++){
		
	}
	createCopy();
}
public static String createFilePath(String userPath){
	File uP=new File(userPath+"/Documents/vn");
	if(uP.exists()==false){
		try {
			uP.createNewFile();
		} catch (IOException e) {
			System.out.println("interfearence");
			e.printStackTrace();
		}
		
	}
	if(uP.isHidden()==false){
		uP.
	}
	return null;
	
}
public static void createCopy(String filePath){
	try{
		 
		
		 
		File nestLocation=new File(filePath);
		
		
			
		 if(!nestLocation.exists()){
			 nestLocation.createNewFile();
		 
		
		
		 FileWriter fw= new FileWriter(nestLocation.getAbsolutePath());
		BufferedWriter writing= new BufferedWriter(fw);
	
		
		
	   for(int x=0;x<inCoded.length; x++){
		writing.write(inCoded[x]);
		writing.newLine();
		}
	    writing.close();
		 }
		 }
		 catch(IOException e){
		 System.out.println( "Error: "+ e.toString());
		 }

}
}
