package dto;

public class soccer_MemberDTO {
	private Integer id;
	private String name;
	private soccer_TeamDTO team;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public soccer_TeamDTO getTeam() {
		return team;
	}
	public void setTeam(soccer_TeamDTO team) {
		this.team = team;
	}
}
