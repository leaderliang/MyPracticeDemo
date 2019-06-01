package com.java.practice.chain;

/**
 * TODO Builder模式，链式调用Demo
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @version 1.0
 * @since 2019/04/11 22:55
 */

public class User {

    private final String firstName;
    private final String lastName;
    private final int age;
    private final String phone;
    private final String address;

    private User(UserBuilder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.phone = builder.phone;
        this.address = builder.address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    //Builder
    public static class UserBuilder {
        private final String firstName;
        private final String lastName;
        private int age;
        private String phone;
        private String address;

        public UserBuilder(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public UserBuilder age(int age) {
            this.age = age;
            return this;
        }

        public UserBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public UserBuilder address(String address) {
            this.address = address;
            return this;
        }

        public User build() {
            // 由于Builder是非线程安全的，所以如果要在Builder内部类中检查一个参数的合法性，
            // 必需要在对象创建完成之后再检查
            User user = new User(this);
            if (user.getAge() < 0 || user.getAge() > 255) {
                // 线程安全
                throw new IllegalStateException("Age out of range:" + user.getAge());
            }
            return user;
        }
    }

    public static void main(String[] args) {
        User june = new UserBuilder("dan", "liang").age(18).address("tty").build();
        System.out.println(june.getAddress());
    }
}


