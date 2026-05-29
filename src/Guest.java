public class Guest {
    private String name;
    private int age;
    private String phone;

    public Guest(String name, int age, String phone) {
        setName(name);
        setAge(age);
        setPhone(phone);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.trim().equals("")) {
            this.name = name.trim();
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        }
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        if (phone != null && !phone.trim().equals("")) {
            this.phone = phone.trim();
        }
    }

    public void displayInfo() {
        System.out.println("Guest Name : " + name);
        System.out.println("Age        : " + age);
        System.out.println("Phone      : " + phone);
    }
}