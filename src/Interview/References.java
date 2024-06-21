package Interview;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * References play a crucial role in determining whether an object is eligible for removal by the garbage collection.
 */
public class References {

    public static void main(String[] args) {
        // Strong Reference - By Default, Not Collected.
        Object strongRef = new Object();

        /*
         * Weak Reference
         * Collected by garbage collector if there are no strong references to it.
         */
        WeakReference<Object> weakReference = new WeakReference<>(new Object());

        /*
         * Soft Reference
         * Collected by the garbage collector if memory pressure increases.
         * */
        SoftReference<Object> softReference = new SoftReference<>(new Object());

        /*
         * Weakest type of reference.
         * */
        ReferenceQueue<Object> phantomQueue = new ReferenceQueue<>();
        PhantomReference<Object> phantomReference = new PhantomReference<>(new Object(), phantomQueue);

        System.gc();

        System.out.println("Strong reference: " + strongRef);
        System.out.println("Weak reference: " + weakReference.get());
        System.out.println("Soft reference: " + softReference.get());
        System.out.println("Phantom reference: " + phantomReference.get());
    }
}
