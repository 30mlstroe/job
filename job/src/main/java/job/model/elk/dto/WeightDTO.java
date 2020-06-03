package job.model.elk.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeightDTO {
	
	private String id;
	private int salLevel;
	private int workTime;
	private int workInfo;
	private int distance;
	private int workability;
	private int careers;

}
