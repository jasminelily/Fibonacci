package number.com.helper;

import number.com.constant.Constant;

/**
 * 変換共通クラス
 * @author lily tan
 *
 */
public class ConvertHelper {
	/**
	 * 文字列から数字へ変換
	 * @param input　文字列
	 * @return　数字（無効の時、0へ戻す）
	 */
	public static int convertStrToInt(String input) {
		int i = 0;
		if (CheckHelper.checkIsNumber(input)) {
			i = Integer.parseInt(input);
		}
		return i;
	}

	/**
	 * 数列タイプ文字列から数列タイプへ変換
	 * @param input　数列タイプ文字列
	 * @return　数列タイプ（無効の時、nullへ戻す）
	 */
	public static Constant.ArrayType convertStrToArrayType(String input) {
		//フィボナッチ数列
		if (Constant.TYPE_FLG_FIBON_LONG.equals(input)
				|| Constant.TYPE_FLG_FIBON_SHORT.equals(input)) {
			return Constant.ArrayType.Fibonacci;
		}
		//素数列
		if (Constant.TYPE_FLG_PRIME_LONG.equals(input)
				|| Constant.TYPE_FLG_PRIME_SHORT.equals(input)) {
			return Constant.ArrayType.Prime;
		}
		
		return null;
	}
}
