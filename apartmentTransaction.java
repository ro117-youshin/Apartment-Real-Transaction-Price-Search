package apartmentProject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class apartmentTransaction {
	static List<String> importCsvfile = new ArrayList<String>();
	static List<String> chageAt = new ArrayList<String>();
	static List<String> deleteCommaAndSplit = new ArrayList<String>();
	static List<String> extractArrAndSplit = new ArrayList<String>();

	int i;

	public apartmentTransaction(int i) {
		this.i = i;
	}

	public void AddressSearch() {

		try {
			BufferedReader br = new BufferedReader(new FileReader("��� ��ģ csv���� ���"));
			File file = new File("������ ���丮 �ּ� + ���ϸ�.csv");
			BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
			
			Scanner sc = new Scanner(System.in);
			System.out.println(" > ã���� ������ ������ ��/���� �Է��ϼ���. (����Ư����, ��õ������, ��⵵)");
			String siOrdo = sc.nextLine();
			System.out.println(" > ã���� ������ ������ ��/��/���� �Է��ϼ���.");
			String siGunGu = sc.nextLine();

			String line;
			while ((line = br.readLine()) != null) {
				importCsvfile.add(line);
			}
			for (int a = 0; a < importCsvfile.size(); a++) {
				String comma = importCsvfile.get(a).replaceAll("\",\"", "@");
				chageAt.add(comma);
			}
			for (int b = 0; b < chageAt.size(); b++) {
				String collon = chageAt.get(b).replaceAll("\"", "");
				deleteCommaAndSplit.add(collon);
			}
			for (int c = 0; c < deleteCommaAndSplit.size(); c++) {
				String[] array = deleteCommaAndSplit.get(c).replaceAll(",", "").split("@");
				extractArrAndSplit.add(array[0] + "," + array[1] + "," + array[2] + "," + array[3] + "," + array[4] + "," + array[5]
						+ "," + array[6] + "," + array[7] + "," + array[8] + "," + array[9] + "," + array[10] + ","
						+ array[11]);
			}
			bw.write(extractArrAndSplit.get(0)); // write intro
			for (int d = 0; d < extractArrAndSplit.size(); d++) {
				String[] listSplit = extractArrAndSplit.get(d).split(",");
				if (listSplit[0].contains(siOrdo) && listSplit[0].contains(siGunGu)) {
					bw.newLine();
					for (int e = 0; e < listSplit.length; e++) {
						bw.write(listSplit[e] + ",");
					}
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(" > ������ �����Ǿ����ϴ�.");
	}

	public void AddressAndDateSearch() {

		try {
			BufferedReader br = new BufferedReader(new FileReader("��� ��ģ csv���� ���"));
			File file = new File("������ ���丮 �ּ� + ���ϸ�.csv");
			BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));

			Scanner sc = new Scanner(System.in);
			System.out.println(" > ã���� ������ ������ ��/���� �Է��ϼ���. (����Ư����, ��õ������, ��⵵)");
			String siOrdo = sc.nextLine();
			System.out.println(" > ã���� ������ ������ ��/��/���� �Է��ϼ���.");
			String siGunGu = sc.nextLine();
			System.out.println("������ڸ� �Է����ּ���. ");
			String date = sc.nextLine();

//			�ϳ��� ������ csv������ line���� �޾� ����Ʈ�� �ֱ� 
			String line;
			while ((line = br.readLine()) != null) {
				importCsvfile.add(line);
			}
//			(",")�� @�� �ٲٱ�
			for (int a = 0; a < importCsvfile.size(); a++) {
				String comma = importCsvfile.get(a).replaceAll("\",\"", "@");
				chageAt.add(comma);
			}
//			����ǥ(") ���� 
			for (int b = 0; b < chageAt.size(); b++) {
				String collon = chageAt.get(b).replaceAll("\"", "");
				deleteCommaAndSplit.add(collon);
			}
//			�ݾ׿� �ִ� �޸�(,)�� �����ϰ� @�� �������� �ɰ���, �迭�� �ɰ��� ���ϴ� �κ��� �÷��� ����.
			for (int c = 0; c < deleteCommaAndSplit.size(); c++) {
				String[] array = deleteCommaAndSplit.get(c).replaceAll(",", "").split("@");
				extractArrAndSplit.add(array[0] + "," + array[1] + "," + array[2] + "," + array[3] + "," + array[4] + "," + array[5]
						+ "," + array[6] + "," + array[7] + "," + array[8] + "," + array[9] + "," + array[10] + ","
						+ array[11]);
			}
//			��/��, ��/��/��, ������� �Է°��� ���� list
			for (int d = 0; d < extractArrAndSplit.size(); d++) {
				String[] listSplit = extractArrAndSplit.get(d).split(",");
				if (listSplit[0].contains(siOrdo) && listSplit[0].contains(siGunGu) && listSplit[6].contains(date)) {
					bw.newLine();
					for (int e = 0; e < listSplit.length; e++) {
						bw.write(listSplit[e] + ",");
					}
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(" > ������ �����Ǿ����ϴ�.");
	}

	public void Menu() {
		System.out.println("				<2006-2021�⵵ ������ ���� �ε��� ����Ʈ �ǰŷ��� �˻�>\n");
		System.out.println("------------------------------------------------------------------------------------------------------------------------");
		System.out.println(" |����Ư����|\n  > ������ > ������ > ���ϱ� > ������ > ���Ǳ� > ������ > ���α� > ��õ�� > ����� > ������ > ���۱� > ���빮��\n "
				+ " > ������ > ���빮�� > ���ʱ� > ������ > ���ϱ� > ���ı� > ��õ�� > �������� > ��걸 > ���� > ���α� > �߱� > �߶��� ");
		System.out.println("------------------------------------------------------------------------------------------------------------------------");
		System.out.println(" |��õ������|\n  > ��ȭ�� > ��籸 > ������ > ���� > ����Ȧ�� > ���� > ���� > ������ > ������ > �߱�");
		System.out.println("------------------------------------------------------------------------------------------------------------------------");
		System.out.println(" |��⵵|\n "
				+ " > ���� > �����籸 > ����ϻ굿�� > ����ϻ꼭�� > ��õ�� > ����� > ���ֽ� > ������ > ������ > ������ > �����ֽ�\n " 
				+ " > ����õ�� > ��õ�� > �����д籸 > ���������� > �����߿��� > �����Ǽ��� > �������뱸 > ������ȱ� > �����ȴޱ� > �����\n "
				+ " > �Ȼ�ܿ��� > �Ȼ��� > �ȼ��� > �Ⱦ絿�ȱ� > �Ⱦ縸�ȱ� > ���ֽ� > ���� > ���ֽ� > ��õ�� > ����� > ���α��ﱸ\n "
				+ " > ���μ����� > ����ó�α� > �ǿս� > �����ν� > ��õ�� > ���ֽ� > ���ý� > ��õ�� > �ϳ��� > ȭ����");
		System.out.println("------------------------------------------------------------------------------------------------------------------------\n");
		System.out.println("1. ������ ���� \"��, ��\" ���� ����Ʈ �ŸŰ� �˻�");
		System.out.println("2. �ñ��� ������� �˻� (�������) ex) 2010�� 1�� -> 201001");
		Scanner sc = new Scanner(System.in);
		this.i = sc.nextInt();
		if (this.i == 1) {
			AddressSearch();
		} else if (this.i == 2) {
			AddressAndDateSearch();
		}

	}

}
