package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants;
import frc.robot.Constants.MiscConstants;

public class Pnmeumatics {
    public DoubleSolenoid shooterSolenoid;
    public DoubleSolenoid rampSolenoid;
    public DoubleSolenoid intakeSolenoid;

    public Pnmeumatics() {
        rampSolenoid = new DoubleSolenoid(4,5);
        shooterSolenoid = new DoubleSolenoid(2,3);
        intakeSolenoid = new DoubleSolenoid(0,1);
        //intak 0,1
        //shooter 2,3
        //ramp 4,5
    }
    public void squeezeIntake(boolean squeazed){
        if(squeazed == true)
            intakeSolenoid.set(Value.kReverse);

        else
            intakeSolenoid.set(Value.kForward);
    }

    public void toggleRamp(boolean toggled){
        if(toggled == true){
            rampSolenoid.set(Value.kReverse);
            SmartDashboard.putString("Ramp", "off");
        }

        else{
            rampSolenoid.set(Value.kForward);
            SmartDashboard.putString("ramp", "on");
    }


    
}

public void toggleShooterAngle(){
        shooterSolenoid.set(Value.kForward);

}

public void reverseShooterAngle(){
        shooterSolenoid.set(Value.kReverse);
}
}
