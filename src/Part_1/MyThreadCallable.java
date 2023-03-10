package Part_1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.Callable;

public class MyThreadCallable  implements Callable<Integer> {
    private String fileName;
    private int numLines;

    public MyThreadCallable(String fileName){
        this.fileName = fileName;
    }

    @Override
    public Integer call() throws Exception {
        int count = 0;
        try{
            BufferedReader reader = new BufferedReader(new FileReader(this.fileName));
           // System.out.println("Thread started " + this.fileName);
            while (reader.readLine()!= null){
                count++;
            }
            this.numLines = count;
           // System.out.println("Thread finished " + this.fileName);
            reader.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return this.numLines;
    }
}
