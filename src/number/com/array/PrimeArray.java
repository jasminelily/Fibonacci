package number.com.array;

import number.com.common.ArrayTemplate;
import number.com.helper.CheckHelper;
/**
 * 素数配列クラス
 * @author lily tan
 *
 */
public class PrimeArray extends ArrayTemplate {
	private long[] arrayPrime = null;
	
	public PrimeArray(){}
	public PrimeArray(int length) {
		setArray(length);
	}

	public long[] getArray() {
		return arrayPrime;
	}

	public long[] getArray(int length) {

		//数列長さ有効チェック
		if (!CheckHelper.checkIsValidArrayLength(length)) {
			return null;
		}

		//一部数列
		long[] newArray = new long[length];
		//一部数列複製個数
		int copyCount = 0;
		//index = 0 から
		for (int i = 0; i < length; i++) {
			//複製個数 < 複製目標個数
			if (copyCount < length) {
				newArray[copyCount] = arrayPrime[i];
			}
			//複製個数 plus
			copyCount++;
		}
		return newArray;
	}

	public void setArray(int length) {

		//数列長さ有効チェック
		if (!CheckHelper.checkIsValidArrayLength(length)) {
			return;
		}

		arrayPrime = new long[length];

		int count = 0;
		long num = 2;
		Boolean isPrime = true;
		while (count < length) {
			isPrime = true;

			for (int i = 2; i <= num / 2; i++) {
				if (num % i == 0) {
					isPrime = false;
					break;
				}
			}

			if (isPrime) {
				arrayPrime[count] = num;
				count++;
			}

			num++;
		}
	}

	public long getArrayValue(int index) {
		return arrayPrime[index];
	}
}
