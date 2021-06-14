package lombok.test;

import lombok.Getter;
import lombok.Setter;
// 필요한 메소드만 선택해서 만들 수 있음
public class User {
	
	@Getter
	private String name;
	
	@Getter
	private String nick;
	
	@Getter
	@Setter
	private boolean loggedIn;
}
