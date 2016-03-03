package body;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Path;
import javax.swing.Timer;

public class Viper implements ActionListener {
	Timer t= new Timer(1,this);
	Path vPath;
	File vF;
public Viper(){
	t.start();
	 vF=new File(System.getProperty("use.dir"));
	vPath=vF.toPath();
}
public void hatch(String mode){
	if(mode.equals("Lab Rat")){
		
	}else if(mode.equals("Wild")){
		
	}
}
@Override
public void actionPerformed(ActionEvent arg0) {
	File modeF= new File(vF.getAbsolutePath()+"/mode.txt");
	if(modeF.exists()==true){
		
	}
	
}
public static void main(String Args[]){
	 Viper vip=new Viper();
}
}
