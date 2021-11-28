public class Word implements Comparable<Word>{
    private String word;
    private int countPT;
    private int countYT;

    public Word(String word, int countPT, int countYT) {
        this.word = word;
        this.countPT = countPT;
        this.countYT = countYT;
    }

    public String toString() {
        String outString = "----------\n" + word + "\n" + countPT + "\n" + countYT;
        return outString;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getCountPT() {
        return countPT;
    }

    public void setCountPT(int count) {
        this.countPT = count;
    }

    public int getCountYT() {
        return countYT;
    }

    public void setCountYT(int count) {
        this.countYT = count;
    }

    public boolean equals(Word w) {
        return (this.word.equals(w.word));
    }

    public int compareTo(Word w) {
        return (this.word.compareTo(w.word));
    }
}