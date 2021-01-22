/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class Robot extends TimedRobot 
{
  private Command autonomousCommand;

  private RobotContainer robotContainer;

  @Override
  public void robotInit() 
  {
    NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(1);
    robotContainer = new RobotContainer();
  }

  @Override
  public void robotPeriodic() 
  {
    CommandScheduler.getInstance().run();
  }

  @Override
  public void disabledInit() 
  {
    NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(1);
  }

  @Override
  public void disabledPeriodic() 
  {
  }

  @Override
  public void autonomousInit() 
  {
    autonomousCommand = robotContainer.getAutonomousCommand();

    if (autonomousCommand != null)
      autonomousCommand.schedule();
  }

  @Override
  public void autonomousPeriodic() 
  {
  }

  @Override
  public void teleopInit() 
  {
    NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(1);
    if (autonomousCommand != null)
      autonomousCommand.cancel();
  }

  @Override
  public void teleopPeriodic() 
  {
  }

  @Override
  public void testInit() 
  {
    CommandScheduler.getInstance().cancelAll();
  }

  @Override
  public void testPeriodic() 
  {
  }
}
