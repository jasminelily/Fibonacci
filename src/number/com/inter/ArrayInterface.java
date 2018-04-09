package number.com.inter;
/**
 * 配列interfaceクラス
 * @author lily tan
 *
 */
public interface ArrayInterface {
	//数列設定
	public void setArray(int length);
	//数列取得
	public long[] getArray();
	public long[] getArray(int length);
	//数列値取得
	public long getArrayValue(int index);
}
