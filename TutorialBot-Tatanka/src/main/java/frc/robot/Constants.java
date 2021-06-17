package frc.robot;

public class Constants{
    public class DriveConstants{
        public static final int DEVICE_ID_LEFT_TALON_MASTER = 20;
        public static final int DEIVCE_ID_LEFT_TALON_SLAVE = 11;
        public static final int DEVICE_ID_RIGHT_TALON_MASTER = 21; 
        public static final int DEVICE_ID_RIGHT_TALON_SLAVE = 10;
        public static final double DEADBAND = 0;
    }

    public class ShooterConstants{
        public static final int DEVICE_ID_TALON_SHOOTER_MASTER = 42;
        public static final int DEVICE_ID_TALON_SHOOTER_SLAVE = 43;
        public static final int DEVICE_ID_SPARK_SHOOTER = 41;
        public static final int DEVICE_ID_SPARK_SHOOTER_2 = 40;
    }

    public class IntakeCOnstants{
        public static final int DEVICE_ID_INTAKE_SPARK_LEFT = 30;
        public static final int DEVICE_ID_INTAKE_SPARK_RIGHT = 31;
    } 

    public class MiscConstants{
        public static final int COMPRESSOR_ID = 0; //idk
        public static final int CONTROLLER_ID = 0;
    }
}