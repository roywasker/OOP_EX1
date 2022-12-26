package observer;


import java.util.Stack;

public class UndoableStringBuilder
{

    StringBuilder str;
    Stack<String> stack = new Stack<>();

    //constructor

    /**
     * This method is an empty constructor.
     */
    public UndoableStringBuilder()
    {
        str = new StringBuilder();
    }

    /**
     * This method is a constructor that gets a String.
     *
     * @param str string to initialize.
     */
    public UndoableStringBuilder(String str)
    {
        this.str = new StringBuilder(str);
        stack.push(this.str.substring(0));
    }

    /**
     * This method appends a string to the end of the character sequence.
     *
     * @param str The string you want to append.
     * @return the character sequence after the appends.
     */
    public UndoableStringBuilder append(String str)
    {
        this.str.append(str); // do append based on StringBuilder append method
        stack.push(this.str.substring(0)); // add the string after the append method to the stack
        return this;
    }

    /**
     * This method deletes a substring between the two indexes it receives.
     *
     * @param start index of the start of the substring to delete.
     * @param end   index of the end of the substring to delete.
     * @return the character sequence after the deletes.
     * @throws if start is negative, or greater than the end.
     */
    public UndoableStringBuilder delete(int start, int end)
    {
        if (end > str.length()) // if end is bigger than the string length set end to equal the string length
            end = str.length();
        if (start == end || str.length() == 0) // start = end or the string is empty, return the string without change
            return this;
        try
        {
            str.delete(start, end); // do delete based on StringBuilder delete method
            stack.push(str.substring(0)); // add the string after the deletion to the stack
        } catch (Exception e)
        {
            if (start < 0) // if start is smaller that 0 print error
                System.out.println("you entered " + start + " to start the substring");
            else
                System.out.println("you entered a start that is greater than the end"); // if start is bigger than end print error
            e.printStackTrace();
        }
        return this;
    }

    /**
     * This method insert a string into a character sequence in a specific position.
     *
     * @param offset the index of the wanted position to insert the string.
     * @param str    the string to insert.
     * @return the character sequence after the insert.
     * @throws if the offset is negative or bigger that the string length.
     */
    public UndoableStringBuilder insert(int offset, String str)
    {
        if (str == null) //check if str is null to return string without change
            return this;
        try
        {
            this.str.insert(offset, str); // do insert based on StringBuilder insert method
            stack.push(this.str.substring(0)); // add the string after the insert to the stack
        } catch (Exception e)
        {
            System.out.print("you entered " + offset + " for the start of the insert position"); // if start is not in the range of the string length print error
            System.out.println((offset > str.length()) ? " and its over the string length" : "");
            e.printStackTrace();
        }
        return this;
    }

    /**
     * This method replace a string in character sequence by start and end index.
     *
     * @param start the start index for the replace method.
     * @param end   the end index for the replace method.
     * @param str   the string to replace.
     * @return the character sequence after the swap.
     * @throws if start is negative, or greater than end or end is negative.
     */
    public UndoableStringBuilder replace(int start, int end, String str)
    {
        if (end > this.str.length()) // if end is bigger than the string length set end to string length
            end = this.str.length();
        try
        {
            this.str.replace(start, end, str); // do replace based on StringBuilder replace method
            stack.push(this.str.substring(0)); // add the string after the replacement to the stack
        } catch (Exception e)
        {
            if (start < 0) // if start is smaller than 0 print error
                System.out.println("you entered " + start + " for the start of the replace position");
            if (end < 0) // if end is smaller than 0 print error
                System.out.println("you entered " + end + " for the end of the replace position");
            if (start > end) // if start is bigger than end print error
                System.out.println("the start is bigger than the end");
            e.printStackTrace();
        }
        return this;
    }

    /**
     * This method replace the string from end to beginning.
     *
     * @return the character sequence after the swaps.
     */
    public UndoableStringBuilder reverse()
    {
        str.reverse(); // do reverse based on StringBuilder reverse method
        stack.push(str.substring(0)); // add the string after the reverse to the stack
        return this;
    }

    /**
     * This method cancels the last change made.
     *
     * @return the previous string.
     */
    public void undo()
    {
        try
        {

            String NewStr = stack.pop();
            if (NewStr.equals(this.str.toString()))
            { // check if the last value in the stack is equal to the current string
                NewStr = stack.pop();                 // if yes do another pop from the stack
            }

            str.replace(0, str.length(), NewStr); // do replace based on StringBuilder replace method
        } catch (Exception e)
        {
            str.replace(0, str.length(), "");
            System.out.println("The stack is empty and therefore, there isn't undo operations anymore.");
        }
    }

    /**
     * This method print the string.
     *
     * @return the current string.
     */
    public String toString()
    {
        return str.toString();
    }

}
