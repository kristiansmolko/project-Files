package projectFiles;

public class Main {
    public static void main(String[] args) {
        ReadFileLine read = new ReadFileLine();
        read.copyFileWithCapital("resource/a.txt");
        read.copyAndEncryptFile("resource/a.txt", 5);
    }
}
