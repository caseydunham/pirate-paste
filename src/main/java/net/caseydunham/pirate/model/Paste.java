package net.caseydunham.pirate.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "pastes")
public class Paste  implements IValueObject, Serializable {

	private Long id;
	private String title;
	private String username;
	private String content;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }

	@Column(name = "title")
	public String getTitle() { return title; }
	public void setTitle(String title) { this.title = title; }

	@Column(name = "username")
	public String getUsername() { return username; }
	public void setUsername(String username) { this.username = username; }

	@Column(name = "content")
	public String getContent() { return content; }
	public void setContent(String content) { this.content = content; }

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[Title: ").append(getTitle()).append(", Content: ").append(getContent()).append("]");
		return sb.toString();
	}

}
