package job.model.elk.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScoreDTO {
	
	private String id;
	private String name;
	private double salLevel;
	private double workTime;
	private double workInfo;
	private String distance;
	private String workability;
	private double careers;
	
	public ScoreDTO(String id, String name, double salLevel, double workInfo, String workability) {
		this.id = id;
		this.name = name;
		this.salLevel = salLevel;
		this.workInfo = workInfo;
		this.workability = workability;
	}

}
