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
		File dir = new File("\\2006-2021�⵵ ������ ������ ���� ����Ʈ �ǰŷ��� �ּ� (�� 48�� ����)");
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
			FileWriter writer = new FileWriter("������ ���丮 �ּ� + ���ϸ�.csv", true);
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
