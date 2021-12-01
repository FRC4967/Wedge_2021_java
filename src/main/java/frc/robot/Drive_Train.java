package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;


public class Drive_Train {
    static TalonFX leftDrive = new TalonFX(0);
    static TalonFX rightDrive = new TalonFX(2);
    static double leftSpeed = 0;
    static double rightSpeed = 0;
    public static void Drive(){
        if(Math.abs(RobotMap.Controller.getRawAxis(1))<0.05){
            leftSpeed = 0;
        }else{
            leftSpeed = RobotMap.Controller.getRawAxis(1);
        }
        if(Math.abs(RobotMap.Controller.getRawAxis(3))<0.05){
            rightSpeed = 0;
        }else{
            rightSpeed = RobotMap.Controller.getRawAxis(3);
        }
        leftDrive.set(ControlMode.PercentOutput, leftSpeed);
        rightDrive.set(ControlMode.PercentOutput, rightSpeed);
        
    }
    public static void DriveInit(){
        leftSpeed = 0;
        rightSpeed = 0;
        leftDrive.setInverted(true);
    }
    public static void DriveDis(){
        leftSpeed = 0;
        rightSpeed = 0;
        leftDrive.set(ControlMode.PercentOutput, leftSpeed);
        rightDrive.set(ControlMode.PercentOutput, rightSpeed);
    }
}
