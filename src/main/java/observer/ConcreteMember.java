package observer;

public class ConcreteMember implements Member
{
    // Data members
    private UndoableStringBuilder memberUSB;
    private String name;

    // Constructor
    /**
     * A constructor that gets a name for the specific new Concrete member,
     * and a creates a new UndoableStringBuilder object.
     */
    public ConcreteMember(String memberName)
    {
        this.memberUSB = new UndoableStringBuilder();
        this.name = memberName;
    }

    /**
     * An empty constructor.
     */
    public ConcreteMember()
    {
        this.memberUSB = new UndoableStringBuilder();
        this.name = "this member";
    }

    /**
     * getter method for the Concrete member's name
     * @return ConcreteMember's name
     */
    public String getName()
    {
        return name;
    }

    /**
     * this method update this specific Concrete member, that is linked to
     * the Group admin, with the new changes that applied for the UndoableStringBuilder.
     * @param usb the UndoableStringBuilder object.
     */
    public void update(UndoableStringBuilder usb)
    {
        if(this.memberUSB != usb)
        {
            this.memberUSB = usb; // there is no need for this step everytime because it is shallow copy
        }
        System.out.println("The member " + this.name + " got the update.");
    }

    /**
     * this is a toString method that uses the toString method
     * of the UndoableStringBuilder object.
     * it prints the last change that applied in the UndoableStringBuilder.
     * @return String with details about this specific Concrete member.
     */
    public String toString()
    {
        String s = "Member's name: " + this.name + " , content of the UndoableStringBuilder right now is: "
                + this.memberUSB;
        return s;
    }

    /**
     * getter method for the Concrete member's UndoableStringBuilder attribute.
     * @return UndoableStringBuilder attribute of this specific member.
     */
    public UndoableStringBuilder getMemberusb()
    {
        return memberUSB;
    }
}
