package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpiutil.math.MathUtil;
import frc.robot.Constants;

public class Drive {
    public TalonSRX leftMaster;
    public TalonSRX leftSlave;
    public TalonSRX rightMaster;
    public TalonSRX rightSlave;

    public Drive() {
        leftMaster = new TalonSRX(Constants.DriveConstants.DEVICE_ID_LEFT_TALON_MASTER);
        leftSlave = new TalonSRX(Constants.DriveConstants.DEIVCE_ID_LEFT_TALON_SLAVE);
        rightMaster = new TalonSRX(Constants.DriveConstants.DEVICE_ID_RIGHT_TALON_MASTER);
        rightSlave = new TalonSRX(Constants.DriveConstants.DEVICE_ID_RIGHT_TALON_SLAVE);
        leftMaster.setInverted(true);
        leftSlave.setInverted(true);
        leftSlave.follow(leftMaster);
        rightSlave.follow(rightMaster);
    }

    public void tankDrive(double leftSpeed, double rightSpeed, boolean squaredInputs){
        leftMaster.set(ControlMode.PercentOutput, leftSpeed);
        rightMaster.set(ControlMode.PercentOutput, rightSpeed);
    }

    public void rocketDrive(double rightTrigger, double leftStick, double leftTrigger){
        if(rightTrigger > 0.1){
            leftMaster.set(ControlMode.PercentOutput, -(rightTrigger + leftStick));
            rightMaster.set(ControlMode.PercentOutput, -(rightTrigger - leftStick));
        }else if(leftTrigger > 0.1){
            leftMaster.set(ControlMode.PercentOutput, (rightTrigger - leftStick));
            rightMaster.set(ControlMode.PercentOutput, (rightTrigger + leftStick));
        }else{
            leftMaster.set(ControlMode.PercentOutput, -leftStick);
            rightMaster.set(ControlMode.PercentOutput, leftStick);
        }
        
    }
    public void otherRocketDrive( double rightTrigger, double leftTrigger, double turn){
            turn= Math.pow(turn, 2)* Math.signum(turn);
            double rightSpeed;
            double leftSpeed;
            if(rightTrigger > .1){
                rightSpeed = rightTrigger + turn;
                leftSpeed = rightTrigger - turn;
            }

            else if (leftTrigger> .1){
                rightSpeed = -(leftTrigger + turn);
                leftSpeed = -(leftTrigger - turn);
            }

            else{
                rightSpeed = turn;
                leftSpeed =  -turn;
            }
            leftSpeed = MathUtil.clamp(leftSpeed, -1, 1);
            rightSpeed = MathUtil.clamp(rightSpeed, -1, 1);
            leftMaster.set(ControlMode.PercentOutput, leftSpeed);
            rightMaster.set(ControlMode.PercentOutput, rightSpeed);
        }
    }
