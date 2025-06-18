import java.io.*;
public class Fhw_223d0859
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in,"Shift-JIS"));

		System.out.println("世帯数を入力してください。");
		String str = br.readLine();
		int setaisuu = Integer.parseInt(str);

		int[] setaicode = new int[setaisuu];
		int[] ampere = new int[setaisuu];
		int[] kWh = new int[setaisuu];
		int[] ryoukin = new int[setaisuu];

		for(int i=0; i<setaisuu; i++){
			System.out.println((i + 1) + "番目の世帯コードを入力してください。");
			String str1 = br.readLine();
			setaicode[i] = Integer.parseInt(str1);

			System.out.println((i + 1) + "番目の電気契約アンペアを入力してください。");
			String str2 = br.readLine();
			ampere[i] = Integer.parseInt(str2);

			System.out.println((i + 1) + "番目の電気使用量を入力してください。");
			String str3 = br.readLine();
			kWh[i] = Integer.parseInt(str3);
		}

		int izyou = 0;
		int miman = 0;

		for(int i=0; i<setaisuu; i++){
			int kihonryoukin = 0;
			int kWhryoukin = 0;

			if(ampere[i] == 20){
				kihonryoukin = 500;
				kWhryoukin = 250;
			}else if(ampere[i] == 30){
				kihonryoukin = 700;
				kWhryoukin = 360;
			}else{
				kihonryoukin = 800;
				kWhryoukin = 430;
			}

		 	ryoukin[i] = kihonryoukin + kWhryoukin * kWh[i];

			System.out.println("世帯コード：" + setaicode[i] + "　電気使用量：" + kWh[i] + "kWh　電気料金：" + ryoukin[i] + "です。");

			if(ryoukin[i] >= 20000){
				izyou++;
			}else{
				miman++;
			}

		}

		System.out.println("電気料金が20,000円以上の世帯数：" + izyou + "　電気料金が20,000円未満の世帯数：" + miman + "世帯です。");

		int max = kWh[0];

		for(int i =1; i<kWh.length-1; i++){
			if(kWh[i] > max){
				max = kWh[i];
			}
		}
		System.out.println("最大電気使用量は" + max + "kWhです。");

		int min = kWh[0];

		for(int i =1; i<kWh.length-1; i++){
			if(kWh[i] < min){
				min = kWh[i];
			}
		}
		System.out.println("最小電気使用量は" + min + "kWhです。");

		int sum = 0;

		for(int i =0; i<kWh.length; i++){
			sum += kWh[i];
		}
		double ave = (double)sum/kWh.length;
		System.out.println("平均電気使用量は" + ave + "kWhです。");

	}
}
