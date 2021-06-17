/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.subsystems.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends TimedRobot {
 
  public Joystick controller = new Joystick(Constants.MiscConstants.CONTROLLER_ID);
  
  Drive m_drive = new Drive();
  Shooter m_shooter = new Shooter();
  Intake m_intake = new Intake();
  Pnmeumatics m_pnmeumatics = new Pnmeumatics();
  Compressor c = new Compressor();
 //Joystick driveStick1 = new Joystick(1);
 //Joystick driveStick2 = new Joystick(2);
  
  @Override
  public void robotInit() {
  
  }

 
  @Override
  public void autonomousInit() {

  }

 
  @Override
  public void autonomousPeriodic() {
  
  }

  
  @Override
  public void teleopInit() {
    c.start();

  }

  
  @Override
  public void teleopPeriodic() {
        m_drive.tankDrive(controller.getRawAxis(1), controller.getRawAxis(3), false);
        //m_drive.rocketDrive(controller.getRawAxis(3), controller.getRawAxis(0), controller.getRawAxis(2));
       if(controller.getRawButtonPressed(8)){
        m_shooter.setShooter(1.0);
       }
       if(controller.getRawButtonReleased(8))
        m_shooter.setShooter(0);
        //m_intake.intakeCube(controller.getRawAxis(5));
        if(controller.getRawButton(1)){
          m_pnmeumatics.toggleShooterAngle();
        }
        if(controller.getRawButton(5)){
          m_pnmeumatics.reverseShooterAngle();
        }
    
        if(controller.getRawButtonPressed(5)){
          m_pnmeumatics.squeezeIntake(true);
          m_intake.intakeCube(-1.0);
        }    

        if(controller.getRawButtonReleased(5)){
        m_pnmeumatics.squeezeIntake(false);
        m_intake.intakeCube(0) ;
        }

        if(controller.getRawButtonReleased(6))
        m_pnmeumatics.toggleRamp(false);

        if(controller.getRawButtonPressed(6))
        m_pnmeumatics.toggleRamp(true);

        
  }

  
  @Override
  public void testPeriodic() {
  }
}