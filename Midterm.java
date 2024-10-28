import java.util.Stack;
import java.util.Scanner;

class BrowserHistory {
    private Stack <String> historyStack;
    private Stack <String> forwardStack;

    public BrowserHistory () {
        historyStack = new Stack <> ();
        forwardStack = new Stack <> ();
    }

    public void visit(String url) {
        historyStack.push (url);
        forwardStack.clear();
        System.out.println ("Visited:" + url);
    }

    public void back () {
        if (historyStack.isEmpty()) {
            System.out.println ("No previous pages.");
        } else {
            forwardStack.push(historyStack.pop());
            System.out.println ("Went back to:" + (historyStack.isEmpty() ? "None": historyStack.peek()));
        }
    }

    public void deleteHistory (){
        System.out.println ("Browser History:");
        for (String url: historyStack) {
            System.out.println (url);
        }
    }
}

public class Midterm {
    public static void main (String [] args) {
        BrowserHistory browser = new BrowserHistory ();
        Scanner scanner = new Scanner (System.in);

        while (true) {
            System.out.println ("\nBrowser History:");
            System.out.println ("1. Visit New Page");
            System.out.println ("2. Go Back to Last Page");
            System.out.println ("3. Delete All History");
            System.out.println ("4. Exit");
            System.out.println ("Enter your choice:");

            int choice = scanner.nextInt ();
             scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println ("Enter New Page");
                    String url = scanner.nextLine ();
                    browser.visit (url);
                    System.out.println ("Page added to history");
                    break;
                case 2:
                    browser.back();
                    break;

                case 3:
                    browser.deleteHistory();
                    break;
                case 4:
                    System.out.println ("Exiting.....");
                    return;
                    default:
                        System.out.println ("Invalid Choice. Please choose again.");
            }
        }
    }
}