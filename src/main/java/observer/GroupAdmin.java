package observer;

import java.util.ArrayList;
import java.util.List;

public class GroupAdmin implements Sender
{
    // Data members
    private UndoableStringBuilder usb;
    private ArrayList<Member> members;

    // Constructor
    /**
     * An empty constructor.
     */
    public GroupAdmin()
    {
        this.usb = new UndoableStringBuilder();
        this.members = new ArrayList<Member>();
    }

    /**
     * this method returns the Members attribute
     * @return ArrayList that contains all the members
     */
    public ArrayList<Member> getMembers()
    {
        return members;
    }

    /**
     * this method add a specific member to the Group admin.
     */
    public void register(Member obj)
    {
        if (obj == null ||members.contains(obj)==true){
        }else {
            this.members.add(obj);
            ConcreteMember cMember = (ConcreteMember) obj;
            String cName = ((ConcreteMember) obj).getName();
            System.out.println(cName + " is successfully registered to the group.");
        }
    }

    /**
     * this method removes a specific member from the Group admin.
     */
    public void unregister(Member obj)
    {
        if (obj == null){

        }else {
            obj.update(new UndoableStringBuilder()); // no longer points to the "usb" attribute
            this.members.remove(obj);
            ConcreteMember cMember = (ConcreteMember) obj;
            String cName = ((ConcreteMember) obj).getName();
            System.out.println(cName + " is no longer part of the group.");
        }
    }

    /**
     * this method operates the "update" method in ConcreteMember on
     * all the members that currently in the members list.
     */
    public void notifyMembers()
    {
        for (Member m:members)
        {
            m.update(this.usb);
        }
    }

    /**
     * This method insert a string into the "usb" attribute in a specific position.
     * Then notify to all the members on the members attribute.
     *
     * @param offset the index of the wanted position to insert the string.
     * @param obj the string to insert.
     *
     */
    public void insert(int offset, String obj)
    {
        usb.insert(offset, obj);
        notifyMembers();
    }

    /**
     * This method appends a string to the end of the "usb" attribute.
     * Then notify to all the members on the members attribute.
     * @param obj The string you want to append.
     */
    public void append(String obj)
    {
        usb.append(obj);
        notifyMembers();
    }

    /**
     * This method deletes a substring from the "usb" attribute, between the two indexes it receives.
     * Then notify to all the members on the members attribute.
     *
     * @param start index of the start of the substring to delete.
     * @param end   index of the end of the substring to delete.
     */
    public void delete(int start, int end)
    {
        usb.delete(start, end);
        notifyMembers();
    }

    /**
     * This method cancels the last change made in the "usb" attribute.
     * Then notify to all the members on the members attribute.
     */
    public void undo()
    {
        usb.undo();
        notifyMembers();
    }
}
