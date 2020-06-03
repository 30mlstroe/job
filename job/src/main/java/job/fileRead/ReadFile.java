package job.fileRead;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import org.springframework.stereotype.Component;

@Component
public class ReadFile {
	
    public ArrayList<String> firstWorkTime() {
        BufferedReader br = null;
        String line = "";
        ArrayList<String> companys = new ArrayList<>();
        
        try {
            br = new BufferedReader(new FileReader("data/first_work_time.csv"));
            Charset.forName("UTF-8");
            while ((line = br.readLine()) != null) {
                String[] country = line.split(",");
               companys.add(country[1]);
            }

        } catch (IOException e ) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
		return companys;
	}
    
    public ArrayList<String> secondWorkTime() {
        BufferedReader br = null;
        String line = "";
        ArrayList<String> companys = new ArrayList<>();
        
        try {
            br = new BufferedReader(new FileReader("data/second_work_time.csv"));
            Charset.forName("UTF-8");
            while ((line = br.readLine()) != null) {
                String[] country = line.split(",");
               companys.add(country[1]);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
		return companys;
	}
    
    public ArrayList<String> firstWorkInfo() {
        BufferedReader br = null;
        String line = "";
        ArrayList<String> companys = new ArrayList<>();
        
        try {
            br = new BufferedReader(new FileReader("data/first_work_info.csv"));
            Charset.forName("UTF-8");
            while ((line = br.readLine()) != null) {
                String[] country = line.split(",");
               companys.add(country[2]);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
		return companys;
	}
    
    public ArrayList<String> secondWorkInfo() {
        BufferedReader br = null;
        String line = "";
        ArrayList<String> companys = new ArrayList<>();
        
        try {
            br = new BufferedReader(new FileReader("data/second_work_info.csv"));
            Charset.forName("UTF-8");
            while ((line = br.readLine()) != null) {
                String[] country = line.split(",");
               companys.add(country[1]);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
		return companys;
	}

    public ArrayList<String> getForeignCompanies() throws IOException {
		// 파일 객체 생성
		File file = new File("data/foreign_companies.txt");
		// 입력 스트림 생성
		@SuppressWarnings("resource")
		BufferedReader fileReader = new BufferedReader(new FileReader(file));
		ArrayList<String> ForeignCompanyNames = new ArrayList<String>();
		String line = null;
		while ((line = fileReader.readLine()) != null) {
			ForeignCompanyNames.add(line);
		}
		return ForeignCompanyNames;

	}
}
