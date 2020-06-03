package job.model.elk.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JKDataDTO {
	
	private String title;
	private String startDate;
	private String endDate;
	private String name;

}
