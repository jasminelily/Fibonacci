package number.com.helper;

import number.com.common.PrintTemplate;
/**
 * 印刷共通クラス
 * @author lily tan
 *
 */
public class PrintHelper extends PrintTemplate{
	
	public PrintHelper(){}
	
	/**
	 * 印刷
	 * @param msg　印刷メッセージ
	 * @param values　format値
	 */
	public static void print(String msg,Object... values){
		String content = String.format(msg, values);
		print(content);
	}
}
