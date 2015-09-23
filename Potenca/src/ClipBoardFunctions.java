import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;


public class ClipBoardFunctions 
{
	public static void setClipboard(String str) 
	{
		StringSelection ss = new StringSelection(str);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
	}
}
