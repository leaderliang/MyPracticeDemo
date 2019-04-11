package com.java.test.chain;

/**
 * TODO
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @version 1.0
 * @since 2019/04/11 23:17
 */
public class People {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static Builder builder() {
        return new Builder();
    }

    private People(Builder builder) {
        this.username = builder.username;
        this.password = builder.password;
    }

    public static class Builder {
        private String username;
        private String password;

        public Builder setUserName(String username) {
            this.username = username;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public People build() {
            return new People(this);
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "username='" + username + '\'' +
                    ", password='" + password + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }


    public static void main(String[] args) {
        Builder builder = new People.Builder();
        builder.setUserName("lss0555")
                .setPassword("12345")
                .build();
        //或者
        People user = new People.Builder().setUserName("lss0555").setPassword("123123").build();
        //或者
        People user1 = People.builder().setUserName("lss0555").setPassword("654321").build();

        System.out.println("builder 结果:" + builder.toString());
        System.out.println("User 结果:" + user.toString());
        System.out.println("User1 结果:" + user1.toString());
    }
}

