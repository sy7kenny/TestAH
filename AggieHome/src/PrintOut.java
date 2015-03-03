public class PrintOut {
  public void SetPrint(AggieHome home,CANRead canPort,EnergyMgmt1 energyMgmt1){
	  
	  	if (home.mode==true & canPort.mode==true ){
	   		System.out.print("Eureka!"+"power"+energyMgmt1.power+"step "+energyMgmt1.step+"\n");}
		// time 
	  	
		 System.out.print("dt"+home.time.timeDt+" ");
		 System.out.print("now"+home.time.timeNow+" ");
		 System.out.print("vmax"+home.battery.vMax+" ");
		 System.out.print("vmin"+home.battery.vMin+" ");
		 System.out.print("tmax"+home.battery.tMax+" ");
		 System.out.print("tmin"+home.battery.tMin+" ");
		 System.out.print("vpack"+home.battery.vPack+" ");
		 System.out.print("cpackh"+home.battery.cPack+" ");
		 System.out.print("socSuper"+home.battery.socSuper+" ");
		 System.out.print("sohSuper"+home.battery.sohSuper+" ");
		 System.out.print("batt"+home.pB+" ");
		 System.out.print("grid"+home.pG+" ");
		 System.out.print("home"+home.pH+" ");
		 System.out.print("pv"+home.pP+" ");
		 System.out.print("\n");
		//cell
		 for (int p = 0; p < 5; p++){
			 System.out.print("v"+home.battery.cell[p].v+" ");
			 System.out.print("t"+home.battery.cell[p].t+" ");
			 System.out.print("b"+home.battery.cell[p].b+" ");
			 System.out.print("socC"+home.battery.cell[p].socC+" ");
			 System.out.print("sohC"+home.battery.cell[p].sohC+" ");
			 System.out.print("sohP"+home.battery.cell[p].sohP+" ");
			 System.out.print("\n");
		 }
		 for (int p = 5; p < 10; p++){
			 System.out.print("v"+home.battery.cell[p].v+" ");
			 System.out.print("t"+home.battery.cell[p].t+" ");
			 System.out.print("b"+home.battery.cell[p].b+" ");
			 System.out.print("socC"+home.battery.cell[p].socC+" ");
			 System.out.print("sohC"+home.battery.cell[p].sohC+" ");
			 System.out.print("sohP"+home.battery.cell[p].sohP+" ");
			 System.out.print("\n");
		 }
		 for (int p = 10; p < 15; p++){
			 System.out.print("v"+home.battery.cell[p].v+" ");
			 System.out.print("t"+home.battery.cell[p].t+" ");
			 System.out.print("b"+home.battery.cell[p].b+" ");
			 System.out.print("socC"+home.battery.cell[p].socC+" ");
			 System.out.print("sohC"+home.battery.cell[p].sohC+" ");
			 System.out.print("sohP"+home.battery.cell[p].sohP+" ");
			 System.out.print("\n");
		 }
  }
}
