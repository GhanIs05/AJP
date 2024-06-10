import java.util.Scanner;
import java.io.*;

interface MySTack {
    public void push();
    public void pop();
    public void display();
}

class StackArray implements MySTack{
    final static int n = 5;
    int stack[] = new int[n];
    int top = -1;

    public void push() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            if(top == (n - 1)) {
                System.out.println("overflow");
                return;
            } else {
                int ele;
                System.out.print("Enter element: ");
                ele = Integer.parseInt(br.nextLine());
                stack[++top] = ele;
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void pop() {
        if(top < 0) {
            System.out.println("underflow");
            return;
        } else {
            int popped = stack[top];
            top--;
            System.out.println("Popped element: "+popped);
        }
    }


    public void display() {
        if(top < 0) {
            System.out.println("underflow");
            return;
        } else {
            String str = "";
            for(int i = 0; i<= top; i++) {
                str = str + " " + stack[i] + "<--";
            }
            System.out.println("Elements are: "+str);
        }
    }
}

class Link {
    public int data;
    public Link nextLink;
    
    public Link(int d) {
        data = d;
        nextLink = null;
    }
    
    public void printLink() {
        System.out.print("-->"+data);
    }
}

class StackLink {
    private Link first;
    
    public StackLink() {
        first = null;
    }
    
    public boolean isEmpty() {
        return first == null;
    }
    
    public void push() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter element: ");
            int ele = Integer.parseInt(br.readLine());
            Link link = new Link(ele);
            link.nextLink = first;
            first = link;
            
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    
    public Link delete() {
        Link temp = first;
        try {
            
            first = first.nextLink;
        } catch(NullPointerException e) {
            e.printStackTrace();
        }
        return temp;
    }
    public void pop() {
        try {
            Link deletedLink = delete();
            System.out.println("Deleted element is "+deletedLink.data);
        } catch(NullPointerException e) {
            e.printStackTrace();
        }
    }
    
    public void display() {
        if(first == null) {
            System.out.println("Empty");
        } else {
            Link currentLink = first;
            System.out.print("Elements are:");
            while(currentLink != null) {
                currentLink.printLink();
                currentLink = currentLink.nextLink;
            }
            System.out.println();
        }
    }
}



class Main {
    public static void main(String args[]) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
        System.out.println("Implementation of stack using Array");
        StackArray stackArray = new StackArray();
        int ch = 0;

        do{
            System.out.println("1.Push 2.Pop 3.Display 4.Exit 5.Use LinkedList");
            System.out.println("Enter yoyr choice:");
            ch = Integer.parseInt(br.readLine());
            switch (ch) {
                case 1:
                    stackArray.push();
                    break;
                case 2:
                    stackArray.pop();
                    break;
                case 3:
                    stackArray.display();
                    break;
                case 4:
                    System.exit(0);
                default:
                    break;
            }

        } while(ch < 5);
        System.out.println("Implementation of stack using Array");
        StackLink link = new StackLink();
        ch = 0;
         do{
            System.out.println("1.Push 2.Pop 3.Display 4.Exit");
            System.out.println("Enter yoyr choice:");
            ch = Integer.parseInt(br.readLine());
            switch (ch) {
                case 1:
                    link.push();
                    break;
                case 2:
                    link.pop();
                    break;
                case 3:
                    link.display();
                    break;
                case 4:
                    System.exit(0);
                default:
                    break;
            }

    }while(ch < 5);   
    
}
}
