package edu.purdue.sankara2.todolist;
//Don't copy the package statement

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

/**
 * This Class is the data model of a todoitem (An entry of the todolist).
 * You need to implement 4 methods to return different Comparators.
 * A Comparator defines how two objects are compared. Comparators can be used for sorting a list.
 *
 * Search online to find (1) How to compare two date Strings in Java (HINT: Use SimpleDateFormat)
 *                           Note: The date String is in the format of "MM/dd/yy"
 *                       (2) How to compare two Strings alphabetically (String has a built-in method to do it)
 */

public class TodoItem implements Serializable{


    private String category;
    private String note;
    private String date;

    public TodoItem(String category, String note, String date) {
        this.category = category;
        this.note = note;
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    static Comparator<TodoItem> getClosestDueComparator() {
        return new Comparator<TodoItem>() {
            @Override
            public int compare(TodoItem item1, TodoItem item2) {
                //TODO: 1. Returns 1 if item2's due date is closer than item1's
                //         Returns -1 if item1's due date is closer than item2's
                //         Returns 0 if they have the same due date
                int result = 0;
                SimpleDateFormat d = new SimpleDateFormat("MM/dd/yy");
                try {
                     Date d1 = d.parse(item1.getDate());
                     Date d2 = d.parse(item2.getDate());
                    if(d1.before(d2) == true)
                    {
                        result = -1;
                    }
                    else if(d2.before(d1) == true)
                    {
                        result = 1;
                    }
                    else if(d1.compareTo(d2) == 0 && d2.compareTo(d1) == 0)
                    {
                        result = 0;
                    }
                    return result;
                } catch (ParseException e) {
                    e.printStackTrace();
                    return 0;
                }



            }
        };
    }

    static Comparator<TodoItem> getFarthestDueComparator() {
        return new Comparator<TodoItem>() {
            @Override
            public int compare(TodoItem item1, TodoItem item2) {
                //TODO: 2. Returns 1 if item1's due date is closer than item2's
                //         Returns -1 if item2's due date is closer than item1's
                //         Returns 0 if they have the same due date
                int result = 0;
                DateFormat d = new SimpleDateFormat("MM/dd/yy");
                try {
                    Date d1 = d.parse(item1.getDate());
                    Date d2 = d.parse(item2.getDate());
                     if(d1.before(d2) == true)
                    {
                        result = 1;
                    }
                    else if(d2.before(d1) == true)
                    {
                        result = -1;
                    }
                    else if(d1.compareTo(d2) == 0 && d2.compareTo(d1) == 0)
                     {
                         result = 0;
                     }
                    return result;
                } catch (ParseException e) {
                    e.printStackTrace();
                    return 0;
                }


            }
        };
    }

    static Comparator<TodoItem> getAtoZComparator() {
        return new Comparator<TodoItem>() {
            @Override
            public int compare(TodoItem item1, TodoItem item2) {
                //TODO: 3. Returns 1 if item1's note is alphabetically lager than item2's
                //         Returns -1 if item1's note is alphabetically smaller than item2's
                //         Returns 0 if they are equal
                int result = 0;
                if(item1.getNote().compareTo(item2.getNote()) < 0)
                {
                    result = -1;
                }
                else if(item1.getNote().compareTo(item2.getNote()) > 0)
                {
                    result = 1;
                }
                else if(item1.getNote().compareTo(item2.getNote()) == 0)
                {
                    result = 0;
                }

                return result;
            }
        };
    }

    static Comparator<TodoItem> getZtoAComparator() {
        return new Comparator<TodoItem>() {
            @Override
            public int compare(TodoItem item1, TodoItem item2) {
                //TODO: 4. Returns 1 if item1's note is alphabetically smaller than item2's
                //         Returns -1 if item1's note is alphabetically larger than item2's
                //         Returns 0 if they are equal
                int result = 0;
                if(item1.getNote().compareTo(item2.getNote()) < 0)
                {
                    result = 1;
                }
                else if(item1.getNote().compareTo(item2.getNote()) > 0)
                {
                    result = -1;
                }
                else if(item1.getNote().compareTo(item2.getNote()) == 0)
                {
                    result = 0;
                }

                return result;
            }
        };
    }

}
