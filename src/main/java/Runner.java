import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by DarkPrince on 11/19/2015.
 */
public class Runner {
    public static void main(String[] args) {
        Map<String, List<String>> friendGraph = new HashMap<>();
        FriendShipApp friendShipApp = new FriendShipApp(friendGraph);
        friendGraph = friendShipApp.linkFriends("A", "B");
        System.out.println(friendGraph);
        friendGraph = friendShipApp.linkFriends("C", "D");
        System.out.println(friendGraph);
        friendGraph = friendShipApp.linkFriends("A", "C");
        System.out.println(friendGraph);
        System.out.println("Friends of \"A\" are " +friendShipApp.getFriends("A"));

        friendGraph = friendShipApp.unlinkFriends("A", "C");
        System.out.println(friendGraph);
        System.out.println("Friends of \"A\" are " +friendShipApp.getFriends("A"));
    }
}
