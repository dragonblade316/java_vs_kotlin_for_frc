package frc.robot.subsystems;


import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import java.util.function.DoubleSupplier;

public class DriveSubsystem extends SubsystemBase {

    // With eager singleton initialization, any static variables/fields used in the 
    // constructor must appear before the "INSTANCE" variable so that they are initialized 
    // before the constructor is called when the "INSTANCE" variable initializes.

    CANSparkMax frontleft;
    CANSparkMax frontright;
    CANSparkMax backleft;
    CANSparkMax backright;

    MecanumDrive driver;
    /**
     * The Singleton instance of this DriveSubsystem. Code should use
     * the {@link #getInstance()} method to get the single instance (rather
     * than trying to construct an instance of this class.)
     */
    private final static DriveSubsystem INSTANCE = new DriveSubsystem();

    /**
     * Returns the Singleton instance of this DriveSubsystem. This static method
     * should be used, rather than the constructor, to get the single instance
     * of this class. For example: {@code DriveSubsystem.getInstance();}
     */
    @SuppressWarnings("WeakerAccess")
    public static DriveSubsystem getInstance() {
        return INSTANCE;
    }

    /**
     * Creates a new instance of this DriveSubsystem. This constructor
     * is private since this class is a Singleton. Code should use
     * the {@link #getInstance()} method to get the singleton instance.
     */
    private DriveSubsystem() {
        // TODO: Set the default command, if any, for this subsystem by calling setDefaultCommand(command)
        //       in the constructor or in the robot coordination class, such as RobotContainer.
        //       Also, you can call addChild(name, sendableChild) to associate sendables with the subsystem
        //       such as SpeedControllers, Encoders, DigitalInputs, etc.

        frontleft = new CANSparkMax(Constants.FRONT_LEFT_MOTOR, CANSparkMaxLowLevel.MotorType.kBrushless);
        frontright = new CANSparkMax(Constants.FRONT_RIGHT_MOTOR, CANSparkMaxLowLevel.MotorType.kBrushless);
        backleft = new CANSparkMax(Constants.BACK_LEFT_MOTOR, CANSparkMaxLowLevel.MotorType.kBrushless);
        backright = new CANSparkMax(Constants.BACK_RIGHT_MOTOR, CANSparkMaxLowLevel.MotorType.kBrushless);

        driver = new MecanumDrive(frontleft, backleft, frontright,backright);
    }

    public void Drive(DoubleSupplier x, DoubleSupplier y, DoubleSupplier z) {
        driver.driveCartesian(y.getAsDouble(), x.getAsDouble(), z.getAsDouble());
    }
}

