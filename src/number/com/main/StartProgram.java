package number.com.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import number.com.action.PrintArray;
import number.com.array.FibonacciArray;
import number.com.array.PrimeArray;
import number.com.common.ArrayTemplate;
import number.com.constant.Constant;
import number.com.helper.*;
/**
 * 業務クラス
 * @author lily tan
 *
 */
public class StartProgram {

	//入力文字列
	private static String inputStr = "";
	//入力番目
	private static int inputInt = 0;
	//数列タイプ
	private static Constant.ArrayType arrayType = null;
	//フィボナッチ数列
	private static FibonacciArray fArray = null;
	//素数列
	private static PrimeArray pArray = null;
	//モード数列
	private static ArrayTemplate modeArray = null;
	//初期化フラグ
	private static Boolean isInit = true;
	//印刷実行
	private static PrintArray printAction = null;
	

	/**
	 * 起動口
	 * @param args
	 */
	public static void main(String[] args) {
		initArray();
		doInputOutput();
	}

	/**
	 * 数列初期化
	 * 説明：画面起動の時、数列初期化
	 */
	private static void initArray() {

		PrintHelper.print("------初期化中、少々お待ちください。------");
		createArray();
		changeArray(Constant.DEFAULT_TYPE);
		isInit = false;
	}

	/**
	 * 入力、出力実行メーソッド
	 */
	private static void doInputOutput() {

		//繰り返しフラグ
		Boolean isLoop = true;
		while (isLoop) {
			try {
				//入力文字列取得
				getInputStr();

				//停止フラグ判定
				if (CheckHelper.checkIsStop(inputStr)) {
					isLoop = false;
					PrintHelper.print("終了");
					continue;
				}
				//モード変換フラグ判定
				if (CheckHelper.checkIsArrayType(inputStr)) {
					changeArray(ConvertHelper.convertStrToArrayType(inputStr));
					continue;
				}
				//番目取得
				if (!getInputInt()) {
					//無効の時、再入力
					continue;
				}

				//出力実行
				doOutput();
				
			} catch (Exception e) {
				PrintHelper.print("システムエラー。");
			}
		}
	}

	/**
	 * 出力実行メーソッド
	 */
	private static void doOutput() {
		//出力実行クラスがなし、新規
		if (printAction == null) {
			printAction = new PrintArray();
		}
		
		//数列、数列タイプ設定
		printAction.setArray(modeArray);
		printAction.setArrayType(arrayType);

		//印刷実行
		//数列値印刷
		printAction.PrintValue(inputInt);
		//数列印刷
		printAction.PrintList(inputInt);
	}

	/**
	 * 入力文字列取得メーソッド
	 */
	private static void getInputStr() {

		PrintHelper.print("番目を入力してください: ");

		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);

		try {
			inputStr = br.readLine();
		} catch (IOException e) {
			//IOエラー、再入力
			PrintHelper.print("システムエラー。");
			getInputStr();
		}
	}

	/**
	 * 入力番目取得メーソッド
	 * @return
	 */
	private static Boolean getInputInt() {
		// 数字チェック
		ValidationHelper.checkIsNumber(inputStr);
		if (!ValidationHelper.IsValid) {
			PrintHelper.print(ValidationHelper.Message);
			return false;
		}

		// 数列長さチェック
		inputInt = ConvertHelper.convertStrToInt(inputStr);
		ValidationHelper
				.checkArrayLength(inputInt, modeArray.getArray().length);
		if (!ValidationHelper.IsValid) {
			PrintHelper.print(ValidationHelper.Message);
			return false;
		}

		return true;
	}

	/**
	 * 数列新規
	 */
	private static void createArray() {
		fArray = new FibonacciArray(Constant.DEFAULT_LENGTH_FIBON);
		pArray = new PrimeArray(Constant.DEFAULT_LENGTH_PRIME);
	}

	/**
	 * 数列モード変換
	 * @param type　数列タイプ
	 */
	private static void changeArray(Constant.ArrayType type) {
		arrayType = type;
		setMode();
		setChangePrintMsg();
	}

	/**
	 * モード設定
	 */
	private static void setMode() {
		if (Constant.ArrayType.Fibonacci == arrayType) {
			modeArray = fArray;
		}
		else if (Constant.ArrayType.Prime == arrayType) {
			modeArray = pArray;
		}
	}

	/**
	 * モード変換メッセージ設定
	 */
	private static void setChangePrintMsg() {
		//初期化以外、変換文字表示
		if (!isInit) {
			PrintHelper.print("出力変換");
		}
		
		if (Constant.ArrayType.Fibonacci == arrayType) {
			PrintHelper.print("------フィボナッチ数列------");
		}

		if (Constant.ArrayType.Prime == arrayType) {
			PrintHelper.print("------素数列------");
		}
	}
}
