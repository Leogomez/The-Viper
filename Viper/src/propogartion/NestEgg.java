package propogartion;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class NestEgg {
	static String[] inCoded= {"testing","testing","testing"};
public static void labEgg(){
	
	try{
		 
		 //FileOutputStream stream2 = new FileOutputStream(fileName);
		 
		File nestLocation=new File("saves/game1.txt");
		
		
			
		 if(!nestLocation.exists()){
			 nestLocation.createNewFile();
		 
		
		//OutputStreamWriter myStream2 = new OutputStreamWriter (stream2);
		 FileWriter fw= new FileWriter(nestLocation.getAbsolutePath());
		BufferedWriter writing= new BufferedWriter(fw);
	
		
		 //String line="playShipHealth= "+playShipHealth+"secDescov= "+secDescov+"shipsDef= "+shipsDef+"level= "+level+"population= "+population;
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
