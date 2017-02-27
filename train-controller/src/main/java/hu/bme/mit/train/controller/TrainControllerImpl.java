package hu.bme.mit.train.controller;

import hu.bme.mit.train.interfaces.TrainController;
import com.google.common.collect.Table;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.google.common.collect.HashBasedTable;

public class TrainControllerImpl implements TrainController{
private Table<String, Integer, Integer> records = HashBasedTable.create();

	private int step = 0;
	private int referenceSpeed = 0;
	private int speedLimit = 0;
	
	public void addrec(){
		records.put(new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()),new Integer(step), new Integer(referenceSpeed));
	}

	@Override
	public void followSpeed() {
		referenceSpeed += step;
		if (referenceSpeed <= 0) {
			referenceSpeed = 0;
		} 

		enforceSpeedLimit();
	}

	@Override
	public int getReferenceSpeed() {
		return referenceSpeed;
	}
	
	@Override
	public int getSpeedLimit() {
		return speedLimit;
	}

	@Override
	public void setSpeedLimit(int speedLimit) {
		this.speedLimit = speedLimit;
		enforceSpeedLimit();
		
	}

	private void enforceSpeedLimit() {
		if (referenceSpeed > speedLimit) {
			referenceSpeed = speedLimit;
		}
		addrec();
	}
	
	public int getTableSize(){
		return records.size();
	}

	@Override
	public void setJoystickPosition(int joystickPosition) {
		this.step = joystickPosition;		
	}

	}


