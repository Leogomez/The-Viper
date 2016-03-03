package communication;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Identification {
	int[] viperData=new int[2];
	public Identification(File vF){
		
	}
public int getUnitNumber(){
	return viperData[0];
	
}
public int getUnitsCopys(){
	return viperData[1];
	
}
public void getInfo(File vF){

String[] code={"a","b","c","d","e","f","g","h","i","j"};

int x=0;
int out=0;
	try{
	 //Declaring the input streams and readers
	 FileInputStream stream = new FileInputStream(vF.getAbsolutePath()+"/Info.txt");
	 InputStreamReader myStream = new InputStreamReader (stream);
	 BufferedReader reader = new BufferedReader(myStream);
	 String line;
	 
	 line = reader.readLine();  //This actaully reads a line
	 	while(line !=null){   //Loops until it finds the end of the file
 			
 		
 				
 					for(int y=0;y<line.length();y++){
 						for(int z=0;z<code.length;z++){
 							if(y+1!=line.length()){
 								if(line.substring(y,y+1).equals(code[z])==true){
 									out=(out*10)+z;
 								}
 							}else{
 								if(line.substring(y).equals(code[z])==true){
 									out=(out*10)+z;
 								}
 					}
 					}
 					}
 					viperData[x]=out;
 					System.out.println(out);
 					x++;
 					out=0;
 			
 			line=reader.readLine();
	 	}	
	} catch(IOException e){
		 System.out.println( "Error: "+ e.toString());
		 }	
		 
	 
	 

	
	
}
public void saveInfo(int unitNumber, int unitCopys,File vF){
int[] vData={unitNumber,unitCopys};
		String[] code={"a","b","c","d","e","f","g","h","i","j"};
	String[] inCoded=new String[100];
	for(int x=0;x<inCoded.length;x++){
		inCoded[x]="";
	}
	for(int x=0;x<vData.length;x++){
		int y=vData[x];
		int z=0;
		String intermid="";
		while(y>10){
			z=y%10;
			intermid=code[z]+intermid;
			System.out.println(intermid);
			y=(y-z)/10;
			System.out.println(y);
			if(y<10){
				intermid=code[y]+intermid;
				
			}
		}
		if(y<10){
			intermid=code[y]+intermid;
			
		}
		inCoded[x]=intermid;
	}
	try{
		 
		 
		 
		File saveFile=new File("");
		
		
			
		
		 if(!saveFile.exists()){
			 saveFile.createNewFile();
		 }
		
		
		 FileWriter fw= new FileWriter(saveFile.getAbsolutePath());
		BufferedWriter writing= new BufferedWriter(fw);
	
		
		
	   for(int x=0;x<inCoded.length; x++){
		writing.write(inCoded[x]);
		writing.newLine();
		}
	    writing.close();
		
		 }
		 catch(IOException e){
		 System.out.println( "Error: "+ e.toString());
		 }
		
	
}
}
