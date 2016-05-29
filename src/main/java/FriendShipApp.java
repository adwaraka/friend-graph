/**
 * Created by DarkPrince on 11/18/2015.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Create a friendship chart
 * Run it using this command -> java -cp com.myproject.myapp-1.0-SNAPSHOT.jar Runner
 */
public class FriendShipApp {

    Map<String, List<String>> friendGraph;

    public FriendShipApp(Map<String, List<String>> friendGraph) {
        this.friendGraph = friendGraph;
    }

    public Map<String, List<String>> linkFriends(String friend1, String friend2) {
        if ((null == friend1) || (null == friend2)) {
            System.out.println("null is not valid");
        }
        else if ((friend1.equalsIgnoreCase("")) || (friend2.equalsIgnoreCase(""))
                && (friend1.equalsIgnoreCase(friend2))) {
            System.out.println("Invalid");
        }
        else {
            if (!this.friendGraph.containsKey(friend1)){
                this.friendGraph.put(friend1, new ArrayList<String>());
            }
            if (!this.friendGraph.containsKey(friend2)){
                this.friendGraph.put(friend2, new ArrayList<String>());
            }
            if ((!this.friendGraph.get(friend1).contains(friend2)
                    && (!this.friendGraph.get(friend2).contains(friend1)))) {
                List<String> getFriends = this.friendGraph.get(friend1);
                getFriends.add(friend2);
                this.friendGraph.put(friend1, getFriends);
                List<String> getFriends2 = this.friendGraph.get(friend2);
                getFriends2.add(friend1);
                this.friendGraph.put(friend2, getFriends2);
            }
            //System.out.println(this.friendGraph);
        }
        return this.friendGraph;
    }

    public Map<String, List<String>> unlinkFriends(String friend1, String friend2) {
        if ((null == friend1) || (null == friend2)) {
            System.out.println("null is not valid");
        }
        else if ((friend1.equalsIgnoreCase("")) || (friend2.equalsIgnoreCase(""))
                && (friend1.equalsIgnoreCase(friend2))) {
            System.out.println("Invalid");
        }
        else {
            if (!this.friendGraph.containsKey(friend1)){
                System.out.println("Invalid - friend1 does not exist");
            }
            if (!this.friendGraph.containsKey(friend2)){
                System.out.println("Invalid - friend2 does not exist");
            }
            if ((this.friendGraph.get(friend1).contains(friend2)
                    && (this.friendGraph.get(friend2).contains(friend1)))) {
                List<String> getFriends = this.friendGraph.get(friend1);
                getFriends.remove(friend2);
                this.friendGraph.put(friend1, getFriends);
                List<String> getFriends2 = this.friendGraph.get(friend2);
                getFriends2.remove(friend1);
                this.friendGraph.put(friend2, getFriends2);
            }
            else {
                System.out.println("Invalid - friend1 and friend2 friendship does not exist");
            }
            //System.out.println(this.friendGraph);
        }
        return this.friendGraph;
    }

    public List<String> getFriends(String person) {
        if (this.friendGraph.containsKey(person)) {
            return this.friendGraph.get(person);
        } else {
            System.out.println("No friends!");
            return null;
        }
    }
}