package util;

public class Session {
    public enum Role { USER, ADMIN }
    private static String username;
    private static Role role;

    public static void setUser(String u, Role r) {
        username = u;
        role = r;
    }

    public static String getUsername() { return username; }
    public static Role getRole() { return role; }
}
