package frc.robot.subsystems

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax
import com.revrobotics.CANSparkMaxLowLevel
import edu.wpi.first.wpilibj.drive.MecanumDrive
import frc.robot.BACK_LEFT_MOTOR
import frc.robot.BACK_RIGHT_MOTOR
import frc.robot.FRONT_LEFT_MOTOR
import frc.robot.FRONT_RIGHT_MOTOR
import java.util.function.DoubleSupplier

object DriverSubsystem : SubsystemBase() {
    private val FL = CANSparkMax(FRONT_LEFT_MOTOR, CANSparkMaxLowLevel.MotorType.kBrushless)
    private val FR = CANSparkMax(FRONT_RIGHT_MOTOR, CANSparkMaxLowLevel.MotorType.kBrushless)
    private val BL = CANSparkMax(BACK_LEFT_MOTOR, CANSparkMaxLowLevel.MotorType.kBrushless)
    private val BR = CANSparkMax(BACK_RIGHT_MOTOR, CANSparkMaxLowLevel.MotorType.kBrushless)

    private val driver = MecanumDrive(FL, FR, BL, BR)

    fun drive(x: DoubleSupplier, y: DoubleSupplier, z: DoubleSupplier) {
        driver.driveCartesian(y.asDouble, x.asDouble, z.asDouble)
    }
}