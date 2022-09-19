package connectus.board;

public class BoardDTO {
	
	private long id; 
	private String userId; 
	private String title; 
	private String contents; 
	private String boardRegion; 
	private String createdAt;
	private String img; 
	private String timeDiff;
	
	
	@Override
	public String toString() {
		return "BoardDTO [id=" + id + ", userId=" + userId + ", title=" + title + ", contents=" + contents
				+ ", boardRegion=" + boardRegion + ", createdAt=" + createdAt + "]";
	}
	
	public BoardDTO() {}
	public BoardDTO(long id, String userId, String title, String contents, String boardRegion, String createdAt, String img, String timeDiff) {
		super();
		this.id = id;
		this.userId = userId;
		this.title = title;
		this.contents = contents;
		this.boardRegion = boardRegion;
		this.createdAt = createdAt;
		this.img = img;
		this.timeDiff = timeDiff;
	}
	
	
	
	
	
	public String getTimeDiff() {
		return timeDiff;
	}

	public void setTimeDiff(String timeDiff) {
		this.timeDiff = timeDiff;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getBoardRegion() {
		return boardRegion;
	}
	public void setBoardRegion(String boardRegion) {
		this.boardRegion = boardRegion;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	
	
	
	
	
	

}
