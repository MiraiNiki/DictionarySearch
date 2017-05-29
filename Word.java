public class Word {
    // 名前
    private String name;
    // 点数
    private int point;
    // コンストラクタ
    public Word(String name, int point){
        this.name = name;
        this.point = point;
    }
    // ゲッターとセッター
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getPoint(){ return point; }
    public void setPoint(int point){ this.point = point; }
}
