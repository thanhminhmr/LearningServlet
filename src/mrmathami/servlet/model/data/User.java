package mrmathami.servlet.model.data;

public  final class User {
    private final Integer userId;
    private final String username;
    private final String password; // REALLY, DO NEVER DO THIS IN REAL LIFE!

	public User(Integer userId, String username, String password) {
		this.userId = userId;
		this.username = username;
		this.password = password;
	}

	public Integer getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

	public boolean has(boolean userId, boolean username, boolean password) {
    	return (!userId || this.userId != null) && (!username || this.username != null) && (!password || this.password != null);
    }
}
