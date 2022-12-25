package observer;

public class GroupAdmin implements Sender{


    /**
     * methods to register new member
     * @param obj  member to register
     */
    @Override
    public void register(Member obj) {
    }

    /**
     * methods to unregister new member
     * @param obj member to unregister
     */
    @Override
    public void unregister(Member obj) {

    }

    /**
     * Inserts the string into this character sequence.
     * @param offset the string to insert.
     * @param obj the index of the wanted position to insert the string.
     */
    @Override
    public void insert(int offset, String obj) {
    }

    /**
     * Appends the specified string to this character sequence.
     * @param obj The string you want to append.
     */
    @Override
    public void append(String obj) {
    }

    /**
     * Removes the characters in a substring of this sequence.
     * @param start index of the start of the substring to delete.
     * @param end  index of the end of the substring to delete.
     */
    @Override
    public void delete(int start, int end) {

    }

    /**
     * Erases the last change done to the document, reverting it to an older state.
     */
    @Override
    public void undo() {
    }
}
