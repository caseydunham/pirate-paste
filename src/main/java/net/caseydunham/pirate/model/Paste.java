package net.caseydunham.pirate.model;

public class Paste {

	private String title;
	private String username;
	private String content;

	public String getTitle() { return title; }
	public void setTitle(String title) { this.title = title; }

	public String getUsername() { return username; }
	public void setUsername(String username) { this.username = username; }

	public String getContent() { return content; }
	public void setContent(String content) { this.content = content; }

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[Title: ").append(getTitle()).append(", Content: ").append(getContent()).append("]");
		return sb.toString();
	}

}
