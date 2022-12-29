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

        groupAdmin.register(member1); //register  2 member
        groupAdmin.register(member2);
        assertTrue(groupAdmin.getMembers().contains(member1));
        assertTrue(groupAdmin.getMembers().contains(member2));
        logger.info(()->JvmUtilities.objectFootprint(groupAdmin));

        groupAdmin.register(null); //try register member that point to null
        assertEquals(2, groupAdmin.getMembers().size());
        logger.info(()->JvmUtilities.objectFootprint(groupAdmin));


        groupAdmin.register(member1);  //try register member that already exists in groupadmin
        assertEquals(2, groupAdmin.getMembers().size());
        assertTrue(groupAdmin.getMembers().contains(member1));
        assertTrue(groupAdmin.getMembers().contains(member2));
        logger.info(()->JvmUtilities.objectFootprint(groupAdmin));

    }

    @Test
    void unregister() {
        GroupAdmin groupAdmin = new GroupAdmin();
        ConcreteMember member1 = new ConcreteMember("roy");
        ConcreteMember member2 = new ConcreteMember("yuval");

        groupAdmin.register(member1); //register  2 member and unregister one of them
        groupAdmin.register(member2);
        groupAdmin.unregister(member1);
        assertFalse(groupAdmin.getMembers().contains(member1));
        assertTrue(groupAdmin.getMembers().contains(member2));
        logger.info(()->JvmUtilities.objectFootprint(groupAdmin));


        groupAdmin.unregister(null); //try unregister member that point to null
        assertEquals(1, groupAdmin.getMembers().size());
        logger.info(()->JvmUtilities.objectFootprint(groupAdmin));


        ConcreteMember member4 = new ConcreteMember("noam"); //try unregister member that not in groupadmin
        groupAdmin.unregister(member4);
        assertEquals(1, groupAdmin.getMembers().size());
        logger.info(()->JvmUtilities.objectFootprint(groupAdmin));


        groupAdmin.unregister(member2); //try unregister member and let the groupadmin to be in size 0
        assertEquals(0, groupAdmin.getMembers().size());
        logger.info(()->JvmUtilities.objectFootprint(groupAdmin));

    }

    @Test
    void update() {

        //check if after change in usb the member get the change
        ConcreteMember member1 = new ConcreteMember("roy");
        ConcreteMember member2 = null;
        UndoableStringBuilder usb = new UndoableStringBuilder();
        member1.update(usb);
        usb.append("Hello");
        assertEquals("Hello", member1.getMemberusb().toString());
        usb.append(" world!");
        assertEquals("Hello world!", member1.getMemberusb().toString());
        logger.info(()->JvmUtilities.objectFootprint(member1));


        //check if after add new member to groupadmin he get the usb after update
        GroupAdmin groupAdmin = new GroupAdmin();
        groupAdmin.register(member1);
        groupAdmin.insert(0,"test");
        ConcreteMember member3 =new ConcreteMember("yuval");
        groupAdmin.register(member3);
        assertNotEquals(member1.getMemberusb().toString(),member3.getMemberusb().toString());
        groupAdmin.append(" update");
        assertEquals(member1.getMemberusb().toString(),member3.getMemberusb().toString());
        logger.info(()->JvmUtilities.objectFootprint(groupAdmin));

    }
}
