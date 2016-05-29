/**
 * Created by DarkPrince on 11/18/2015.
 */
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FriendShipAppTest {
    private Map<String, List<String>> friendGraph;
    private FriendShipApp friendShipApp;

    @Before
    public void setUp() throws Exception {
        Map<String, List<String>> friendGraph = new HashMap<>();
        this.friendGraph = friendGraph;
        this.friendShipApp = new FriendShipApp(friendGraph);
    }

    @Test
    public void testLinkFriends() {
        //expected {A=[B], B=[A]}
        String friend1 = "A", friend2 = "B";
        this.friendGraph = this.friendShipApp.linkFriends(friend1, friend2);
        assertTrue(this.friendGraph.containsKey(friend1));
        assertTrue(this.friendGraph.get(friend1).contains(friend2));
        assertTrue(this.friendGraph.containsKey(friend2));
        assertTrue(this.friendGraph.get(friend2).contains(friend1));
    }

    @Test
    public void testUnLinkFriends() {
        String friend1 = "A", friend2 = "B";
        this.friendGraph = this.friendShipApp.linkFriends(friend1, friend2);
        this.friendGraph = this.friendShipApp.unlinkFriends(friend1, friend2);
        assertTrue(this.friendGraph.containsKey(friend1));
        assertTrue(this.friendGraph.containsKey(friend2));
        assertFalse(this.friendGraph.get(friend1).contains(friend2));
        assertFalse(this.friendGraph.get(friend2).contains(friend1));
    }
}