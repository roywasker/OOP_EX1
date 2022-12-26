import observer.ConcreteMember;
import observer.GroupAdmin;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GroupAdminTest {

    @Test
    void register() {
        GroupAdmin groupAdmin = new GroupAdmin();
        ConcreteMember member1 = new ConcreteMember("roy");
        ConcreteMember member2 = new ConcreteMember("yuval");

        groupAdmin.register(member1);
        groupAdmin.register(member2);
        assertTrue(groupAdmin.getMembers().contains(member1));
        assertTrue(groupAdmin.getMembers().contains(member2));

        ConcreteMember member3 = null;
        groupAdmin.register(member3);
        assertEquals(2, groupAdmin.getMembers().size());

        groupAdmin.register(member1);
        assertEquals(2, groupAdmin.getMembers().size());
        assertTrue(groupAdmin.getMembers().contains(member1));
        assertTrue(groupAdmin.getMembers().contains(member2));

    }

    @Test
    void unregister() {
        GroupAdmin groupAdmin = new GroupAdmin();
        ConcreteMember member1 = new ConcreteMember("roy");
        ConcreteMember member2 = new ConcreteMember("yuval");

        groupAdmin.register(member1);
        groupAdmin.register(member2);
        groupAdmin.unregister(member1);
        assertFalse(groupAdmin.getMembers().contains(member1));
        assertTrue(groupAdmin.getMembers().contains(member2));

        ConcreteMember member3 = null;
        groupAdmin.unregister(member3);
        assertEquals(1, groupAdmin.getMembers().size());

        ConcreteMember member4 = new ConcreteMember("noam");
        groupAdmin.unregister(member4);
        assertEquals(1, groupAdmin.getMembers().size());

        groupAdmin.unregister(member2);
        assertEquals(0, groupAdmin.getMembers().size());
    }

    @Test
    void insert() {
        GroupAdmin groupAdmin = new GroupAdmin();
        ConcreteMember member1 = new ConcreteMember("roy");
        groupAdmin.register(member1);

        groupAdmin.insert(-1, "test");
        assertEquals("", member1.getMemberusb().toString());

        groupAdmin.insert(100, "test");
        assertEquals("", member1.getMemberusb().toString());

        groupAdmin.insert(0, "");
        assertEquals("", member1.getMemberusb().toString());

        groupAdmin.insert(0, null);
        assertEquals("", member1.getMemberusb().toString());
    }

    @Test
    void append() {
    }

    @Test
    void delete() {
    }

    @Test
    void undo() {
    }
}