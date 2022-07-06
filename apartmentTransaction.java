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
			BufferedReader br = new BufferedReader(new FileReader("모두 합친 csv파일 경로"));
			File file = new File("저장할 디렉토리 주소 + 파일명.csv");
			BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
			
			Scanner sc = new Scanner(System.in);
			System.out.println(" > 찾으실 수도권 지역의 시/도를 입력하세요. (서울특별시, 인천광역시, 경기도)");
			String siOrdo = sc.nextLine();
			System.out.println(" > 찾으실 수도권 지역의 시/군/구를 입력하세요.");
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
		System.out.println(" > 파일이 생성되었습니다.");
	}

	public void AddressAndDateSearch() {

		try {
			BufferedReader br = new BufferedReader(new FileReader("모두 합친 csv파일 경로"));
			File file = new File("저장할 디렉토리 주소 + 파일명.csv");
			BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));

			Scanner sc = new Scanner(System.in);
			System.out.println(" > 찾으실 수도권 지역의 시/도를 입력하세요. (서울특별시, 인천광역시, 경기도)");
			String siOrdo = sc.nextLine();
			System.out.println(" > 찾으실 수도권 지역의 시/군/구를 입력하세요.");
			String siGunGu = sc.nextLine();
			System.out.println("계약일자를 입력해주세요. ");
			String date = sc.nextLine();

//			하나로 결합한 csv파일을 line으로 받아 리스트에 넣기 
			String line;
			while ((line = br.readLine()) != null) {
				importCsvfile.add(line);
			}
//			(",")를 @로 바꾸기
			for (int a = 0; a < importCsvfile.size(); a++) {
				String comma = importCsvfile.get(a).replaceAll("\",\"", "@");
				chageAt.add(comma);
			}
//			따옴표(") 제거 
			for (int b = 0; b < chageAt.size(); b++) {
				String collon = chageAt.get(b).replaceAll("\"", "");
				deleteCommaAndSplit.add(collon);
			}
//			금액에 있는 콤마(,)를 삭제하고 @를 기준으로 쪼개기, 배열로 쪼개서 원하는 부분의 컬럼만 추출.
			for (int c = 0; c < deleteCommaAndSplit.size(); c++) {
				String[] array = deleteCommaAndSplit.get(c).replaceAll(",", "").split("@");
				extractArrAndSplit.add(array[0] + "," + array[1] + "," + array[2] + "," + array[3] + "," + array[4] + "," + array[5]
						+ "," + array[6] + "," + array[7] + "," + array[8] + "," + array[9] + "," + array[10] + ","
						+ array[11]);
			}
//			시/도, 시/군/구, 계약일자 입력값에 대한 list
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
		System.out.println(" > 파일이 생성되었습니다.");
	}

	public void Menu() {
		System.out.println("				<2006-2021년도 수도권 지역 부동산 아파트 실거래가 검색>\n");
		System.out.println("------------------------------------------------------------------------------------------------------------------------");
		System.out.println(" |서울특별시|\n  > 강남구 > 강동구 > 강북구 > 강서구 > 관악구 > 광진구 > 구로구 > 금천구 > 노원구 > 도봉구 > 동작구 > 동대문구\n "
				+ " > 마포구 > 서대문구 > 서초구 > 성동구 > 성북구 > 송파구 > 양천구 > 영등포구 > 용산구 > 은평구 > 종로구 > 중구 > 중랑구 ");
		System.out.println("------------------------------------------------------------------------------------------------------------------------");
		System.out.println(" |인천광역시|\n  > 강화군 > 계양구 > 남동구 > 동구 > 미추홀구 > 부평구 > 서구 > 연수구 > 옹진군 > 중구");
		System.out.println("------------------------------------------------------------------------------------------------------------------------");
		System.out.println(" |경기도|\n "
				+ " > 가평군 > 고양덕양구 > 고양일산동구 > 고양일산서구 > 과천시 > 광명시 > 광주시 > 구리시 > 군포시 > 김포시 > 남양주시\n " 
				+ " > 동두천시 > 부천시 > 성남분당구 > 성남수정구 > 성남중원구 > 수원권선구 > 수원영통구 > 수원장안구 > 수원팔달구 > 시흥시\n "
				+ " > 안산단원구 > 안산상록 > 안성시 > 안양동안구 > 안양만안구 > 양주시 > 양평군 > 여주시 > 연천군 > 오산시 > 용인기흥구\n "
				+ " > 용인수지구 > 용인처인구 > 의왕시 > 의정부시 > 이천시 > 파주시 > 평택시 > 포천시 > 하남시 > 화성시");
		System.out.println("------------------------------------------------------------------------------------------------------------------------\n");
		System.out.println("1. 수도권 지역 \"시, 도\" 단위 아파트 매매가 검색");
		System.out.println("2. 시군구 계약일자 검색 (년월단위) ex) 2010년 1월 -> 201001");
		Scanner sc = new Scanner(System.in);
		this.i = sc.nextInt();
		if (this.i == 1) {
			AddressSearch();
		} else if (this.i == 2) {
			AddressAndDateSearch();
		}

	}

}
