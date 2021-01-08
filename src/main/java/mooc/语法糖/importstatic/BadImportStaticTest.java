package mooc.语法糖.importstatic;
import static java.lang.Double.*;
import static java.lang.Math.*;
import static java.lang.Integer.*;
import static java.text.NumberFormat.*;

import java.text.NumberFormat;

public class BadImportStaticTest {

	public static void main(String[] args) {
		double s = PI * pow(parseDouble(args[0]),2);
		NumberFormat nf = getInstance();
		nf.setMaximumFractionDigits(parseInt(args[1]));
		System.out.println("Բ����ǣ�" + nf.format(s));
		//System.out.println("���ֵ��" + MAX_VALUE); //error
		System.out.println("���ֵ��" + Integer.MAX_VALUE);
	}
}



