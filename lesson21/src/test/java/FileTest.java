import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.junit.Before;

import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import java.io.File;

import static org.junit.Assert.*;

public class FileTest {
  @Rule
  public TemporaryFolder temporaryFolder = new TemporaryFolder();
  @Test
  public void test1() {
    assertEquals(true, true);
  }

  @Test
  public void test3() throws Exception {
    File file = temporaryFolder.newFile();

    System.out.println(file.getAbsolutePath());
    System.out.println(file.toString());
  }

  @Test
  public void test4() throws Exception {
    File dir = new File("C:\\ololo");
    dir.mkdir();

    assertThat(dir.exists(), is(true));
    dir.deleteOnExit();

  }
  @Test
  public void test5() throws Exception {
    File dir = new File("dir1/dir2/dir3");
    dir.mkdirs();

    assertThat(dir.exists(), is(true));
    dir.deleteOnExit();
  }

  @Test
  public void test6() throws Exception {
    File parentDir = new File("helloDirList");
    parentDir.mkdir();

    File dir1 = new File(parentDir, "dir1");
    dir1.mkdir();

    File dir2 = new File(parentDir, "dir2");
    dir2.mkdir();

    File file1 = new File(parentDir, "file1");
    file1.createNewFile();

    File file2 = new File(parentDir, "file2");
    file2.createNewFile();

    File file3 = new File(dir2, "file3");
    file3.createNewFile();

    System.out.println(Arrays.toString(parentDir.list()));

    parentDir.deleteOnExit();
    dir1.deleteOnExit();
    file1.deleteOnExit();
    file2.deleteOnExit();
    file3.deleteOnExit();
  }

  @Test
  public void test7() throws Exception {
    File parentDir = new File("helloDirList");
    parentDir.mkdir();

    File dir1 = new File(parentDir, "dir1");
    dir1.mkdir();

    File dir2 = new File(parentDir, "dir2");
    dir2.mkdir();

    File file1 = new File(parentDir, "file1");
    file1.createNewFile();

    File file2 = new File(parentDir, "file2");
    file2.createNewFile();

    File file3 = new File(dir2, "file3");
    file3.createNewFile();


    System.out.println(Arrays.toString(parentDir.list()));

    deleteRecursively(parentDir);
  }

  private void deleteRecursively(File dir) {
    if (dir.isDirectory()) {
      for (File child : dir.listFiles()) {
        deleteRecursively(child);
      }
    }
    dir.delete();
  }

  @Test
  public void test8() throws Exception {
    File parentDir = new File("helloDirList");
    parentDir.mkdir();

    File dir1 = new File(parentDir, "dir1");
    dir1.mkdir();

    File dir2 = new File(parentDir, "dir2");
    dir2.mkdir();

    File file1 = new File(parentDir, "file1");
    file1.createNewFile();

    File file2 = new File(parentDir, "file2");
    file2.createNewFile();

    File file3 = new File(dir2, "file3");
    file3.createNewFile();


    System.out.println(Arrays.toString(parentDir.list(new FilenameFilter() {
      @Override
      public boolean accept(File dir, String name) {
        return true;//name.contains("1");
      }
    })));

    /*Files.walkFileTree(Paths.get(parentDir.getAbsolutePath()), new SimpleFileVisitor<Path>() {
      @Override
      public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        return super.preVisitDirectory(dir, attrs);
      }
    });*/
  }

  @Test
  public void test10() throws Exception {
    File temp = File.createTempFile("test", ".txt");
    System.out.println(temp.getAbsolutePath());
  }
}
