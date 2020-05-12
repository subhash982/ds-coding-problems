package ds.file;

import java.io.*;
import java.nio.file.Files;
import java.util.LinkedList;
import java.util.List;

public class FileSplitter {

    /**
     * Split a file into chunks
     * @param f
     * @return
     * @throws IOException
     */
    public static  List<File> splitFile(File f) throws IOException {
        List<File> generatedFile = new LinkedList <>();
        int chunkCounter = 1;

        int sizeOfFiles = 1024 * 10;// 10KB
        byte[] buffer = new byte[sizeOfFiles];

        String fileName = f.getName();

        //try-with-resources to ensure closing stream
        try (FileInputStream fis = new FileInputStream(f);
             BufferedInputStream bis = new BufferedInputStream(fis)) {

            int bytesAmount = 0;
            while ((bytesAmount = bis.read(buffer)) > 0) {
                //write each chunk of data into separate file with different number in name
                String filePartName = String.format("%s.%03d", fileName, chunkCounter++);
                File newFile = new File(f.getParent(), filePartName);
                try (FileOutputStream out = new FileOutputStream(newFile)) {
                    out.write(buffer, 0, bytesAmount);
                }
                generatedFile.add(newFile);
            }
        }
        return generatedFile;
    }

    /**
     * Merge the chunk into the files
     * @param files list of file chunks
     * @param into final output file
     * @throws IOException
     */
    public static void mergeFiles(List<File> files, File into)
            throws IOException {
        try (FileOutputStream fos = new FileOutputStream(into);
             BufferedOutputStream mergingStream = new BufferedOutputStream(fos)) {
            for (File f : files) {
                Files.copy(f.toPath(), mergingStream);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        String inputFilePAth ="C:\\Users\\subha\\Desktop\\Files\\TestFile.pdf";
        String outputFilePAth = "C:\\Users\\subha\\Desktop\\Files\\MergedFile.pdf";
        List<File> splittedFiles = splitFile(new File(inputFilePAth));
        mergeFiles(splittedFiles,new File(outputFilePAth));
    }
}
