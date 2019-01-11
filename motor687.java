/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.ExampleSubsystem;

public class Robot extends TimedRobot {
  public static ExampleSubsystem m_subsystem = new ExampleSubsystem();
  public static OI m_oi;

  
  private SpeedController m_flywheel;
  private Joystick m_joystick;
  private Timer timer;
  Command m_autonomousCommand;

  public void robotInit() {
    m_oi = new OI();
      SmartDashboard.putData("Auto mode", m_chooser);
    m_flywheel = new Talon(kMotorPort);
    m_joystick = new Joystick(kJoystickPort);
  }

  
  @Override
  public void testPeriodic() {
    while(driving == false){
      goPercent(50, 5);
      
    }
    m_flywheel.set(-m_joystick.getY());
  }

  public void goPercent(int percent, float time)
  {
    time = time*1000;
    while(timer.get() <= time)
    percent = percent/10;
    m_flywheel.set(percent);
  }

  public void stop(){
    m_flywheel.set(0);
  }
}