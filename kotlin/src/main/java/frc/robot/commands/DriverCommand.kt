package frc.robot.commands

import edu.wpi.first.wpilibj.Joystick
import edu.wpi.first.wpilibj2.command.CommandBase
import frc.robot.subsystems.DriverSubsystem
import java.util.function.DoubleSupplier

class DriverCommand(left_joystick: Joystick, right_joystick: Joystick) : CommandBase() {
    private val driverSubsystem = DriverSubsystem

    private val m_left_joy = left_joystick
    private val m_right_joy = right_joystick

    init {
        // each subsystem used by the command must be passed into the addRequirements() method
        addRequirements(driverSubsystem)
    }

    override fun initialize() {}

    override fun execute() {

        driverSubsystem.drive({ m_right_joy.x }, { m_right_joy.y }, { m_left_joy.x } )
    }

    override fun isFinished(): Boolean {
        // TODO: Make this return true when this Command no longer needs to run execute()
        return false
    }



    override fun end(interrupted: Boolean) {}
}
