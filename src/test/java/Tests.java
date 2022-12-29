import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import observer.ConcreteMember;
import observer.GroupAdmin;
import observer.UndoableStringBuilder;

import static org.junit.jupiter.api.Assertions.*;

public class Tests {
    public static final Logger logger = LoggerFactory.getLogger(Tests.class);
    // stub method to check external dependencies compatibility
    @Test
    public void test(){
        String s1 = "Alice";
        String s2 = "Bob";

        logger.info(()->JvmUtilities.objectFootprint(s1));

        logger.info(()->JvmUtilities.objectFootprint(s1,s2));

        logger.info(()->JvmUtilities.objectTotalSize(s1));

        logger.info(() -> JvmUtilities.jvmInfo());
    }

    @Test
    void register() {
        GroupAdmin groupAdmin = new GroupAdmin();
        ConcreteMember member1 = new ConcreteMember("roy");
        ConcreteMember member2 = new ConcreteMember("yuval");

        groupAdmin.register(member1);
        groupAdmin.register(member2);
        assertTrue(groupAdmin.getMembers().contains(member1));
        assertTrue(groupAdmin.getMembers().contains(member2));

        groupAdmin.register(null);
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

        groupAdmin.unregister(null);
        assertEquals(1, groupAdmin.getMembers().size());

        ConcreteMember member4 = new ConcreteMember("noam");
        groupAdmin.unregister(member4);
        assertEquals(1, groupAdmin.getMembers().size());

        groupAdmin.unregister(member2);
        assertEquals(0, groupAdmin.getMembers().size());
    }

    @Test
    void testupdate() {
        GroupAdmin groupAdmin = new GroupAdmin();
        ConcreteMember member1=new ConcreteMember("roy");
        groupAdmin.register(member1);
        groupAdmin.insert(0,"test");

        ConcreteMember member2 =new ConcreteMember("yuval");
        groupAdmin.register(member2);
        assertNotEquals(member1.getMemberusb().toString(),member2.getMemberusb().toString());
        groupAdmin.append(" update");
        assertEquals(member1.getMemberusb().toString(),member2.getMemberusb().toString());
    }
    @Test
    void update() {
        ConcreteMember member = new ConcreteMember("roy");
        ConcreteMember member2 = null;
        UndoableStringBuilder usb = new UndoableStringBuilder();
        member.update(usb);
        usb.append("Hello");
        assertEquals("Hello", member.getMemberusb().toString());
        usb.append(" world!");
        assertEquals("Hello world!", member.getMemberusb().toString());

    }
}
