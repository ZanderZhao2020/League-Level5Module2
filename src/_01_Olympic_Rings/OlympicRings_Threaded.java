package _01_Olympic_Rings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.jointheleague.graphical.robot.Robot;

public class OlympicRings_Threaded {
	// Make A Program that uses Threads and robots to draw the Olympic rings. One robot should draw one ring simultaneously with the other 4 robots.
	static void DrawCircle(int Scale, Robot Rob) {
		Byte Degrees[] = new Byte[360];
		for (short Degree = 0; Degree < 360; Degree++) {
			if (Degree > 130) {
				Degrees[Degree] = 1;
			} else {
				Degrees[Degree] = 2;
			}
		}
		ArrayList<Byte> DegreesList = new ArrayList<Byte>(Arrays.asList(Degrees));
		Collections.shuffle(DegreesList);
		Rob.penDown();
		DegreesList.forEach((Dist) -> {
			Rob.turn(1);
			Rob.move((int) Dist);
		});
		Rob.hide();
	}
	public static void main(String[] args) {
		Robot[] Robots = new Robot[5];
		int Scale = 200;
		for (byte RobotLoop = 0; RobotLoop < Robots.length; RobotLoop++) {
			Robots[RobotLoop] = new Robot();
			Robots[RobotLoop].moveTo(RobotLoop * Scale / 2 + Scale / 2, RobotLoop % 2 * Scale / 2 + Scale / 2);
		}
		Thread T1 = new Thread(() -> DrawCircle(Scale, Robots[0]));
		Thread T2 = new Thread(() -> DrawCircle(Scale, Robots[1]));
		Thread T3 = new Thread(() -> DrawCircle(Scale, Robots[2]));
		Thread T4 = new Thread(() -> DrawCircle(Scale, Robots[3]));
		Thread T5 = new Thread(() -> DrawCircle(Scale, Robots[4]));
		T1.start();
		T2.start();
		T3.start();
		T4.start();
		T5.start();
	}
}

