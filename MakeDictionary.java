import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;

//点数順にソートするプログラム
class MakeDictionary {
    static Word[] dictWord = new Word[72412];
    
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
            int point = 0;
            while ((str = br.readLine()) != null){
                point = calcPoint(str);
                dictWord[i] = new Word(str, point);
                i++;
            }
            br.close();
        } catch(Exception e){
            System.out.println(e);
        }
    }

    /**
     * 文字列の点数を計算する
     * @param str 文字列
     * @return point 文字列の点数 
     */
    public static int calcPoint(String str){
        String upperStr = str.toUpperCase();
        int point = 0;
        for(int i = 0; i < upperStr.length(); i++){
            char c = upperStr.charAt(i);
            if(c == 'J' || c == 'K' || c == 'X' || c == 'Z' || c == 'Q'){
                point = point + 3;
            }else if(c == 'C' || c == 'F' || c == 'H' || c == 'L' || c == 'M' || c == 'P' || c == 'V' || c == 'W' || c == 'Y'){
                point = point + 2;
            }else{
                point++;
            }
        }
        return point;
    }

    public static void main(String[] args){
        readFile("Dictionary.txt");
        for(Word word : dictWord){
            System.out.println("name: " + word.getName() + " point: " + word.getPoint());
        }
    }



}
