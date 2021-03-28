package DataStructure;

import java.util.ArrayList;
import java.util.List;

public class MaxHeap<E extends Comparable<E>> {
    private List<E> maxHeap;
    public MaxHeap() {
        maxHeap = new ArrayList();
    }

    public void add(E e) {
        maxHeap.add(maxHeap.size() - 1, e);
        siftUp(maxHeap.size() - 1);
    }

    public int size() {
        return maxHeap.size();
    }

    public boolean empty() {
        return maxHeap.isEmpty();
    }

    private int getParentIndex(int i) {
        return (i - 1) / 2;
    }

    private int getLeftChild(int i) {
        return 2 * i + 1;
    }

    private int getRightChild(int i) {
        return 2 * i + 2;
    }

    private void siftUp(int index) {
        int parentIndex = getParentIndex(index);
        while (maxHeap.get(index).compareTo(maxHeap.get(parentIndex)) > 0) {
            swap(maxHeap, index, parentIndex);
            index = getParentIndex(index);
            parentIndex = getParentIndex(index);
        }
    }

    private void siftDown(int k) {
        swap(maxHeap, 0, maxHeap.size() - 1);
        maxHeap.remove(maxHeap.size() - 1);

        //当左孩子大于length，说明已经再没有孩子了 退出循环
        while (getLeftChild(k) < maxHeap.size()) {
            int j = getLeftChild(k);
            if (j + 1 < maxHeap.size() && maxHeap.get(j + 1).compareTo(maxHeap.get(j)) > 0) {
                j++;
            }
            if (maxHeap.get(j).compareTo(maxHeap.get(k)) < 0) {
                break;
            } else {
                swap(maxHeap, j, k);
            }
            k = j;
        }
    }

    private void swap(List<E> maxHeap, int index1, int index2) {
        E t = maxHeap.get(index1);
        maxHeap.set(index1, maxHeap.get(index2));
        maxHeap.set(index2, t);
    }
}
