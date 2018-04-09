package number.com.action;

import number.com.common.ArrayTemplate;
import number.com.constant.Constant;
import number.com.helper.PrintHelper;
/**
 * 数列印刷クラス
 * @author lily tan
 *
 */
public class PrintArray {

	//印刷対象
	private ArrayTemplate array = null;
	//印刷対象タイプ
	private Constant.ArrayType arrayType = null;
	//印刷対象名称
	private String arrayName = "";

	/**
	 * コンストラクタ
	 */
	public PrintArray() {
	}
	
	/**
	 * 数列値を印刷
	 * @param inputNum　配列順
	 */
	public void PrintValue(int inputNum) {
		//数列のindexは０から
		int index = inputNum - 1;
		PrintHelper.print("%1$s番目の%2$s数：%3$s", inputNum, arrayName, array
				.getArrayValue(index));
	}

	/**
	 * 数列を印刷
	 * @param length　数列長さ
	 */
	public void PrintList(int length) {

		// 配列取得
		long[] arr = array.getArray(length);
		// 配列の数字を文字列へ変換
		StringBuffer values = new StringBuffer();
		for (long value : arr) {
			values.append(value);
			values.append(" ");
		}
		// print values
		PrintHelper.print("%1$s番目までの%2$s数列：%3$s", length, arrayName, values
				.toString().trim());
	}

	/**
	 * 印刷対象名称を設定
	 */
	private void SetArrayName() {
		if (Constant.ArrayType.Fibonacci == arrayType) {
			arrayName = "フィボナッチ";
		} else if (Constant.ArrayType.Prime == arrayType) {
			arrayName = "素";
		}
	}
	
	//-----get set----
	public Constant.ArrayType getArrayType() {
		return arrayType;
	}

	public void setArrayType(Constant.ArrayType arrayType) {
		this.arrayType = arrayType;
		SetArrayName();
	}

	public ArrayTemplate getArray() {
		return array;
	}

	public void setArray(ArrayTemplate array) {
		this.array = array;
	}

}
