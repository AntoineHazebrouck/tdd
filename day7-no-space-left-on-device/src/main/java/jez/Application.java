package jez;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import jez.utils.Directory;
import jez.utils.FileSystem;

public class Application
{

	public static void main(String[] args) throws IOException
	{
		String path = "src\\main\\resources\\input.txt";
		String file = new String(Files.readAllBytes(Paths.get(path)));
		List<String> lines = Arrays.asList(
											file.replace("$", "@")
													.split("\\r\\n"));

		FileSystem fs = new FileSystem("/");
		fs.goToRoot();

		for (String line : lines)
		{
			if (line.contains("@ ls"))
			{
			} else if (line.contains("@ cd"))
			{
				String cdPath = changeDirectoryPath(line);
				// si ..
				if (cdPath.equals(".."))
				{
					fs.goUp();
				}
				// else
				else
				{
					fs.goTo(cdPath);
				}
			} else
			{
				if (line.startsWith("dir"))
				// si dir
				{
					String dirName = line.split(" ")[1];
					fs.addDir(dirName);
				} else
				// si file
				{
					String fileName = line.split(" ")[1];
					Integer fileSize = Integer.parseInt(line.split(" ")[0]);
					fs.addFile(fileName, fileSize);
				}
			}
		}

		Stack<Directory> stack = new Stack<>();
		fs.goToRoot();
		stack.push(fs.currentDirectory());

		// Integer count = 0;
		List<Directory> allDirectories = new ArrayList<>();

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
			allDirectories.add(top);
		}

		// List<Directory> sub100000BytesDirectories = allDirectories.stream()
		// .filter(dir -> {
		// return dir.recursiveFilesSize() < 100000;
		// })
		// .collect(Collectors.toList());

		// Integer sumOfSub100000Dirs = sub100000BytesDirectories.stream()
		// .mapToInt(dir -> dir.recursiveFilesSize())
		// .sum();

		// System.out.println(sumOfSub100000Dirs);

		fs.goToRoot();
		Integer usedSpace = fs.currentDirectory()
				.recursiveFilesSize();

		Integer unusedSpace = FileSystem.DISK_SPACE - usedSpace;

		Integer spaceNeededForUpdate = FileSystem.UPDATE_SPACE - unusedSpace;

		System.out.println(spaceNeededForUpdate);

		List<Directory> directoriesThatWouldAllowUpdate = allDirectories.stream()
				.filter(dir -> dir.recursiveFilesSize() > spaceNeededForUpdate)
				.toList();

		System.out.println(
							directoriesThatWouldAllowUpdate.stream()
									.sorted((dir1, dir2) -> {
										return dir1.recursiveFilesSize()
												.compareTo(dir2.recursiveFilesSize());
									})
									.findFirst()
									.get()
									.recursiveFilesSize());

		// System.out.println(allDirectories.size());
		// System.out.println(directoriesThatWouldAllowUpdate.size());
	}

	private static String changeDirectoryPath(String line)
	{
		return line.split(" ")[2];
	}
}
