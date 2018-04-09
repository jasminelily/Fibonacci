package number.com.constant;
/**
 * 定数クラス
 * @author lily tan
 *
 */
public class Constant {
	
	//数列タイプ
	public enum ArrayType{
		Fibonacci,
		Prime
	}
	//数列デーフォルタタイプ
	public static Constant.ArrayType DEFAULT_TYPE = Constant.ArrayType.Fibonacci;
	
	//停止フラグー入力文字列
	public static String STOP_FLG_QUIT ="quit";
	public static String STOP_FLG_EXIT ="exit";
	
	//数列タイプー入力文字列
	public static String TYPE_FLG_FIBON_SHORT = "f";
	public static String TYPE_FLG_FIBON_LONG = "fibonacci";
	public static String TYPE_FLG_PRIME_SHORT = "p";
	public static String TYPE_FLG_PRIME_LONG = "prime";
	
	//数列デーフォルタ長さ
	public static int DEFAULT_LENGTH_FIBON = 70;
	public static int DEFAULT_LENGTH_PRIME = 10000;
	
	
}
