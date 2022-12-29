package com.sdjr2.rest_sp5_ztoe.models;

/**
 * Represents the domain over a user who uses the Java Faker External API.
 *
 * @author jroldan
 * @version 1.0
 * @category Model
 * @since 22/12/26
 */
public class UserFaker {

	private String nickName;
	private String username;
	private String password;

	public UserFaker() {
	}

	public UserFaker(final String nickName, final String username, final String password) {
		super();
		this.nickName = nickName;
		this.username = username;
		this.password = password;
	}

	public String getNickName() {
		return this.nickName;
	}

	public void setNickName(final String nickName) {
		this.nickName = nickName;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(final String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

}
