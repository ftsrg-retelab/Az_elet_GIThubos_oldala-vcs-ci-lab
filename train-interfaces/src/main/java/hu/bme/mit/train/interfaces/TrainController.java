package hu.bme.mit.train.interfaces;

public interface TrainController {

	void followSpeed();

	int getReferenceSpeed();
	
	int getSpeedLimit();
	
	int getTableSize();

	void setSpeedLimit(int speedLimit);

	void setJoystickPosition(int joystickPosition);

}
