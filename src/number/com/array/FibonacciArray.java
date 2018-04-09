package number.com.array;

import number.com.common.ArrayTemplate;
import number.com.helper.CheckHelper;

/**
 * フィボナッチ数列クラス
 * @author lily tan
 *
 */
public class FibonacciArray extends ArrayTemplate {
	private long[] arrayFibonacci=null;
	
	public FibonacciArray(){}
	public FibonacciArray(int length){
		setArray(length);
	}
	public long[] getArray() {
		return arrayFibonacci;
	}

	public long[] getArray(int length) {
		
		//数列長さ有効チェック
		if(!CheckHelper.checkIsValidArrayLength(length)){return null;}
		
		//一部数列
		long [] newArray = new long[length];
		//一部数列複製個数
		int copyCount=0;
		//index = 0 から
		for(int i = 0;i<length;i++){
			//複製個数 < 複製目標個数
			if(copyCount<length){
				newArray[copyCount] = arrayFibonacci[i];
			}
			//複製個数 plus
			copyCount++;
		}
		return newArray;
	}

	public void setArray(int length) {
		
		//数列長さ有効チェック
		if(!CheckHelper.checkIsValidArrayLength(length)){return;}

		arrayFibonacci = new long[length];
		for(int i=0; i<length;i++){
			switch(i){
			case 0:
				arrayFibonacci[i] = 0;
				break;
			case 1:
				arrayFibonacci[i] = 1;
				break;
		    default:
		    	arrayFibonacci[i] = arrayFibonacci[i-1]+arrayFibonacci[i-2];
		    	break;
			}
		}		
	}
	
	public long getArrayValue(int index) {
		return arrayFibonacci[index];
	}
}
