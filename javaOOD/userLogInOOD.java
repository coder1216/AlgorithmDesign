// OOD: Design Pattern
// Singleton: guarantee a class only have one instance，provide global access to the instance
// Multiple threading


// thread1 / class
// Singleton s1 = Singleton.getInstance();
// thread2 / class
// Singleton s2 = Singleton.getInstance();

//Bad 	time
public class Singleton {
	// fields
private static Singleton INSTANCE;

	// methods
	private Singleton() {
		// do sthing;
	}

	public static synchronized Singleton getInstance() {
		if (!INSTANCE) {
			INSTANCE = new Singleton();
		}
		return INSTANCE;
	}
}
}

//Bad	space
public class Singleton {
	// fields
private static final Singleton INSTANCE = new Singleton();

	// static {}

	// methods
	private Singleton() {
		// do sthing;
	}

	public static Singleton getInstance() {
		return INSTANCE;
	}
}

// Builder Pattern: 一个object / Class 里可能有很多个不同的optional fields
// class User with fields

public class User {
	// fields
	private final int id; // @GenerateId
	private final String username; // required
	private String password; // required
	private final String firstname;
	private final String lastname;
	private String phone;
	private Address address;
	private String email;
	private Date joinTime;

	// methods
	public  User(String un, String pw) {

	}
}

// User user1 = new User()

// S1: set all fields to null bad
// S2: use getter/setter good
// S3: Builder

// after:
public  class User { // ORM Object Relationship Mapping
	private String username; // required
	private String password;  // required
	private final String firstname;
	private final String lastname;
	private String phone;
	private String address;
	private String email;

private User(UserBuilder builder ) { // JSONObject object
		this.username = builder.username;
		this.password = builder.password;
		….
		this.email = builder.email;
	}

public static class UserBuilder {
		private String username; // required
		private String password;  // required
		private final String firstname;
		private final String lastname;
		private String phone;
		private String address;
		private String email;

	public UserBuilder(String username, String password) {
		this.username = builder.username;
		this.password = builder.password;
	}

	// all the methods below are for managing fileds set or get
	public UserBuilder phone(String phone) {
		this.phone = phone;
		return this;
	}

	public UserBuilder address(String address) [
		this.address = address;
		return this;
	}

	public User build() {
		return new User(this);
	}

		// User user = new User.UserBuilder("weijun", "li").phone("2132681234").build();

		User.Userbuilder builder = new User.UserBuilder("weijun", "li");
		builder.phone("2132681234").age(12).address('gaga');
		User user = builder.build();
	}
}
