/**
 * interface -- 只有method 没有 fields
 * abstrat class -- 可以有没有实现的method
 * class -- method都要实现
 * 
 * 所以 用abstract method
 */

// Q2 How to design a Parking Lot? vs Amazon Locker
// step0: clarify your assumption
// step1: find nouns and verbs
// step2: classes
// step3: relationship
// step4: for Class, fields & methods
// step5: public private → outside

// fields → access modifier, final, static
// methods → constructor, getter setter, specific (lombok)
// relationship → override vs overloading + abstract class vs interface

// step0: 
// fee? No
// type? Bus, Car, Moto
// level? Many levels
// handicap? No

// step1:
// ParkingLot, Level, ParkingSpot
// Bus, Car, Moto

// step2 & step3
// ParkingLot, Level, ParkingSpot 包含
// Bus, Car, Moto → Vehicle 继承

// option1: interface
// option2: abtract class
// option3: class

enum Type {
	BUS,
	CAR,
	MOTO,
}

abstract class Vehicle {
	private Type type; // protected, final

	Constructor needed
	// getter
	// setter
	public Type getType() {
		return type;
	}
}

class Bus extends Vehicle {
	// fields

	// methods
	public Bus() {
		this.type = Type.BUS;
	}
}
class Car extends Vehicle {
	// fields

	// methods
	public Car() {
		this.type = Type.CAR;
	}
}
class Moto extends Vehicle {
	// fields

	// methods
	public Moto() {
		this.type = Type.MOTOR;
	}
}

public class ParkingSpot {
// fields
	private Vehicle cur;
	private final Type type;

// methods
	public ParkingSpot(Type type) {
		this.type = type;
		cur = null;
	}
public boolean canPark(Vehicle v) {
// corner case
		return cur == null && this.type == v.getType();

}
public synchronized boolean goPark(final Vehicle v) {
		if (canPark(v)) {
cur = v;
return true;
}
return false;
	}
public Vehicle leavePark() {
		// coner case
		Vehicle temp = cur;
		cur = null;
		return temp;
	}
}

public class Level { //不要过度design
	// fields
	private final int floor;
	private final ParkingSpot[] spots;

// methods
	public Level (int floor, int BusCap, int CarCap, int MotoCap) {
		this.floor = floor;
		spots = new PatkingSpot[BusCap + CarCap + MotoCap];
		for(int i = 0; i < spots.length; i++) {
if (i < BusCap) {
	spots[i] = new ParkingSpot(Type.BUS);
}
else if (i >= BusCap && i < BusCap + CarCap) {
	spots[i] = new ParkingSpot(Type.CAR);
}
else {
	spots[i] = new ParkingSpot(Type.MOTOR);
}
		}
	}

	public boolean canPark(Vehicle v) {
		for (ParkingSpot spot : spots) {
			if (spot.canPark(v)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean goPark(Vehicle v) [
		if (!canPark(v)) {
			return false;
		}
		for (ParkingSpot spot: spots) {
			if (spot.canPark(v)) {
				spot.goPark(v);
				return true;
			}
		}
		return false; // concurrency or compiler
	}
	public int numOfAvilableSpot(Vehicle v) {
		int count = 0;
		for (ParkingSpot spot : spots) {
			if (spot.canPark(v)) {
				count++;
}
}
return count;
}
}

class ParkingLot {
	// fields
	private final Level[] levels;

	public ParkingLot(int num) {
		levels = new Level[num]
		for (int i = 0; i < num; i++) {
			levels[i] = new Level(i, …, …, … ); // design[][]
}
	}
	public boolean canPark(Vehicle v) {
		for (Level lev : levels) {
			if (lev.canPark(v)) {
				return true;
}
}
return false;
	}
	public boolean goPark(Vehicle v) {
		if (!canPark(v)) return false;
		for (Level lev : levels) {
			if (lev.canPark(v)) {
				lev.goPark(v);
				return true;
}
}
return false; 
}
}

// Extension: what if you can park car in bus spot,
// 	what if you can park multiple cars in bus spot;
// https://github.com/careercup/ctci/tree/master/java 

/**
 * 
 ******************* configure driving ******************* BQ
 */