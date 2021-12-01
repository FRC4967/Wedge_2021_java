package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;

public class Solinoids {
    static Compressor compressor = new Compressor();
    static Solenoid leftF = new Solenoid(3);
    static Solenoid leftB = new Solenoid(1);
    static Solenoid rightF = new Solenoid(0);
    static Solenoid rightB = new Solenoid(2);
    static Solenoid charge = new Solenoid(6);
    static Solenoid shoot = new Solenoid(7);
    static TalonFX shooterArm = new TalonFX(4);
    static boolean LF = false;
    static boolean LB = false;
    static boolean RF = false;
    static boolean RB = false;

    public static void Solenoids() {
        
        if (RobotMap.Controller.getRawButtonPressed(2) == true) {
            LF = !LF;
            LB = !LB;
            RF = !RF;
            RB = !RB;
            leftF.set(LF);
            leftB.set(LB);
            rightF.set(RF);
            rightB.set(RB);
        }
        
        if (RobotMap.Controller.getRawButton(6)){
            charge.set(true);
        } else {
            charge.set(false);
        }
        if (RobotMap.Controller.getRawButton(8)){
            shoot.set(true);
        } else {
            shoot.set(false);
        }
        if (RobotMap.Controller.getRawButton(7)){
            shooterArm.set(ControlMode.PercentOutput, -0.2);
        } else if(RobotMap.Controller.getRawButton(5)){
            shooterArm.set(ControlMode.PercentOutput, 0.2);
        } else {
            shooterArm.set(ControlMode.PercentOutput, 0);
        }


    }

    public static void SolenoidsInit() {
        compressor.start();
        leftF.set(false);
        leftB.set(false);
        rightF.set(false);
        rightB.set(false);
        LF = false;
        LB = false;
        RF = false;
        RB = false;
    }

    public static void SolenoidsDis() {
        compressor.stop();
        leftF.set(false);
        leftB.set(false);
        rightF.set(false);
        rightB.set(false);
        LF = false;
        LB = false;
        RF = false;
        RB = false;
    }
}
