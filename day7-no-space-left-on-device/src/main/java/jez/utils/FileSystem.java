package jez.utils;

public class FileSystem
{
	public static final int DISK_SPACE = 70000000;
	public static final int UPDATE_SPACE = 30000000;
	private final Directory root;
	private Directory current;

	public FileSystem(String root)
	{
		this.root = new Directory(root, null);
	}

	public void goToRoot()
	{
		current = root;
	}

	public void addDir(String name)
	{
		current.addDir(name);
	}

	public void addFile(String name, int size)
	{
		current.addFile(name, size);
	}

	public void goTo(String name)
	{
		if (name.equals("/"))
		{
			goToRoot();
		} else
		{
			current = current.getDirectory(name);
		}
	}

	public void goUp()
	{
		current = current.getParent();
	}

	public Directory currentDirectory()
	{
		return current;
	}
}
