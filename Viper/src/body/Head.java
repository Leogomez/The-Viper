package body;

import java.io.File;
import java.nio.file.Path;

import communication.Identification;
import propogartion.NestEgg;

public class Head {
	int unitNumber;
	int unitCopys;
	Identification vID;
	File vF;
public Head(File vI){
	vF=vI;
	vID=new Identification(vF);
	unitNumber=vID.getUnitNumber();
	unitCopys=vID.getUnitsCopys();
}
public void labMode(Path vPath){
	NestEgg.labEgg(vPath,unitNumber);
	unitCopys+=NestEgg.getUnitsCreated();
	
	
}
public void wildMode(Path vPath){
	
	}
}
