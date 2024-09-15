import java.util.Formatter;
class Ex7 
{
        public static void main(String[] args) {
            Formatter fmt = new Formatter();
    
            fmt.format("%-15s %-15s %-15s%n", "ID", "Name", "Age");
            fmt.format("%-15s %-15s %-15s%n", "1", "Alice", "23");
            fmt.format("%-15s %-15s %-15s%n", "2", "Bob", "30");
            fmt.format("%-15s %-15s %-15s%n", "3", "Charlie", "25");
    
            System.out.println(fmt);
            fmt.close();
        }
    }
        

