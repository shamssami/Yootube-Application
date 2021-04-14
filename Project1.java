package project1;

import java.util.Arrays;
import java.util.Scanner;

public class Project1 {

    public static DNode searchNodeList(DoublyLinkedList head, String s) {

        if (head.listname == null) {
            System.out.println("There is no list! ");

        }
        try {
            // This line of code throws NullPointerException 
            // because ptr is null 
            if (head.listname.equalsIgnoreCase(s)) {
                return head.header;
            } else {
                return searchNodeList(head.Next, s);
            }
        } catch (NullPointerException e) {
            System.out.println(s + " list is not found!");
            return null;
        }

    }

    public static DNode search(DNode head, String x) {
        x.toLowerCase();

        // Base case
        if (head.videoTitle == null) {
            System.out.println("The video is not found");
        }

        // If key is present in current node,
        // return true
        try {
            if (head.videoTitle.toLowerCase().equalsIgnoreCase(x) || head.keyWord.toLowerCase().equalsIgnoreCase(x)) {
                return head;
            } else {// Recur for remaining list
                return search(head.next, x);
            }

        } catch (NullPointerException e) {
            return null;
        }
    }

    static void ListsSearch(DoublyLinkedList header, String data) {
        data.toLowerCase();
        DoublyLinkedList current = header;
        DNode h = current.header.next;
        try {
            if (current == null) {
                System.out.println("The List is empty!");
            } else {

                while (h != null) {
                    DNode temp = h;

                    if (temp == null) {
                        System.out.println("No Elements in the list!");
                    } else {

                        while (temp != null) {

                            if (temp.videoTitle.toLowerCase().equalsIgnoreCase(data) || temp.keyWord.toLowerCase().equalsIgnoreCase(data)) {
                                System.out.println("Serach Result for " + data + " is:" + "\nVideoTitle: " + temp.videoTitle + "\nVideoID: " + temp.videoID
                                        + " \nNumOfHits: " + temp.numberOfHits + " \nURL is: " + temp.url + " \nThe size:"
                                        + temp.size + "\nThe keyword is: " + temp.keyWord + " \n" + "List is: " + current.listname);
                                return;
                            }
                            if (temp.next != null) {
                                temp = temp.next;
                            }
                            if (temp.next == null && current.Next != null) {
                                current = current.Next;
                                temp = current.header.next;

                            }

                        }

                    }
                    //	System.out.println("No Results!");

                }
            }
        } catch (NullPointerException e) {
            System.out.println("The video is not found!");
        }

    }

    static void ListsSearch(ListLinked a, DoublyLinkedList header, String data) {

        DNode head = header.header.next;

        DoublyLinkedList current = header;

        if (current.header == null) {
            System.out.println("The List is empty!");
        } else {

            while (current != null) {
                DNode temp = head;

                if (temp == null) {
                    System.out.println("No Elements in the list!");
                } else {

                    while (temp != null) {

                        if (temp.videoTitle == data) {
                            System.out.println("Serach Result for " + data + " is:"
                                    + "\n video Title: " + temp.videoTitle + "\n videoID: " + temp.videoID + " \nNumOfHits: " + temp.numberOfHits + " \nURL is: "
                                    + temp.url + " \nThe size:" + temp.size + "\nThe Best keyword is: " + temp.keyWord + " the list name is   " + current.listname);
                            return;
                        }
                        if (temp.next != null) {
                            temp = temp.next;
                        } else {
                            if (temp.next
                                    == null && temp.next.next != null) {
                                temp = current.Next.header.next;
                            }
                        }

                    }

                }
                if (current.Next != null) {
                    current = current.Next;
                    System.out.println("The current list is: " + current.listname);

                } else {
                    break;
                }
            }
            System.out.println("No Results!");
        }
    }

    static void ListsSearch(DoublyLinkedList history, DoublyLinkedList header, String data) {
        int p;
        Scanner input = new Scanner(System.in);

        DoublyLinkedList current = header;
        DNode h = current.header.next;
        try {
            if (current == null) {
                System.out.println("The List is empty!");
            } else {

                while (h != null) {
                    DNode temp = h;

                    if (temp == null) {
                        System.out.println("No Elements in the list!");
                    } else {

                        while (temp != null) {

                            if (temp.videoTitle.toLowerCase().equalsIgnoreCase(data) || temp.keyWord.toLowerCase().equalsIgnoreCase(data)) {
                                System.out.println("Serach Result for " + data + " is:" + "\nvideo Title: " + temp.videoTitle
                                        + "\nvideoID: " + temp.videoID
                                        + " \nNumOfHits: " + temp.numberOfHits + " \nURL is: " + temp.url + " \nThe size:"
                                        + temp.size + "\nThe keyword is: " + temp.keyWord + "\nList:  " + current.listname);

                                DNode curr = temp.next;
                                DNode prv = temp.prev;

                                System.out.println("Do u want to watch the video? answer with yes or no");

                                String answer = input.nextLine();

                                if (answer.equalsIgnoreCase("yes")) {
                                    int i = (int) (Math.random() * 10);
                                    System.out.println(temp.videoTitle + " is running now...");

                                    for (int j = 0; j < i; j++) {

                                        System.out.println(j + " s");
                                    }
                                    history.addFirst(temp);
                                    System.out.println("The video has finished!");
                                    ////////////////////////// 

                                    do {

                                        System.out.println("Which video u wanna to watch: ");
                                        System.out.println("1-Next video");
                                        System.out.println("2-Previous Video");
                                        System.out.println("3-No Video");
                                        p = input.nextInt();

                                        if (p == 1) {
                                            if (curr.videoTitle != null) {

                                                System.out.println(curr.videoTitle + " is running now...");
                                                for (int j = 0; j < i; j++) {

                                                    System.out.println(j + " s");
                                                }
                                                curr = curr.next;
                                                history.addFirst(curr);
                                                System.out.println("The video has finished!");

                                            } else {

                                                System.out.println("there isnet video next this..");

                                            }

                                        } else if (p == 2) {

                                            if (prv.videoTitle != null) {
                                                System.out.println(prv.videoTitle + " is running now...");
                                                for (int j = 0; j < i; j++) {

                                                    System.out.println(j + " s");
                                                }
                                                prv = prv.prev;
                                                history.addFirst(prv);
                                                System.out.println("The viedeio has finished-------------------");
                                                break;

                                            } else {
                                                System.out.println("there isnt vidoe prev this");
                                            }
                                        } else {
                                            System.out.println("ok, u can watch any video when u like..");
                                        }

                                    } while (p != 3);

                                    ////////////////////////////////  
                                } else {

                                    System.out.println("ok, you can watch it later!");
                                }

                                return;
                            }

                            if (temp.next != null) {
                                temp = temp.next;
                            }
                            if (temp.next == null && current.Next != null) {
                                current = current.Next;
                                temp = current.header.next;

                            }

                        }

                    }

                }
            }
        } catch (NullPointerException e) {
            System.out.println("The video is not found!");
        }

    }

//////////////////////////////////////////////////////////////////////////
    public static DoublyLinkedList searchList(DoublyLinkedList head, String s) {

        DoublyLinkedList menu = head;

        if (head.listname == null) {
            System.out.println("There is not any list! ");

        }
        try {
            // This line of code throws NullPointerException 
            // because ptr is null 
            if (head.listname.equalsIgnoreCase(s)) {
                return menu;
            } else {
                return searchList(head.Next, s);

            }
        } catch (NullPointerException e) {
            System.out.println("The list is not found!");
            return null;
        }

    }
    ///////////////////////////////////////////////

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        ListLinked main = new ListLinked();

        DoublyLinkedList favourites = new DoublyLinkedList();
        favourites.listname = "Favourites";
        favourites = main.head;

        DoublyLinkedList watchLater = new DoublyLinkedList();
        watchLater.listname = "watchLater";
        watchLater = main.head.Next;

        DoublyLinkedList history = new DoublyLinkedList();
        history.listname = "History";
        history = main.head.Next.Next;

        // Note: we can make getter method in DoublyLinkedList to call the current name of the list
        DNode m = new DNode("How to learn programming", 1, "CroatCode", "Eductional",
                26, 8, "https://www.youtube.com/watch?v=bJzb-RuUcMU", "program");
        favourites.addFirst(m);
        favourites.addDNode(new DNode("Albi Ya Albi", 2, "Nancy Ajram", "Music",
                12, 4, "https://www.youtube.com/watch?v=dNQMH3WVMNs", "song"), 1);
        favourites.addDNode(new DNode("Infinity", 3, "Sandara Sahi", "Music",
                8, 4, "https://www.youtube.com/watch?v=mBVybIlJxUw", "mySong"), 2);
        favourites.addDNode(new DNode("Summer In The City ", 34, " OW UNITED ", "song",
                11, 150, "https://www.youtube.com/watch?v=n_EVldaWng0", "summer"), 3);
        favourites.addDNode(new DNode("Believer", 48, " Imagine Dragon ", "song ",
                14, 450, "https://www.youtube.com/watch?v=7wtfhZwyrcc", "imagine"), 4);
        favourites.addDNode(new DNode("Dance Monkey", 72, "Royal Music", "song",
                13, 350, "https://www.youtube.com/watch?v=1__CAdTJ5JU", "monkey"), 5);
        favourites.addDNode(new DNode("Faded", 86, "Alan Walker", "song",
                16, 650, "https://www.youtube.com/watch?v=60ItHLz5WEA", "alan"), 6);
        favourites.addDNode(new DNode("Alive", 92, " Sia ", "song",
                17, 750, "https://www.youtube.com/watch?v=t2NgsJrrAyM", "sia"), 7);
        favourites.addDNode(new DNode("FRIENDS", 62, " Marshmello", " song ", 12,
                250, "https://www.youtube.com/watch?v=CY8E6N5Nzec", "marshemello"), 8);
        favourites.addDNode(new DNode("Sing", 91, "Fandango Family", "song", 20,
                50, "https://www.youtube.com/watch?v=ubRii1LIXM0", "family"), 9);

        watchLater.addFirst(new DNode("4 Easy Meals To Start Cooking", 22, "Tasty",
                "Cook", 2, 200, "https://www.youtube.com/watch?v=WEDndTCyGgU", "food"));
        watchLater.addFirst(new DNode("Love Yourself", 33, "Justin Bieber",
                "Song", 3, 300, "https://www.youtube.com/watch?v=oyEuk8j8imI", "me"));

        DNode n = new DNode("lovely", 11, "Billie Eilish and Khalid",
                "Song", 1, 100, "https://www.youtube.com/watch?v=V1Pl8CzNzCw", "love");

        watchLater.addFirst(n);
        watchLater.addDNode(new DNode("10 Most Beautiful Places In The World",
                44, "Top Trending", "Places", 4, 400, "https://youtu.be/m0iMU57w2_U", "beautiful"), 3);
        watchLater.addDNode(new DNode("Hob Kol Hayati", 55, "Elissa ", "Song ",
                5, 500, "https://www.youtube.com/watch?v=5iezwFAPAXQ", "hob"), 4);
        watchLater.addDNode(new DNode("Singing birds", 66, "Wildlife World",
                "Song", 6, 600, "https://youtu.be/I7dYd-Ra8bk", "bride"), 5);
        watchLater.addDNode(new DNode("Birthday", 77, "Anne Marie ", "Song",
                7, 700, "https://www.youtube.com/watch?v=egVAW6l_QU8", "My day"), 6);
        watchLater.addDNode(new DNode("Amazing Chocolate Cake", 88,
                "Preppy Kitchen", "Cook", 8, 800, "https://youtu.be/3r3tpxzn5t8", "cake"), 7);
        watchLater.addDNode(new DNode("Wild Amazone Documentary HD", 99,
                "National Geographic", "places", 9, 900, "https://youtu.be/F5UPc8dya-M", "amazone"), 8);
        watchLater.addDNode(new DNode("Come Together", 54, "NOW UNITED", "Song",
                10, 1000, "https://youtu.be/_tileyCRZlA", "togther"), 9);

        DoublyLinkedList myVideo = new DoublyLinkedList();
        myVideo = main.head.Next.Next.Next;
        myVideo.listname = "myVideo";

        DoublyLinkedList random = new DoublyLinkedList();
        random = main.head.Next.Next.Next.Next;
        random.listname = "random";

        DNode m1 = new DNode("snowman", 43, "sia", "song", 2, 100000, "//https:www.youtube.com/watch?v=1R_wYJMUKoc ", "favouite");
        myVideo.addFirst(m1);
        myVideo.addDNode(new DNode("Gausss Law Basics", 6, "lasseviren1", "teach", 3,
                20000, "https://www.youtube.com/watch?v=QNIJC1emss8", "physics"), 1);
        myVideo.addDNode(new DNode("Angle Basics", 8, "mathantics", "learning", 13,
                50000, "https://www.youtube.com/watch?v=DGKwdHMiqCg", "math"), 2);
        myVideo.addDNode(new DNode("Introduction to Geometry", 5,
                "The Organic Chemistry Tutor", "mathTeach", 61, 6000,
                "https://www.youtube.com/watch?v=302eJ3TzJQU", "Geometry"), 3);
        myVideo.addDNode(new DNode("The Science Behind Ice Storms", 9,
                "The Weather Channel ", "storm", 21, 60000, "https://www.youtube.com/watch?v=wfzm1M_iSos", "weather"), 4);
        myVideo.addDNode(new DNode("9 AMAZING ICE experiments you must see", 5,
                "Go Experimental", "experiment", 9, 13000, "https://www.youtube.com/watch?v=8e4pAXy1iZI", "ice"), 5);
        myVideo.addDNode(new DNode("Making uranium glass", 11, "NileRed", "homemade",
                19, 346987, "https://www.youtube.com/watch?v=RGw6fXprV9U", "glass"), 6);
        myVideo.addDNode(new DNode("Maldives Travel Guide", 16, "Ayo World",
                "world", 18656, 678, "https://www.youtube.com/watch?v=3FM1waTeTDE", "travel"), 7);
        myVideo.addDNode(new DNode("Why I travel", 10, "JustKay", "travel",
                18700, 132, "https://www.youtube.com/watch?v=qLh99Cxb1e0", "trip"), 8);
        myVideo.addDNode(new DNode("One Week in China", 17, "Nas Daily", "travel",
                39800, 154, "https://www.youtube.com/watch?v=IY0P38yrQ_Y", "china"), 9);

        DNode r = new DNode("One Week in Hawaii", 81, "Nas Daily", "travel",
                12500, 245, "https://www.youtube.com/watch?v=RUr72w4YA-k", "hawaii");
        random.addFirst(r);
        random.addDNode(new DNode("The Culture of Palestine", 41,
                "shishi87", "culture", 350000, 389, "https://www.youtube.com/watch?v=YJXC046hzXQ", "palestine"), 1);
        random.addDNode(new DNode("3 Daqat ", 31, "Abu music ", "music",
                58000, 462, "https://www.youtube.com/watch?v=ejvpVhvKesM", "3"), 2);
        random.addDNode(new DNode("JERUSALEM TRAVEL GUIDE 2019", 61,
                "Walking Distance", "walk", 3340000, 673, "https://www.youtube.com/watch?v=_3LM7dtL9k4", "jerusalem"), 3);
        random.addDNode(new DNode("Top 100 Places To Visit In Europe", 51,
                "Ryan Shirley", "places", 7890000, 671, "https://www.youtube.com/watch?v=ixIzimI35SE", "europe"), 4);
        random.addDNode(new DNode("West England", 71, "Rick Steves' Europe ",
                "country", 200000, 255, "https://www.youtube.com/watch?v=lEgPVrSZa6w", "england"), 5);
        random.addDNode(new DNode("The Holy Land in 4K", 722, "devinsupertramp",
                "land", 30090, 342, "https://www.youtube.com/watch?v=otP54vrpOJ4", "holy"), 6);
        random.addDNode(new DNode("Hobbo Ganna", 81, "Sherine", "song", 50092, 321,
                "https://www.youtube.com/watch?v=nn5PgeXMq8w", "ganna"), 7);
        random.addDNode(new DNode("Easy Rainbow Cake Recipe", 93, "The Tasty Mix", "cook",
                123000, 276, "https://www.youtube.com/watch?v=VLrHDsZWV8w", "cake"), 8);
        random.addDNode(new DNode("The Lion and the Mouse", 21, "Fairy Tales and Stories for Kids ",
                "story", 987000, 211, "https://www.youtube.com/watch?v=23_mESawEEc", "story"), 9);

        int choose = 0;
 
        do {
        	       try {
            System.out.println(" Welcome to yooTube application :) (Please choose "
                    + "one of these)");
            System.out.println(" 1. Show all lists");  //Done
            System.out.println(" 2. Inseret a new list"); //Done
            System.out.println(" 3. Delete a specific list(to show vidoe details and watch it if you want)"); //Done
            System.out.println(" 4. Search in all lists(to show vidoe details and watch it if you want)");//Done
            System.out.println(" 5. Search in a specific list"); //Done
            System.out.println(" 6. Add video to any list"); //Done
            System.out.println(" 7. Show all the videos in a specific list"); //Done
            System.out.println(" 8. Relocate a video within same list"); //Done
            System.out.println(" 9. Relocate a video to another list");//Done
            System.out.println(" 10. Copy a video to another list"); //Done
            System.out.println(" 11. Choose to play a list in order "); //Done
            System.out.println(" 12. Reverse a specific list"); //Done
            System.out.println(" 13. Shuffle between videos within the same list");
            System.out.println(" 14. Shuffle videos accross all lists");
            System.out.println(" 15. Delete video from any list");
            System.out.println(" 16. Exit");

            choose = input.nextInt();
        	  	}catch(Exception e) {
               		System.out.println("Please enter num");
               	}
            switch (choose) {
                case 1:
                    main.printList();
                    break;

                case 2: //do not read 
                    System.out.println("Enter the name of the new list");
                    input.nextLine();
                    String newListName = input.nextLine();
                    DoublyLinkedList newList = new DoublyLinkedList();
                    newList.listname = newListName;
                    main.append(newList);

                    System.out.println("Do you want to add a new video to " + newListName
                            + " list? (answer with yes or no)");
                    //input.nextLine();
                    String answer = input.nextLine();
                    if (answer.equals("Yes") || answer.equals("yes")) {
                        do {
                            System.out.println("Enter the video title: ");
                            String title = input.nextLine();
                            System.out.println("Enter the video id: ");
                            int id = input.nextInt();
                            System.out.println("Enter the video author: ");
                            input.nextLine();
                            String author = input.nextLine();
                            System.out.println("Enetr the video category: ");
                            String category = input.nextLine();
                            System.out.println("Enter the number of hits(views): ");
                            int hits = input.nextInt();
                            System.out.println("Enter the video size: ");
                            int size = input.nextInt();

                            System.out.println("Enter the video URL(Link) ");
                            input.nextLine();
                            String link = input.nextLine();
                            System.out.println("Input the key word");
                            String key = input.nextLine();
                            newList.addFirst(new DNode(title, id, author, category, hits,
                                    size, link, key));
                            System.out.println("The " + title + " video added successfully "
                                    + "to " + newList.listname + " list");
                            System.out.println("Do you want to add another video");
                            answer = input.nextLine();
                        } while (!(answer.equalsIgnoreCase("no")));
                    } else {
                        System.out.println("Ok, you can add video whenever you want");
                    }
                    break;
                case 3:
                    System.out.println("Please enter the name of the list you want to delete: ");
                    input.nextLine();
                    String dl = input.nextLine();
                    DoublyLinkedList delList = searchList(favourites, dl);

                    main.deleteNode(favourites, delList);
                    //System.out.println("Done............");
                    main.printList();

                    break;

                case 4:
                    System.out.println("Please enter the video you want to search: ");
                    input.nextLine();
                    String sevideo = input.nextLine();

                    ListsSearch(history, favourites, sevideo);
                    System.out.println(history.header.next.videoTitle+"\n"+
                            history.header.next.next.videoTitle+"\n"+
                            history.header.next.next.next.videoTitle+"\n");
                    break;
                case 5:
                    try {
                        System.out.println("Enter the list name: ");
                        input.nextLine();
                        String listName = input.nextLine();

                        DNode node = searchNodeList(favourites, listName);

                        if (node != null) {

                            System.out.println("Please enter the video you want to search: ");
                            String videoName = input.nextLine();

                            DNode videoSearch = node.next;
                            DNode myVideos = search(videoSearch, videoName);
                            ///////////
                            DNode nxt = myVideos.next;
                            DNode prv = myVideos.prev;

                            if (myVideo != null) {
                                System.out.println("The Result: ");
                                System.out.println("Video title: " + myVideos.videoTitle);
                                System.out.println("Video ID: " + myVideos.videoID);
                                System.out.println("Video author: " + myVideos.authoringUser);
                                System.out.println("Video category: " + myVideos.category);
                                System.out.println("Video hits: " + myVideos.numberOfHits);
                                System.out.println("Video URL: " + myVideos.url);
                                System.out.println("Video keyword: " + myVideo.size);

                                System.out.println("Do you want to watch the video? answer with yes or no");
//			    
                                String ans = input.nextLine();

                                if (ans.equalsIgnoreCase("yes")) {

                                    System.out.println(myVideos.videoTitle + " is running now...");

                                    for (int j = 1; j < 3; j++) {

                                        System.out.println(j + "sec");
                                    }
                                    System.out.println("The video has finished!");
                                    history.addFirst(myVideos);

                                    int p;
                                    do {
                                        //	System.out.println(nxt.next+"--------------------");

                                        System.out.println("enter vido u want to watch:  ");
                                        System.out.println("1- next");
                                        System.out.println("2- prev");
                                        System.out.println("3- no videos");

                                        p = input.nextInt();

                                        if (p == 1) {
                                            if (nxt.videoTitle != null) {
                                                System.out.println(nxt.videoTitle + "  The video is running now...........");
                                                for (int j = 1; j < 3; j++) {
                                                    System.out.println(j + "sec");

                                                }
                                                System.out.println("Finished");
                                                nxt = nxt.next;
                                                history.addFirst(nxt);

                                            } else {
                                                System.out.println("------------The end of the list");
                                                break;
                                            }

                                            /////////////////////
                                        } else if (p == 2) {
                                            if (prv.videoTitle != null) {
                                                System.out.println(prv.videoTitle + " is running now........");
                                                for (int j = 1; j < 3; j++) {
                                                    System.out.println(j + "sec");

                                                }
                                                System.out.println("The video has finished..");
                                                history.addFirst(nxt);
                                                prv = prv.prev;
                                            } else {
                                                System.out.println("------------The end of the list");
                                                break;
                                            }
                                        } else {
                                            System.out.println("Ok, you can watch any video when you want...");
                                        }

                                    } while (p != 3);

                                }
                            }
                        }
                    } catch (Exception e) {
                        System.out.println("Enter a vaild input");
                    }
                    System.out.println(history.header.next.videoTitle+"\n"+
                            history.header.next.next.videoTitle+"\n"+
                            history.header.next.next.next.videoTitle+"\n");
                    break;

                case 6:
                    //System.out.println(" If You Want To Add video To any List ");
                    System.out.println(" Please choose the list That you want to add video to it :");
                    // lists.printList();
                    input.nextLine();
                    String s = input.nextLine();

                    if (s.equalsIgnoreCase("Favourite") || s.equalsIgnoreCase("favourites")) {
                        System.out.println(" Enter The video title : ");
                        //input.nextLine();
                        String titleVideo = input.nextLine();
                        System.out.println(" Enter the video ID : ");
                        // input.nextInt();
                        int idVideo = input.nextInt();
                        System.out.println(" Enter the video auther : ");
                        input.nextLine();
                        String autherName = input.nextLine();
                        System.out.println(" Enter the video category : ");
                        // input.nextLine();
                        String categoryVideo = input.nextLine();
                        System.out.println(" Enter the number of hits(views) : ");
                        //input.nextInt();
                        int hitsVideo = input.nextInt();
                        System.out.println(" Enter the video size : ");
                        //input.nextInt();
                        int sizeOfVideo = input.nextInt();
                        System.out.println(" Enter the video URL(Link) : ");
                        input.nextLine();
                        String linkOfVideo = input.nextLine();
                        System.out.println(" Enter the video keyword");
                        String keyWord = input.nextLine();
                        favourites.addLast(new DNode(titleVideo, idVideo, autherName, categoryVideo, hitsVideo, sizeOfVideo, linkOfVideo, keyWord));
                        //favourites.addDNode(new DNode(titleVideo, idVideo, autherName, categoryVideo, hitsVideo, sizeOfVideo, linkOfVideo), 12);
                        // System.out.println("the video added successfully");
                        System.out.println("The " + titleVideo + " video added successfully to Favourite List");
                    } else if (s.equalsIgnoreCase("watch Later") || s.equalsIgnoreCase("watchlater")) {
                        System.out.println(" Enter The video title : ");
                        //input.nextLine();
                        String titleVideo = input.nextLine();
                        System.out.println(" Enter the video ID : ");
                        // input.nextInt();
                        int idVideo = input.nextInt();
                        System.out.println(" Enter the video auther : ");
                        input.nextLine();
                        String autherName = input.nextLine();
                        System.out.println(" Enter the video category : ");
                        // input.nextLine();
                        String categoryVideo = input.nextLine();
                        System.out.println(" Enter the number of hits(views) : ");
                        //input.nextInt();
                        int hitsVideo = input.nextInt();
                        System.out.println(" Enter the video size : ");
                        //input.nextInt();
                        int sizeOfVideo = input.nextInt();
                        System.out.println(" Enter the video URL(Link) : ");
                        input.nextLine();
                        String linkOfVideo = input.nextLine();
                        System.out.println(" Enter the video key word");
                        String keyWord = input.nextLine();
                        watchLater.addLast(new DNode(titleVideo, idVideo, autherName, categoryVideo, hitsVideo, sizeOfVideo, linkOfVideo, keyWord));
                        //System.out.println("the video added successfully");
                        System.out.println("The " + titleVideo + " video added successfully to WatchLater List");

                    } else if (s.equalsIgnoreCase("History")) {
                        System.out.println("You can not add any videos to history list"
                                + " the videos you watch go automaticaly to history list");

                    } else {

                        DoublyLinkedList searchedList = searchList(favourites, s);
                        if (searchedList != null) {
                            System.out.println(" Enter The video title : ");
                            //input.nextLine();
                            String titleVideo = input.nextLine();
                            System.out.println(" Enter the video ID : ");
                            // input.nextInt();
                            int idVideo = input.nextInt();
                            System.out.println(" Enter the video auther : ");
                            input.nextLine();
                            String autherName = input.nextLine();
                            System.out.println(" Enter the video category : ");
                            // input.nextLine();
                            String categoryVideo = input.nextLine();
                            System.out.println(" Enter the number of hits(views) : ");
                            //input.nextInt();
                            int hitsVideo = input.nextInt();
                            System.out.println(" Enter the video size : ");
                            //input.nextInt();
                            int sizeOfVideo = input.nextInt();
                            System.out.println(" Enter the video URL(Link) : ");
                            input.nextLine();
                            String linkOfVideo = input.nextLine();
                            System.out.println(" Enter the video key word");
                            String keyWord = input.nextLine();
                            //System.out.println("the video added successfully");
                            searchedList.addLast(new DNode(titleVideo, idVideo,
                                    autherName, categoryVideo, hitsVideo, sizeOfVideo, linkOfVideo, keyWord));
                            System.out.println("The " + titleVideo + " video added successfully to "
                                    + searchedList.listname + " List");
                        }
                    }
                    break;
                case 7:
                    System.out.println("PLease choose the list that you want to show her video:");
                    main.printList();
                    input.nextLine();
                    String name = input.nextLine();
                    if (name.equalsIgnoreCase("favourite") || name.equalsIgnoreCase("favourites")) {
                        System.out.println("I will show you all the video in favourite list : ");
                        System.out.println("");
                        favourites.playList2();
                    } else if (name.equalsIgnoreCase("watch later") || name.equalsIgnoreCase("watchlater")) {
                        System.out.println("I will show you all the video in watch later list : ");
                        System.out.println("");
                        watchLater.printList();
                    } else if (name.equalsIgnoreCase("history")) {
                        
                            System.out.println("You did not watch any video yet");
                    
                        
                    } else {
                        DoublyLinkedList myList = searchList(favourites, name);

                        if (myList != null) {
                            myList.printList();
                        }
                    }
                    break;
                case 8:
                    System.out.println("Enter list name: ");
                    input.nextLine();
                    String yourList = input.nextLine();
                    if (yourList.equalsIgnoreCase("history")) {
                        System.out.println("You can not relocate videos in the history list");
                    } else {
                        DoublyLinkedList llist = searchList(favourites, yourList);
                        if (llist != null) {
                            System.out.println("First, we will show you the videos you have"
                                    + " in " + llist.listname);

                            llist.printList();
                        }
                        //DNode nody = searchNodeList(favourites, yourList);
                        if (llist != null) {
                            System.out.println("Please enter the video you want to relocate: ");
                            String videoName = input.nextLine();

                            System.out.println("Choose the new position for the video: ");
                            System.out.println("1- In the last of the list: ");
                            System.out.println("2- In the first of the list: ");
                            System.out.println("3- An index at the list: ");
                            int x = input.nextInt();

                            switch (x) {
                                case 1:
                                    if (llist.header.next != null) {

                                        DNode myVideoo = search(llist.header.next, videoName);
                                        llist.deleteNod(llist.header.next, myVideoo);
                                        llist.addLast(myVideoo);
                                        llist.printList(llist.header);

                                    }
                                    break;
                                case 2:

                                    if (llist.header.next != null) {

                                        DNode myVideoo = search(llist.header.next, videoName);
                                        llist.deleteNod(llist.header.next, myVideoo);
                                        llist.addFirst(myVideoo);
                                        llist.printList(llist.header);

                                    }

                                    break;

                                case 3: {
                                    System.out.println("The size of " + llist.listname + ""
                                            + " is " + llist.size + "(Starts from 0 1 ...)");
                                    System.out.println("Enter the index you want to change"
                                            + " the video location to it: ");
                                    int location = input.nextInt();
                                    if (location > llist.size || location < 0) {
                                        System.out.println("Enter a vaild index");
                                    } else {
                                        if (llist.header.next != null) {

                                            DNode myVideoo = search(llist.header.next, videoName);
                                            llist.deleteNod(llist.header.next, myVideoo);
                                            llist.addDNode(myVideoo, location);
                                            llist.printList(llist.header);

                                        }

                                    }
                                }
                                break;
                                default: {
                                    System.out.println("Enetr a number between 1 and 3");
                                }
                            }
                        }
                    }
                    break;
                case 9:

                    try {
                        System.out.println("From where want want to relocate the video:    ");

                        input.nextLine();
                        String from = input.nextLine();
                        DoublyLinkedList fromList = searchList(favourites, from);
                        if (fromList == null) {
                            break;
                        }

                        String str = "history";
                        if (from.toLowerCase().equalsIgnoreCase(str)) {
                            System.out.println("You cant relocate videoes into the history!");
                            break;
                        }

                        System.out.println("Enter the name of the new list    ");

                        String Into = input.nextLine();

                        DoublyLinkedList IntoList = searchList(favourites, Into);
                        String str1 = "history";
                        if (Into.toLowerCase().equalsIgnoreCase(str)) {
                            System.out.println("You cant relocate videoes into the history!");
                            break;
                        }

                        if (fromList.header.next != null && IntoList.header.next != null) {
                            System.out.println("Please enter the video you want to relocate: ");
                            String relocateVideo = input.nextLine();

                            DNode delVideo = search(fromList.header.next, relocateVideo);

                            fromList.deleteNod(fromList.header.next, delVideo);
                            System.out.println("");
                            fromList.printList(fromList.header.next);
                            System.out.println("");
                            IntoList.addLast(delVideo);

                            IntoList.printList(IntoList.header.next);

                        }
                    } catch (NullPointerException e) {
                        System.out.println("Invalid input :( ");
                    }
                    break;
                case 10:
                    System.out.println(" please enter the name of the video "
                            + "that you want to copied it : ");
                    input.nextLine();
                    String copyVideo = input.nextLine();
                    DNode copy = search(favourites.header.next, copyVideo);
                    if (copy != null) {
                        System.out.println(" please write the name of the list"
                                + " that you want to copied video to it :");
                        String listcopy = input.nextLine();
                        if (listcopy.equalsIgnoreCase("history")) {
                            System.out.println("Can not copy any video to History list(videos"
                                    + " go automatically there when you watch them");
                        } else {
                            DoublyLinkedList copylist = searchList(favourites, listcopy);

                            if (copylist != null) {
                                copylist.addLast(copy);
                                System.out.println(" this video " + copyVideo
                                        + " copied to this list " + listcopy);

                            }
                        }
                    }
                    break;
                case 11:
                    System.out.println("Enter the name of the list you want to "
                            + "play it in order");
                    input.nextLine();
                    String playList = input.nextLine();
                    if (playList.equalsIgnoreCase("favourite") || playList.equalsIgnoreCase("favourites")) {
                        favourites.playList();
                    } else if (playList.equalsIgnoreCase("watchlater") || playList.equalsIgnoreCase("watch later")) {
                        watchLater.playList();
                    } else {
                        DoublyLinkedList play = searchList(favourites, playList);
                        if (play != null) {
                            play.playList();
                        }

                    }
                    break;

                case 12:
                    System.out.println("Enter the name of list you want to reversed");
                    input.nextLine();
                    String reversedList = input.nextLine();
                    if (reversedList.equalsIgnoreCase("favourite") || reversedList.equalsIgnoreCase("favourites")) {
                        System.out.println("The original List");
                        System.out.println("");
                        favourites.playList2();
                        favourites.reverse();
                        System.out.println("");
                        System.out.println("The reversed List is");
                        System.out.println("");
                        favourites.playList2();

                    } else if (reversedList.equalsIgnoreCase("watchLater")
                            || reversedList.equalsIgnoreCase("watch later")) {
                        System.out.println("The original List");
                        System.out.println("");
                        watchLater.playList2();
                        watchLater.reverse();
                        System.out.println("");
                        System.out.println("The reversed List is");
                        System.out.println("");
                        watchLater.playList2();
                    } else if (reversedList.equalsIgnoreCase("history")) {
                        System.out.println("You can not reverse History list");
                    } else {
                        DoublyLinkedList reverse = searchList(favourites, reversedList);
                        if (reverse != null) {
                            System.out.println("The original List");
                            System.out.println("");
                            reverse.playList2();
                            reverse.reverse();
                            System.out.println("");
                            System.out.println("The reversed List is");
                            System.out.println("");
                            reverse.playList2();
                        }
                    }

                    break;
                case 13:
                    System.out.println("Enter the name of the list that you want to shuffle her videos :");
                    input.nextLine();
                    String shuffle = input.nextLine();
                    DoublyLinkedList shuffleList = searchList(main.head, shuffle);
                    if (shuffleList != null) {
                        System.out.println("---------Before Shuffleing--------------------------------");
                        shuffleList.playList2();
                        System.out.println("---------After Shuffleing--------------------------------");
                        DNode k = shuffleList.rearrange(shuffleList.header.next);
                        shuffleList.playList2();
                        //shuffleList.display(k);
                    }
                    break;

                case 14:
                    DoublyLinkedList v = favourites; // favourite
                    DoublyLinkedList z = v.Next;// history
                    DoublyLinkedList p = z.Next; // watch later it statrt print after it print 
                    DoublyLinkedList ff = p.Next; // myvideo this  is work well                    
                    DoublyLinkedList w = ff.Next;// random   this  is work well 
                    v.header = main.head.header;
                    v.header.prev = null;
                    v.header.next = main.head.header.next;
                    v.trailer.next = z.header.next;
                    z.header.next.prev = v.trailer;
                    z.trailer.next = p.header.next;
                    p.header.next.prev = z.trailer;
                    p.trailer.next = ff.header.next;
                    ff.header.next.prev = p.trailer;
                    ff.trailer.next = w.header.next;
                    w.header.next.prev = ff.trailer;
                    w.trailer.next = null;

                    v.rearrange(v.header.next);
                    v.display(v.header);
                    //z.rearrange(z.header.next);
                    //z.display(z.header);
                    p.rearrange(p.header.next);
                    p.display(p.header.next);
                    ff.rearrange(ff.header.next);
                    ff.display(ff.header);
                    w.rearrange(w.header.next);
                    w.display(w.header);
                    break;
                case 15:

                    System.out.println("Enter list name: ");
                    input.nextLine();
                    String listname = input.nextLine();
                    DoublyLinkedList listt = searchList(favourites, listname);
                    if (listt != null) {
                        //DNode nody = searchNodeList(favourites, yourList);
                        System.out.println("Please enter the video you want to delete: ");
                        String delV = input.nextLine();

                        if (listt.header.next != null) {

                            DNode myVideo1 = search(listt.header.next, delV);

                            listt.deleteNod(listt.header.next, myVideo1);
                        }
                    }
                    break;
                case 16:
                    System.out.println("Thank you for using our appliciation");
                    break;

            }
      
        	       
         
        	       } while (choose != 16);
        
    }

    static void SearchInList(DoublyLinkedList header, String data, DNode head) {
        DoublyLinkedList current = header;

        if (current == null) {
            System.out.println("The List is empty!");
        } else {

            DNode temp = head;
            if (temp == null) {
                System.out.println("No Elements in the list!");
            } else {
                while (temp != null) {
                    if (temp.videoTitle == data || temp.keyWord == data) {
                        System.out.println("Serach Result for " + data + " is:"
                                + "\n videoID: " + temp.videoID + " \nNumOfHits: " + temp.numberOfHits + " \nURL is: " + temp.url + " \nThe size:" + temp.size + "\nThe keyword is: " + temp.keyWord);
                        return;
                    }
                    if (temp.next != null) {
                        temp = temp.next;
                    } else {
                        break;
                    }

                }

            }
            System.out.println("No Results!");

        }
    }

}
