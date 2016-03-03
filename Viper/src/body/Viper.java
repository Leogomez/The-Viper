package body;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Path;
import javax.swing.Timer;

import communication.Identification;

public class Viper implements ActionListener {
	Timer t= new Timer(1,this);
	Head head;
	Path vPath;
	File vF;
public Viper(){
	t.start();
	 vF=new File(System.getProperty("use.dir"));
	 head= new Head(vF);
	vPath=vF.toPath();
	File modeF= new File(vF.getAbsolutePath()+"/mode.txt");
	if(modeF.exists()==true){
		hatch("Lab Rat");
	}else{
		hatch("Wild");
	}
}
public void hatch(String mode){
	if(mode.equals("Lab Rat")){
		head.labMode(vPath);
	}else if(mode.equals("Wild")){
		
	}
}
@Override
public void actionPerformed(ActionEvent arg0) {
	
	
}
public static void main(String Args[]){
	 Viper vip=new Viper();
}
}
