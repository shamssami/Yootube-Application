package project1;

public class DNode {

    String videoTitle;
    int videoID;
    String authoringUser;
    String category;
    int numberOfHits;
    int size;
    String url;
    String keyWord = null;

    DNode next;
    DNode prev;

    DNode(String title, int id, String author, String type, int hits,
            int bytes, String link, String word) {
        this.videoTitle = title;
        this.videoID = id;
        this.authoringUser = author;
        this.category = type;
        this.numberOfHits = hits;
        this.size = bytes;
        this.url = link;
        this.keyWord = word;
    }

    DNode() {

    }

    public String toString() {
        return this.videoTitle + " _ " + this.authoringUser + " _ " +
                this.category + " _ " + this.numberOfHits + " _ " + 
                this.size + " _ " + this.url + "_ " + this.keyWord;
    }
//    public DNode getNext() {
//        return next;
//
//    }
//
//    public void setNext(DNode next) {
//        this.next = next;
//
//    }
//
//    public DNode getPrevious() {
//        return prev;
//
//    }
//
//    public void setPrevious(DNode pre) {
//        this.prev = pre;
//
//    }
}
