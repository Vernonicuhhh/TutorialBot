package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import frc.robot.Constants;

public class intake{
    VictorSPX slave;
    VictorSPX master;

    public intake(){
        slave = new VictorSPX(Constants.IntakeConstants.DEVICE_ID_SLAVE_TALON);
        master = new VictorSPX(Constants.IntakeConstants.DEVICE_ID_MASTER_TALON);
        slave.follow(master);
    }

    public void intakeCube(double speed){
        master.set(ControlMode.PercentOutput, speed);
        SmartDashboard.putNumber("Intake Speed", speed);
    }
}