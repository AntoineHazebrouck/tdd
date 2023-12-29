package jez.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Directory
{
	private final Directory parent;
	private final String name;
	private final Map<String, Directory> directories;
	private final Map<String, File> files;

	public Directory(String name, Directory parent)
	{
		this.name = name;
		this.parent = parent;
		this.directories = new HashMap<>();
		this.files = new HashMap<>();
	}

	public void addDir(String name)
	{
		directories.put(name, new Directory(name, this));
	}

	public void addFile(String name, int size)
	{
		files.put(name, new File(name, size));
	}

	public Directory getDirectory(String name)
	{
		if (directories.containsKey(name))
		{
			return directories.get(name);
		} else
		{
			throw new NullPointerException(
					"Subdirectory with name " + name + " does not exists in " + this.name);
		}
	}

	public Directory getParent()
	{
		return parent;
	}

	public String getName()
	{
		return this.name;
	}

	public Map<String, Directory> getChildrenDirectories()
	{
		return directories;
	}

	public Map<String, File> getChildrenFiles()
	{
		return files;
	}

	public int filesSize()
	{
		int count = 0;
		for (File file : files.values())
		{
			count += file.getSize();
		}
		return count;
	}

	private Integer recursiveFilesSizeImpl(Directory traversedDir)
	{
		if (traversedDir == null)
			return null;

		Stack<Directory> stack = new Stack<>();
		stack.push(traversedDir);

		Integer count = 0;

		while (!stack.empty())
		{
			Directory top = stack.pop();
			for (
				Directory child : top.getChildrenDirectories()
						.values()
			)
			{
				stack.push(child);
			}
			count += top.filesSize();
		}
		return count;
	}


	public Integer recursiveFilesSize()
	{
		return recursiveFilesSizeImpl(this);
	}
}
