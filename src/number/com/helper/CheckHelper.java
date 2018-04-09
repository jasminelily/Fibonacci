package number.com.helper;

import number.com.constant.Constant;

/**
 * チェック共通クラス
 * @author lily tan
 *
 */
public class CheckHelper {
	
	/**
	 * 停止チェック
	 * @param flg 文字列
	 * @return　true:停止 false:不停止
	 */
	public static Boolean checkIsStop(String flg) {

		if (Constant.STOP_FLG_QUIT.equals(flg) || Constant.STOP_FLG_EXIT.equals(flg)) {
			return true;
		}
		return false;
	}
	
	/**
	 * 数列タイプチェック
	 * @param flg　文字列
	 * @return　true:数列タイプフラグ false:数列タイプフラグじゃない
	 */
	public static Boolean checkIsArrayType(String flg){
		if (Constant.TYPE_FLG_FIBON_LONG.equals(flg) 
				|| Constant.TYPE_FLG_FIBON_SHORT.equals(flg)
				|| Constant.TYPE_FLG_PRIME_LONG.equals(flg)
				|| Constant.TYPE_FLG_PRIME_SHORT.equals(flg)) {
			return true;
		}
		return false;
	}
	
	/**
	 * 数字チェック
	 * @param input　文字列
	 * @return　true:数字 false:数字じゃない
	 */
	public static Boolean checkIsNumber(String input){
		try {
			Integer.parseInt(input);
		} catch (Exception e) {
			return false;			
		}
		return true;
	}
	
	/**
	 * 数列長さ有効チェック
	 * @param length　長さ
	 * @return　true:有効 false:無効
	 */
	public static Boolean checkIsValidArrayLength(int length){
		if (length <= 0) {
			return false;
		}
		return true;
	}
}
