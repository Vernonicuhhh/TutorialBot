package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Constants;

public class Drive{
    private TalonSRX frontLeft;
    private TalonSRX frontRight;
    private TalonSRX backLeft;
    private TalonSRX backRight;
    public Drive(){
        frontLeft = new TalonSRX(Constants.DriveConstants.DEVICE_ID_LEFT_TALON_MASTER);
        frontRight = new TalonSRX(Constants.DriveConstants.DEVICE_ID_RIGHT_TALON_MASTER);
        backLeft = new TalonSRX(Constants.DriveConstants.DEIVCE_ID_LEFT_TALON_SLAVE);
        backRight = new TalonSRX(Constants.DriveConstants.DEVICE_ID_RIGHT_TALON_SLAVE);
        backLeft.follow(frontLeft);
        backRight.follow(frontRight);
    }

    public void drive(double leftSpeed, double rightSpeed){
        frontLeft.set(ControlMode.PercentOutput,leftSpeed);
        frontRight.set(ControlMode.PercentOutput, rightSpeed);


    }
    
}