import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Scanner;


//点数順にソートするプログラム
class GetBestAnswer {
    static String[] dictWord = new String[72412];
    
    /**
     * ファイルを読み込み，内容を配列に格納．
     * @param path 読み込むファイルのパス
     */
    public static void readFile(String path) {
        try {
            File file = new File(path);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String str;
            int i = 0;
            while ((str = br.readLine()) != null){
                dictWord[i] = str;
                i++; 
            }
            br.close();
        } catch(Exception e){
            System.out.println(e);
        }
    }

    /**
     * 文字列の点数を計算する
     * @param str 入力する16個の文字からなる文字列 
     */
    public static void getHighPointWord(String str){
        String upperStr = str.toUpperCase();
        for(int i = 0; i < dictWord.length; i++){
            String w = dictWord[i];
            StringBuffer s = new StringBuffer(w);
            for(int j = 0; j < upperStr.length(); j++){
                //dictwordの中の文字がstrにあるかどうか（並び順は関係ない）
                char c = upperStr.charAt(j);
                int index = s.indexOf(String.valueOf(c));
                if(index != -1){
                    //文字列からその文字を削除w.indexOf(c)番目を削除
                    s = s.deleteCharAt(index);
                    if(s == null || s.length() == 0){
                        System.out.println(w);
                        return;
                    }
                }
            }
        }
        System.out.println("I cannnot find the best word.");
    }

    public static void main(String[] args){
        readFile("GetPointDictionary.txt");
        Scanner scan = new Scanner(System.in);
        while(true){
            String s = scan.next();
            getHighPointWord(s);
        }
    }

}
