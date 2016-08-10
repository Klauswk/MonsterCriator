package Classes;
import java.io.File;
import javax.swing.filechooser.*;
public class FileFilters extends FileFilter{
	private String ImageFormat = "GIF";
	private char DotIndex = '.';
	
	public boolean accept(File f)
	{
		if(f.isDirectory())
		{
			return true;	
		}
		if(extension(f).equalsIgnoreCase(ImageFormat))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	private String extension(File f) {
		String FileName = f.getName();
		int indexFile = FileName.lastIndexOf(DotIndex);
		if(indexFile > 0 && indexFile < FileName.length()-1)
		{
			return FileName.substring(indexFile+1);
		}
		else
		{
			return " ";
		}
	}

	@Override
	public String getDescription() {
		
		return null;
	}
	
}
