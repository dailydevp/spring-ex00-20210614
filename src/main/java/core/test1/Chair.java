package core.test1;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Chair {
	private Leg leg; //leg를 dependency로 가지고 있다고 가정.
}
