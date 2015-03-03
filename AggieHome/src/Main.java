import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import jssc.SerialPort;
import jssc.SerialPortException;
import peak.can.basic.*;
import smaGson.SMA;
import xml.*;


public class Main {
	public static void main(String[] args) {
		AggieHome home=new AggieHome();
		//EnergyMgmt control= new EnergyMgmt();
		//SerialRead serialPort=new SerialRead();
		CANRead canPort=new CANRead();
		DummyRead dummy=new DummyRead();
		PrintOut printOut=new PrintOut();
		WriteToFile writeToFile=new WriteToFile();
		EnergyMgmt1 energyMgmt1 = new EnergyMgmt1();
		//generate classes for sma read/write, 
		SMA smaPort2 = new SMA();
		//and xml file read
		XmlRead obviusPort=new XmlRead();
		
		
		for (int p = 0; p <10 ; p++){ //34160
		//while (true) {
	     //try {Thread.sleep(1000);}catch (InterruptedException e){e.printStackTrace();} 
		 try {Thread.sleep(1000);}catch (InterruptedException e){e.printStackTrace();} 
		 // step 1. update time
		 		home.time.SetTime();
		 // step 2. update measurements
		     // get measurement from sma, pv power and battery current
		 	    smaPort2.getSMAmeasure();
		 	    home.pP=smaPort2.pvBat.getPv();
		 	    home.battery.cPack = smaPort2.pvBat.getBatCur();
		 	// get measurement canbus, voltage, temperature
		 	    home=canPort.ReadCAN(home);
		 	// get measurement from obvius panel, house power
		 	    obviusPort.getMeasure();
		 	    home.pH=obviusPort.va;
		 	    //home.battery=dummy.GetRead(home.battery);
		 // step 3. update soc/soh, update power management states
		 	    home.battery.SetBatteryUpdate();
		 	    energyMgmt1.SetPower(home);
		    if (home.mode==true & canPort.mode==true ){
		    	//smaPort.WritePort(home, energyMgmt1.power);
		    	smaPort2.setParameters(0);//energyMgmt1.power
		    	}
		    else {
		    	//smaPort.WritePort(home, 0);
		    	smaPort2.setParameters(0);
		    	} // during safe mode, battery power is zero
		 // step 4. variables print out & data logging
			    printOut.SetPrint(home,canPort,energyMgmt1);
			    writeToFile.SetDatalog(home);
		}
	}
}