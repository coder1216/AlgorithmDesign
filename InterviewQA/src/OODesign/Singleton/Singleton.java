package OODesign.Singleton;

public class Singleton {
    private static Singleton instance;

    // laze initialization
    private Singleton() {
        instance = new Singleton();
    }

    public static Singleton getInstance() {
//        if (instance == null) {
//            instance = new Singleton();
//        }
//        return instance;

//        synchronized (instance) {
//            if (instance == null) {
//                instance = new Singleton();
//            }
//            return instance;
//        }

        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
