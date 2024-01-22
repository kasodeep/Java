package stacks;

public class TwoStacks {

    int size;

    int top1, top2;

    int[] arr;

    TwoStacks(int n) {
        arr = new int[n];
        size = n;
        top1 = -1;
        top2 = size;
    }

    public static void main(String[] args) {
        TwoStacks ts = new TwoStacks(5);
        ts.push1(5);
        ts.push2(10);
        ts.push2(15);
        ts.push1(11);
        ts.push1(7);
        System.out.println("Popped element from" + " stack1 is " + ts.pop1());
        ts.push2(40);
        System.out.println("Popped element from" + " stack2 is " + ts.pop2());
    }

    void push1(int x) {
        if (top2 - top1 > 1) {
            arr[++top1] = x;
        } else {
            System.out.println("Stack Overflow");
        }
    }

    void push2(int x) {
        if (top2 - top1 > 1) {
            arr[--top2] = x;
        } else {
            System.out.println("Stack Overflow");
        }
    }

    int pop1() {
        if (top1 >= 0) {
            return arr[top1--];
        } else {
            System.out.println("Stack Underflow");
            return -1;
        }
    }

    int pop2() {
        if (top2 < size) {
            return arr[top2++];
        } else {
            System.out.println("Stack Underflow");
            return -1;
        }
    }
}
