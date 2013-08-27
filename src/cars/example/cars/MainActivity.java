package cars.example.cars;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Car carOne = new Car();
		Car carTwo = new Car();
		
		carOne.shiftGears(3);
		carOne.accelerateSpeed(15);
		carOne.turnWheel("E");
		
		carTwo.shiftGears(2);
		carTwo.applyBrake(10);
		carTwo.turnWheel("W");
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	class Car implements ICar{
		int speed = 15;
		int gear = 1;
		int drivetrain = 4;
		String direction = "N";
		String color = "Red";
		String fuel = "Gas";	
		
		public void shiftGears (int newGear){
			gear = newGear;
		}
		
		public void accelerateSpeed (int acceleration){
			speed = speed + acceleration;
		}
		
		public void applyBrake (int brakingFactor){
			speed = speed - brakingFactor;
		}
		
		public void turnWheel (String newDirection){
			direction = newDirection;
		}
	}
	
	class SUV extends Car{
		public void applyBrake(int brakingFactor){
			super.applyBrake(brakingFactor);
			speed = speed - brakingFactor;
			}
	}
	
	public interface ICar{
		void shiftGears (int newGear);
		void accelerateSpeed (int acceleration);
		void applyBrake (int brakingFactor);
		void turnWheel (String newDirection);
	}
	
}
