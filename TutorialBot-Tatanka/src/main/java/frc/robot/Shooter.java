package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants;

public class Shooter{
    VictorSPX shooter1;
    VictorSPX shooter2;
    TalonSRX leftShooter;
    TalonSRX rightShooter;

    public Shooter(){
        shooter1 = new VictorSPX(Constants.ShooterConstants.DEVICE_ID_SPARK_SHOOTER);
        shooter2 = new VictorSPX(Constants.ShooterConstants.DEVICE_ID_SPARK_SHOOTER_2);
        leftShooter = new TalonSRX(Constants.ShooterConstants.DEVICE_ID_TALON_SHOOTER_MASTER);
        rightShooter = new TalonSRX(Constants.ShooterConstants.DEVICE_ID_TALON_SHOOTER_SLAVE);
        leftShooter.setInverted(true);
        rightShooter.setInverted(true);
        shooter1.setInverted(true);
        shooter2.setInverted(false);
        rightShooter.follow(leftShooter);
    }

    public void setShooter(double speed){
        shooter1.set(ControlMode.PercentOutput, -speed);
        shooter2.set(ControlMode.PercentOutput, -speed);
        leftShooter.set(ControlMode.PercentOutput, -speed);
        rightShooter.set(ControlMode.PercentOutput,-speed);
        SmartDashboard.putNumber("shooter speed", speed);       
        
    }
}