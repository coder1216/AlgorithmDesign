package OODesign.StudentManagement;

/* Builder design pattern
* */
public class Student {
    private String id;
    private String name;
    private String email;
    private String phone;

    private Student(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        if (builder.email != null) this.email = builder.email;
        if (builder.phone != null) this.phone = builder.phone;
    }

    public static class Builder {
        private String id;
        private String name;
        private String email;
        private String phone;

        public Builder(String id, String name) {
            this.id = id;
            this.name = name;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}

/* How to use?
* Student student = new Student.Builder(id, name).setEmail().build();
* */