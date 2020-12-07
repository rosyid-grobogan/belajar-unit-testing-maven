package com.belajar.entities;

public class User {
    public enum UserType {REGULAR_USER, ADMIN_USER}
    private String username;
    private String password;
    private boolean live = true;
    private final UserType userType;

    // AllArgs

    public User(String username, String password, UserType userType) {
        this.username = username;
        this.password = password;
        this.userType = userType;
    }

    public static User createReqularUser(String username, String password){
        return new User(username, password, UserType.REGULAR_USER);
    }
    public static User createAdminUser(String username, String password){
        return new User(username, password, UserType.ADMIN_USER);
    }

    // Getter

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isLive() {
        return live;
    }

    public UserType getUserType() {
        return userType;
    }

    // hashCode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (live != user.live) return false;
        if (!username.equals(user.username)) return false;
        if (!password.equals(user.password)) return false;
        return userType == user.userType;
    }

    @Override
    public int hashCode() {
        int result = username.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + (live ? 1 : 0);
        result = 31 * result + userType.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", live=" + live +
                ", userType=" + userType +
                '}';
    }
}
