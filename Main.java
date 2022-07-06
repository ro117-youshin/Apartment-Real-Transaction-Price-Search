package apartmentProject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main{

	public static void main(String[] args) {
//		ComebineFile();
		apartmentTransaction run = new apartmentTransaction(0);
		run.Menu();
	}

	public static void ComebineFile() {
		File dir = new File("\\2006-2021년도 수도권 지역에 대한 아파트 실거래가 주소 (총 48개 파일)");
		File[] files = dir.listFiles();
		List<String> list = new ArrayList<String>();
		String combineLine;
		try {
			for (int a = 0; a < files.length; a++) {
				int cnt = 0;
				int cntFile = 0;
				BufferedReader br = new BufferedReader(new FileReader(files[a]));
				while ((combineLine = br.readLine()) != null) {
					if (cntFile == 0 && cnt >= 15) {
						list.add(combineLine + "\n");
					} else if (cntFile >= 1 && cnt >= 16) {
						list.add(combineLine + "\n");
					}
					cnt++;
				}
				cntFile++;
			}
			FileWriter writer = new FileWriter("저장할 디렉토리 주소 + 파일명.csv", true);
			for (int j = 0; j < list.size(); j++) {
				writer.write(list.get(j));
			}
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
