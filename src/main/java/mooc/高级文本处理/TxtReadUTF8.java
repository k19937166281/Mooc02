package mooc.高级文本处理;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class TxtReadUTF8 {
	public static void main(String[] args) {
		readFile1();
		System.out.println("===================");
		//readFile2(); //JDK 7�����ϲſ���ʹ��
	}

	public static void readFile1() {
		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		String charset = "UTF-8";

		try {
			fis = new FileInputStream("c:/temp/abc.txt"); // �ڵ���
			isr = new InputStreamReader(fis, charset); // ת����
			//isr = new InputStreamReader(fis); //���ò���ϵͳĬ�ϱ���
			br = new BufferedReader(isr); // װ����
			// br = new BufferedReader(new InputStreamReader(new
			// FileInputStream("c:/temp/abc.txt")))
			String line;
			while ((line = br.readLine()) != null) // ÿ�ζ�ȡһ��
			{
				System.out.println(line);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				br.close(); // �ر����һ���࣬�Ὣ���еĵײ������ر�
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	public static void readFile2() {
		String line;
		//try-resource ��䣬�Զ��ر���Դ
		try (BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("c:/temp/abc.txt")))) {
			while ((line = in.readLine()) != null) {
				System.out.println(line);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
