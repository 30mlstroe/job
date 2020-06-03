package job.model.elk.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorknetDTO {
	private String wantedAuthNo;
	private String comPanySize;
	private String salTpNm;
	private Integer minSal;
	private Integer maxSal;
	private String jobsCd;
	private String relJobsNm;
	private String corpNm;
	private String totPsncnt;
	private String capitalAmt;
	private String yrSalesAmt;
	private String indTpCdNm;
	private String busiCont;
	private String busiSize;
	private String corpAddr;
	private String jobsNm;
	private String wantedTitle;
	private String empTpNm;
	private String collectPsncnt;
	private String enterTpNm;
	private String eduNm;
	private String major;
	private String certificate;
	private String compAbl;
	private String pfCond;
	private String etcPfCond;
	private String workRegion;
	private String retirepay;
	private String maxEdubgIcd;
	private String minEdubgIcd;
	private String regionCd;
	private String empTpCd;
	private String enterTpCd;
	private String staAreaRegionCd;
	private String workdayWorkhrCont;
	
	
	public WorknetDTO(String wantedAuthNo, String salTpNm, Integer minSal, Integer maxSal ){
		this.wantedAuthNo = wantedAuthNo;
		this.salTpNm = salTpNm;
		this.minSal = minSal;
		this.maxSal = maxSal;
	}
	
	public WorknetDTO(String wantedAuthNo, String corpNm, Integer minSal, String empTpCd, String corpAddr){
		this.wantedAuthNo = wantedAuthNo;
		this.corpNm = corpNm;
		this.minSal = minSal;
		this.empTpCd = empTpCd;
		this.corpAddr = corpAddr;
	}
	
}







