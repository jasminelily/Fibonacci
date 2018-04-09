package number.com.helper;
/**
 * 有効チェッククラス
 * @author lily tan
 *
 */
public class ValidationHelper {

	//有効フラグ
	public static Boolean IsValid = true;
	//メッセージ（有効の時空白）
	public static String Message = "";

	public ValidationHelper(){}
	
	private static void setValidStatus(){		
		IsValid = true;
		Message = "";
	}
	
	/**
	 * 数列の配列順チェック
	 * @param index　配列順
	 * @param maxLength　数列長さ
	 */
	public static void checkArrayLength(int index, int maxLength) {
		
		//index　値チェック
		if (index <= 0) {
			IsValid = false;
			Message = "番目は不正です。";
			return;
		}
		//index 最大長さチェック
		if (index > maxLength) {

			IsValid = false;
			Message = "番目は" + maxLength + "まで入力しください。";
			return;
		}
		
		//有効設定
		setValidStatus();
	}
	
	/**
	 * 数字チェック
	 * @param input　文字列
	 */
	public static void checkIsNumber(String input){
		if(!CheckHelper.checkIsNumber(input)){
			IsValid = false;
			Message = "数字を入力してください。";
			return;
		}
		//有効設定
		setValidStatus();
	}

}
