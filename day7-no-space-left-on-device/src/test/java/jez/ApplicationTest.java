package jez;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import jez.utils.FileSystem;

class ApplicationTest
{
	// $ cd /
	// $ ls
	// dir bqc
	// dir mwmlf
	// dir ngn
	// 143562 nrwjb
	// 78449 qqvdcclf
	// dir qrnm
	// dir smfzmmhc
	// 116085 tvrms
	// dir vrdrsj

	// $ cd bqc
	// $ ls
	// 5693 qqvdcclf

	// $ cd ..

	// $ cd mwmlf
	// $ ls
	// dir cmfphpc
	// dir lqqshq
	// dir mwmlf
	// dir rlf
	// dir smfzmmhc
	@Test
	void high_order_test()
	{
		FileSystem fs = new FileSystem("/");

		fs.goToRoot();
		fs.addDir("bqc");
		fs.addDir("mwmlf");
		fs.addDir("ngn");
		fs.addFile("nrwjb", 143562);
		fs.addFile("qqvdcclf", 78449);
		fs.addDir("qrnm");
		fs.addDir("smfzmmhc");
		fs.addFile("tvrms", 116085);
		fs.addDir("vrdrsj");

		fs.goTo("bqc");
		assertThat(fs.currentDirectory().getName()).isEqualTo("bqc");
		fs.addFile("qqvdcclf", 5693);
		assertThat(fs.currentDirectory().filesSize()).isEqualTo(5693);

		fs.goUp();
		fs.goTo("mwmlf");

		fs.addDir("cmfphpc");
		fs.addDir("lqqshq");
		fs.addDir("mwmlf");
		fs.addDir("rlf");
		fs.addDir("smfzmmhc");

		fs.goToRoot();
		assertThat(fs.currentDirectory().getName()).isEqualTo("/");
		assertThat(
				fs.currentDirectory().getChildrenDirectories().size() +
						fs.currentDirectory().getChildrenFiles().size()).isEqualTo(9);
		assertThat(fs.currentDirectory().filesSize()).isEqualTo(143562 + 78449 + 116085);
		assertThat(fs.currentDirectory().recursiveFilesSize())
				.isEqualTo(143562 + 78449 + 116085 + 5693);

		fs.goTo("bqc");
		assertThat(fs.currentDirectory().getChildrenFiles().size()).isEqualTo(1);
		assertThat(fs.currentDirectory().filesSize()).isEqualTo(5693);
		assertThat(fs.currentDirectory().recursiveFilesSize()).isEqualTo(5693);

		fs.goUp();
		fs.goTo("mwmlf");
		assertThat(fs.currentDirectory().getChildrenDirectories().size() +
				fs.currentDirectory().getChildrenFiles().size())
						.isEqualTo(5);
		assertThat(fs.currentDirectory().filesSize()).isEqualTo(0);
		assertThat(fs.currentDirectory().recursiveFilesSize()).isEqualTo(0);
	}
}
